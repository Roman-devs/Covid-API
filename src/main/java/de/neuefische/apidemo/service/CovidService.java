package de.neuefische.apidemo.service;

import de.neuefische.apidemo.model.ActiveCasesHamburg;
import de.neuefische.apidemo.model.CovidApiGermanyStatusData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CovidService {

    private final CovidApiService covidApiService;

    @Autowired
    public CovidService(CovidApiService covidApiService) {
        this.covidApiService = covidApiService;
    }

    public List<CovidApiGermanyStatusData> getActiveCasesHamburg(){
        List<CovidApiGermanyStatusData> filteredData = new ArrayList<>();
        CovidApiGermanyStatusData[] unfilteredData = covidApiService.getActiveCasesGermany();
        for (CovidApiGermanyStatusData someProvince : unfilteredData) {
            if (someProvince.getProvince().equals("Hamburg")){
                filteredData.add(someProvince);
            }

        }
            return filteredData;
        /*return Arrays.stream(unfilteredData)
                .filter(CovidApiGermanyStatusData -> CovidApiGermanyStatusData.getProvince().equals("Hamburg"))
                .map(CovidApiGermanyStatusData -> new ActiveCasesHamburg(

                ))*/

    }
}
