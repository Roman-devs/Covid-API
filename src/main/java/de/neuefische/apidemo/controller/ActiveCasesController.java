package de.neuefische.apidemo.controller;

import de.neuefische.apidemo.model.ActiveCasesHamburg;
import de.neuefische.apidemo.model.CovidApiGermanyStatusData;
import de.neuefische.apidemo.service.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("covid")
public class ActiveCasesController {

    private final CovidService covidService;

    @Autowired
    public ActiveCasesController(CovidService covidService) {
        this.covidService = covidService;
    }

    @GetMapping
    public List<CovidApiGermanyStatusData> getActiveCasesHamburg(){
        return covidService.getActiveCasesHamburg();
    }
}
