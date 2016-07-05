package io.beekeeper.ssllabs.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChainCert {

    /**
     * certificate subject
     */
    public String subject;

    /**
     * certificate label (user-friendly name)
     */
    public String label;

    /**
     * 
     */
    public long notBefore;

    /**
     * 
     */
    public long notAfter;

    /**
     * issuer subject
     */
    public String issuerSubject;

    /**
     * issuer label (user-friendly name)
     */
    public String issuerLabel;

    /**
     * 
     */
    public String sigAlg;

    /**
     * a number of flags the describe the problems with this certificate:
     * <ul>
     * <li>bit 0 (1) - certificate not yet valid</li>
     * <li>bit 1 (2) - certificate expired</li>
     * <li>bit 2 (4) - weak key</li>
     * <li>bit 3 (8) - weak signature</li>
     * <li>bit 4 (16) - blacklisted</li>
     * </ul>
     */
    public int issues;

    /**
     * key algorithm
     */
    public String keyAlg;

    /**
     * key size, in bits appropriate for the key algorithm.
     */
    public int keySize;

    /**
     * key strength, in equivalent RSA bits
     */
    public int keyStrength;

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
    public String revocationStatus;

    /**
     * same as revocationStatus, but only for the CRL information (if any).
     */
    public String crlRevocationStatus;

    /**
     * same as revocationStatus, but only for the OCSP information (if any).
     */
    public String ocspRevocationStatus;

    /**
     * PEM-encoded certificate data
     */
    public String raw;

}
