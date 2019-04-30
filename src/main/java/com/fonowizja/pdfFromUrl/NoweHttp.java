package com.fonowizja.pdfFromUrl;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.time.Duration;

/**
 * @author krzysztof.kramarz
 */
class NoweHttp
{

   public HttpClient getHttpClient()
   {
      return HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)  // this is the default
            .build();
   }

   public HttpRequest getHttpRequest()
   {
      return HttpRequest.newBuilder()
            .uri(URI.create("https://www.oracle.com/webfolder/technetwork/tutorials/moocjdk8/documents/week1/lesson-1-1.pdf"))
            .timeout(Duration.ofMinutes(2))
            .GET()
            .build();

   }

}
