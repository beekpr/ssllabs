package io.beekeeper.ssllabs.junit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import io.beekeeper.ssllabs.api.dto.Endpoint;
import io.beekeeper.ssllabs.api.dto.Host;

/**
 * Matcher that checks if a given protocol is <i>offered</i> or <i>not
 * offered</i> by a given {@link Host}. With this matcher you can make sure that
 * SSLv3 is disabled or TLS 1.0 is enabled (required by Android &lt; 4.4).
 * 
 * <pre>
 * <code>
 * import static io.beekeeper.ssllabs.test.ProtocolMatcher.*;
 * ...
 * assertThat(host, hasProtocols(offered(TLS_1_0), notOffered(SSLv3)));
 * </code>
 * </pre>
 */
public class ProtocolMatcher extends TypeSafeMatcher<Host> {

	public final static Protocol SSLv2 = new Protocol("SSL", "2");
	public final static Protocol SSLv3 = new Protocol("SSL", "3");
	public final static Protocol TLS_1_0 = new Protocol("TLS", "1.0");
	public final static Protocol TLS_1_1 = new Protocol("TLS", "1.1");
	public final static Protocol TLS_1_2 = new Protocol("TLS", "1.2");

	public static Matcher<Host> hasProtocols(ProtocolMatcher.ProtocolRequirement... requirements) {
		return new ProtocolMatcher(Arrays.asList(requirements));
	}

	public static ProtocolMatcher.ProtocolRequirement offered(String protocol, String version) {
		return offered(new Protocol(protocol, version));
	}

	public static ProtocolMatcher.ProtocolRequirement offered(Protocol protocol) {
		return new ProtocolRequirement(protocol, true);
	}

	public static ProtocolMatcher.ProtocolRequirement notOffered(String protocol, String version) {
		return notOffered(new Protocol(protocol, version));
	}

	public static ProtocolMatcher.ProtocolRequirement notOffered(Protocol protocol) {
		return new ProtocolRequirement(protocol, false);
	}

	private static class Protocol {

		private final String name;
		private final String version;

		Protocol(String name, String version) {
			this.name = name;
			this.version = version;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + ((version == null) ? 0 : version.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			final ProtocolMatcher.Protocol other = (ProtocolMatcher.Protocol) obj;
			if (name == null) {
				if (other.name != null) {
					return false;
				}
			} else if (!name.equals(other.name)) {
				return false;
			}
			if (version == null) {
				if (other.version != null) {
					return false;
				}
			} else if (!version.equals(other.version)) {
				return false;
			}
			return true;
		}

		@Override
		public String toString() {
			return "Protocol " + name + " " + version;
		}

	}

	public static class ProtocolRequirement {

		private final ProtocolMatcher.Protocol protocol;
		private final boolean present;

		private ProtocolRequirement(ProtocolMatcher.Protocol protocol, boolean present) {
			this.protocol = protocol;
			this.present = present;
		}

		public ProtocolMatcher.Protocol getProtocol() {
			return protocol;
		}

		public boolean isPresent() {
			return present;
		}

		@Override
		public String toString() {
			return protocol.toString() + " is " + (present ? "offered" : "not-offered");
		}

	}

	private static class ProtocolMismatch {

		private String endpoint;
		private ProtocolMatcher.ProtocolRequirement requirement;

		ProtocolMismatch(String endpoint, ProtocolMatcher.ProtocolRequirement requirement) {
			super();
			this.endpoint = endpoint;
			this.requirement = requirement;
		}

		@Override
		public String toString() {
			return "Endpoint " + endpoint + " " + (requirement.present ? "didn't offer" : "offered") + " "
					+ requirement.protocol.toString();
		}

	}

	private final Collection<ProtocolMatcher.ProtocolRequirement> requirements;

	private ProtocolMatcher(final Collection<ProtocolMatcher.ProtocolRequirement> requirements) {
		this.requirements = requirements;
	}

	@Override
	public void describeTo(final Description description) {
		description.appendValueList("[", ",", "]", requirements);

	}

	@Override
	protected void describeMismatchSafely(final Host host, final Description description) {
		final Collection<ProtocolMatcher.ProtocolMismatch> mistmatches = checkRequirements(host);
		description.appendText("but ").appendValueList("[", ",", "]", mistmatches);
	}

	@Override
	protected boolean matchesSafely(final Host host) {
		final Collection<ProtocolMatcher.ProtocolMismatch> mistmatches = checkRequirements(host);
		return mistmatches.isEmpty();
	}

	private Collection<ProtocolMatcher.ProtocolMismatch> checkRequirements(final Host host) {
		final Collection<ProtocolMatcher.ProtocolMismatch> mismatches = new ArrayList<>();
		for (final Endpoint endpoint : host.endpoints) {
			for (final ProtocolMatcher.ProtocolRequirement requirement : requirements) {
				boolean offered = isProtocolOffered(requirement, endpoint);
				if (requirement.present != offered) {
					mismatches.add(new ProtocolMismatch(endpoint.serverName, requirement));
				}
			}
		}
		return mismatches;
	}

	private boolean isProtocolOffered(final ProtocolMatcher.ProtocolRequirement requirement, final Endpoint endpoint) {
		boolean offered = false;
		for (final io.beekeeper.ssllabs.api.dto.Protocol protocol : endpoint.details.protocols) {
			if (requirement.protocol.equals(new Protocol(protocol.name, protocol.version))) {
				offered = true;
				break;
			}
		}
		return offered;
	}

}