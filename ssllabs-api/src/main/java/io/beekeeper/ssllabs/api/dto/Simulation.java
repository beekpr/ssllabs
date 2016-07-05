package io.beekeeper.ssllabs.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Simulation {

    /**
     * instance of SimClient.
     */
    public SimClient client;

    /**
     * zero if handshake was successful, 1 if it was not.
     */
    public int errorCode;

    /**
     * always 1 with the current implementation.
     */
    public int attempts;

    /**
     * Negotiated protocol ID.
     */
    public String protocolId;

    /**
     * Negotiated suite ID
     */
    public String suiteId;

}
