package com.bitso.whalefinpoc;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class WhalefinPoCClient extends WhalefinPoCDefaultClient {

    private static final String whalefinUrl = "https://be-alpha.whalefin.com";

    private static final RestTemplate restTemplate = new RestTemplate();

    private static final String balancePath = "/api/v2/asset/balance";
    private static final String depositPath = "/api/v2/wallet/deposits";
    private static final String earnProductsPath = "/api/v2/earn/products?type=";
    private static final String statementsPath = "/api/v2/asset/statement?type=";
    private static final String interestRecordsPath = "/api/v2/earn/balance/interest/records?ccy=";

    private static Object doRequest(final String method, final String path, final String bodyString) {

        var httpEntity = new HttpEntity<>(
                createHeaders(method, path, bodyString));

        return restTemplate.exchange(
                whalefinUrl + path,
                HttpMethod.valueOf(method),
                httpEntity,
                String.class);
    }

    public static Object getBalances() {
        return doRequest("GET", balancePath, null);
    }

    public static Object getDeposits() {
        return doRequest("GET", depositPath, null);
    }

    public static Object getEarnProductsByType(final String type) {
        return doRequest("GET", earnProductsPath + type, null);
    }

    public static Object getStatementsByType(final String type) {
        return doRequest("GET", statementsPath + type, null);
    }

    public static Object getInterestRecordsByCcy(final String ccy){
        return doRequest("GET", interestRecordsPath + ccy, null);
    }

}
