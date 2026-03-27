package com.revenuecat.purchases.utils;

import H5.i;
import com.revenuecat.purchases.models.Price;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/revenuecat/purchases/utils/PriceFactory;", "", "()V", "createPrice", "Lcom/revenuecat/purchases/models/Price;", "amountMicros", "", "currencyCode", "", "locale", "Ljava/util/Locale;", "createPrice$purchases_defaultsRelease", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PriceFactory {
    public static final PriceFactory INSTANCE = new PriceFactory();

    private PriceFactory() {
    }

    public final /* synthetic */ Price createPrice$purchases_defaultsRelease(long amountMicros, String currencyCode, Locale locale) {
        AbstractC2304t.f(currencyCode, "currencyCode");
        AbstractC2304t.f(locale, "locale");
        Currency currency = Currency.getInstance(currencyCode);
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(locale);
        currencyInstance.setCurrency(currency);
        int iB = i.b(currency.getDefaultFractionDigits(), 0);
        currencyInstance.setMaximumFractionDigits(iB);
        currencyInstance.setMinimumFractionDigits(iB);
        String formatted = currencyInstance.format(amountMicros / 1000000.0d);
        AbstractC2304t.e(formatted, "formatted");
        return new Price(formatted, amountMicros, currencyCode);
    }
}
