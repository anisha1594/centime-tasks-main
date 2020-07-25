package com.centime.tasks.tasksmainservice.task1.controller;

import com.centime.tasks.tasksmainservice.task1.handler.GreetingNameHandler;
import com.centime.tasks.tasksmainservice.task1.model.FullName;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GreetingNameController.class)
public class GreetingNameControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private GreetingNameHandler greetingNameHandler;

    @Test
    public void testShouldReturnStatusWhenGetHealthCheckEndpointIsInvoked() throws Exception {
        //Given

        //When
        mvc.perform(get("/health-check").contentType(MediaType.APPLICATION_JSON))
                //Then
                .andExpect(status().isOk()).andExpect(content().string("Up"));
        ;
    }

    @Test
    public void testShouldReturnNameGreetingWhenPostEndpointIsInvoked() throws Exception {
        //Given
        String request = new JSONObject().put("name", "John").put("surName", "Doe").toString();
        String response = "Hello John Doe";
        when(greetingNameHandler.create(anyString(), any(FullName.class))).thenReturn(response);

        //When
        mvc.perform(post("/name-greeting").contentType(MediaType.APPLICATION_JSON)
                .content(request))
                //Then
                .andExpect(status().isOk()).andExpect(content().string(response));
        ;
    }

    @Test
    public void testShouldReturnBadRequestWhenPostEndpointRequestIsInvalid() throws Exception {
        //Given
        String request = new JSONObject().put("name", "John").put("middlename", "Doe").toString();

        //When
        mvc.perform(post("/name-greeting").contentType(MediaType.APPLICATION_JSON)
                .content(request))
                //Then
                .andExpect(status().isBadRequest());
    }
}
