package com.revenuecat.purchases.utils;

import com.revenuecat.purchases.models.Price;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import kotlin.jvm.internal.r;
import o3.AbstractC1681l;

/* JADX INFO: loaded from: classes3.dex */
public final class PriceFactory {
    public static final PriceFactory INSTANCE = new PriceFactory();

    private PriceFactory() {
    }

    public final /* synthetic */ Price createPrice$purchases_defaultsRelease(long j4, String currencyCode, Locale locale) {
        r.f(currencyCode, "currencyCode");
        r.f(locale, "locale");
        Currency currency = Currency.getInstance(currencyCode);
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(locale);
        currencyInstance.setCurrency(currency);
        int iB = AbstractC1681l.b(currency.getDefaultFractionDigits(), 0);
        currencyInstance.setMaximumFractionDigits(iB);
        currencyInstance.setMinimumFractionDigits(iB);
        String formatted = currencyInstance.format(j4 / 1000000.0d);
        r.e(formatted, "formatted");
        return new Price(formatted, j4, currencyCode);
    }
}
