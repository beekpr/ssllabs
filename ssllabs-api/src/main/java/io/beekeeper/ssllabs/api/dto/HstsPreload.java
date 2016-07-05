package io.beekeeper.ssllabs.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The HstsPreload object contains preload HSTS status of one source for the
 * current hostname. Preload checks are done for the current hostname, not for a
 * domain name. For example, a hostname "www.example.com" tested in SSL Labs
 * would come back as "present" if there is an entry for "example.com" with
 * includeSubDomains enabled or if there is an explicit entry for
 * "www.example.com".
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HstsPreload {

    /**
     * source name
     */
    public String source;

    /**
     * preload status:
     * <ul>
     * <li>error</li>
     * <li>unknown - either before the preload status is checked, or if the
     * information is not available for some reason.</li>
     * <li>absent</li>
     * <li>present</li>
     * </ul>
     */
    public String status;

    /**
     * error message, when status is "error"
     */
    public String error;

    /**
     * time, as a Unix timestamp, when the preload database was retrieved
     */
    public long sourceTime;

}
