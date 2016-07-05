package io.beekeeper.ssllabs.api.dto;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StatusCodes {

    /**
     * a map containing all status details codes and the corresponding English
     * translations. Please note that, once in use, the codes will not change,
     * whereas the translations may change at any time.
     */
    public HashMap<Integer, String> statusDetails;
}
