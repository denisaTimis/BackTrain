package com.project.TrainApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TrainAppApplication {

	public static List<Train> trains= new ArrayList<Train>();
	public static List<Station> stations=new ArrayList<Station>();

	public static void main(String[] args) {
		SpringApplication.run(TrainAppApplication.class, args);

	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/products").allowedOrigins("http://localhost:8080");
			}
		};
	}

	public static List<Train> SearchByStation(String start, String finish, String date)
	{
		List<Train> t=new ArrayList<Train>();
		for (Train train: trains)
		{
			//String stations=train.getRoute().getStations();
			if(stations.contains(start) && stations.contains(finish) && train.getRoute().getDate().contains(date))
			{
				t.add(train);
			}
		}
		return t;
	}



	public static Route SearchByTrainId(int id)
	{
		for (Train train: trains)
		{
			if(train.getId()==id)
			{
				return train.getRoute();
			}
		}
		return null;
	}

}

