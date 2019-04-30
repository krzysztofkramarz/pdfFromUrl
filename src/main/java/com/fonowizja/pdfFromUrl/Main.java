package com.fonowizja.pdfFromUrl;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @author krzysztof.kramarz
 */
class Main
{

   public static void main(String[] args) throws IOException, InterruptedException
   {
      NoweHttp noweHttp = new NoweHttp();
      HttpClient client = noweHttp.getHttpClient();
      HttpRequest request = noweHttp.getHttpRequest();

      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
      System.out.println(response.statusCode());
      System.out.println(response.body());
      
   }
}
