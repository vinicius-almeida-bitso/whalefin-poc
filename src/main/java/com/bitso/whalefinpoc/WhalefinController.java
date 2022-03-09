package com.bitso.whalefinpoc;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "balance")
@RestController("/whalefin")
public class WhalefinController {

    private static final String getEarnProductsAllowedValues = "FIXED, CUSTOMIZE";

    private static final String getStatementsAllowedValues =
            "DEPOSIT, FIXED_TERM_INTEREST, CURRENT_TERM_INTEREST, REDEMPTION_FEE, COST_INTEREST";

    private static final String getInterestRecordsAllowedValues = "BTC, USD";

    @ApiOperation(value = "get all balances from treasury wallet")
    @GetMapping("/balances")
    public Object getBalances() {
        return WhalefinPoCClient.getBalances();
    }

    @ApiOperation(value = "get all deposits from treasury wallet")
    @GetMapping("/deposits")
    public Object getDeposits() {
        return WhalefinPoCClient.getDeposits();
    }

    @ApiOperation(value = "get all earn products available by type")
    @GetMapping("/earn-products")
    public Object getEarnProductsByType(
            @ApiParam(name = "type", allowableValues = getEarnProductsAllowedValues)
            @RequestParam final String type) {

        return WhalefinPoCClient.getEarnProductsByType(type);
    }

    @ApiOperation(value = "get account statements by type")
    @GetMapping("/statements")
    public Object getStatementsByType(
            @ApiParam(name = "type", allowableValues = getStatementsAllowedValues)
            @RequestParam final String type) {

        return WhalefinPoCClient.getStatementsByType(type);
    }

    @ApiOperation(value = "get all interest records by ccy")
    @GetMapping("/interest-records")
    public Object getInterestRecordsByCcy(
            @ApiParam(name = "ccy", allowableValues = getInterestRecordsAllowedValues)
            @RequestParam final String ccy) {

        return WhalefinPoCClient.getInterestRecordsByCcy(ccy);
    }

}
