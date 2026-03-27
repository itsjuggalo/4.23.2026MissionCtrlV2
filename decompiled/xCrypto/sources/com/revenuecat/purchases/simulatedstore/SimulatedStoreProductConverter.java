package com.revenuecat.purchases.simulatedstore;

import X2.x;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.PurchasesException;
import com.revenuecat.purchases.common.networking.WebBillingPhase;
import com.revenuecat.purchases.common.networking.WebBillingPrice;
import com.revenuecat.purchases.common.networking.WebBillingProductResponse;
import com.revenuecat.purchases.common.networking.WebBillingPurchaseOption;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.models.RecurrenceMode;
import com.revenuecat.purchases.models.TestStoreProduct;
import com.revenuecat.purchases.utils.PriceFactory;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class SimulatedStoreProductConverter {
    public static final SimulatedStoreProductConverter INSTANCE = new SimulatedStoreProductConverter();

    private SimulatedStoreProductConverter() {
    }

    public static /* synthetic */ TestStoreProduct convertToStoreProduct$default(SimulatedStoreProductConverter simulatedStoreProductConverter, WebBillingProductResponse webBillingProductResponse, Locale locale, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            locale = Locale.getDefault();
            r.e(locale, "getDefault()");
        }
        return simulatedStoreProductConverter.convertToStoreProduct(webBillingProductResponse, locale);
    }

    public final /* synthetic */ TestStoreProduct convertToStoreProduct(WebBillingProductResponse productResponse, Locale locale) throws PurchasesException {
        PricingPhase pricingPhase;
        Price priceCreatePrice$purchases_defaultsRelease;
        Period period;
        PricingPhase pricingPhase2;
        r.f(productResponse, "productResponse");
        r.f(locale, "locale");
        String defaultPurchaseOptionId = productResponse.getDefaultPurchaseOptionId();
        Map<String, WebBillingPurchaseOption> purchaseOptions = productResponse.getPurchaseOptions();
        if (defaultPurchaseOptionId == null) {
            defaultPurchaseOptionId = (String) x.G(purchaseOptions.keySet());
        }
        WebBillingPurchaseOption webBillingPurchaseOption = purchaseOptions.get(defaultPurchaseOptionId);
        if (webBillingPurchaseOption == null) {
            throw new PurchasesException(new PurchasesError(PurchasesErrorCode.ProductNotAvailableForPurchaseError, "No purchase option found for product " + productResponse.getIdentifier()));
        }
        PricingPhase pricingPhase3 = null;
        if (webBillingPurchaseOption.getBasePrice() != null) {
            WebBillingPrice basePrice = webBillingPurchaseOption.getBasePrice();
            priceCreatePrice$purchases_defaultsRelease = PriceFactory.INSTANCE.createPrice$purchases_defaultsRelease(basePrice.getAmountMicros(), basePrice.getCurrency(), locale);
            period = null;
            pricingPhase2 = null;
            pricingPhase = null;
        } else {
            WebBillingPhase base = webBillingPurchaseOption.getBase();
            if ((base != null ? base.getPrice() : null) == null) {
                throw new PurchasesException(new PurchasesError(PurchasesErrorCode.ProductNotAvailableForPurchaseError, "Base price is required for test subscription products"));
            }
            WebBillingPrice price = base.getPrice();
            PriceFactory priceFactory = PriceFactory.INSTANCE;
            Price priceCreatePrice$purchases_defaultsRelease2 = priceFactory.createPrice$purchases_defaultsRelease(price.getAmountMicros(), price.getCurrency(), locale);
            Period periodCreate = base.getPeriodDuration() != null ? Period.Factory.create(base.getPeriodDuration()) : null;
            WebBillingPhase trial = webBillingPurchaseOption.getTrial();
            PricingPhase pricingPhase4 = (trial != null ? trial.getPeriodDuration() : null) != null ? new PricingPhase(Period.Factory.create(trial.getPeriodDuration()), RecurrenceMode.FINITE_RECURRING, Integer.valueOf(trial.getCycleCount()), priceFactory.createPrice$purchases_defaultsRelease(0L, base.getPrice().getCurrency(), locale)) : null;
            WebBillingPhase introPrice = webBillingPurchaseOption.getIntroPrice();
            if ((introPrice != null ? introPrice.getPrice() : null) != null && introPrice.getPeriodDuration() != null) {
                WebBillingPrice price2 = introPrice.getPrice();
                pricingPhase3 = new PricingPhase(Period.Factory.create(introPrice.getPeriodDuration()), RecurrenceMode.FINITE_RECURRING, Integer.valueOf(introPrice.getCycleCount()), priceFactory.createPrice$purchases_defaultsRelease(price2.getAmountMicros(), price2.getCurrency(), locale));
            }
            pricingPhase = pricingPhase3;
            priceCreatePrice$purchases_defaultsRelease = priceCreatePrice$purchases_defaultsRelease2;
            period = periodCreate;
            pricingPhase2 = pricingPhase4;
        }
        String identifier = productResponse.getIdentifier();
        String title = productResponse.getTitle();
        String title2 = productResponse.getTitle();
        String description = productResponse.getDescription();
        if (description == null) {
            description = "";
        }
        return new TestStoreProduct(identifier, title, title2, description, priceCreatePrice$purchases_defaultsRelease, period, pricingPhase2, pricingPhase, null, 256, null);
    }
}
