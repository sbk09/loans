package com.example.loans.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanDto {
    @NotEmpty(message = "Mobile number should not be empty.")
    @Pattern(regexp = "(^$|\\d{10})", message = "Mobile number should be 10 character long.")
    private String mobileNumber;

    @NotNull(message = "Loan number should not be empty.")
    private String loanNumber;

    @NotNull(message = "Loan type should not be empty.")
    private String loanType;

    @Positive(message = "Total loan amount should not be empty.")
    private Long totalLoan;

    @PositiveOrZero(message = "Total amount paid should not be empty.")
    private Long amountPaid;

    @PositiveOrZero(message = "Total outstanding amount should not be empty.")
    private Long outstandingAmount;

}
