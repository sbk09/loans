package com.example.loans.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerLoanDto {

    @NotEmpty(message = "Customer name should not be empty.")
    @Size(min = 5, max = 30, message = "Customer name should be between 5 to 30 characters.")
    private String customerName;

    @NotEmpty(message = "Email should not be empty.")
    @Email
    private String email;

    @NotEmpty(message = "Mobile number should not be empty.")
    @Pattern(regexp = "(^$|\\d{10})", message = "Mobile number should be 10 character long.")
    private String mobileNumber;

    @NotNull(message = "Account number should not be empty.")
    private Long accountNumber;

    @NotNull(message = "Loan number should not be empty.")
    private String loanNumber;

    @NotNull(message = "Loan type should not be empty.")
    private String loanType;

    @NotNull(message = "Total loan amount should not be empty.")
    private Long totalLoan;

    @NotNull(message = "Total amount paid should not be empty.")
    private Long amountPaid;

    @NotNull(message = "Total outstanding amount should not be empty.")
    private Long outstandingAmount;
}
