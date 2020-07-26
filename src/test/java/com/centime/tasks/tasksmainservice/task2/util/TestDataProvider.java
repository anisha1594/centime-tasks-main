package com.centime.tasks.tasksmainservice.task2.util;

import com.centime.tasks.tasksmainservice.task2.model.NestedNameResponse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestDataProvider {
    public static NestedNameResponse getNestedNameResponse() {
        List<NestedNameResponse.SubClass> subClasses10 = new ArrayList<>();
        List<NestedNameResponse.SubClass> subClasses1 = new ArrayList<>();
        subClasses1.add(new NestedNameResponse.SubClass(5l, 1l, "Fighter", "blue", new ArrayList<>()));
        subClasses1.add(new NestedNameResponse.SubClass(6l, 1l, "Paladin", "lighblue", new ArrayList<>()));
        subClasses1.add(new NestedNameResponse.SubClass(7l, 1l, "Ranger", "lighgreen", new ArrayList<>()));
        subClasses10.add(new NestedNameResponse.SubClass(1l, 0l, "Warrior", "red", subClasses1));
        List<NestedNameResponse.SubClass> subClasses20 = new ArrayList<>();
        List<NestedNameResponse.SubClass> subClasses2 = new ArrayList<>();
        subClasses2.add(new NestedNameResponse.SubClass(8l, 2l, "Mage", "grey", new ArrayList<>()));
        subClasses2.add(new NestedNameResponse.SubClass(9l, 2l, "Specialist wizard", "lightgrey", new ArrayList<>()));
        subClasses20.add(new NestedNameResponse.SubClass(2l, 0l, "Wizard", "green", subClasses2));
        List<NestedNameResponse.SubClass> subClasses30 = new ArrayList<>();
        List<NestedNameResponse.SubClass> subClasses3 = new ArrayList<>();
        subClasses3.add(new NestedNameResponse.SubClass(10l, 3l, "Cleric", "red", new ArrayList<>()));
        subClasses3.add(new NestedNameResponse.SubClass(11l, 3l, "Druid", "green", new ArrayList<>()));
        subClasses3.add(new NestedNameResponse.SubClass(12l, 3l, "Priest of specific mythos", "white", new ArrayList<>()));
        subClasses30.add(new NestedNameResponse.SubClass(3l, 0l, "Priest", "white", subClasses3));
        List<NestedNameResponse.SubClass> subClasses40 = new ArrayList<>();
        List<NestedNameResponse.SubClass> subClasses4 = new ArrayList<>();
        List<NestedNameResponse.SubClass> subClasses15 = new ArrayList<>();
        subClasses15.add(new NestedNameResponse.SubClass(15l, 13l, "Assassin", "lighblue", new ArrayList<>()));
        subClasses4.add(new NestedNameResponse.SubClass(13l, 4l, "Thief", "yellow", subClasses15));
        subClasses4.add(new NestedNameResponse.SubClass(14l, 4l, "Bard", "blue", new ArrayList<>()));
        subClasses40.add(new NestedNameResponse.SubClass(4l, 0l, "Rogue", "yellow", subClasses4));

        List<NestedNameResponse.SubClass> subClasses = Stream.of(subClasses10, subClasses20, subClasses30, subClasses40)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        return new NestedNameResponse(subClasses);
    }
}
