package com.revenuecat.purchases.google.usecase;

import B5.k;
import B5.o;
import D3.m;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.DurationExtensionsKt;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.google.BillingResponse;
import com.revenuecat.purchases.google.BillingResultExtensionsKt;
import com.revenuecat.purchases.google.ErrorsKt;
import java.io.PrintWriter;
import java.io.StringWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2302q;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.AbstractC2306v;
import o5.C2470H;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BS\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\b\u0012*\u0010\r\u001a&\u0012\u0004\u0012\u00020\u000b\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0004\u0012\u00020\u00070\nj\u0002`\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J+\u0010\u0017\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u0019\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00072\b\b\u0002\u0010\u001c\u001a\u00020\u000b¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0007H&¢\u0006\u0004\b\u001f\u0010\u001bJ\u0017\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00028\u0000H&¢\u0006\u0004\b!\u0010\"JI\u0010%\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010#\u001a\u00028\u00002\u0014\b\u0002\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u00052\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b%\u0010&J)\u0010)\u001a\u00020\u0007*\u0004\u0018\u00010'2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00070\u0005H\u0004¢\u0006\u0004\b)\u0010*R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010+R$\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010,R;\u0010\r\u001a&\u0012\u0004\u0012\u00020\u000b\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0004\u0012\u00020\u00070\nj\u0002`\f8\u0006¢\u0006\f\n\u0004\b\r\u0010-\u001a\u0004\b.\u0010/R\u001a\u00101\u001a\u0002008\u0014X\u0094D¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0014\u00106\u001a\u0002058\u0002X\u0082D¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00107R\u001c\u0010:\u001a\u0002098\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010=\u001a\u00020\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\b<\u0010\u0012\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006>"}, d2 = {"Lcom/revenuecat/purchases/google/usecase/BillingClientUseCase;", "T", "", "Lcom/revenuecat/purchases/google/usecase/UseCaseParams;", "useCaseParams", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/PurchasesError;", "Lo5/H;", "Lcom/revenuecat/purchases/PurchasesErrorCallback;", "onError", "Lkotlin/Function2;", "", "Lcom/revenuecat/purchases/google/usecase/ExecuteRequestOnUIThreadFunction;", "executeRequestOnUIThread", "<init>", "(Lcom/revenuecat/purchases/google/usecase/UseCaseParams;LB5/k;LB5/o;)V", "", "getStackTrace", "()Ljava/lang/String;", "Lcom/android/billingclient/api/a;", "billingResult", "forwardError", "(Lcom/android/billingclient/api/a;)V", "backoffOrRetryNetworkError", "(LB5/k;Lcom/android/billingclient/api/a;)V", "backoffOrErrorIfServiceUnavailable", "retryWithBackoff", "()V", "delayMilliseconds", "run", "(J)V", "executeAsync", "received", "onOk", "(Ljava/lang/Object;)V", "response", "onSuccess", "processResult", "(Lcom/android/billingclient/api/a;Ljava/lang/Object;LB5/k;LB5/k;)V", "LR0/c;", "receivingFunction", "withConnectedClient", "(LR0/c;LB5/k;)V", "Lcom/revenuecat/purchases/google/usecase/UseCaseParams;", "LB5/k;", "LB5/o;", "getExecuteRequestOnUIThread", "()LB5/o;", "", "backoffForNetworkErrors", "Z", "getBackoffForNetworkErrors", "()Z", "", "maxRetries", "I", "retryAttempt", "LW6/a;", "retryBackoff", "J", "getErrorMessage", com.amazon.a.a.o.b.f14054f, "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
public abstract class BillingClientUseCase<T> {
    private final boolean backoffForNetworkErrors;
    private final o executeRequestOnUIThread;
    private final int maxRetries;
    private final k onError;
    private int retryAttempt;
    private long retryBackoff;
    private final UseCaseParams useCaseParams;

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.usecase.BillingClientUseCase$processResult$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends AbstractC2302q implements k {
        public AnonymousClass1(Object obj) {
            super(1, obj, BillingClientUseCase.class, "onOk", "onOk(Ljava/lang/Object;)V", 0);
        }

        @Override // B5.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m94invoke(obj);
            return C2470H.f21956a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m94invoke(T t8) {
            ((BillingClientUseCase) this.receiver).onOk(t8);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.usecase.BillingClientUseCase$processResult$2, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass2 extends AbstractC2302q implements k {
        public AnonymousClass2(Object obj) {
            super(1, obj, BillingClientUseCase.class, "forwardError", "forwardError(Lcom/android/billingclient/api/BillingResult;)V", 0);
        }

        @Override // B5.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((com.android.billingclient.api.a) obj);
            return C2470H.f21956a;
        }

        public final void invoke(com.android.billingclient.api.a p02) {
            AbstractC2304t.f(p02, "p0");
            ((BillingClientUseCase) this.receiver).forwardError(p02);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.usecase.BillingClientUseCase$run$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "Lcom/revenuecat/purchases/PurchasesError;", "connectionError", "Lo5/H;", "invoke", "(Lcom/revenuecat/purchases/PurchasesError;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    public static final class C15691 extends AbstractC2306v implements k {
        final /* synthetic */ BillingClientUseCase<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15691(BillingClientUseCase<T> billingClientUseCase) {
            super(1);
            this.this$0 = billingClientUseCase;
        }

        @Override // B5.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return C2470H.f21956a;
        }

        public final void invoke(PurchasesError purchasesError) {
            if (purchasesError == null) {
                this.this$0.executeAsync();
            } else {
                ((BillingClientUseCase) this.this$0).onError.invoke(purchasesError);
            }
        }
    }

    public BillingClientUseCase(UseCaseParams useCaseParams, k onError, o executeRequestOnUIThread) {
        AbstractC2304t.f(useCaseParams, "useCaseParams");
        AbstractC2304t.f(onError, "onError");
        AbstractC2304t.f(executeRequestOnUIThread, "executeRequestOnUIThread");
        this.useCaseParams = useCaseParams;
        this.onError = onError;
        this.executeRequestOnUIThread = executeRequestOnUIThread;
        this.maxRetries = 3;
        this.retryBackoff = BillingClientUseCaseKt.RETRY_TIMER_START;
    }

    private final void backoffOrErrorIfServiceUnavailable(k onError, com.android.billingclient.api.a billingResult) {
        LogLevel logLevel;
        LogHandler currentLogHandler;
        StringBuilder sb;
        LogLevel logLevel2;
        LogHandler currentLogHandler2;
        StringBuilder sb2;
        LogLevel logLevel3;
        LogHandler currentLogHandler3;
        StringBuilder sb3;
        LogIntent logIntent = LogIntent.GOOGLE_WARNING;
        BillingClientUseCase$backoffOrErrorIfServiceUnavailable$$inlined$log$1 billingClientUseCase$backoffOrErrorIfServiceUnavailable$$inlined$log$1 = new BillingClientUseCase$backoffOrErrorIfServiceUnavailable$$inlined$log$1(logIntent, this);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    sb = new StringBuilder();
                    sb.append("[Purchases] - ");
                    sb.append(logLevel.name());
                    currentLogHandler.d(sb.toString(), (String) billingClientUseCase$backoffOrErrorIfServiceUnavailable$$inlined$log$1.invoke());
                }
                break;
            case 2:
            case 6:
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingClientUseCase$backoffOrErrorIfServiceUnavailable$$inlined$log$1.invoke(), null);
                break;
            case 3:
                logLevel2 = LogLevel.WARN;
                currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    sb2 = new StringBuilder();
                    sb2.append("[Purchases] - ");
                    sb2.append(logLevel2.name());
                    currentLogHandler2.w(sb2.toString(), (String) billingClientUseCase$backoffOrErrorIfServiceUnavailable$$inlined$log$1.invoke());
                }
                break;
            case 4:
                logLevel3 = LogLevel.INFO;
                currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    sb3 = new StringBuilder();
                    sb3.append("[Purchases] - ");
                    sb3.append(logLevel3.name());
                    currentLogHandler3.i(sb3.toString(), (String) billingClientUseCase$backoffOrErrorIfServiceUnavailable$$inlined$log$1.invoke());
                }
                break;
            case 5:
                logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    sb = new StringBuilder();
                    sb.append("[Purchases] - ");
                    sb.append(logLevel.name());
                    currentLogHandler.d(sb.toString(), (String) billingClientUseCase$backoffOrErrorIfServiceUnavailable$$inlined$log$1.invoke());
                }
                break;
            case 7:
                logLevel3 = LogLevel.INFO;
                currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    sb3 = new StringBuilder();
                    sb3.append("[Purchases] - ");
                    sb3.append(logLevel3.name());
                    currentLogHandler3.i(sb3.toString(), (String) billingClientUseCase$backoffOrErrorIfServiceUnavailable$$inlined$log$1.invoke());
                }
                break;
            case 8:
                logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    sb = new StringBuilder();
                    sb.append("[Purchases] - ");
                    sb.append(logLevel.name());
                    currentLogHandler.d(sb.toString(), (String) billingClientUseCase$backoffOrErrorIfServiceUnavailable$$inlined$log$1.invoke());
                }
                break;
            case 9:
                logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    sb = new StringBuilder();
                    sb.append("[Purchases] - ");
                    sb.append(logLevel.name());
                    currentLogHandler.d(sb.toString(), (String) billingClientUseCase$backoffOrErrorIfServiceUnavailable$$inlined$log$1.invoke());
                }
                break;
            case 10:
                logLevel2 = LogLevel.WARN;
                currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    sb2 = new StringBuilder();
                    sb2.append("[Purchases] - ");
                    sb2.append(logLevel2.name());
                    currentLogHandler2.w(sb2.toString(), (String) billingClientUseCase$backoffOrErrorIfServiceUnavailable$$inlined$log$1.invoke());
                }
                break;
            case m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                logLevel2 = LogLevel.WARN;
                currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    sb2 = new StringBuilder();
                    sb2.append("[Purchases] - ");
                    sb2.append(logLevel2.name());
                    currentLogHandler2.w(sb2.toString(), (String) billingClientUseCase$backoffOrErrorIfServiceUnavailable$$inlined$log$1.invoke());
                }
                break;
        }
        if (W6.a.m(this.retryBackoff, this.useCaseParams.getAppInBackground() ? BillingClientUseCaseKt.getRETRY_TIMER_MAX_TIME() : BillingClientUseCaseKt.getRETRY_TIMER_SERVICE_UNAVAILABLE_MAX_TIME_FOREGROUND()) < 0) {
            retryWithBackoff();
        } else {
            onError.invoke(billingResult);
        }
    }

    private final void backoffOrRetryNetworkError(k onError, com.android.billingclient.api.a billingResult) {
        int i8;
        if (getBackoffForNetworkErrors() && W6.a.m(this.retryBackoff, BillingClientUseCaseKt.getRETRY_TIMER_MAX_TIME()) < 0) {
            retryWithBackoff();
        } else if (getBackoffForNetworkErrors() || (i8 = this.retryAttempt) >= this.maxRetries) {
            onError.invoke(billingResult);
        } else {
            this.retryAttempt = i8 + 1;
            executeAsync();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void forwardError(com.android.billingclient.api.a billingResult) {
        LogLevel logLevel;
        LogHandler currentLogHandler;
        StringBuilder sb;
        LogLevel logLevel2;
        LogHandler currentLogHandler2;
        StringBuilder sb2;
        LogLevel logLevel3;
        LogHandler currentLogHandler3;
        StringBuilder sb3;
        String str = getErrorMessage() + " - " + BillingResultExtensionsKt.toHumanReadableDescription(billingResult);
        LogIntent logIntent = LogIntent.GOOGLE_ERROR;
        BillingClientUseCase$forwardError$$inlined$log$1 billingClientUseCase$forwardError$$inlined$log$1 = new BillingClientUseCase$forwardError$$inlined$log$1(logIntent, str);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    sb = new StringBuilder();
                    sb.append("[Purchases] - ");
                    sb.append(logLevel.name());
                    currentLogHandler.d(sb.toString(), (String) billingClientUseCase$forwardError$$inlined$log$1.invoke());
                }
                break;
            case 2:
            case 6:
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingClientUseCase$forwardError$$inlined$log$1.invoke(), null);
                break;
            case 3:
                logLevel2 = LogLevel.WARN;
                currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    sb2 = new StringBuilder();
                    sb2.append("[Purchases] - ");
                    sb2.append(logLevel2.name());
                    currentLogHandler2.w(sb2.toString(), (String) billingClientUseCase$forwardError$$inlined$log$1.invoke());
                }
                break;
            case 4:
                logLevel3 = LogLevel.INFO;
                currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    sb3 = new StringBuilder();
                    sb3.append("[Purchases] - ");
                    sb3.append(logLevel3.name());
                    currentLogHandler3.i(sb3.toString(), (String) billingClientUseCase$forwardError$$inlined$log$1.invoke());
                }
                break;
            case 5:
                logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    sb = new StringBuilder();
                    sb.append("[Purchases] - ");
                    sb.append(logLevel.name());
                    currentLogHandler.d(sb.toString(), (String) billingClientUseCase$forwardError$$inlined$log$1.invoke());
                }
                break;
            case 7:
                logLevel3 = LogLevel.INFO;
                currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    sb3 = new StringBuilder();
                    sb3.append("[Purchases] - ");
                    sb3.append(logLevel3.name());
                    currentLogHandler3.i(sb3.toString(), (String) billingClientUseCase$forwardError$$inlined$log$1.invoke());
                }
                break;
            case 8:
                logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    sb = new StringBuilder();
                    sb.append("[Purchases] - ");
                    sb.append(logLevel.name());
                    currentLogHandler.d(sb.toString(), (String) billingClientUseCase$forwardError$$inlined$log$1.invoke());
                }
                break;
            case 9:
                logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    sb = new StringBuilder();
                    sb.append("[Purchases] - ");
                    sb.append(logLevel.name());
                    currentLogHandler.d(sb.toString(), (String) billingClientUseCase$forwardError$$inlined$log$1.invoke());
                }
                break;
            case 10:
                logLevel2 = LogLevel.WARN;
                currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    sb2 = new StringBuilder();
                    sb2.append("[Purchases] - ");
                    sb2.append(logLevel2.name());
                    currentLogHandler2.w(sb2.toString(), (String) billingClientUseCase$forwardError$$inlined$log$1.invoke());
                }
                break;
            case m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                logLevel2 = LogLevel.WARN;
                currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    sb2 = new StringBuilder();
                    sb2.append("[Purchases] - ");
                    sb2.append(logLevel2.name());
                    currentLogHandler2.w(sb2.toString(), (String) billingClientUseCase$forwardError$$inlined$log$1.invoke());
                }
                break;
        }
        k kVar = this.onError;
        PurchasesError purchasesErrorBillingResponseToPurchasesError = ErrorsKt.billingResponseToPurchasesError(billingResult.c(), str);
        LogUtilsKt.errorLog(purchasesErrorBillingResponseToPurchasesError);
        kVar.invoke(purchasesErrorBillingResponseToPurchasesError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getStackTrace() {
        StringWriter stringWriter = new StringWriter();
        new Throwable().printStackTrace(new PrintWriter(stringWriter));
        String string = stringWriter.toString();
        AbstractC2304t.e(string, "stringWriter.toString()");
        return string;
    }

    public static /* synthetic */ void processResult$default(BillingClientUseCase billingClientUseCase, com.android.billingclient.api.a aVar, Object obj, k kVar, k kVar2, int i8, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: processResult");
        }
        if ((i8 & 4) != 0) {
            kVar = new AnonymousClass1(billingClientUseCase);
        }
        if ((i8 & 8) != 0) {
            kVar2 = new AnonymousClass2(billingClientUseCase);
        }
        billingClientUseCase.processResult(aVar, obj, kVar, kVar2);
    }

    private final void retryWithBackoff() {
        long j8 = this.retryBackoff;
        this.retryBackoff = DurationExtensionsKt.m62minQTBD994(W6.a.X(j8, 2), BillingClientUseCaseKt.getRETRY_TIMER_MAX_TIME());
        run(W6.a.H(j8));
    }

    public static /* synthetic */ void run$default(BillingClientUseCase billingClientUseCase, long j8, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: run");
        }
        if ((i8 & 1) != 0) {
            j8 = 0;
        }
        billingClientUseCase.run(j8);
    }

    public abstract void executeAsync();

    public boolean getBackoffForNetworkErrors() {
        return this.backoffForNetworkErrors;
    }

    public abstract String getErrorMessage();

    public final o getExecuteRequestOnUIThread() {
        return this.executeRequestOnUIThread;
    }

    public abstract void onOk(T received);

    public final void processResult(com.android.billingclient.api.a billingResult, T response, k onSuccess, k onError) {
        LogLevel logLevel;
        LogHandler currentLogHandler;
        StringBuilder sb;
        LogLevel logLevel2;
        LogHandler currentLogHandler2;
        StringBuilder sb2;
        LogLevel logLevel3;
        LogHandler currentLogHandler3;
        StringBuilder sb3;
        AbstractC2304t.f(billingResult, "billingResult");
        AbstractC2304t.f(onSuccess, "onSuccess");
        AbstractC2304t.f(onError, "onError");
        BillingResponse billingResponseFromCode = BillingResponse.INSTANCE.fromCode(billingResult.c());
        if (AbstractC2304t.b(billingResponseFromCode, BillingResponse.OK.INSTANCE)) {
            this.retryBackoff = BillingClientUseCaseKt.RETRY_TIMER_START;
            onSuccess.invoke(response);
            return;
        }
        if (!AbstractC2304t.b(billingResponseFromCode, BillingResponse.ServiceDisconnected.INSTANCE)) {
            if (AbstractC2304t.b(billingResponseFromCode, BillingResponse.ServiceUnavailable.INSTANCE)) {
                backoffOrErrorIfServiceUnavailable(onError, billingResult);
                return;
            }
            if (AbstractC2304t.b(billingResponseFromCode, BillingResponse.NetworkError.INSTANCE) ? true : AbstractC2304t.b(billingResponseFromCode, BillingResponse.Error.INSTANCE)) {
                backoffOrRetryNetworkError(onError, billingResult);
                return;
            } else {
                onError.invoke(billingResult);
                return;
            }
        }
        LogIntent logIntent = LogIntent.GOOGLE_ERROR;
        BillingClientUseCase$processResult$$inlined$log$1 billingClientUseCase$processResult$$inlined$log$1 = new BillingClientUseCase$processResult$$inlined$log$1(logIntent);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    sb = new StringBuilder();
                    sb.append("[Purchases] - ");
                    sb.append(logLevel.name());
                    currentLogHandler.d(sb.toString(), (String) billingClientUseCase$processResult$$inlined$log$1.invoke());
                }
                break;
            case 2:
            case 6:
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) billingClientUseCase$processResult$$inlined$log$1.invoke(), null);
                break;
            case 3:
                logLevel2 = LogLevel.WARN;
                currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    sb2 = new StringBuilder();
                    sb2.append("[Purchases] - ");
                    sb2.append(logLevel2.name());
                    currentLogHandler2.w(sb2.toString(), (String) billingClientUseCase$processResult$$inlined$log$1.invoke());
                }
                break;
            case 4:
                logLevel3 = LogLevel.INFO;
                currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    sb3 = new StringBuilder();
                    sb3.append("[Purchases] - ");
                    sb3.append(logLevel3.name());
                    currentLogHandler3.i(sb3.toString(), (String) billingClientUseCase$processResult$$inlined$log$1.invoke());
                }
                break;
            case 5:
                logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    sb = new StringBuilder();
                    sb.append("[Purchases] - ");
                    sb.append(logLevel.name());
                    currentLogHandler.d(sb.toString(), (String) billingClientUseCase$processResult$$inlined$log$1.invoke());
                }
                break;
            case 7:
                logLevel3 = LogLevel.INFO;
                currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    sb3 = new StringBuilder();
                    sb3.append("[Purchases] - ");
                    sb3.append(logLevel3.name());
                    currentLogHandler3.i(sb3.toString(), (String) billingClientUseCase$processResult$$inlined$log$1.invoke());
                }
                break;
            case 8:
                logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    sb = new StringBuilder();
                    sb.append("[Purchases] - ");
                    sb.append(logLevel.name());
                    currentLogHandler.d(sb.toString(), (String) billingClientUseCase$processResult$$inlined$log$1.invoke());
                }
                break;
            case 9:
                logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    sb = new StringBuilder();
                    sb.append("[Purchases] - ");
                    sb.append(logLevel.name());
                    currentLogHandler.d(sb.toString(), (String) billingClientUseCase$processResult$$inlined$log$1.invoke());
                }
                break;
            case 10:
                logLevel2 = LogLevel.WARN;
                currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    sb2 = new StringBuilder();
                    sb2.append("[Purchases] - ");
                    sb2.append(logLevel2.name());
                    currentLogHandler2.w(sb2.toString(), (String) billingClientUseCase$processResult$$inlined$log$1.invoke());
                }
                break;
            case m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                logLevel2 = LogLevel.WARN;
                currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    sb2 = new StringBuilder();
                    sb2.append("[Purchases] - ");
                    sb2.append(logLevel2.name());
                    currentLogHandler2.w(sb2.toString(), (String) billingClientUseCase$processResult$$inlined$log$1.invoke());
                }
                break;
        }
        run$default(this, 0L, 1, null);
    }

    public final void run(long delayMilliseconds) {
        this.executeRequestOnUIThread.invoke(Long.valueOf(delayMilliseconds), new C15691(this));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void withConnectedClient(R0.AbstractC0806c r4, B5.k r5) {
        /*
            Method dump skipped, instruction units count: 384
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.google.usecase.BillingClientUseCase.withConnectedClient(R0.c, B5.k):void");
    }
}
