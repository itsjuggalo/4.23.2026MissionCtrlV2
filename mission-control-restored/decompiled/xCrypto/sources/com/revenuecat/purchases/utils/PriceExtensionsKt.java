package com.revenuecat.purchases.utils;

import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import java.util.Locale;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
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

    private static final Price pricePerPeriod(Price price, double d4, Locale locale) {
        return PriceFactory.INSTANCE.createPrice$purchases_defaultsRelease((long) (price.getAmountMicros() / d4), price.getCurrencyCode(), locale);
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
