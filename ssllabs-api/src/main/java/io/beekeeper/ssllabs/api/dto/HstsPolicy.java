package io.beekeeper.ssllabs.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HstsPolicy {

    /**
     * this constant contains what SSL Labs considers to be sufficiently large
     * max-age value
     */
    public long LONG_MAX_AGE;

    /**
     * the contents of the HSTS response header, if present
     */
    public String header;

    /**
     * HSTS status:
     * <ul>
     * <li>unknown - either before the server is checked or when its HTTP
     * response headers are not available</li>
     * <li>absent - header not present</li>
     * <li>present - header present and syntatically correct</li>
     * <li>invalid - header present, but couldn't be parsed</li>
     * <li>disabled - header present and syntatically correct, but HSTS is
     * disabled</li>
     * </ul>
     */
    public String status;

    /**
     * error message when error is encountered, null otherwise
     */
    public String error;

    /**
     * the max-age value specified in the policy; null if policy is missing or
     * invalid or on parsing error; the maximum value currently supported is
     * 9223372036854775807
     */
    public long maxAge;

    /**
     * true if the includeSubDomains directive is set; null otherwise
     */
    public boolean includeSubDomains;

    /**
     * true if the preload directive is set; null otherwise
     */
    public boolean preload;

}
