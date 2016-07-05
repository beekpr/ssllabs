package io.beekeeper.ssllabs.api.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Chain {

    /**
     * a list of ChainCert objects, representing the chain certificates in the
     * order in which they were retrieved from the server
     */
    public List<Cert> certs;

    /**
     * a number of flags that describe the chain and the problems it has:
     * <ul>
     * <li>bit 0 (1) - unused</li>
     * <li>bit 1 (2) - incomplete chain (set only when we were able to build a
     * chain by adding missing intermediate certificates from external sources)</li>
     * <li>bit 2 (4) - chain contains unrelated or duplicate certificates (i.e.,
     * certificates that are not part of the same chain)</li>
     * <li>bit 3 (8) - the certificates form a chain (trusted or not), but the
     * order is incorrect</li>
     * <li>bit 4 (16) - contains a self-signed root certificate (not set for
     * self-signed leafs)</li>
     * <li>bit 5 (32) - the certificates form a chain (if we added external
     * certificates, bit 1 will be set), but we could not validate it. If the
     * leaf was trusted, that means that we built a different chain we trusted.</li>
     * </ul>
     */
    public int issues;
}
