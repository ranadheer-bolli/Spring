package com.ranadheer.springsecuritydemo.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@PropertySource("classpath:persistence-mysql.properties")
@ComponentScan(basePackages = "com.ranadheer.springsecuritydemo")
public class DemoAppConfig {

    // setup variable to hold properties
    @Autowired
    private Environment env;

    // set up logger for diagnostics

    private Logger logger = Logger.getLogger(getClass().getName());



    // define bean for viewResolver
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver internalResourceViewResolver =
                new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/view/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }

    // define a bean for security datasource

    @Bean
    public DataSource securityDataSource(){

        // create a connection pool

        ComboPooledDataSource securityDataSource =
                new ComboPooledDataSource();

        // set the jdbc driver class

        try {
            securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

        // log the connection props

        logger.info(">>>jdbc url"+env.getProperty("jdbc.url"));
        logger.info(">>>jdbc user"+env.getProperty("jdbc.user"));

        // set database connection props

        securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        securityDataSource.setUser(env.getProperty("jdbc.user"));
        securityDataSource.setPassword(env.getProperty("jdbc.password"));

        // set connectionpool props

        securityDataSource.setInitialPoolSize(getProperty("connection.pool.initialPoolSize"));
        securityDataSource.setMinPoolSize(getProperty("connection.pool.minPoolSize"));
        securityDataSource.setMaxPoolSize(getProperty("connection.pool.maxPoolSize"));
        securityDataSource.setMaxIdleTime(getProperty("connection.pool.maxIdleTime"));

        return securityDataSource;
    }

    // need a helper method
    // read environment property and convert to int

    private int getProperty(String propName){
        int val = Integer.parseInt(env.getProperty(propName));
        return val;
    }

}
