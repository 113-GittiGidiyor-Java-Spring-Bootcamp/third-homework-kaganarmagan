package com.sms.kgnarmaganthirdhomeworkside.currency;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum CurrencyConfig {
    DOLLAR(8.35),
    LIRA(0.12);

   @Getter
   private double cost;
}
