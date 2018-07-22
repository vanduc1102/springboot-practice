package com.baeldung.controller.web.api;

import com.baeldung.model.GenericEntity;
import com.baeldung.repository.GenericEntityRepository;
import com.baeldung.service.GenericEntityService;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/entity")
public class GenericEntityController {
  @Autowired
  private GenericEntityRepository genericEntityRepository;
  @Autowired
  private GenericEntityService genericEntityService;

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public GenericEntity addEntity(GenericEntity entity) {
    this.genericEntityRepository.save(entity);
    return entity;
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<GenericEntity> findAll() {
    return StreamSupport.
        stream(this.genericEntityRepository.findAll().spliterator(),false).
        collect(Collectors.toList());
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public GenericEntity findById(@PathVariable Long id) {
    return this.genericEntityRepository.findById(id).orElse(null);
  }

}
