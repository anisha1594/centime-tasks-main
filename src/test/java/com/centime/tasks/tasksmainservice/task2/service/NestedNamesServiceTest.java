package com.centime.tasks.tasksmainservice.task2.service;

import com.centime.tasks.tasksmainservice.task2.entity.Name;
import com.centime.tasks.tasksmainservice.task2.model.NestedNameResponse;
import com.centime.tasks.tasksmainservice.task2.repository.NameRepository;
import com.centime.tasks.tasksmainservice.task2.util.TestDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NestedNamesServiceTest {

    @InjectMocks
    private NestedNamesService nestedNamesService;
    @Mock
    private NameRepository nameRepository;

    @Test
    public void testShouldFetchAllNames() {
        //Given
        when(nameRepository.findAll()).thenReturn(getNames());
        NestedNameResponse expectedNestedNameResponse = TestDataProvider.getNestedNameResponse();

        //When
        NestedNameResponse nestedNameResponse = nestedNamesService.fetchAllNames();

        //Then
        assertThat(nestedNameResponse).usingRecursiveComparison().isEqualTo(expectedNestedNameResponse);
    }

    private List<Name> getNames() {
        List<Name> names = new ArrayList<>();
        names.add(new Name(1l, 0l, "Warrior", "red"));
        names.add(new Name(2l, 0l, "Wizard", "green"));
        names.add(new Name(3l, 0l, "Priest", "white"));
        names.add(new Name(4l, 0l, "Rogue", "yellow"));
        names.add(new Name(5l, 1l, "Fighter", "blue"));
        names.add(new Name(6l, 1l, "Paladin", "lighblue"));
        names.add(new Name(7l, 1l, "Ranger", "lighgreen"));
        names.add(new Name(8l, 2l, "Mage", "grey"));
        names.add(new Name(9l, 2l, "Specialist wizard", "lightgrey"));
        names.add(new Name(10l, 3l, "Cleric", "red"));
        names.add(new Name(11l, 3l, "Druid", "green"));
        names.add(new Name(12l, 3l, "Priest of specific mythos", "white"));
        names.add(new Name(13l, 4l, "Thief", "yellow"));
        names.add(new Name(14l, 4l, "Bard", "blue"));
        names.add(new Name(15l, 13l, "Assassin", "lighblue"));
        return names;
    }
}