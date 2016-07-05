package io.beekeeper.ssllabs.junit;

import io.beekeeper.ssllabs.api.SSLLabsClient;
import io.beekeeper.ssllabs.api.SSLLabsService;
import io.beekeeper.ssllabs.api.dto.Host;

import java.io.IOException;

import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import retrofit2.Call;
import retrofit2.Response;

@RunWith(Parameterized.class)
public class SSLBaseTest {

    private String hostname;
    private SSLLabsService service = new SSLLabsClient().getService();

    protected Matcher<Host> hostMatcher = new HostGradeMatcher("A");

    public SSLBaseTest(String host) {
        this.hostname = host;
    }

    @Test
    public void testHostSSL() throws Exception {

        Host host = startHostAnalysis();
        while (!Host.READY.equals(host.status) && !Host.ERROR.equals(host.status)) {
            host = getHostAnalysis();
            Thread.sleep(15 * 1000);
        }

        Assert.assertThat(host, hostMatcher);
    }

    private Host startHostAnalysis() throws IOException {

        Response<Host> response = callWithRetry(service.analyze(hostname,
                                                                SSLLabsService.OFF,
                                                                SSLLabsService.ON,
                                                                SSLLabsService.OFF,
                                                                null,
                                                                SSLLabsService.DONE,
                                                                SSLLabsService.OFF));

        return response.body();
    }

    private Host getHostAnalysis() throws IOException {

        Response<Host> response = callWithRetry(service.analyze(hostname,
                                                                SSLLabsService.OFF,
                                                                SSLLabsService.OFF,
                                                                SSLLabsService.OFF,
                                                                null,
                                                                SSLLabsService.DONE,
                                                                SSLLabsService.OFF));

        return response.body();
    }

    private <T> Response<T> callWithRetry(Call<T> call) throws IOException {
        int maxTries = 4;
        IOException lastException = null;
        Response<T> response = null;
        do {
            if (maxTries != 4) {
                try {
                    Thread.sleep(3 * 1000);
                } catch (InterruptedException e) {}
            }
            maxTries--;
            Call<T> clone = call.clone();
            try {
                response = clone.execute();
            } catch (IOException e) {
                lastException = e;
            }
        } while (maxTries > 0 && (response == null || !response.isSuccessful()));

        if (response == null || !response.isSuccessful()) {
            String reason = response != null ? response.raw().message() : "IOException";
            throw new IOException("Could not fetch information from the server. Reason: " + reason,
                                  lastException);
        }
        return response;
    }
}