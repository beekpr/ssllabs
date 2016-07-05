package io.beekeeper.ssllabs.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Key {

    public static String ALG_RSA = "RSA";
    public static String ALG_DSA = "DSA";
    public static String ALG_EC = "EC";

    /**
     * key size, e.g., 1024 or 2048 for RSA and DSA, or 256 bits for EC.
     */
    public int size;

    /**
     * key size expressed in RSA bits.
     */
    public int strength;

    /**
     * key algorithm; possible values: RSA, DSA, and EC.
     */
    public String alg;

    /**
     * true if we suspect that the key was generated using a weak random number
     * generator (detected via a blacklist database)
     */
    public boolean debianFlaw;

    /**
     * if key is insecure, null otherwise
     */
    public Integer q;

}
