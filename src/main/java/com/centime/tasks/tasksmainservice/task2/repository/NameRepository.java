package com.centime.tasks.tasksmainservice.task2.repository;

import com.centime.tasks.tasksmainservice.task2.entity.Name;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NameRepository extends JpaRepository<Name, Long> {
}
