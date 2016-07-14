package io.beekeeper.ssllabs.junit;

import io.beekeeper.ssllabs.api.dto.Endpoint;
import io.beekeeper.ssllabs.api.dto.Host;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.hamcrest.*;

/**
 * Matcher for an {@link Host} class.
 * 
 * Verifies that a host has endpoints which have grades which are at least of a
 * given grade.
 */
public class HostGradeMatcher extends BaseMatcher<Host> {

    private final static List<String> GRADES = Arrays.asList("A+", "A", "A-", "B", "C", "D", "E", "F");
    
    /** Checks if SSLLabs rating is at least <b>A</b> grade. */
    public final static Matcher<Host> hasAtLeastGradeA = hasAtLeastGrade("A");
    /** Checks if SSLLabs rating is the maxium <b>A+</b>. */
    public final static Matcher<Host> hasAtLeastGradeAPlus = hasAtLeastGrade("A+");
    
    /**
     * Checks if SSLLabs rating is at lease <tt>grade</tt>.
     */
	public static Matcher<Host> hasAtLeastGrade(String grade) {
    	return new HostGradeMatcher(grade);
    }
    
    private final Set<String> acceptableGrades = new HashSet<String>();

    /**
     * Instantiates a new host grade matcher.
     *
     * @param minimumGrade
     *            the minimum grade. The matcher will pass if the endpoint grade
     *            is equal to the minumum grade or if the grade is better. Must
     *            not be <code>null</code>
     */
    public HostGradeMatcher(String minimumGrade) {
        super();
        if (minimumGrade == null || !GRADES.contains(minimumGrade)) {
            throw new IllegalArgumentException("minimumGrade must be one of " + GRADES);
        }

        for (String grade : GRADES) {
            acceptableGrades.add(grade);
            if (grade.equals(minimumGrade)) {
                break;
            }
        }
    }

    @Override
    public boolean matches(Object item) {
        if (item instanceof Host) {
            return getFailingEndpoints((Host)item).isEmpty();
        } else {
            throw new IllegalArgumentException("This matcher only applies to Host Objects");
        }
    }

    @Override
    public void describeMismatch(Object item, Description description) {
        if (item instanceof Host) {
            List<Endpoint> endpoints = getFailingEndpoints((Host)item);
            List<String> out = new ArrayList<>();
            for (Endpoint e : endpoints) {
                out.add("Endpoint " + e.ipAddress + " : " + getEndpointGrade(e));
            }
            description.appendText("was ").appendValueList("[", ", ", "]", out);
        } else {
            throw new IllegalArgumentException("This matcher only applies to Host Objects");
        }
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("all host endpoint grades to be in ")
                   .appendValueList("[", ",", "]", acceptableGrades);
    }

    private List<Endpoint> getFailingEndpoints(Host host) {
        List<Endpoint> result = new LinkedList<Endpoint>();
        for (Endpoint endpoint : host.endpoints) {
            if (!acceptableGrades.contains(getEndpointGrade(endpoint))) {
                result.add(endpoint);
            }
        }
        return result;
    }

    private String getEndpointGrade(Endpoint e) {
        return e.grade;
    }

}