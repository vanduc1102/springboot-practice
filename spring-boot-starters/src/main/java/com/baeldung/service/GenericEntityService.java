package com.baeldung.service;

import com.baeldung.model.GenericEntity;
import com.baeldung.repository.GenericEntityRepository;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenericEntityService {
  @Autowired
  private GenericEntityRepository genericEntityRepository;

  @PostConstruct
  public  void init(){
    genericEntityRepository.save(new GenericEntity( "entity 1"));
    genericEntityRepository.save(new GenericEntity( "entity 6"));
    genericEntityRepository.save(new GenericEntity( "entity 2"));
    genericEntityRepository.save(new GenericEntity( "entity 3"));
    genericEntityRepository.save(new GenericEntity( "entity 4"));
    genericEntityRepository.save(new GenericEntity( "entity 5"));

  }
}
