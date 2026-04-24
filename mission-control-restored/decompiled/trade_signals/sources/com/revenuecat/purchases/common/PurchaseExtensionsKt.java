package com.revenuecat.purchases.common;

import D3.m;
import com.android.billingclient.api.Purchase;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.LogWrapperKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;
import p5.z;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\f\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"firstProductId", "", "Lcom/android/billingclient/api/Purchase;", "getFirstProductId", "(Lcom/android/billingclient/api/Purchase;)Ljava/lang/String;", "toHumanReadableDescription", "purchases_defaultsRelease"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PurchaseExtensionsKt {
    public static final String getFirstProductId(Purchase purchase) {
        LogLevel logLevel;
        LogHandler currentLogHandler;
        StringBuilder sb;
        LogLevel logLevel2;
        LogHandler currentLogHandler2;
        StringBuilder sb2;
        LogLevel logLevel3;
        LogHandler currentLogHandler3;
        StringBuilder sb3;
        AbstractC2304t.f(purchase, "<this>");
        Object obj = purchase.c().get(0);
        String str = (String) obj;
        if (purchase.c().size() > 1) {
            LogIntent logIntent = LogIntent.GOOGLE_WARNING;
            PurchaseExtensionsKt$_get_firstProductId_$lambda$1$$inlined$log$1 purchaseExtensionsKt$_get_firstProductId_$lambda$1$$inlined$log$1 = new PurchaseExtensionsKt$_get_firstProductId_$lambda$1$$inlined$log$1(logIntent);
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        sb = new StringBuilder();
                        sb.append("[Purchases] - ");
                        sb.append(logLevel.name());
                        currentLogHandler.d(sb.toString(), (String) purchaseExtensionsKt$_get_firstProductId_$lambda$1$$inlined$log$1.invoke());
                    }
                    break;
                case 2:
                case 6:
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchaseExtensionsKt$_get_firstProductId_$lambda$1$$inlined$log$1.invoke(), null);
                    break;
                case 3:
                    logLevel2 = LogLevel.WARN;
                    currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        sb2 = new StringBuilder();
                        sb2.append("[Purchases] - ");
                        sb2.append(logLevel2.name());
                        currentLogHandler2.w(sb2.toString(), (String) purchaseExtensionsKt$_get_firstProductId_$lambda$1$$inlined$log$1.invoke());
                    }
                    break;
                case 4:
                    logLevel3 = LogLevel.INFO;
                    currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        sb3 = new StringBuilder();
                        sb3.append("[Purchases] - ");
                        sb3.append(logLevel3.name());
                        currentLogHandler3.i(sb3.toString(), (String) purchaseExtensionsKt$_get_firstProductId_$lambda$1$$inlined$log$1.invoke());
                    }
                    break;
                case 5:
                    logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        sb = new StringBuilder();
                        sb.append("[Purchases] - ");
                        sb.append(logLevel.name());
                        currentLogHandler.d(sb.toString(), (String) purchaseExtensionsKt$_get_firstProductId_$lambda$1$$inlined$log$1.invoke());
                    }
                    break;
                case 7:
                    logLevel3 = LogLevel.INFO;
                    currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        sb3 = new StringBuilder();
                        sb3.append("[Purchases] - ");
                        sb3.append(logLevel3.name());
                        currentLogHandler3.i(sb3.toString(), (String) purchaseExtensionsKt$_get_firstProductId_$lambda$1$$inlined$log$1.invoke());
                    }
                    break;
                case 8:
                    logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        sb = new StringBuilder();
                        sb.append("[Purchases] - ");
                        sb.append(logLevel.name());
                        currentLogHandler.d(sb.toString(), (String) purchaseExtensionsKt$_get_firstProductId_$lambda$1$$inlined$log$1.invoke());
                    }
                    break;
                case 9:
                    logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        sb = new StringBuilder();
                        sb.append("[Purchases] - ");
                        sb.append(logLevel.name());
                        currentLogHandler.d(sb.toString(), (String) purchaseExtensionsKt$_get_firstProductId_$lambda$1$$inlined$log$1.invoke());
                    }
                    break;
                case 10:
                    logLevel2 = LogLevel.WARN;
                    currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        sb2 = new StringBuilder();
                        sb2.append("[Purchases] - ");
                        sb2.append(logLevel2.name());
                        currentLogHandler2.w(sb2.toString(), (String) purchaseExtensionsKt$_get_firstProductId_$lambda$1$$inlined$log$1.invoke());
                    }
                    break;
                case m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                    logLevel2 = LogLevel.WARN;
                    currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        sb2 = new StringBuilder();
                        sb2.append("[Purchases] - ");
                        sb2.append(logLevel2.name());
                        currentLogHandler2.w(sb2.toString(), (String) purchaseExtensionsKt$_get_firstProductId_$lambda$1$$inlined$log$1.invoke());
                    }
                    break;
            }
        }
        AbstractC2304t.e(obj, "products[0].also {\n     …ONE_SKU }\n        }\n    }");
        return str;
    }

    public static final String toHumanReadableDescription(Purchase purchase) {
        AbstractC2304t.f(purchase, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append("productIds: ");
        List listC = purchase.c();
        AbstractC2304t.e(listC, "this.products");
        sb.append(z.h0(listC, null, "[", "]", 0, null, null, 57, null));
        sb.append(", orderId: ");
        sb.append(purchase.a());
        sb.append(", purchaseToken: ");
        sb.append(purchase.f());
        return sb.toString();
    }
}
