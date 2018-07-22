package com.baeldung.controller.web.view;

import com.baeldung.model.GenericEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/entity")
public class GenericEntityWebViewController {

  private List<GenericEntity> entityList = new ArrayList<>();

  {
    entityList.add(new GenericEntity(1l, "entity 1"));
    entityList.add(new GenericEntity(2l, "entity 2"));
    entityList.add(new GenericEntity(3l, "entity 3"));
    entityList.add(new GenericEntity(4l, "entity 4"));
  }

  @RequestMapping(value = "/")
  public ModelAndView view() {
    ModelAndView mav = new ModelAndView("entity");
    mav.addObject("entities", entityList);
    return mav;
  }

}

