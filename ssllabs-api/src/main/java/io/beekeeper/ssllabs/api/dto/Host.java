package io.beekeeper.ssllabs.api.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Host {

    public static final String DNS = "DNS";
    public static final String ERROR = "ERROR";
    public static final String IN_PROGRESS = "IN_PROGRESS";
    public static final String READY = "READY";

    /**
     * assessment host, which can be a hostname or an IP address
     */
    public String host;

    /**
     * assessment port (e.g., 443)
     */
    public int port;

    /**
     * protocol (e.g., HTTP)
     */
    public String protocol;

    /**
     * true if this assessment is publicly available (listed on the SSL Labs
     * assessment boards)
     */
    public boolean isPublic;

    /**
     * assessment status; possible values: DNS, ERROR, IN_PROGRESS, and READY.
     */
    public String status;

    /**
     * status message in English. When status is ERROR, this field will contain
     * an error message.
     */
    public String statusMessage;

    /**
     * assessment starting time, in milliseconds since 1970
     */
    public long startTime;

    /**
     * assessment completion time, in milliseconds since 1970
     */
    public long testTime;

    /**
     * assessment engine version (e.g., "1.0.120")
     */
    public String engineVersion;

    /**
     * grading criteria version (e.g., "2009")
     */
    public String criteriaVersion;

    /**
     * when will the assessment results expire from the cache (typically set
     * only for assessment with errors; otherwise the results stay in the cache
     * for as long as there's sufficient room)
     */
    public long cacheExpiryTime;

    /**
     * list of Endpoint objects
     */
    public List<Endpoint> endpoints;

    /**
     * the list of certificate hostnames collected from the certificates seen
     * during assessment. The hostnames may not be valid. This field is
     * available only if the server certificate doesn't match the requested
     * hostname. In that case, this field saves you some time as you don't have
     * to inspect the certificates yourself to find out what valid hostnames
     * might be.
     */
    public List<String> certHostnames;
}
