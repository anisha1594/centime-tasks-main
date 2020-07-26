package com.centime.tasks.tasksmainservice.task2.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.centime.tasks.tasksmainservice.task2.repository")
public class RepositoryConfiguration {
}
