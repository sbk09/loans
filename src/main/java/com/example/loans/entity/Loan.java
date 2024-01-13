package com.example.loans.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "loans")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Audited
@AuditTable(value = "H$loan")
@DynamicUpdate
public class Loan extends BaseEntity {

    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "loan_id_seq", sequenceName = "native", allocationSize = 2)
    @Column(name = "loan_id")
    private Long loanId;

    @Column(name = "mobile_number", updatable = false)
    private String mobileNumber;

    @Column(name = "loan_number")
    @Generated(GenerationTime.INSERT)
    //@GeneratedValue(generator = "MY_OWN_LOAN_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "MY_OWN_LOAN_SEQ", sequenceName = "MY_OWN_LOAN_SEQ")
    private String loanNumber;

    @Column(name = "loan_type")
    private String loanType;

    @Column(name = "total_loan")
    private Long totalLoan;

    @Column(name = "amount_paid")
    private Long amountPaid;

    @Column(name = "outstanding_amount")
    private Long outstandingAmount;


}
