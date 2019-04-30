package com.fonowizja.pdfFromUrl;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author krzysztof.kramarz
 */
class StareHttp
{
   public void doSmth()
   {
      try
      {

         URL url = new URL("https://www.oracle.com/webfolder/technetwork/tutorials/moocjdk8/documents/week1/lesson-1-1.pdf");
         HttpURLConnection connection1 = (HttpURLConnection) url.openConnection();
         connection1.setRequestMethod("GET");

         connection1.getResponseMessage();
         connection1.getResponseCode();
         InputStream bodyStream = connection1.getInputStream();
         InputStreamReader inputStreamReader = new InputStreamReader(bodyStream);
         BufferedReader in = new BufferedReader(inputStreamReader);
         StringBuffer content = new StringBuffer();
         String linia;
         while ((linia = in.readLine()) != null)
         {
            content.append(linia);
         }
         in.close();
         connection1.disconnect();
         System.out.println(content);
         FileWriter fileWriter = new FileWriter("my2.txt");
         PrintWriter printWriter = new PrintWriter(fileWriter);
         printWriter.print(content.toString());
         printWriter.close();
         fileWriter.close();

      }
      catch (IOException s)
      {
         s.printStackTrace();
      }
   }
}
