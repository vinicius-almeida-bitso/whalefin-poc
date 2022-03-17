package com.bitso.whalefinpoc;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import static com.bitso.whalefinpoc.WhalefinPoCDefaultClient.createHeaders;

public class WhalefinPoCClient extends WhalefinPoCClientPaths {

    private static final String WHALEFIN_URL = "https://be-alpha.whalefin.com";

    private static final RestTemplate restTemplate = new RestTemplate();

    private Object doRequest(final String method, final String path, final String bodyString) {

        var httpEntity = new HttpEntity<>(bodyString,
                createHeaders(method, path, bodyString));

        return restTemplate.exchange(
                WHALEFIN_URL + path,
                HttpMethod.valueOf(method),
                httpEntity,
                String.class);
    }

    public Object getBalances() {
        return doRequest("GET", balancePath, null);
    }

    public Object getDeposits() {
        return doRequest("GET", depositPath, null);
    }

    public Object getEarnProductsByType(final String type) {
        return doRequest("GET", earnProductsPath + type, null);
    }

    public Object getStatementsByType(final String type) {
        return doRequest("GET", statementsPath + type, null);
    }

    public Object getInterestRecordsByCcy(final String ccy){
        return doRequest("GET", interestRecordsPath + ccy, null);
    }

    public Object getApy(){
        return doRequest("GET", apyPath, null);
    }

    public Object getAddresses(final String transactionType) {
        return doRequest("GET", addressesPath + transactionType, null);
    }

    @SneakyThrows
    public Object postWithDraw(final WithdrawModel withdrawModel) {
        return doRequest("POST", withdrawPath, new ObjectMapper().writeValueAsString(withdrawModel));
    }
}
