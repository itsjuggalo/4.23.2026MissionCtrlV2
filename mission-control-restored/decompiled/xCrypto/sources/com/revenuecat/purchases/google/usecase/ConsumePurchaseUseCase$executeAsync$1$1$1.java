package com.revenuecat.purchases.google.usecase;

import W2.E;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PostReceiptInitiationSource;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.google.BillingResultExtensionsKt;
import com.revenuecat.purchases.google.ErrorsKt;
import com.revenuecat.purchases.strings.PurchaseStrings;
import i3.k;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
public final class ConsumePurchaseUseCase$executeAsync$1$1$1 extends s implements k {
    final /* synthetic */ ConsumePurchaseUseCase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumePurchaseUseCase$executeAsync$1$1$1(ConsumePurchaseUseCase consumePurchaseUseCase) {
        super(1);
        this.this$0 = consumePurchaseUseCase;
    }

    @Override // i3.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((com.android.billingclient.api.d) obj);
        return E.f5463a;
    }

    public final void invoke(com.android.billingclient.api.d errorBillingResult) {
        String str;
        LogHandler currentLogHandler;
        String str2;
        String str3;
        r.f(errorBillingResult, "errorBillingResult");
        if (errorBillingResult.b() != 8 || this.this$0.useCaseParams.getInitiationSource() != PostReceiptInitiationSource.RESTORE) {
            str = this.this$0.getErrorMessage() + " - " + BillingResultExtensionsKt.toHumanReadableDescription(errorBillingResult);
            LogIntent logIntent = LogIntent.GOOGLE_ERROR;
            ConsumePurchaseUseCase$executeAsync$1$1$1$invoke$$inlined$log$2 consumePurchaseUseCase$executeAsync$1$1$1$invoke$$inlined$log$2 = new ConsumePurchaseUseCase$executeAsync$1$1$1$invoke$$inlined$log$2(logIntent, str);
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler2.d("[Purchases] - " + logLevel.name(), (String) consumePurchaseUseCase$executeAsync$1$1$1$invoke$$inlined$log$2.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) consumePurchaseUseCase$executeAsync$1$1$1$invoke$$inlined$log$2.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler3.w("[Purchases] - " + logLevel2.name(), (String) consumePurchaseUseCase$executeAsync$1$1$1$invoke$$inlined$log$2.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel3 = LogLevel.INFO;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler4.i("[Purchases] - " + logLevel3.name(), (String) consumePurchaseUseCase$executeAsync$1$1$1$invoke$$inlined$log$2.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel4 = LogLevel.DEBUG;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        currentLogHandler5.d("[Purchases] - " + logLevel4.name(), (String) consumePurchaseUseCase$executeAsync$1$1$1$invoke$$inlined$log$2.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) consumePurchaseUseCase$executeAsync$1$1$1$invoke$$inlined$log$2.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler6.i("[Purchases] - " + logLevel5.name(), (String) consumePurchaseUseCase$executeAsync$1$1$1$invoke$$inlined$log$2.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        currentLogHandler7.d("[Purchases] - " + logLevel6.name(), (String) consumePurchaseUseCase$executeAsync$1$1$1$invoke$$inlined$log$2.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        currentLogHandler8.d("[Purchases] - " + logLevel7.name(), (String) consumePurchaseUseCase$executeAsync$1$1$1$invoke$$inlined$log$2.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler9.w("[Purchases] - " + logLevel8.name(), (String) consumePurchaseUseCase$executeAsync$1$1$1$invoke$$inlined$log$2.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel9 = LogLevel.WARN;
                    LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler10.w("[Purchases] - " + logLevel9.name(), (String) consumePurchaseUseCase$executeAsync$1$1$1$invoke$$inlined$log$2.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) consumePurchaseUseCase$executeAsync$1$1$1$invoke$$inlined$log$2.invoke(), null);
                    break;
            }
        } else {
            LogIntent logIntent2 = LogIntent.GOOGLE_WARNING;
            str = PurchaseStrings.CONSUMING_PURCHASE_ERROR_RESTORE;
            ConsumePurchaseUseCase$executeAsync$1$1$1$invoke$$inlined$log$1 consumePurchaseUseCase$executeAsync$1$1$1$invoke$$inlined$log$1 = new ConsumePurchaseUseCase$executeAsync$1$1$1$invoke$$inlined$log$1(logIntent2, PurchaseStrings.CONSUMING_PURCHASE_ERROR_RESTORE);
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
                case 1:
                    LogLevel logLevel10 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                        str2 = "[Purchases] - " + logLevel10.name();
                        str3 = (String) consumePurchaseUseCase$executeAsync$1$1$1$invoke$$inlined$log$1.invoke();
                        currentLogHandler.d(str2, str3);
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) consumePurchaseUseCase$executeAsync$1$1$1$invoke$$inlined$log$1.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel11 = LogLevel.WARN;
                    LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                        currentLogHandler11.w("[Purchases] - " + logLevel11.name(), (String) consumePurchaseUseCase$executeAsync$1$1$1$invoke$$inlined$log$1.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel12 = LogLevel.INFO;
                    LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                        currentLogHandler12.i("[Purchases] - " + logLevel12.name(), (String) consumePurchaseUseCase$executeAsync$1$1$1$invoke$$inlined$log$1.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel13 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                        str2 = "[Purchases] - " + logLevel13.name();
                        str3 = (String) consumePurchaseUseCase$executeAsync$1$1$1$invoke$$inlined$log$1.invoke();
                        currentLogHandler.d(str2, str3);
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) consumePurchaseUseCase$executeAsync$1$1$1$invoke$$inlined$log$1.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel14 = LogLevel.INFO;
                    LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                        currentLogHandler13.i("[Purchases] - " + logLevel14.name(), (String) consumePurchaseUseCase$executeAsync$1$1$1$invoke$$inlined$log$1.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel15 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                        str2 = "[Purchases] - " + logLevel15.name();
                        str3 = (String) consumePurchaseUseCase$executeAsync$1$1$1$invoke$$inlined$log$1.invoke();
                        currentLogHandler.d(str2, str3);
                    }
                    break;
                case 9:
                    LogLevel logLevel16 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                        str2 = "[Purchases] - " + logLevel16.name();
                        str3 = (String) consumePurchaseUseCase$executeAsync$1$1$1$invoke$$inlined$log$1.invoke();
                        currentLogHandler.d(str2, str3);
                    }
                    break;
                case 10:
                    LogLevel logLevel17 = LogLevel.WARN;
                    LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                        currentLogHandler14.w("[Purchases] - " + logLevel17.name(), (String) consumePurchaseUseCase$executeAsync$1$1$1$invoke$$inlined$log$1.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel18 = LogLevel.WARN;
                    LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                        currentLogHandler15.w("[Purchases] - " + logLevel18.name(), (String) consumePurchaseUseCase$executeAsync$1$1$1$invoke$$inlined$log$1.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) consumePurchaseUseCase$executeAsync$1$1$1$invoke$$inlined$log$1.invoke(), null);
                    break;
            }
        }
        this.this$0.getOnError().invoke(ErrorsKt.billingResponseToPurchasesError(errorBillingResult.b(), str));
    }
}
