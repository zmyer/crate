package io.crate.rest.action.admin;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.test.ESIntegTestCase;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Locale;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;


@ESIntegTestCase.ClusterScope(scope = ESIntegTestCase.Scope.SUITE, numDataNodes = 2)
public class AdminUIIntegrationTest extends AdminUIHttpIntegrationTest {

    private URI adminURI() throws URISyntaxException {
        return new URI(String.format(Locale.ENGLISH, "http://%s:%d/", address.getHostName(), address.getPort()));
    }

    @Test
    public void testNonBrowserRequestToRoot() throws IOException {
        //request to root
        assertIsJsonInfoResponse(get(""));
    }

    @Test
    public void testBrowserJsonRequestToRoot() throws IOException {
        Header[] headers = {
            browserHeader(),
            new BasicHeader("Accept", "application/json")
        };
        assertIsJsonInfoResponse(get("/", headers));
    }

    @Test
    public void testLegacyRedirect() throws IOException, URISyntaxException {
        //request to '/admin' is redirected to '/index.html'
        Header[] headers = {
            browserHeader()
        };

        List<URI> allRedirectLocations = getAllRedirectLocations("/admin", headers);

        // all redirect locations should not be null
        assertThat(allRedirectLocations, notNullValue());
        // all redirect locations should contain the crateAdminUI URI
        assertThat(allRedirectLocations.contains(adminURI()), is(true));
    }

    @Test
    public void testPostForbidden() throws IOException {
        CloseableHttpResponse response = post("/static/");
        //status should be 403 FORBIDDEN
        assertThat(response.getStatusLine().getStatusCode(), is(403));
    }

    @Test
    public void testGetHTML() throws IOException {
        assertIsIndexResponse(browserGet("/"));
        assertIsIndexResponse(browserGet("/index.html"));
        assertIsIndexResponse(browserGet("//index.html"));
    }

    @Test
    public void testNotFound() throws Exception {
        CloseableHttpResponse response = browserGet("/static/does/not/exist.html");
        assertThat(response.getStatusLine().getStatusCode(), is(404));
    }

    private static void assertIsIndexResponse(CloseableHttpResponse response) throws IOException {
        //response body should not be null
        String bodyAsString = EntityUtils.toString(response.getEntity());
        assertThat(bodyAsString, is("<h1>Crate Admin</h1>\n"));
        assertThat(response.getHeaders("Content-Type")[0].getValue(), is("text/html"));
    }

    private static void assertIsJsonInfoResponse(CloseableHttpResponse response) throws IOException {
        //status should be 200 OK
        assertThat(response.getStatusLine().getStatusCode(), is(200));

        //response body should not be null
        String bodyAsString = EntityUtils.toString(response.getEntity());
        assertThat(bodyAsString, notNullValue());

        //check content-type of response is json
        String contentMimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
        assertThat(contentMimeType, equalTo(ContentType.APPLICATION_JSON.getMimeType()));
    }
}
