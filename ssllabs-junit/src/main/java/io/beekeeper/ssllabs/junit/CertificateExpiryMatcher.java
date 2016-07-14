package io.beekeeper.ssllabs.junit;

import java.time.*;
import java.util.*;

import org.hamcrest.*;

import io.beekeeper.ssllabs.api.dto.*;


/**
 * Checks if the certificate expirce in a given amount of time.
 * 
 * Usage:
 * <code><pre>
 * CertificateExpiryMatcher.willNotExpireFor(Duration.ofDays(30))
 * </pre></code>
 */
public class CertificateExpiryMatcher extends TypeSafeMatcher<Host> {
	
	
	private final Duration timeLeft;
	
	public static Matcher<Host> willNotExpireFor(final Duration timeLeft) {
		return new CertificateExpiryMatcher(timeLeft);
	}
	
	
	private CertificateExpiryMatcher(final Duration timeLeft) {
		this.timeLeft = timeLeft;
	}

	@Override
	protected void describeMismatchSafely(Host host, Description description) {
		description.appendText("but ").appendValueList("[", ",", "]", checkExpiryOfCertificatesOn(host));
	}
	
	@Override
	public void describeTo(Description description) {
		description.appendText(" the certificate should expire after " + Instant.now().plus(timeLeft).toString());
	}


	private static class ExpiredCertifice {
		
		private final String endpoint;
		private final long expiry;
		
		public ExpiredCertifice(String endpoint, long expiry) {
			super();
			this.endpoint = endpoint;
			this.expiry = expiry;
		}
		
		@Override
		public String toString() {
			return "it will expire on " + Instant.ofEpochMilli(expiry).toString() + " on " + endpoint;
		}
		
	}
	
	@Override
	protected boolean matchesSafely(Host host) {
		final List<ExpiredCertifice> expiredCertificates = checkExpiryOfCertificatesOn(host);
		return expiredCertificates.isEmpty();
	}


	private List<ExpiredCertifice> checkExpiryOfCertificatesOn(Host host) {
		final List<ExpiredCertifice> mismatches = new ArrayList<>(); 
		for (Endpoint endpoint : host.endpoints) {
			final long expiry = endpoint.details.cert.notAfter;
			final long expectedMinExpiry = Instant.now().plus(timeLeft).toEpochMilli();
			
			if (expectedMinExpiry > expiry) {
				mismatches.add(new ExpiredCertifice(endpoint.serverName + "(" + host.host + ")", expiry));
			}
		}
		return mismatches;
	}
	
	
	

}
