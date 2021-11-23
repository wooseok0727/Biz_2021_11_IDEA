package com.wooseok.study.service;

import com.wooseok.study.model.TodoEntity;
import com.wooseok.study.persistence.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TodoService {

    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public String testService() {

        TodoEntity entity = TodoEntity.builder().title("todo").build();

        repository.save(entity);

        TodoEntity saveEntity = repository.findById(entity.getId()).get();
        return saveEntity.getTitle();

    }

    public List<TodoEntity> create(final TodoEntity entity) {

        validate(entity);

        repository.save(entity);
        log.info("Entity Id : {} is saved",entity.getId());

        return repository.findByUserId(entity.getUserId());
    }

    private void validate(final TodoEntity entity) {

        if(entity == null) {
            log.warn("Entity cannot be null");
            throw new RuntimeException("Entity cannot be null");
        }
        if(entity.getUserId() == null) {
            log.warn("Unknown user");
            throw new RuntimeException("Unknown user");
        }
    }




}
