package pl.coderslab.SpringHibernateModul6;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "pl.coderslab")
@EnableTransactionManagement
public class AppConfig {
}
