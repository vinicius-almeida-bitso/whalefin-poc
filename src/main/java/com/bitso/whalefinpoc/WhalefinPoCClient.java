package com.bitso.whalefinpoc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import static com.bitso.whalefinpoc.WhalefinPoCDefaultClient.createHeaders;

public class WhalefinPoCClient {

    private static final String WHALEFIN_URL = "https://be-alpha.whalefin.com";

    private static final RestTemplate restTemplate = new RestTemplate();

    @Value("${whalefin.asset.balance.endpoint:/api/v2/asset/balance}")
    private String balancePath;

    @Value("${whalefin.wallet.deposit.endpoint:/api/v2/wallet/deposits}")
    private String depositPath;

    @Value("${whalefin.earn.product.endpoint:/api/v2/earn/products?type=}")
    private String earnProductsPath;

    @Value("${whalefin.asset.statement.endpoint:/api/v2/asset/statement?type=}")
    private String statementsPath;

    @Value("${whalefin.earn.balance.interest.endpoint:/api/v2/earn/balance/interest/records?ccy=}")
    private String interestRecordsPath;

    @Value("${whalefin.earn.balance.apy.endpoint:/api/v2/earn/balance/apy}")
    private String apyPath;

    private Object doRequest(final String method, final String path, final String bodyString) {

        var httpEntity = new HttpEntity<>(
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

}
