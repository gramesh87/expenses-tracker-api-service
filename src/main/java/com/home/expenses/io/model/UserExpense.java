package com.home.expenses.io.model;

import com.home.expenses.entity.Category;
import com.home.expenses.entity.PaymentMode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserExpense {

    private Integer user_id;
    private BigDecimal amount;
    private LocalDate purchaseDate;
    private Category category_id;
    private PaymentMode paymentMode_id;
    private String purchaseItem;
    private String otherCategory;
}
