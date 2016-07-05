package io.beekeeper.ssllabs.api.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cert {

    /**
     * certificate subject
     */
    public String subject;

    /**
     * common names extracted from the subject
     */
    public List<String> commonNames;

    /**
     * alternative names
     */
    public List<String> altNames;

    /**
     * timestamp before which the certificate is not valid
     */
    public long notBefore;

    /**
     * timestamp after which the certificate is not valid
     */
    public long notAfter;

    /**
     * issuer subject
     */
    public String issuerSubject;

    /**
     * certificate signature algorithm
     */
    public String sigAlg;

    /**
     * issuer name
     */
    public String issuerLabel;

    /**
     * a number that represents revocation information present in the
     * certificate:
     * <ul>
     * <li>bit 0 (1) - CRL information available</li>
     * <li>bit 1 (2) - OCSP information available</li>
     * </ul>
     */
    public int revocationInfo;

    /**
     * CRL URIs extracted from the certificate
     */
    public List<String> crlURIs;

    /**
     * OCSP URIs extracted from the certificate
     */
    public List<String> ocspURIs;

    /**
     * a number that describes the revocation status of the certificate:
     * <ul>
     * <li>0 - not checked</li>
     * <li>1 - certificate revoked</li>
     * <li>2 - certificate not revoked</li>
     * <li>3 - revocation check error</li>
     * <li>4 - no revocation information</li>
     * <li>5 - internal error</li>
     * </ul>
     */
    public int revocationStatus;

    /**
     * same as revocationStatus, but only for the CRL information (if any).
     */
    public String crlRevocationStatus;

    /**
     * same as revocationStatus, but only for the OCSP information (if any).
     */
    public String ocspRevocationStatus;

    /**
     * Server Gated Cryptography support; integer: bit 1 (1) - Netscape SGC bit
     * 2 (2) - Microsoft SGC
     */
    public int sgc;

    /**
     * E for Extended Validation certificates; may be null if unable to
     * determine
     */
    public String validationType;

    /**
     * list of certificate issues, one bit per issue:
     * <ul>
     * <li>bit 0 (1) - no chain of trust</li>
     * <li>bit 1 (2) - not before</li>
     * <li>bit 2 (4) - not after</li>
     * <li>bit 3 (8) - hostname mismatch</li>
     * <li>bit 4 (16) - revoked</li>
     * <li>bit 5 (32) - bad common name</li>
     * <li>bit 6 (64) - self-signed</li>
     * <li>bit 7 (128) - blacklisted</li>
     * <li>bit 8 (256) - insecure signature</li>
     * </ul>
     */
    public int issues;

    /**
     * true if the certificate contains an embedded SCT; false otherwise.
     */
    public boolean sct;

}
