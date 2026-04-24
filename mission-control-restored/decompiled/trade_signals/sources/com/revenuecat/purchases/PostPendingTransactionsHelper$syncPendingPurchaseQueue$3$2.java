package com.revenuecat.purchases;

import B5.k;
import D3.m;
import com.revenuecat.purchases.SyncPendingPurchaseResult;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.AbstractC2306v;
import o5.C2470H;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/revenuecat/purchases/PurchasesError;", "error", "Lo5/H;", "invoke", "(Lcom/revenuecat/purchases/PurchasesError;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
public final class PostPendingTransactionsHelper$syncPendingPurchaseQueue$3$2 extends AbstractC2306v implements k {
    final /* synthetic */ k $callback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostPendingTransactionsHelper$syncPendingPurchaseQueue$3$2(k kVar) {
        super(1);
        this.$callback = kVar;
    }

    @Override // B5.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PurchasesError) obj);
        return C2470H.f21956a;
    }

    public final void invoke(PurchasesError error) {
        LogLevel logLevel;
        LogHandler currentLogHandler;
        StringBuilder sb;
        LogLevel logLevel2;
        LogHandler currentLogHandler2;
        StringBuilder sb2;
        LogLevel logLevel3;
        LogHandler currentLogHandler3;
        StringBuilder sb3;
        AbstractC2304t.f(error, "error");
        LogIntent logIntent = LogIntent.GOOGLE_ERROR;
        PostPendingTransactionsHelper$syncPendingPurchaseQueue$3$2$invoke$$inlined$log$1 postPendingTransactionsHelper$syncPendingPurchaseQueue$3$2$invoke$$inlined$log$1 = new PostPendingTransactionsHelper$syncPendingPurchaseQueue$3$2$invoke$$inlined$log$1(logIntent, error);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    sb = new StringBuilder();
                    sb.append("[Purchases] - ");
                    sb.append(logLevel.name());
                    currentLogHandler.d(sb.toString(), (String) postPendingTransactionsHelper$syncPendingPurchaseQueue$3$2$invoke$$inlined$log$1.invoke());
                }
                break;
            case 2:
            case 6:
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) postPendingTransactionsHelper$syncPendingPurchaseQueue$3$2$invoke$$inlined$log$1.invoke(), null);
                break;
            case 3:
                logLevel2 = LogLevel.WARN;
                currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    sb2 = new StringBuilder();
                    sb2.append("[Purchases] - ");
                    sb2.append(logLevel2.name());
                    currentLogHandler2.w(sb2.toString(), (String) postPendingTransactionsHelper$syncPendingPurchaseQueue$3$2$invoke$$inlined$log$1.invoke());
                }
                break;
            case 4:
                logLevel3 = LogLevel.INFO;
                currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    sb3 = new StringBuilder();
                    sb3.append("[Purchases] - ");
                    sb3.append(logLevel3.name());
                    currentLogHandler3.i(sb3.toString(), (String) postPendingTransactionsHelper$syncPendingPurchaseQueue$3$2$invoke$$inlined$log$1.invoke());
                }
                break;
            case 5:
                logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    sb = new StringBuilder();
                    sb.append("[Purchases] - ");
                    sb.append(logLevel.name());
                    currentLogHandler.d(sb.toString(), (String) postPendingTransactionsHelper$syncPendingPurchaseQueue$3$2$invoke$$inlined$log$1.invoke());
                }
                break;
            case 7:
                logLevel3 = LogLevel.INFO;
                currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    sb3 = new StringBuilder();
                    sb3.append("[Purchases] - ");
                    sb3.append(logLevel3.name());
                    currentLogHandler3.i(sb3.toString(), (String) postPendingTransactionsHelper$syncPendingPurchaseQueue$3$2$invoke$$inlined$log$1.invoke());
                }
                break;
            case 8:
                logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    sb = new StringBuilder();
                    sb.append("[Purchases] - ");
                    sb.append(logLevel.name());
                    currentLogHandler.d(sb.toString(), (String) postPendingTransactionsHelper$syncPendingPurchaseQueue$3$2$invoke$$inlined$log$1.invoke());
                }
                break;
            case 9:
                logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    sb = new StringBuilder();
                    sb.append("[Purchases] - ");
                    sb.append(logLevel.name());
                    currentLogHandler.d(sb.toString(), (String) postPendingTransactionsHelper$syncPendingPurchaseQueue$3$2$invoke$$inlined$log$1.invoke());
                }
                break;
            case 10:
                logLevel2 = LogLevel.WARN;
                currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    sb2 = new StringBuilder();
                    sb2.append("[Purchases] - ");
                    sb2.append(logLevel2.name());
                    currentLogHandler2.w(sb2.toString(), (String) postPendingTransactionsHelper$syncPendingPurchaseQueue$3$2$invoke$$inlined$log$1.invoke());
                }
                break;
            case m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                logLevel2 = LogLevel.WARN;
                currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    sb2 = new StringBuilder();
                    sb2.append("[Purchases] - ");
                    sb2.append(logLevel2.name());
                    currentLogHandler2.w(sb2.toString(), (String) postPendingTransactionsHelper$syncPendingPurchaseQueue$3$2$invoke$$inlined$log$1.invoke());
                }
                break;
        }
        k kVar = this.$callback;
        if (kVar != null) {
            kVar.invoke(new SyncPendingPurchaseResult.Error(error));
        }
    }
}
