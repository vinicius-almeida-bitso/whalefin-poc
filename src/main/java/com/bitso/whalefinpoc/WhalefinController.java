package com.bitso.whalefinpoc;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Api(value = "balance")
@RestController("/whalefin")
@RequiredArgsConstructor
public class WhalefinController {

    private static final String GET_EARN_PRODUCTS_ALLOWED_VALUES = "FIXED, CUSTOMIZE";

    private static final String GET_STATEMENTS_ALLOWED_VALUES =
            "DEPOSIT, WITHDRAW, TRANSFER, RED_PACKET, FIXED_TERM_INTEREST, " +
                    "CURRENT_TERM_INTEREST, REDEMPTION_FEE, COST_INTEREST";

    private static final String GET_INTEREST_RECORDS_ALLOWED_VALUES = "BTC, USD";

    private static final String GET_TRANSACTION_TYPE_ALLOWED_VALUES = "DEPOSIT, WITHDRAWAL";

    private final WhalefinPoCClient whalefinPoCClient;

    @ApiOperation(value = "get all balances from treasury wallet")
    @GetMapping("/balances")
    public Object getBalances() {
        return whalefinPoCClient.getBalances();
    }

    @ApiOperation(value = "get all deposits from treasury wallet")
    @GetMapping("/deposits")
    public Object getDeposits() {
        return whalefinPoCClient.getDeposits();
    }

    @ApiOperation(value = "get all earn products available by type")
    @GetMapping("/earn-products")
    public Object getEarnProductsByType(
            @ApiParam(name = "type", allowableValues = GET_EARN_PRODUCTS_ALLOWED_VALUES)
            @RequestParam final String type) {

        return whalefinPoCClient.getEarnProductsByType(type);
    }

    @ApiOperation(value = "get account statements by type")
    @GetMapping("/statements")
    public Object getStatementsByType(
            @ApiParam(name = "type", allowableValues = GET_STATEMENTS_ALLOWED_VALUES)
            @RequestParam final String type) {

        return whalefinPoCClient.getStatementsByType(type);
    }

    @ApiOperation(value = "get all interest records by ccy")
    @GetMapping("/interest-records")
    public Object getInterestRecordsByCcy(
            @ApiParam(name = "ccy", allowableValues = GET_INTEREST_RECORDS_ALLOWED_VALUES)
            @RequestParam final String ccy) {

        return whalefinPoCClient.getInterestRecordsByCcy(ccy);
    }

    @ApiOperation(value = "get all ccy apy's")
    @GetMapping("/apy")
    public Object getApy() {
        return whalefinPoCClient.getApy();
    }

    @ApiOperation(value = "get all addresses deposit or withdraw")
    @GetMapping("/addresses")
    public Object getAddresses(
            @ApiParam(name = "transactionType", allowableValues = GET_TRANSACTION_TYPE_ALLOWED_VALUES)
            @RequestParam final String transactionType) {

        return whalefinPoCClient.getAddresses(transactionType);
    }

    @ApiOperation(value = "/withdraw")
    @PostMapping("/withdraw")
    public Object postWithdraw(@RequestBody final WithdrawModel withdrawModel){
        return whalefinPoCClient.postWithDraw(withdrawModel);
    }

}
