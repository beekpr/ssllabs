package io.beekeeper.ssllabs.api;

import io.beekeeper.ssllabs.api.dto.Cert;
import io.beekeeper.ssllabs.api.dto.Endpoint;
import io.beekeeper.ssllabs.api.dto.Host;
import io.beekeeper.ssllabs.api.dto.Info;
import io.beekeeper.ssllabs.api.dto.StatusCodes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SSLLabsService {

    public static String ON = "on";
    public static String OFF = "off";
    public static String DONE = "done";

    /**
     * This call should be used to check the availability of the SSL Labs
     * servers, retrieve the engine and criteria version, and initialize the
     * maximum number of concurrent assessments. Returns one Info object on
     * success.
     */
    @GET("info")
    public Call<Info> info();

    /**
     * This call is used to initiate an assessment, or to retrieve the status of
     * an assessment in progress or in the cache. It will return a single Host
     * object on success. The Endpoint object embedded in the Host object will
     * provide partial endpoint results. Please note that assessments of
     * individual endpoints can fail even when the overall assessment is
     * successful (e.g., one server might be down). At this time, you can
     * determine the success of an endpoint assessment by checking the
     * statusMessage field; it should contain "Ready".
     *
     * @param host
     * @return the host
     */
    @GET("analyze")
    public Call<Host> analyze(@Query("host") String host);

    /**
     * This call is used to initiate an assessment, or to retrieve the status of
     * an assessment in progress or in the cache. It will return a single Host
     * object on success. The Endpoint object embedded in the Host object will
     * provide partial endpoint results. Please note that assessments of
     * individual endpoints can fail even when the overall assessment is
     * successful (e.g., one server might be down). At this time, you can
     * determine the success of an endpoint assessment by checking the
     * statusMessage field; it should contain "Ready".
     *
     * @param host
     * @param publish
     *            set to "on" if assessment results should be published on the
     *            public results boards; optional, defaults to "off".
     * @return the host
     */
    @GET("analyze")
    public Call<Host>
            analyze(@Query("host") String host, @Query("publish") String publish);

    /**
     * This call is used to initiate an assessment, or to retrieve the status of
     * an assessment in progress or in the cache. It will return a single Host
     * object on success. The Endpoint object embedded in the Host object will
     * provide partial endpoint results. Please note that assessments of
     * individual endpoints can fail even when the overall assessment is
     * successful (e.g., one server might be down). At this time, you can
     * determine the success of an endpoint assessment by checking the
     * statusMessage field; it should contain "Ready".
     *
     * @param host
     * @param publish
     *            set to "on" if assessment results should be published on the
     *            public results boards; optional, defaults to "off".
     * @param startNew
     *            if set to "on" then cached assessment results are ignored and
     *            a new assessment is started. However, if there's already an
     *            assessment in progress, its status is delivered instead. This
     *            parameter should be used only once to initiate a new
     *            assessment; further invocations should omit it to avoid
     *            causing an assessment loop.
     * @return the host
     */
    @GET("analyze")
    public Call<Host> analyze(@Query("host") String host,
                              @Query("publish") String publish,
                              @Query("startNew") String startNew);

    /**
     * This call is used to initiate an assessment, or to retrieve the status of
     * an assessment in progress or in the cache. It will return a single Host
     * object on success. The Endpoint object embedded in the Host object will
     * provide partial endpoint results. Please note that assessments of
     * individual endpoints can fail even when the overall assessment is
     * successful (e.g., one server might be down). At this time, you can
     * determine the success of an endpoint assessment by checking the
     * statusMessage field; it should contain "Ready".
     *
     * @param host
     * @param publish
     *            set to "on" if assessment results should be published on the
     *            public results boards; optional, defaults to "off".
     * @param startNew
     *            if set to "on" then cached assessment results are ignored and
     *            a new assessment is started. However, if there's already an
     *            assessment in progress, its status is delivered instead. This
     *            parameter should be used only once to initiate a new
     *            assessment; further invocations should omit it to avoid
     *            causing an assessment loop.
     * @param fromCache
     *            always deliver cached assessment reports if available;
     *            optional, defaults to "off". This parameter is intended for
     *            API consumers that don't want to wait for assessment results.
     *            Can't be used at the same time as the startNew parameter.
     * @return the host
     */
    @GET("analyze")
    public Call<Host> analyze(@Query("host") String host,
                              @Query("publish") String publish,
                              @Query("startNew") String startNew,
                              @Query("fromCache") String fromCache);

    /**
     * This call is used to initiate an assessment, or to retrieve the status of
     * an assessment in progress or in the cache. It will return a single Host
     * object on success. The Endpoint object embedded in the Host object will
     * provide partial endpoint results. Please note that assessments of
     * individual endpoints can fail even when the overall assessment is
     * successful (e.g., one server might be down). At this time, you can
     * determine the success of an endpoint assessment by checking the
     * statusMessage field; it should contain "Ready".
     *
     * @param host
     * @param publish
     *            set to "on" if assessment results should be published on the
     *            public results boards; optional, defaults to "off".
     * @param startNew
     *            if set to "on" then cached assessment results are ignored and
     *            a new assessment is started. However, if there's already an
     *            assessment in progress, its status is delivered instead. This
     *            parameter should be used only once to initiate a new
     *            assessment; further invocations should omit it to avoid
     *            causing an assessment loop.
     * @param fromCache
     *            always deliver cached assessment reports if available;
     *            optional, defaults to "off". This parameter is intended for
     *            API consumers that don't want to wait for assessment results.
     *            Can't be used at the same time as the startNew parameter.
     * @param maxAge
     *            always deliver cached assessment reports if available;
     *            optional, defaults to "off". This parameter is intended for
     *            API consumers that don't want to wait for assessment results.
     *            Can't be used at the same time as the startNew parameter.
     * @return the host
     */
    @GET("analyze")
    public Call<Host> analyze(@Query("host") String host,
                              @Query("publish") String publish,
                              @Query("startNew") String startNew,
                              @Query("fromCache") String fromCache,
                              @Query("maxAge") String maxAge);

    /**
     * This call is used to initiate an assessment, or to retrieve the status of
     * an assessment in progress or in the cache. It will return a single Host
     * object on success. The Endpoint object embedded in the Host object will
     * provide partial endpoint results. Please note that assessments of
     * individual endpoints can fail even when the overall assessment is
     * successful (e.g., one server might be down). At this time, you can
     * determine the success of an endpoint assessment by checking the
     * statusMessage field; it should contain "Ready".
     *
     * @param host
     * @param publish
     *            set to "on" if assessment results should be published on the
     *            public results boards; optional, defaults to "off".
     * @param startNew
     *            if set to "on" then cached assessment results are ignored and
     *            a new assessment is started. However, if there's already an
     *            assessment in progress, its status is delivered instead. This
     *            parameter should be used only once to initiate a new
     *            assessment; further invocations should omit it to avoid
     *            causing an assessment loop.
     * @param fromCache
     *            always deliver cached assessment reports if available;
     *            optional, defaults to "off". This parameter is intended for
     *            API consumers that don't want to wait for assessment results.
     *            Can't be used at the same time as the startNew parameter.
     * @param maxAge
     *            always deliver cached assessment reports if available;
     *            optional, defaults to "off". This parameter is intended for
     *            API consumers that don't want to wait for assessment results.
     *            Can't be used at the same time as the startNew parameter.
     * @param all
     *            by default this call results only summaries of individual
     *            endpoints. If this parameter is set to "on", full information
     *            will be returned. If set to "done", full information will be
     *            returned only if the assessment is complete (status is READY
     *            or ERROR).
     * @param ignoreMismatch
     *            set to "on" to proceed with assessments even when the server
     *            certificate doesn't match the assessment hostname. Set to off
     *            by default. Please note that this parameter is ignored if a
     *            cached report is returned.
     * @return the host
     */
    @GET("analyze")
    public Call<Host> analyze(@Query("host") String host,
                              @Query("publish") String publish,
                              @Query("startNew") String startNew,
                              @Query("fromCache") String fromCache,
                              @Query("maxAge") String maxAge,
                              @Query("all") String all,
                              @Query("ignoreMismatch") String ignoreMismatch);

    /**
     * This call is used to retrieve detailed endpoint information. It will
     * return a single Endpoint object on success. The object will contain
     * complete assessment information. This API call does not initiate new
     * assessments, even when a cached report is not found.
     *
     * @param host
     * @param s
     *            endpoint IP address
     * @param fromCache
     *            always deliver cached assessment reports if available;
     *            optional, defaults to "off". This parameter is intended for
     *            API consumers that don't want to wait for assessment results.
     *            Can't be used at the same time as the startNew parameter.
     * @return the endpoint data
     */
    @GET("getEndpointData")
    public Call<Endpoint> getEndpointData(@Query("host") String host,
                                          @Query("s") String s,
                                          @Query("fromCache") String fromCache);

    /**
     * This call will return one StatusCodes instance.
     */
    @GET("getStatusCodes")
    public Call<StatusCodes> getStatusCodes();

    /**
     * This call will return one StatusCodes instance.
     */
    @GET("getRootCertsRaw")
    public Call<List<Cert>> getRootCertsRaw();
}
