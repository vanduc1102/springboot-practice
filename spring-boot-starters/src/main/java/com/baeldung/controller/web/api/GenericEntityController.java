package com.baeldung.controller.web.api;

import com.baeldung.model.GenericEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/entity")
public class GenericEntityController {

  private List<GenericEntity> entityList = new ArrayList<>();

  {
    entityList.add(new GenericEntity(1l, "entity 1"));
    entityList.add(new GenericEntity(2l, "entity 2"));
    entityList.add(new GenericEntity(3l, "entity 3"));
    entityList.add(new GenericEntity(4l, "entity 4"));
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public GenericEntity addEntity(GenericEntity entity) {
    entityList.add(entity);
    return entity;
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<GenericEntity> findAll() {
    return entityList;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public GenericEntity findById(@PathVariable Long id) {
    return entityList.stream().
        filter(entity -> entity.getId().equals(id)).
        findFirst().get();
  }

}
