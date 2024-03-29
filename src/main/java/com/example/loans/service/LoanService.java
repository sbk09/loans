package com.example.loans.service;

import com.example.loans.dto.CustomerLoanDto;
import com.example.loans.dto.LoanDto;

public interface LoanService {

    LoanDto requestLoan(String mobileNumber);

    LoanDto depositInstallmentToLoan(String mobileNumber, Long amount);

    LoanDto getLoanByMobileNumber(String mobileNumber);
}
