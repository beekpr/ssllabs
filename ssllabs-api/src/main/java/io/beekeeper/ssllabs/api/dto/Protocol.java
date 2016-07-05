package io.beekeeper.ssllabs.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Protocol {

    /**
     * protocol version number, e.g. 0x0303 for TLS 1.2
     */
    public String id;

    /**
     * protocol name, i.e. SSL or TLS.
     */
    public String name;

    /**
     * protocol name, i.e. SSL or TLS.
     */
    public String version;

    /**
     * some servers have SSLv2 protocol enabled, but with all SSLv2 cipher
     * suites disabled. In that case, this field is set to true.
     */
    public String v2SuitesDisabled;

    /**
     * 0 if the protocol is insecure, null otherwise
     */
    public Integer q;

}
