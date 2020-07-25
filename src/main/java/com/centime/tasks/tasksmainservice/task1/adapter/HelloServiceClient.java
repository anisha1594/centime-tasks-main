package com.centime.tasks.tasksmainservice.task1.adapter;

import com.centime.tasks.tasksmainservice.task1.log.LogMethodParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "HelloServiceClient", url = "${hello-service.url}", configuration = FeignClientConfig.class)
public interface HelloServiceClient {
    @LogMethodParam
    @GetMapping("/hello")
    String getGreeting(@RequestHeader("traceId") String traceId);
}
