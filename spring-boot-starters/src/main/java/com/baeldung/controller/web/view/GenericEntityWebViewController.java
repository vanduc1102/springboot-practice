package com.baeldung.controller.web.view;

import com.baeldung.model.GenericEntity;
import com.baeldung.repository.GenericEntityRepository;
import com.baeldung.service.GenericEntityService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/entity")
public class GenericEntityWebViewController {

  @Autowired
  private GenericEntityRepository genericEntityRepository;
  @Autowired
  private GenericEntityService genericEntityService;

  @RequestMapping(value = "/")
  public ModelAndView view() {
    ModelAndView mav = new ModelAndView("entity");
    List<GenericEntity> entities = new ArrayList<>();
    this.genericEntityRepository.findAll().forEach(entities::add);
    mav.addObject("entities",entities );
    return mav;
  }

}

