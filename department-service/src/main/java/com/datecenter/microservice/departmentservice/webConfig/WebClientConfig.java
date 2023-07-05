package com.datecenter.microservice.departmentservice.webConfig;

import com.datecenter.microservice.departmentservice.client.EmployeeClient;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfig {
//cette classe permet d'injecter un objet (bean) de type de l'interface EmployeeClient dans le context du Department-Service

    private LoadBalancedExchangeFilterFunction loadBalancedExchangeFilterFunction;

    public WebClientConfig(LoadBalancedExchangeFilterFunction loadBalancedExchangeFilterFunction) {
        this.loadBalancedExchangeFilterFunction = loadBalancedExchangeFilterFunction;
    }
//Injection du client a travers la employeWebClient via l'url dans le serviceRegistry
    @Bean
    public WebClient employeeWebClient(){
        return WebClient.builder()// l'URL contenu dans le serviceRegistry (Eureka)
                .baseUrl("http://employee-service")
                .filter(loadBalancedExchangeFilterFunction).build();//le loadBalancer pour la repartition des charges entre les instances du service EmployeeClient
    }
//injection de l'objet du type de l'interface EmployeeClient
    @Bean
    public EmployeeClient employeeClient(){
        //création d'une instance du client EmployeClient qui est une interface
        HttpServiceProxyFactory httpServiceProxyFactory =
                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(employeeWebClient())).build();
        return httpServiceProxyFactory.createClient(EmployeeClient.class);
    }
}
