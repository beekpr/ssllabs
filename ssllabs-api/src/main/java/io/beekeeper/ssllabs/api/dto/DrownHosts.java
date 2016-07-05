package io.beekeeper.ssllabs.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DrownHosts {

    /**
     * Ip address of server that shares same RSA-Key/hostname in its certificate
     */
    public String ip;

    /**
     * true if export cipher suites detected
     */
    public boolean export;

    /**
     * port number of the server
     */
    public int port;

    /**
     * true if vulnerable OpenSSL version detected
     */
    public boolean special;

    /**
     * true if SSL v2 is supported
     */
    public boolean sslv2;

    /**
     * drown host status:
     * <ul>
     * <li>error - error occurred in test</li>
     * <li>unknown - before the status is checked</li>
     * <li>not_checked - not checked if already vulnerable server found</li>
     * <li>not_checked_same_host - Not checked (same host)</li>
     * <li>handshake_failure - when SSL v2 not supported by server</li>
     * <li>sslv2 - SSL v2 supported but not same rsa key</li>
     * <li>key_match - vulnerable (same key with SSL v2)</li>
     * <li>hostname_match - vulnerable (same hostname with SSL v2)</li>
     * </ul>
     */
    public String status;

}
