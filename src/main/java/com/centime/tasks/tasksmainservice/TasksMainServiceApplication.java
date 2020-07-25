package com.centime.tasks.tasksmainservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TasksMainServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TasksMainServiceApplication.class, args);
	}

}
