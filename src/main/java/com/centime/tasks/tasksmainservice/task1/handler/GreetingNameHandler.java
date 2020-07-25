package com.centime.tasks.tasksmainservice.task1.handler;

import com.centime.tasks.tasksmainservice.task1.adapter.FullNameServiceClient;
import com.centime.tasks.tasksmainservice.task1.adapter.HelloServiceClient;
import com.centime.tasks.tasksmainservice.task1.log.LogMethodParam;
import com.centime.tasks.tasksmainservice.task1.model.FullName;
import org.springframework.stereotype.Component;

@Component
public class GreetingNameHandler {

    private HelloServiceClient helloServiceClient;
    private FullNameServiceClient fullNameServiceClient;

    public GreetingNameHandler(HelloServiceClient helloServiceClient, FullNameServiceClient fullNameServiceClient) {
        this.helloServiceClient = helloServiceClient;
        this.fullNameServiceClient = fullNameServiceClient;
    }

    @LogMethodParam
    public String create(String traceId, FullName fullName) {
        String greeting = helloServiceClient.getGreeting(traceId);
        String name = fullNameServiceClient.createFullName(traceId, fullName);
        return (greeting + " " + name);
    }
}
