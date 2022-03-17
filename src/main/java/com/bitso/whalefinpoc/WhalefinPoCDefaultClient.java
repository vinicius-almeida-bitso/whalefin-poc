package com.bitso.whalefinpoc;

import org.apache.commons.codec.digest.HmacUtils;
import org.springframework.http.HttpHeaders;

import java.sql.Timestamp;
import java.time.ZonedDateTime;

public class WhalefinPoCDefaultClient {

    private WhalefinPoCDefaultClient(){}

    private static final String ACCESS_KEY = System.getenv("WHALEFIN_ACCESS_KEY");

    private static final String ACCESS_SECRET = System.getenv("WHALEFIN_ACCESS_SECRET");

    private static final String GET_SIGN = "method=${method}&path=${path}&timestamp=${timestamp}";

    private static String createSign(final String method,
                                     final String path,
                                     final String bodyString,
                                     final String timestamp) {

        var signStr = GET_SIGN
                .replace("${method}", method)
                .replace("${path}", path)
                .replace("${timestamp}", timestamp);

        if (!method.equals("GET")) {
            signStr += "&body=" + bodyString;
        }

        return new HmacUtils("HmacSHA256", ACCESS_SECRET).hmacHex(signStr);
    }

    static HttpHeaders createHeaders(final String method,
                                     final String path,
                                     final String bodyString) {

        var timestamp = Timestamp
                .from(ZonedDateTime.now().toInstant())
                .toString();

        var accessSign = createSign(method, path, bodyString, timestamp);

        var headers = new HttpHeaders();
        headers.add("access-key", ACCESS_KEY);
        headers.add("access-timestamp", timestamp);
        headers.add("access-sign", accessSign);
        headers.add("Content-Type", "application/json");

        return headers;
    }

}
