package org.HTTPRequests;

import java.io.*;
import java.net.*;
import java.net.http.HttpClient;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Drive {
     public class ParameterStringBuilder {
          public static String getParamsString(Map<String, String> params)
                  throws UnsupportedEncodingException{
              StringBuilder result = new StringBuilder();

              for (Map.Entry<String, String> entry : params.entrySet()) {
                  result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                  result.append("=");
                  result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                  result.append("&");
              }

              String resultString = result.toString();
              return resultString.length() > 0
                      ? resultString.substring(0, resultString.length() - 1)
                      : resultString;
          }
      }
    public static void main(String[] args) throws IOException, URISyntaxException {
        HttpClient httpClient = HttpClient.newHttpClient();


       URL url = new URL("https://mangalib.me/api/list");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
     /*   HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .header("Token", "")
                .header("Content-Length", "")
                .uri(new URI("https://mangalib.me/api/list")).build();*/
      /*  con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Token", "");
        con.setRequestProperty("Content-Length", "");
        con.setRequestProperty("Host", "");
        con.setRequestProperty("x-xsrf-token","" );
        con.setRequestProperty("Cookie", "cookies");*/
        Map<String, String> parameters = new HashMap<>();
        parameters.put("sort", "rate");
        parameters.put("dir", "desc");
        parameters.put("page", "2");
        parameters.put("site-id", "1");
        parameters.put("type", "manga");
        parameters.put("caution-list", "\"^О^т^с^у^т^с^т^в^у^е^т\",\"16+\",\"18+\"");

        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();

        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);
        String cookiesHeader = con.getHeaderField("Set-Cookie");
        List<HttpCookie> cookies = HttpCookie.parse(cookiesHeader);



    /*    URL url = new URL("https://mangalib.me/api/list");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        String cookiesHeader = con.getHeaderField("set-cookie");
        List<HttpCookie> cookies = HttpCookie.parse(cookiesHeader);
        con.setRequestMethod("POST");
        con.setRequestProperty("Token", "");
        con.setRequestProperty("Content-Length", "");
        con.setRequestProperty("Host", "");
        con.setRequestProperty("x-xsrf-token",cookies.toString() );
        con.setRequestProperty("Cookie", "cookies");




        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);
        Map<String, String> parameters = new HashMap<>();
        parameters.put("sort", "rate");
        parameters.put("dir", "desc");
        parameters.put("page", "2");
        parameters.put("site-id", "1");
        parameters.put("type", "manga");
        parameters.put("caution-list", "\"^О^т^с^у^т^с^т^в^у^е^т\",\"16+\",\"18+\"");
        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());

        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();




        con.disconnect();

        con = (HttpURLConnection) url.openConnection();

        int status = con.getResponseCode();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();

    }

    }
class ParameterStringBuilder {
    public static String getParamsString(Map<String, String> params)
            throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, String> entry : params.entrySet()) {
            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            result.append("&");
        }

        String resultString = result.toString();
        return resultString.length() > 0
                ? resultString.substring(0, resultString.length() - 1)
                : resultString;*/
    }
}