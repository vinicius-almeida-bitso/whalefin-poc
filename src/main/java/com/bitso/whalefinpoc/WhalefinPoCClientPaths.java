package com.bitso.whalefinpoc;

import org.springframework.beans.factory.annotation.Value;

public class WhalefinPoCClientPaths {

    @Value("${whalefin.asset.balance.endpoint:/api/v2/asset/balance}")
    protected String balancePath;

    @Value("${whalefin.wallet.deposit.endpoint:/api/v2/wallet/deposits}")
    protected String depositPath;

    @Value("${whalefin.earn.product.endpoint:/api/v2/earn/products?type=}")
    protected String earnProductsPath;

    @Value("${whalefin.asset.statement.endpoint:/api/v2/asset/statement?type=}")
    protected String statementsPath;

    @Value("${whalefin.earn.balance.interest.endpoint:/api/v2/earn/balance/interest/records?ccy=}")
    protected String interestRecordsPath;

    @Value("${whalefin.earn.balance.apy.endpoint:/api/v2/earn/balance/apy}")
    protected String apyPath;

    @Value("${whalefin.wallet.addresses.endpoint:/api/v2/wallet/addresses?transactionType=}")
    protected String addressesPath;

    @Value("${whalefin.wallet.withdraw.endpoint:/api/v2/wallet/withdrawals}")
    protected String withdrawPath;

}
