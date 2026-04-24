package com.revenuecat.purchases.amazon;

import com.amazon.a.a.o.b.f;
import com.amazon.device.iap.model.Product;
import com.amazon.device.iap.model.ProductType;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.models.SubscriptionOptions;
import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.r;
import org.json.JSONObject;
import r3.AbstractC1753A;
import r3.x;

/* JADX INFO: loaded from: classes.dex */
public final class StoreProductConversionsKt {
    private static final Pattern pattern;

    static {
        Pattern patternCompile = Pattern.compile("(\\d+[[\\.,\\s]\\d+]*)");
        r.e(patternCompile, "compile(\"(\\\\d+[[\\\\.,\\\\s]\\\\d+]*)\")");
        pattern = patternCompile;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0035, code lost:
    
        if (r9.equals("SemiAnnual") == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0051, code lost:
    
        if (r9.equals("SemiAnnually") == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005e, code lost:
    
        return new com.revenuecat.purchases.models.Period(6, com.revenuecat.purchases.models.Period.Unit.MONTH, "P6M");
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0065, code lost:
    
        if (r9.equals("Annually") == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0071, code lost:
    
        return new com.revenuecat.purchases.models.Period(1, com.revenuecat.purchases.models.Period.Unit.YEAR, "P1Y");
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
    
        if (r9.equals("Annual") == false) goto L43;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final com.revenuecat.purchases.models.Period createPeriod(java.lang.String r9) {
        /*
            Method dump skipped, instruction units count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.amazon.StoreProductConversionsKt.createPeriod(java.lang.String):com.revenuecat.purchases.models.Period");
    }

    public static final Price createPrice(String str, String marketplace) {
        r.f(str, "<this>");
        r.f(marketplace, "marketplace");
        BigDecimal priceNumeric = parsePriceUsingRegex(str);
        if (priceNumeric == null) {
            priceNumeric = BigDecimal.ZERO;
        }
        r.e(priceNumeric, "priceNumeric");
        BigDecimal bigDecimalMultiply = priceNumeric.multiply(new BigDecimal(1000000.0d));
        r.e(bigDecimalMultiply, "this.multiply(other)");
        return new Price(str, bigDecimalMultiply.longValue(), ISO3166Alpha2ToISO42170Converter.INSTANCE.convertOrEmpty(marketplace));
    }

    public static final BigDecimal parsePriceUsingRegex(String str) {
        String strA;
        r.f(str, "<this>");
        Matcher matcher = pattern.matcher(str);
        if ((matcher.find() ? matcher : null) == null) {
            return null;
        }
        String dirtyPrice = matcher.group();
        r.e(dirtyPrice, "dirtyPrice");
        String string = AbstractC1753A.F0(x.A(x.A(x.A(dirtyPrice, " ", "", false, 4, null), " ", "", false, 4, null), " ", "", false, 4, null)).toString();
        List listT0 = AbstractC1753A.t0(string, new String[]{".", f.f8804a}, false, 0, 6, null);
        if (listT0.size() != 1) {
            if (((String) X2.x.R(listT0)).length() == 3) {
                strA = x.A(x.A(string, ".", "", false, 4, null), f.f8804a, "", false, 4, null);
            } else {
                strA = X2.x.Q(X2.x.D(listT0, 1), "", null, null, 0, null, null, 62, null) + com.amazon.a.a.o.c.a.b.f8816a + ((String) X2.x.R(listT0));
            }
            string = strA;
        }
        return new BigDecimal(AbstractC1753A.F0(string).toString());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static final StoreProduct toStoreProduct(Product product, String marketplace) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        r.f(product, "<this>");
        r.f(marketplace, "marketplace");
        if (product.getPrice() != null) {
            String price = product.getPrice();
            r.e(price, "price");
            Price priceCreatePrice = createPrice(price, marketplace);
            String sku = product.getSku();
            r.e(sku, "sku");
            ProductType productType = product.getProductType();
            r.e(productType, "productType");
            com.revenuecat.purchases.ProductType revenueCatProductType = ProductTypeConversionsKt.toRevenueCatProductType(productType);
            String title = product.getTitle();
            r.e(title, "title");
            String title2 = product.getTitle();
            r.e(title2, "title");
            String description = product.getDescription();
            r.e(description, "description");
            String subscriptionPeriod = product.getSubscriptionPeriod();
            Period periodCreatePeriod = subscriptionPeriod != null ? createPeriod(subscriptionPeriod) : null;
            String smallIconUrl = product.getSmallIconUrl();
            r.e(smallIconUrl, "smallIconUrl");
            String freeTrialPeriod = product.getFreeTrialPeriod();
            Period periodCreatePeriod2 = freeTrialPeriod != null ? createPeriod(freeTrialPeriod) : null;
            JSONObject json = product.toJSON();
            r.e(json, "this.toJSON()");
            return new AmazonStoreProduct(sku, revenueCatProductType, title, title2, description, periodCreatePeriod, priceCreatePrice, (SubscriptionOptions) null, (SubscriptionOption) null, smallIconUrl, periodCreatePeriod2, json, (PresentedOfferingContext) null);
        }
        LogIntent logIntent = LogIntent.AMAZON_ERROR;
        StoreProductConversionsKt$toStoreProduct$$inlined$log$1 storeProductConversionsKt$toStoreProduct$$inlined$log$1 = new StoreProductConversionsKt$toStoreProduct$$inlined$log$1(logIntent, product);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    str2 = (String) storeProductConversionsKt$toStoreProduct$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                return null;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) storeProductConversionsKt$toStoreProduct$$inlined$log$1.invoke(), null);
                return null;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) storeProductConversionsKt$toStoreProduct$$inlined$log$1.invoke());
                }
                return null;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) storeProductConversionsKt$toStoreProduct$$inlined$log$1.invoke());
                }
                return null;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    str2 = (String) storeProductConversionsKt$toStoreProduct$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                return null;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) storeProductConversionsKt$toStoreProduct$$inlined$log$1.invoke(), null);
                return null;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) storeProductConversionsKt$toStoreProduct$$inlined$log$1.invoke());
                }
                return null;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    str2 = (String) storeProductConversionsKt$toStoreProduct$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                return null;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    str2 = (String) storeProductConversionsKt$toStoreProduct$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                return null;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) storeProductConversionsKt$toStoreProduct$$inlined$log$1.invoke());
                }
                return null;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) storeProductConversionsKt$toStoreProduct$$inlined$log$1.invoke());
                }
                return null;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) storeProductConversionsKt$toStoreProduct$$inlined$log$1.invoke(), null);
                return null;
            default:
                return null;
        }
    }
}
