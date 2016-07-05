package io.beekeeper.ssllabs.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Endpoint {

    /**
     * endpoint IP address, in IPv4 or IPv6 format.
     */
    public String ipAddress;

    /**
     * server name retrieved via reverse DNS
     */
    public String serverName;

    /**
     * assessment status message; this field will contain "Ready" if the
     * endpoint assessment was successful.
     */
    public String statusMessage;

    /**
     * code of the operation currently in progress
     */
    public String statusDetails;

    /**
     * description of the operation currently in progress
     */
    public String statusDetailsMessage;

    /**
     * possible values: A+, A-, A-F, T (no trust) and M (certificate name
     * mismatch)
     */
    public String grade;

    /**
     * grade (as above), if trust issues are ignored
     */
    public String gradeTrustIgnored;

    /**
     * if this endpoint has warnings that might affect the score (e.g., get A-
     * instead of A).
     */
    public boolean hasWarnings;

    /**
     * this flag will be raised when an exceptional configuration is
     * encountered. The SSL Labs test will give such sites an A+.
     */
    public boolean isExceptional;

    /**
     * assessment progress, which is a value from 0 to 100, and -1 if the
     * assessment has not yet started
     */
    public int progress;

    /**
     * assessment duration, in milliseconds
     */
    public long duration;

    /**
     * estimated time, in seconds, until the completion of the assessment
     */
    public long eta;

    /**
     * indicates domain name delegation with and without the www prefix
     * <ol>
     * <li>bit 0 (1) - set for non-prefixed access</li>
     * <li>bit 1 (2) - set for prefixed access</li>
     * </ol>
     */
    public int delegation;

    /**
     * this field contains an EndpointDetails object. It's not present by
     * default, but can be enabled by using the "all" parameter to the analyze
     * API call.
     */
    public EndpointDetails details;

}
