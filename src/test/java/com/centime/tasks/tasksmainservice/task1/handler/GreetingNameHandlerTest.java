package com.centime.tasks.tasksmainservice.task1.handler;

import com.centime.tasks.tasksmainservice.task1.adapter.FullNameServiceClient;
import com.centime.tasks.tasksmainservice.task1.adapter.HelloServiceClient;
import com.centime.tasks.tasksmainservice.task1.model.FullName;
import feign.FeignException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GreetingNameHandlerTest {

    @InjectMocks
    private GreetingNameHandler greetingNameHandler;
    @Mock
    private HelloServiceClient helloServiceClient;
    @Mock
    private FullNameServiceClient fullNameServiceClient;

    @Test
    public void testShouldCreateFullNameWhenClientResponseIsSuccessful() {
        //Given
        FullName fullName = new FullName("John", "Doe");
        when(helloServiceClient.getGreeting(anyString())).thenReturn("Hello");
        when(fullNameServiceClient.createFullName(anyString(), any(FullName.class))).thenReturn("John Doe");

        //When
        String response = greetingNameHandler.create("traceID", fullName);

        //Then
        assertEquals("Hello John Doe", response);
    }

    @Test(expected = FeignException.BadRequest.class)
    public void testShouldThrowExceptionWhenClientThrowsException() {
        //Given
        FullName fullName = new FullName("John", "Doe");
        when(helloServiceClient.getGreeting(anyString())).thenThrow(FeignException.BadRequest.class);

        //When
        String response = greetingNameHandler.create("traceID", fullName);

        //Then
        //Expect exception
    }
}