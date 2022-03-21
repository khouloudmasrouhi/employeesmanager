package com.example.employeesmanager;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

@SpringBootApplication
public class EmployeesmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeesmanagerApplication.class, args);

		try {
			InetAddress adrLocale = InetAddress.getLocalHost();
			System.out.println("Adresse locale = "+adrLocale);
			System.out.println("Adresse locale = "+adrLocale.getHostAddress());
			InetAddress adrServeur = InetAddress.getByName("www.demo.lunflow.com");//https://simplesolution.dev/java-spring-framework/
			System.out.println("Adresse Lunar demo = "+adrServeur.getHostAddress());
			InetAddress[] adrServeurs = InetAddress.getAllByName("www.lunar-tc.com");
			System.out.println("Adresses lunar-tc.com : ");
			for (int i = 0; i < adrServeurs.length; i++) {
				System.out.println("     "+adrServeurs[i].getHostAddress());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

//	@Bean
//	CommandLineRunner runner(EmployeeRepo repository){
//		return args -> {
//			Experience experience1 = new Experience(
//					LocalDate.of(2020,2,3),
//					LocalDate.of(2021,2,3),
//					"Developer",
//					"Sofrecom"
//			);
//			Experience experience2 = new Experience(
//					LocalDate.of(2020,2,3),
//					LocalDate.of(2021,2,3),
//					"Developer",
//					"Spark-It Group"
//			);
//			Employee employee= new Employee(
//					"Jihen Masrouhi",
//					"jihen@enis.tn",
//					"Student",
//					"23020382",
//					"image",
//					List.of(experience1,experience2)
//			);
//			repository.insert(employee);
//
//		};
//	}


	// necessaire pour les classes mappers
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}

}
