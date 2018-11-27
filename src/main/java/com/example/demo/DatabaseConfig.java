package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.function.DatabaseClient;
import org.springframework.data.r2dbc.repository.support.R2dbcRepositoryFactory;
import org.springframework.data.relational.core.mapping.RelationalMappingContext;
import com.example.demo.repository.DemoRepository;
import io.r2dbc.h2.H2ConnectionConfiguration;
import io.r2dbc.h2.H2ConnectionFactory;

@Configuration
public class DatabaseConfig {

  @Bean
  public H2ConnectionFactory h2ConnectionFactory() {
    return new H2ConnectionFactory(
        H2ConnectionConfiguration.builder()
            .url("mem:~/demodb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=TRUE;MODE=MySQL")
            .username("sa")
            .password("")
            .build());
  }

  @Bean
  public DatabaseClient databaseClient(H2ConnectionFactory connectionFactory) {
    return DatabaseClient.create(connectionFactory);
  }

  @Bean
  public DemoRepository repository(R2dbcRepositoryFactory factory) {
    return factory.getRepository(DemoRepository.class);
  }

  @Bean
  public RelationalMappingContext context() {
    return new RelationalMappingContext();
  }

  @Bean
  public R2dbcRepositoryFactory factory(DatabaseClient client, RelationalMappingContext context) {
    return new R2dbcRepositoryFactory(client, context);
  }
}
