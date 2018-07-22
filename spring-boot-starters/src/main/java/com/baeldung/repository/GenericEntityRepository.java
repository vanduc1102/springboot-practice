package com.baeldung.repository;

import com.baeldung.model.GenericEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenericEntityRepository extends JpaRepository<GenericEntity,Long> {

  List<GenericEntity> findByValue(String value);

}
