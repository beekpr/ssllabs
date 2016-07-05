package io.beekeeper.ssllabs.api.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EndpointDetails {

    /**
     * endpoint assessment starting time, in milliseconds since 1970. This field
     * is useful when test results are retrieved in several HTTP invocations.
     * Then, you should check that the hostStartTime value matches the startTime
     * value of the host.
     */
    public String hostStartTime;

    /**
     * key information
     */
    public Key key;

    /**
     * certificate information
     */
    public Cert cert;

    /**
     * chain information
     */
    public Chain chain;

    /**
     * supported protocols
     */
    public List<Protocol> protocols;

    /**
     * supported cipher suites
     */
    public Suite suites;

    /**
     * Contents of the HTTP Server response header when known. This field could
     * be absent for one of two reasons: 1) the HTTP request failed (check
     * httpStatusCode) or 2) there was no Server response header returned.
     */
    public String serverSignature;

    /**
     * true if this endpoint is reachable via a hostname with the www prefix
     */
    public boolean prefixDelegation;

    /**
     * true if this endpoint is reachable via a hostname without the www prefix
     */
    public boolean nonPrefixDelegation;

    /**
     * true if the endpoint is vulnerable to the BEAST attack
     */
    public boolean vulnBeast;

    /**
     * this is an integer value that describes the endpoint support for
     * renegotiation:
     * <ul>
     * <li>bit 0 (1) - set if insecure client-initiated renegotiation is
     * supported</li>
     * <li>bit 1 (2) - set if secure renegotiation is supported</li>
     * <li>bit 2 (4) - set if secure client-initiated renegotiation is supported
     * </li>
     * <li>bit 3 (8) - set if the server requires secure renegotiation support</li>
     * </ul>
     */
    public int renegSupport;

    /**
     * this is an integer value that describes endpoint support for session
     * resumption. The possible values are:
     * <ul>
     * <li>0 - session resumption is not enabled and we're seeing empty session
     * IDs</li>
     * <li>1 - endpoint returns session IDs, but sessions are not resumed</li>
     * <li>2 - session resumption is enabled</li>
     * </ul>
     */
    public int sessionResumption;

    /**
     * integer value that describes supported compression methods bit 0 is set
     * for DEFLATE
     */
    public int compressionMethods;

    /**
     * true if the server supports NPN
     */
    public boolean supportsNpn;

    /**
     * space separated list of supported protocols
     */
    public String npnProtocols;

    /**
     * indicates support for Session Tickets
     * <ul>
     * <li>bit 0 (1) - set if session tickets are supported</li>
     * <li>bit 1 (2) - set if the implementation is faulty [not implemented]</li>
     * <li>bit 2 (4) - set if the server is intolerant to the extension</li>
     * </ul>
     */
    public int sessionTickets;

    /**
     * true if OCSP stapling is deployed on the server
     */
    public boolean ocspStapling;

    /**
     * same as Cert.revocationStatus, but for the stapled OCSP response.
     */
    public String staplingRevocationStatus;

    /**
     * description of the problem with the stapled OCSP response, if any.
     */
    public String staplingRevocationErrorMessage;

    /**
     * if SNI support is required to access the web site.
     */
    public boolean sniRequired;

    /**
     * status code of the final HTTP response seen. When submitting HTTP
     * requests, redirections are followed, but only if they lead to the same
     * hostname. If this field is not available, that means the HTTP request
     * failed.
     */
    public int httpStatusCode;

    /**
     * available on a server that responded with a redirection to some other
     * hostname.
     */
    public String httpForwarding;

    /**
     * true if the server supports at least one RC4 suite.
     */
    public boolean supportsRc4;

    /**
     * true if RC4 is used with modern clients.
     */
    public boolean rc4WithModern;

    /**
     * true if only RC4 suites are supported.
     */
    public boolean rc4Only;

    /**
     * indicates support for Forward Secrecy
     * <ul>
     * <li>bit 0 (1) - set if at least one browser from our simulations
     * negotiated a Forward Secrecy suite.</li>
     * <li>bit 1 (2) - set based on Simulator results if FS is achieved with
     * modern clients. For example, the server supports ECDHE suites, but not
     * DHE.</li>
     * <li>bit 2 (4) - set if all simulated clients achieve FS. In other words,
     * this requires an ECDHE + DHE combination to be supported.</li>
     * </ul>
     */
    public int forwardSecrecy;

    /**
     * instance of SimDetails.
     */
    public SimDetails sims;

    /**
     * true if the server is vulnerable to the Heartbleed attack.
     */
    public boolean heartbleed;

    /**
     * true if the server supports the Heartbeat extension.
     */
    public boolean heartbeat;

    /**
     * results of the CVE-2014-0224 test:
     * <ul>
     * <li>-1 - test failed</li>
     * <li>0 - unknown</li>
     * <li>1 - not vulnerable</li>
     * <li>2 - possibly vulnerable, but not exploitable</li>
     * <li>3 - vulnerable and exploitable</li>
     * </ul>
     */
    public int openSslCcs;

    /**
     * results of the CVE-2016-2107 test:
     * <ul>
     * <li>-1 - test failed</li>
     * <li>0 - unknown</li>
     * <li>1 - not vulnerable</li>
     * <li>2 - vulnerable and insecure</li>
     * </ul>
     */
    public int openSSLLuckyMinus20;

    /**
     * true if the endpoint is vulnerable to POODLE; false otherwise
     */
    public boolean poodle;

    /**
     * results of the POODLE TLS test:
     * <ul>
     * <li>-3 - timeout</li>
     * <li>-2 - TLS not supported</li>
     * <li>-1 - test failed</li>
     * <li>0 - unknown</li>
     * <li>1 - not vulnerable</li>
     * <li>2 - vulnerable</li>
     * </ul>
     */
    public int poodleTls;

    /**
     * true if the server supports TLS_FALLBACK_SCSV, false if it doesn't. This
     * field will not be available if the server's support for TLS_FALLBACK_SCSV
     * can't be tested because it supports only one protocol version (e.g., only
     * TLS 1.2).
     */
    public boolean fallbackScsv;

    /**
     * true of the server is vulnerable to the FREAK attack, meaning it supports
     * 512-bit key exchange.
     */
    public boolean freak;

    /**
     * information about the availability of certificate transparency
     * information (embedded SCTs): bit 0 (1) - SCT in certificate bit 1 (2) -
     * SCT in the stapled OCSP response bit 2 (4) - SCT in the TLS extension
     * (ServerHello)
     */
    public boolean hasSct;

    /**
     * list of hex-encoded DH primes used by the server. Not present if the
     * server doesn't support the DH key exchange.
     */
    public List<String> dhPrimes;

    /**
     * whether the server uses known DH primes. Not present if the server
     * doesn't support the DH key exchange. Possible values: 0 - no 1 - yes, but
     * they're not weak 2 - yes and they're weak
     */
    public boolean dhUsesKnownPrimes;

    /**
     * true if the DH ephemeral server value is reused. Not present if the
     * server doesn't support the DH key exchange.
     */
    public boolean dhYsReuse;

    /**
     * true if the server uses DH parameters weaker than 1024 bits.
     */
    public boolean logjam;

    /**
     * true if the server takes into account client preferences when deciding if
     * to use ChaCha20 suites.
     */
    public boolean chaCha20Preference;

    /**
     * server's HSTS policy. Experimental.
     */
    public HstsPolicy hstsPolicy;

    /**
     * information about preloaded HSTS policies.
     */
    public List<HstsPreload> hstsPreloads;

    /**
     * server's HPKP policy. Experimental.
     */
    public HpkpPolicy hpkpPolicy;

    /**
     * server's HPKP RO (Report Only) policy. Experimental.
     */
    public HpkpPolicy hpkpRoPolicy;

    /**
     * list of drown hosts. Experimental.
     */
    public List<DrownHosts> drownHosts;

    /**
     * true if error occurred in drown test.
     */
    public boolean drownErrors;

    /**
     * true if server vulnerable to drown attack.
     */
    public boolean drownVulnerable;

}
