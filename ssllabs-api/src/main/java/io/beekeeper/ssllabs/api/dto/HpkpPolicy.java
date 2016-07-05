package io.beekeeper.ssllabs.api.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HpkpPolicy {

    /**
     * HPKP status:
     * <ul>
     * <li>unknown - either before the server is checked or when its HTTP
     * response headers are not available</li>
     * <li>absent - header not present</li>
     * <li>invalid - header present, but couldn't be parsed</li>
     * <li>disabled - header present and syntatically correct, but HPKP is
     * disabled</li>
     * <li>incomplete - header present and syntatically correct, incorrectly
     * used</li>
     * <li>valid - header present, syntatically correct, and correctly used</li>
     * </ul>
     */
    public String status;

    /**
     * the contents of the HPKP response header, if present
     */
    public String header;

    /**
     * error message, when the policy is invalid
     */
    public String error;

    /**
     * the max-age value from the policy
     */
    public long maxAge;

    /**
     * true if the includeSubDomains directive is set; null otherwise
     */
    public boolean includeSubDomains;

    /**
     * the report-uri value from the policy
     */
    public String reportUri;

    /**
     * list of all pins used by the policy
     */
    public List<String> pins;

}
