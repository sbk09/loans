package com.example.loans.controller;

import com.example.loans.dto.LoanDto;
import com.example.loans.service.LoanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loan")
@Validated
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping(value = "/request", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoanDto> requestLoan(@RequestParam(name = "mobileNumber") @Valid String mobileNumber) {
        return new ResponseEntity<>(loanService.requestLoan(mobileNumber),
                HttpStatus.CREATED);
    }

    @PostMapping(value = "/depositLoanAmount", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoanDto> depositInstallmentToLoan(@RequestParam(name = "mobileNumber") @Valid String mobileNumber,
                                                       @RequestParam(name = "installment") Long installment) {
        return new ResponseEntity<>(loanService.depositInstallmentToLoan(mobileNumber, installment), HttpStatus.OK);
    }

    @GetMapping(value = "/getByMobileNumber", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoanDto> getLoanByMobileNumber(@RequestParam String mobileNumber){
        return new ResponseEntity<>(loanService.getLoanByMobileNumber(mobileNumber), HttpStatus.OK);
    }
}
