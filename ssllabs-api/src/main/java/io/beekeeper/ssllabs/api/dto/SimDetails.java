package io.beekeeper.ssllabs.api.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SimDetails {

    /**
     * instances of Simulation.
     */
    public List<Simulation> results;
}
