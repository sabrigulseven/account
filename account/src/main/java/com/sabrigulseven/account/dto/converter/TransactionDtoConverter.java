package com.sabrigulseven.account.dto.converter;

import com.sabrigulseven.account.dto.TransactionDto;
import com.sabrigulseven.account.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionDtoConverter {
    public TransactionDto convert(Transaction from) {
        return new TransactionDto(from.getId(),
                from.getTransactionType(),
                from.getAmount(),
                from.getTransactionDate());
    }
}
