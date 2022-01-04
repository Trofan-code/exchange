package com.example.Exchange.persistance.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name = "accounts")
public class AccountEntry {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long Id;
    @Column(name = "currency")
    private String currency;
    @Column(name = "balance")
    private BigDecimal balance;
}
