package com.revenuecat.purchases.simulatedstore;

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
import dd.a0;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/revenuecat/purchases/simulatedstore/SimulatedStoreProductConverter;", "", "()V", "convertToStoreProduct", "Lcom/revenuecat/purchases/models/TestStoreProduct;", "productResponse", "Lcom/revenuecat/purchases/common/networking/WebBillingProductResponse;", "locale", "Ljava/util/Locale;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SimulatedStoreProductConverter {
    public static final SimulatedStoreProductConverter INSTANCE = new SimulatedStoreProductConverter();

    private SimulatedStoreProductConverter() {
    }

    public static /* synthetic */ TestStoreProduct convertToStoreProduct$default(SimulatedStoreProductConverter simulatedStoreProductConverter, WebBillingProductResponse webBillingProductResponse, Locale locale, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            locale = Locale.getDefault();
            t.e(locale, "getDefault()");
        }
        return simulatedStoreProductConverter.convertToStoreProduct(webBillingProductResponse, locale);
    }

    public final /* synthetic */ TestStoreProduct convertToStoreProduct(WebBillingProductResponse productResponse, Locale locale) throws PurchasesException {
        PricingPhase pricingPhase;
        Price priceCreatePrice$purchases_defaultsBc8Release;
        Period period;
        PricingPhase pricingPhase2;
        t.f(productResponse, "productResponse");
        t.f(locale, "locale");
        String defaultPurchaseOptionId = productResponse.getDefaultPurchaseOptionId();
        Map<String, WebBillingPurchaseOption> purchaseOptions = productResponse.getPurchaseOptions();
        if (defaultPurchaseOptionId == null) {
            defaultPurchaseOptionId = (String) a0.Y(purchaseOptions.keySet());
        }
        WebBillingPurchaseOption webBillingPurchaseOption = purchaseOptions.get(defaultPurchaseOptionId);
        if (webBillingPurchaseOption == null) {
            throw new PurchasesException(new PurchasesError(PurchasesErrorCode.ProductNotAvailableForPurchaseError, "No purchase option found for product " + productResponse.getIdentifier()));
        }
        PricingPhase pricingPhase3 = null;
        if (webBillingPurchaseOption.getBasePrice() != null) {
            WebBillingPrice basePrice = webBillingPurchaseOption.getBasePrice();
            priceCreatePrice$purchases_defaultsBc8Release = PriceFactory.INSTANCE.createPrice$purchases_defaultsBc8Release(basePrice.getAmountMicros(), basePrice.getCurrency(), locale);
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
            Price priceCreatePrice$purchases_defaultsBc8Release2 = priceFactory.createPrice$purchases_defaultsBc8Release(price.getAmountMicros(), price.getCurrency(), locale);
            Period periodCreate = base.getPeriodDuration() != null ? Period.INSTANCE.create(base.getPeriodDuration()) : null;
            WebBillingPhase trial = webBillingPurchaseOption.getTrial();
            PricingPhase pricingPhase4 = (trial != null ? trial.getPeriodDuration() : null) != null ? new PricingPhase(Period.INSTANCE.create(trial.getPeriodDuration()), RecurrenceMode.FINITE_RECURRING, Integer.valueOf(trial.getCycleCount()), priceFactory.createPrice$purchases_defaultsBc8Release(0L, base.getPrice().getCurrency(), locale)) : null;
            WebBillingPhase introPrice = webBillingPurchaseOption.getIntroPrice();
            if ((introPrice != null ? introPrice.getPrice() : null) != null && introPrice.getPeriodDuration() != null) {
                WebBillingPrice price2 = introPrice.getPrice();
                pricingPhase3 = new PricingPhase(Period.INSTANCE.create(introPrice.getPeriodDuration()), RecurrenceMode.FINITE_RECURRING, Integer.valueOf(introPrice.getCycleCount()), priceFactory.createPrice$purchases_defaultsBc8Release(price2.getAmountMicros(), price2.getCurrency(), locale));
            }
            pricingPhase = pricingPhase3;
            priceCreatePrice$purchases_defaultsBc8Release = priceCreatePrice$purchases_defaultsBc8Release2;
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
        return new TestStoreProduct(identifier, title, title2, description, priceCreatePrice$purchases_defaultsBc8Release, period, pricingPhase2, pricingPhase, null, 256, null);
    }
}
