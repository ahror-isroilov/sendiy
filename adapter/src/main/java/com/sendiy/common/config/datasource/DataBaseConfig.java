package com.sendiy.common.config.datasource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * author: ahror
 *
 * <p>since: 04/10/2024
 */
@Configuration
public class DataBaseConfig {
  @Value("${spring.datasource.url}")
  public String dbUrl;

  @Value("${spring.datasource.username}")
  public String dbUsername;

  @Value("${spring.datasource.password}")
  public String dbPassword;

  @Bean
  public DataSource dataSource() {
    HikariConfig config = new HikariConfig();
    config.setJdbcUrl(dbUrl);
    config.setUsername(dbUsername);
    config.setPassword(dbPassword);
    config.setMaximumPoolSize(10);
    config.setMinimumIdle(5);
    config.setIdleTimeout(300000);
    config.setConnectionTimeout(10000);
    return new HikariDataSource(config);
  }

  @Bean
  public DSLContext dslContext(DataSource dataSource) {
    Settings settings =
        new Settings()
            .withExecuteLogging(true)
            .withRenderFormatted(true)
            .withExecuteWithOptimisticLocking(true)
            .withAttachRecords(false);
    org.jooq.Configuration configuration =
        new DefaultConfiguration()
            .set(dataSource)
            .set(SQLDialect.POSTGRES)
            .set(settings)
            .set(new DefaultExecuteListenerProvider(new QueryLogger()));
    return DSL.using(configuration);
  }
}
