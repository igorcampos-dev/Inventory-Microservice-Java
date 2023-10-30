package io.GatewayCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayCloudApplication.class, args);
	}

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder){
		return builder
				.routes()
				.route( r -> r.path("/inventory/**").uri("lb://msinventory") )
				.route( r -> r.path("/notification/**").uri("lb://msnotification") )
				.route( r -> r.path("/order/**").uri("lb://msorder") )
				.route( r -> r.path("/user/**").uri("lb://msuser") )
				.build();
	}
}
