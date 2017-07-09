#! /usr/bin/groovy
package org.incognitjoe

import groovy.json.JsonBuilder
@Grab("org.jodd:jodd-http:3.8.5")
import jodd.http.HttpRequest

/**
 * Helper class for making REST calls from a Jenkins Pipeline job.
 */
class JenkinsHttpClient {

    private HttpRequest httpRequest
    private String userAgent = 'Jenkins'

    JenkinsHttpClient() {
        httpRequest = new HttpRequest()
    }

    /**
     * GET method
     * @param url
     * @return response body as String
     */
    def get(String url) {
        def resp = httpRequest.get(url)
                .header("User-Agent", userAgent)
                .send()
        return resp.bodyText()
    }

    /**
     * POST method, convert body Map to application/json.
     * @param url
     * @param body
     * @return response body as String
     */
    def post_json(String url, Map<?, ?> body) {
        String jsonbody = new JsonBuilder(body).toString()
        def resp = httpRequest.post(url)
                .header("User-Agent", userAgent)
                .contentType('application/json')
                .body(jsonbody)
                .send()
        return resp.bodyText()
    }

    /**
     * DELETE method
     * @param url
     * @return
     */
    def delete(String url) {
        def resp = httpRequest.delete(url)
                .header("User-Agent", userAgent)
                .send()
        return resp
    }
}