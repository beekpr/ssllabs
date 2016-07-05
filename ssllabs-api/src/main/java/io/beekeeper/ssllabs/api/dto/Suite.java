package io.beekeeper.ssllabs.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Suite {

    /**
     * suite RFC ID (e.g., 5)
     */
    public String id;

    /**
     * suite name (e.g., TLS_RSA_WITH_RC4_128_SHA)
     */
    public String name;

    /**
     * suite strength (e.g., 128)
     */
    public long cipherStrength;

    /**
     * strength of DH params (e.g., 1024)
     */
    public int dhStrength;

    /**
     * DH params, p component
     */
    public String dhP;

    /**
     * DH params, g component
     */
    public String dhG;

    /**
     * DH params, Ys component
     */
    public String dhYs;

    /**
     * ECDH bits
     */
    public String ecdhBit;

    /**
     * ECDH RSA-equivalent strength
     */
    public String ecdhStrength;

    /**
     * 0 if the suite is insecure, null otherwise
     */
    public Integer q;

}
