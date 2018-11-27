package com.example.demo;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.function.DatabaseClient;
import org.springframework.stereotype.Component;
import com.example.demo.entity.Demo;

@Component
public class DatabaseInitialize {

  @Autowired DatabaseClient databaseClient;

  @PostConstruct
  public void postConstruct() {

    // テーブル作成
    databaseClient
        .execute()
        .sql(
            "create table if not exists demo ("
                + " id int auto_increment,"
                + " value varchar(50),"
                + " primary key (id)"
                + ");")
        .fetch()
        .one()
        .log()
        .subscribe(
            r -> {
              System.out.println("table created.");
            });

    // 　テストデータ投入
    databaseClient
        .execute()
        .sql("insert into demo(id, value) values($1, $2)")
        .bind(0, 1)
        .bind(1, "demo1")
        .fetch()
        .rowsUpdated()
        .log()
        .subscribe(
            r -> {
              System.out.println("data inserted.");
            });

    // 確認
    databaseClient
        .select()
        .from("demo")
        .as(Demo.class)
        .fetch()
        .all()
        .log()
        .subscribe(System.out::println);
  }
}
