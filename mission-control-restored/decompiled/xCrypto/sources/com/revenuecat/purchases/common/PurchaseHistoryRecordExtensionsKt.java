package com.revenuecat.purchases.common;

import X2.x;
import com.android.billingclient.api.PurchaseHistoryRecord;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.LogWrapperKt;
import java.util.ArrayList;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class PurchaseHistoryRecordExtensionsKt {
    public static final String getFirstSku(PurchaseHistoryRecord purchaseHistoryRecord) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        r.f(purchaseHistoryRecord, "<this>");
        Object obj = purchaseHistoryRecord.f().get(0);
        String str3 = (String) obj;
        if (purchaseHistoryRecord.f().size() > 1) {
            LogIntent logIntent = LogIntent.GOOGLE_WARNING;
            PurchaseHistoryRecordExtensionsKt$_get_firstSku_$lambda$1$$inlined$log$1 purchaseHistoryRecordExtensionsKt$_get_firstSku_$lambda$1$$inlined$log$1 = new PurchaseHistoryRecordExtensionsKt$_get_firstSku_$lambda$1$$inlined$log$1(logIntent);
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        str = "[Purchases] - " + logLevel.name();
                        str2 = (String) purchaseHistoryRecordExtensionsKt$_get_firstSku_$lambda$1$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchaseHistoryRecordExtensionsKt$_get_firstSku_$lambda$1$$inlined$log$1.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchaseHistoryRecordExtensionsKt$_get_firstSku_$lambda$1$$inlined$log$1.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel3 = LogLevel.INFO;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchaseHistoryRecordExtensionsKt$_get_firstSku_$lambda$1$$inlined$log$1.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel4 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        str = "[Purchases] - " + logLevel4.name();
                        str2 = (String) purchaseHistoryRecordExtensionsKt$_get_firstSku_$lambda$1$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchaseHistoryRecordExtensionsKt$_get_firstSku_$lambda$1$$inlined$log$1.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) purchaseHistoryRecordExtensionsKt$_get_firstSku_$lambda$1$$inlined$log$1.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        str = "[Purchases] - " + logLevel6.name();
                        str2 = (String) purchaseHistoryRecordExtensionsKt$_get_firstSku_$lambda$1$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        str = "[Purchases] - " + logLevel7.name();
                        str2 = (String) purchaseHistoryRecordExtensionsKt$_get_firstSku_$lambda$1$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) purchaseHistoryRecordExtensionsKt$_get_firstSku_$lambda$1$$inlined$log$1.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel9 = LogLevel.WARN;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) purchaseHistoryRecordExtensionsKt$_get_firstSku_$lambda$1$$inlined$log$1.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchaseHistoryRecordExtensionsKt$_get_firstSku_$lambda$1$$inlined$log$1.invoke(), null);
                    break;
            }
        }
        r.e(obj, "skus[0].also {\n        i…ONE_SKU }\n        }\n    }");
        return str3;
    }

    public static final ArrayList<String> getListOfSkus(PurchaseHistoryRecord purchaseHistoryRecord) {
        r.f(purchaseHistoryRecord, "<this>");
        ArrayList<String> arrayListF = purchaseHistoryRecord.f();
        r.e(arrayListF, "this.skus");
        return arrayListF;
    }

    public static final String toHumanReadableDescription(PurchaseHistoryRecord purchaseHistoryRecord) {
        r.f(purchaseHistoryRecord, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append("skus: ");
        ArrayList arrayListF = purchaseHistoryRecord.f();
        r.e(arrayListF, "this.skus");
        sb.append(x.Q(arrayListF, null, "[", "]", 0, null, null, 57, null));
        sb.append(", purchaseTime: ");
        sb.append(purchaseHistoryRecord.c());
        sb.append(", purchaseToken: ");
        sb.append(purchaseHistoryRecord.d());
        return sb.toString();
    }
}
