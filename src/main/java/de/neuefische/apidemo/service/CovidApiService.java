package de.neuefische.apidemo.service;

import de.neuefische.apidemo.model.CovidApiGermanyStatusData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class CovidApiService {
    // RestTemplate stellt den Get Request
    private final RestTemplate restTemplate;
    private final String url = "https://api.covid19api.com/live/country/germany/status/confirmed/date/2021-02-01T13:13:30Z";

    @Autowired
    public CovidApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CovidApiGermanyStatusData[] getActiveCasesGermany(){
        ResponseEntity<CovidApiGermanyStatusData[]> responseAllDataGermany = restTemplate.getForEntity(url, CovidApiGermanyStatusData[].class);
        return responseAllDataGermany.getBody();
    }
}
