package com.revenuecat.purchases.utils;

import W5.l;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class PriceExtensionsKt {
    public static final /* synthetic */ Price pricePerDay(Price price, Period billingPeriod, Locale locale) {
        r.f(price, "<this>");
        r.f(billingPeriod, "billingPeriod");
        r.f(locale, "locale");
        return pricePerPeriod(price, billingPeriod.getValueInDays(), locale);
    }

    public static final Price pricePerMonth(Price price, Period billingPeriod, Locale locale) {
        r.f(price, "<this>");
        r.f(billingPeriod, "billingPeriod");
        r.f(locale, "locale");
        return pricePerPeriod(price, billingPeriod.getValueInMonths(), locale);
    }

    private static final Price pricePerPeriod(Price price, double d7, Locale locale) {
        Currency currency = Currency.getInstance(price.getCurrencyCode());
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(locale);
        currencyInstance.setCurrency(currency);
        int iB = l.b(currency.getDefaultFractionDigits(), 0);
        currencyInstance.setMaximumFractionDigits(iB);
        currencyInstance.setMinimumFractionDigits(iB);
        double amountMicros = price.getAmountMicros() / d7;
        String formatted = currencyInstance.format(amountMicros / 1000000.0d);
        r.e(formatted, "formatted");
        return new Price(formatted, (long) amountMicros, price.getCurrencyCode());
    }

    public static final Price pricePerWeek(Price price, Period billingPeriod, Locale locale) {
        r.f(price, "<this>");
        r.f(billingPeriod, "billingPeriod");
        r.f(locale, "locale");
        return pricePerPeriod(price, billingPeriod.getValueInWeeks(), locale);
    }

    public static final Price pricePerYear(Price price, Period billingPeriod, Locale locale) {
        r.f(price, "<this>");
        r.f(billingPeriod, "billingPeriod");
        r.f(locale, "locale");
        return pricePerPeriod(price, billingPeriod.getValueInYears(), locale);
    }
}
