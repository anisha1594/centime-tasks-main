package com.centime.tasks.tasksmainservice.task1.adapter;

import com.centime.tasks.tasksmainservice.task1.log.LogMethodParam;
import com.centime.tasks.tasksmainservice.task1.model.FullName;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "FullNameServiceClient", url = "${full-name-service.url}", configuration = FeignClientConfig.class)
public interface FullNameServiceClient {
    @LogMethodParam
    @PostMapping(value = "/full-name")
    String createFullName(@RequestHeader("traceId") String traceId, @RequestBody FullName fullName);
}
