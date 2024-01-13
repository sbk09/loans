package com.example.loans.service.impl;

import com.example.loans.dto.LoanDto;
import com.example.loans.entity.Loan;
import com.example.loans.mapper.LoanMapper;
import com.example.loans.repository.LoanRepository;
import com.example.loans.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private LoanMapper loanMapper;

    @Override
    public LoanDto requestLoan(String mobileNumber) {
        Optional<Loan> optionalLoan = loanRepository.findByMobileNumber(mobileNumber);
        if (optionalLoan.isPresent())
            throw new RuntimeException("Loan already disbursed to given mobile number.");
        Loan loan = disburseLoan(mobileNumber);

        loanRepository.save(loan);
        return loanMapper.getDtoFromEntity(loan);
    }

    /**
     *
     * @param mobileNumber
     * @param amount
     * @return
     */
    @Override
    public LoanDto depositInstallmentToLoan(String mobileNumber, Long amount) {
        Optional<Loan> optionalLoan = loanRepository.findByMobileNumber(mobileNumber);
        if (optionalLoan.isEmpty())
            throw new RuntimeException("Loan not found for given mobile number.");
        Loan loan = disburseLoan(mobileNumber);
        loan.setAmountPaid(loan.getAmountPaid()+amount);
        loan.setOutstandingAmount(loan.getOutstandingAmount()- loan.getAmountPaid());
        loanRepository.save(loan);
        return loanMapper.getDtoFromEntity(loan);
    }

    private Loan disburseLoan(String mobileNumber) {
        Loan loan = new Loan();
        loan.setLoanNumber(generateLoanNumber());
        loan.setMobileNumber(mobileNumber);
        loan.setLoanType("Home Loan");
        loan.setTotalLoan(100000L);
        loan.setAmountPaid(0L);
        loan.setOutstandingAmount(0L);
        return loan;
    }

    private String generateLoanNumber() {
        return String.valueOf(System.currentTimeMillis());
    }

}
