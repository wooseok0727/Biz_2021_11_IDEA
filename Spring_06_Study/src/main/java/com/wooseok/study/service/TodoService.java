package com.wooseok.study.service;

import com.wooseok.study.model.TodoEntity;
import com.wooseok.study.persistence.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
