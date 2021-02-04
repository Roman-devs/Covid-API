package de.neuefische.apidemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//
@Data
@AllArgsConstructor
@NoArgsConstructor
//
public class CovidApiGermanyStatusData {
    // Member Variables and Annotations/Interpretation handles for the Jackson Object Mapper
    @JsonProperty("Province")
    private String province;
    @JsonProperty("Active")
    private int active;
    @JsonProperty("Confirmed")
    private int confirmed;
    @JsonProperty("Deaths")
    private int deaths;


}
