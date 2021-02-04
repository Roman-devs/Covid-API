package de.neuefische.apidemo.service;

import de.neuefische.apidemo.model.CovidApiGermanyStatusData;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CovidApiServiceTest {

    @Test
    void getActiveCasesGermany() {

        //GIVEN
        RestTemplate restTemplate = mock(RestTemplate.class);
        CovidApiService covidApiService = new CovidApiService(restTemplate);
        CovidApiGermanyStatusData[] covidApiGermanyStatusData = new CovidApiGermanyStatusData[]{
                new CovidApiGermanyStatusData("Hamburg", 1000, 300, 2)};
        String url = "https://api.covid19api.com/live/country/germany/status/confirmed/date/2021-02-01T13:13:30Z";
        when(restTemplate.getForEntity(url, CovidApiGermanyStatusData[].class)).thenReturn(new ResponseEntity<>(covidApiGermanyStatusData, HttpStatus.OK));


        //WHEN
        CovidApiGermanyStatusData[] actual = covidApiService.getActiveCasesGermany();
        CovidApiGermanyStatusData[] expected = covidApiGermanyStatusData;

        //THEN
        assertEquals(expected, actual);

    }
}