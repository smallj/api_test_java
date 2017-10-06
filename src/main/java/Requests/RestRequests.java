package Requests;

/**
 * Created by jsmall on 3/24/2017.
 */
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

public class RestRequests {

    public RestRequests() {}

    public static <T> ResponseEntity<T> GetRequest(String url, HttpHeaders header, Class<T> responseType, Map<String, String> params) {

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> requestHeader = new HttpEntity<String>(header);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);

        //Parameters
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                builder.queryParam(entry.getKey().toString(), entry.getValue().toString());
            }
        }

        return restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, requestHeader, responseType);

    }

    public static <T> ResponseEntity<T> PostRequest(String url, HttpHeaders header, Object body, Class<T> responseType, Map<String, String> params) {

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<?> requestEntity;
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);

        if ((body != null) && (header == null))
            requestEntity = new HttpEntity<>(body);
        else if ((header != null) && (body == null))
            requestEntity = new HttpEntity<>(header);
        else if ((header != null) && (body != null))
            requestEntity = new HttpEntity<>(body, header);
        else
            requestEntity = null;

        //Parameters
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                builder.queryParam(entry.getKey().toString(), entry.getValue().toString());
            }
        }

        return restTemplate.postForEntity(builder.build().encode().toUri(), requestEntity, responseType);
    }
    
    public static <T> ResponseEntity<T> PutRequest(String url, HttpHeaders header, Object body, Class<T> responseType, Map<String, String> params) {

    	RestTemplate restTemplate = new RestTemplate();
        HttpEntity<?> requestEntity;
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);

        if ((body != null) && (header == null))
            requestEntity = new HttpEntity<>(body);
        else if ((header != null) && (body == null))
            requestEntity = new HttpEntity<>(header);
        else if ((header != null) && (body != null))
            requestEntity = new HttpEntity<>(body, header);
        else
            requestEntity = null;

        //Parameters
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                builder.queryParam(entry.getKey().toString(), entry.getValue().toString());
            }
        }

        return restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.PUT, requestEntity, responseType);
    }

    public static <T> ResponseEntity<T> Request(HttpMethod method, String url, HttpHeaders header, Object body, Class<T> responseType, Map<String, String> params) {

    	RestTemplate restTemplate = new RestTemplate();
        HttpEntity<?> requestEntity;
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);

        if ((body != null) && (header == null))
            requestEntity = new HttpEntity<>(body);
        else if ((header != null) && (body == null))
            requestEntity = new HttpEntity<>(header);
        else if ((header != null) && (body != null))
            requestEntity = new HttpEntity<>(body, header);
        else
            requestEntity = null;

        //Parameters
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                builder.queryParam(entry.getKey().toString(), entry.getValue().toString());
            }
        }

        return restTemplate.exchange(builder.build().encode().toUri(), method, requestEntity, responseType);
    }
}
