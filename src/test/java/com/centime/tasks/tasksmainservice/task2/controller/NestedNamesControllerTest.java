package com.centime.tasks.tasksmainservice.task2.controller;

import com.centime.tasks.tasksmainservice.task1.controller.GreetingNameController;
import com.centime.tasks.tasksmainservice.task1.handler.GreetingNameHandler;
import com.centime.tasks.tasksmainservice.task1.model.FullName;
import com.centime.tasks.tasksmainservice.task2.model.NestedNameResponse;
import com.centime.tasks.tasksmainservice.task2.service.NestedNamesService;
import com.centime.tasks.tasksmainservice.task2.util.TestDataProvider;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(NestedNamesController.class)
public class NestedNamesControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private NestedNamesService nestedNamesService;

    @Test
    public void testShouldFetchByIdWhenGetEndpointIsInvoked() throws Exception {
        //Given
        List<NestedNameResponse.SubClass> subClasses = new ArrayList<>();
        subClasses.add(new NestedNameResponse.SubClass(2l, 0l, "Wizard", "green", new ArrayList<>()));
        NestedNameResponse nestedNameResponse = new NestedNameResponse(subClasses);
        when(nestedNamesService.fetchNameById(anyLong())).thenReturn(nestedNameResponse);

        //When
        mvc.perform(get("/nested-objects/2").contentType(MediaType.APPLICATION_JSON))
                //Then
                .andExpect(status().isOk()).andExpect(content()
                .string("{\"subClasses\":[{\"id\":2,\"parentId\":0,\"name\":\"Wizard\",\"color\":\"green\",\"subClasses\":[]}]}"));
        ;
    }

    @Test
    public void testShouldFetchAllNamesWhenGetEndpointIsInvoked() throws Exception {
        //Given
        NestedNameResponse nestedNameResponse = TestDataProvider.getNestedNameResponse();
        when(nestedNamesService.fetchAllNames()).thenReturn(nestedNameResponse);

        //When
        mvc.perform(get("/nested-objects").contentType(MediaType.APPLICATION_JSON))
                //Then
                .andExpect(status().isOk()).andExpect(content()
                .string("{\"subClasses\":[{\"id\":1,\"parentId\":0,\"name\":\"Warrior\",\"color\":\"red\",\"subClasses\":[{\"id\":5,\"parentId\":1,\"name\":\"Fighter\",\"color\":\"blue\",\"subClasses\":[]},{\"id\":6,\"parentId\":1,\"name\":\"Paladin\",\"color\":\"lighblue\",\"subClasses\":[]},{\"id\":7,\"parentId\":1,\"name\":\"Ranger\",\"color\":\"lighgreen\",\"subClasses\":[]}]},{\"id\":2,\"parentId\":0,\"name\":\"Wizard\",\"color\":\"green\",\"subClasses\":[{\"id\":8,\"parentId\":2,\"name\":\"Mage\",\"color\":\"grey\",\"subClasses\":[]},{\"id\":9,\"parentId\":2,\"name\":\"Specialist wizard\",\"color\":\"lightgrey\",\"subClasses\":[]}]},{\"id\":3,\"parentId\":0,\"name\":\"Priest\",\"color\":\"white\",\"subClasses\":[{\"id\":10,\"parentId\":3,\"name\":\"Cleric\",\"color\":\"red\",\"subClasses\":[]},{\"id\":11,\"parentId\":3,\"name\":\"Druid\",\"color\":\"green\",\"subClasses\":[]},{\"id\":12,\"parentId\":3,\"name\":\"Priest of specific mythos\",\"color\":\"white\",\"subClasses\":[]}]},{\"id\":4,\"parentId\":0,\"name\":\"Rogue\",\"color\":\"yellow\",\"subClasses\":[{\"id\":13,\"parentId\":4,\"name\":\"Thief\",\"color\":\"yellow\",\"subClasses\":[{\"id\":15,\"parentId\":13,\"name\":\"Assassin\",\"color\":\"lighblue\",\"subClasses\":[]}]},{\"id\":14,\"parentId\":4,\"name\":\"Bard\",\"color\":\"blue\",\"subClasses\":[]}]}]}"));
        ;
    }
}
