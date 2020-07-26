package com.centime.tasks.tasksmainservice.task2.service;

import com.centime.tasks.tasksmainservice.task2.entity.Name;
import com.centime.tasks.tasksmainservice.task2.model.NestedNameResponse;
import com.centime.tasks.tasksmainservice.task2.repository.NameRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NestedNamesService {
    private NameRepository nameRepository;

    public NestedNamesService(NameRepository nameRepository) {
        this.nameRepository = nameRepository;
    }

    public NestedNameResponse fetchNameById(Long id) {
        Optional<Name> nameById = nameRepository.findById(id);
        return nameById.map(name -> {
            NestedNameResponse.SubClass subClass = new NestedNameResponse.SubClass(name.getId(),
                    name.getParentId(), name.getName(), name.getColor(), null);
            return new NestedNameResponse(Arrays.asList(subClass));
        }).orElse(null);
    }

    public NestedNameResponse fetchAllNames() {
        List<Name> names = nameRepository.findAll();
        Map<Long, Name> parentIdMap = createParentChildIdMap(names);
        NestedNameResponse nestedNameResponse = new NestedNameResponse(new ArrayList<>());

        for (Name name : names) {
            Long parentId = name.getParentId();
            Name parent = parentIdMap.get(parentId);
            if (parent == null) {
                NestedNameResponse.SubClass subClass = new NestedNameResponse.SubClass(name.getId(), parentId, name.getName(), name.getColor(), new ArrayList<>());
                nestedNameResponse.getSubClasses().add(subClass);
            } else {
                final Long currentParentId = parentId;
                while (parent != null) {
                    NestedNameResponse.SubClass foundParent = findParentSubClass(nestedNameResponse.getSubClasses(), currentParentId);
                    if (foundParent != null) {
                        NestedNameResponse.SubClass childSubClass = new NestedNameResponse.SubClass(name.getId(), currentParentId, name.getName(), name.getColor(), new ArrayList<>());
                        foundParent.getSubClasses().add(childSubClass);
                        break;
                    }
                    parentId = parent.getParentId();
                    parent = parentIdMap.get(parentId);
                }
            }
        }
        return nestedNameResponse;
    }

    private Map<Long, Name> createParentChildIdMap(List<Name> names) {
        Map<Long, Name> parentIdMap = new HashMap<>();
        names.forEach(name -> parentIdMap.put(name.getId(), name));
        return parentIdMap;
    }

    private NestedNameResponse.SubClass findParentSubClass(List<NestedNameResponse.SubClass> subClasses, final Long currentParentId) {
        return subClasses.stream().filter(subClass -> subClass.getId() == currentParentId).findFirst()
                .orElseGet(() -> {
                    List<NestedNameResponse.SubClass> childSubClasses = new ArrayList<>();
                    subClasses.forEach(subClass -> childSubClasses.addAll(subClass.getSubClasses()));
                    return findParentSubClass(childSubClasses, currentParentId);
                });
    }
}
