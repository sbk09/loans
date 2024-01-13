package com.example.loans.mapper;

import com.example.loans.dto.CustomerLoanDto;
import com.example.loans.dto.LoanDto;
import com.example.loans.entity.Loan;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LoanMapper {
    LoanMapper INSTANCE = Mappers.getMapper(LoanMapper.class);

    Loan getEntityFromDto(CustomerLoanDto customerLoanDto);

    LoanDto getDtoFromEntity(Loan loan);
}
