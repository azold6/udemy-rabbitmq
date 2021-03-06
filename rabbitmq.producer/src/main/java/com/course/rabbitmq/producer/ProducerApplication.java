package com.course.rabbitmq.producer;

import com.course.rabbitmq.producer.entity.Employee;
import com.course.rabbitmq.producer.entity.Furniture;
import com.course.rabbitmq.producer.entity.Picture;
import com.course.rabbitmq.producer.producer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
@EnableScheduling
public class ProducerApplication implements CommandLineRunner {

	private List<String> SOURCES = List.of("web", "mobile");
	public List<String> TYPES = List.of("png", "svg", "jpg");

	@Autowired
	private SpringEmployeeProducer springEmployeeProducer;

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {

		for (int i=0; i<1; i++){
			var employee = new Employee("emp" + i, "", LocalDate.of(1990, 12, i+1));
			springEmployeeProducer.sendMessage(employee);

		}
	}
}
