package io.beekeeper.ssllabs.api.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Suites {

    /**
     * list of Suite objects
     */
    public List<Suite> list;

    /**
     * true if the server actively selects cipher suites; if null, we were not
     * able to determine if the server has a preference
     */
    public boolean preference;

}
