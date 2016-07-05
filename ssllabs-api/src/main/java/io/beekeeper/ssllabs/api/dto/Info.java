package io.beekeeper.ssllabs.api.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Info {

    /**
     * SSL Labs software version as a string (e.g., "1.11.14")
     */
    public String engineVersion;

    /**
     * rating criteria version as a string (e.g., "2009f")
     */
    public String criteriaVersion;

    /**
     * the maximum number of concurrent assessments the client is allowed to
     * initiate.
     */
    public int maxAssessments;

    /**
     * the number of ongoing assessments submitted by this client.
     */
    public int currentAssessments;

    /**
     * the cool-off period after each new assessment, in milliseconds; you're
     * not allowed to submit a new assessment before the cool-off expires,
     * otherwise you'll get a 429.
     */
    public int newAssessmentCoolOff;

    /**
     * a list of messages (strings). Messages can be public (sent to everyone)
     * and private (sent only to the invoking client). Private messages are
     * prefixed with "[Private]".
     */
    public List<String> messages;

}
