package com.revenuecat.purchases.common;

import B5.o;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PurchasesErrorCode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a!\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0080\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a!\u0010\f\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0080\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\u000b\u001a!\u0010\r\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0080\bø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000b\u001a!\u0010\u000e\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0080\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000b\u001a-\u0010\u0011\u001a\u00020\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0080\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a@\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00032\u0018\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u00142\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0082\b¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0017\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0018H\u0000¢\u0006\u0004\b\u0011\u0010\u001a\"\u0014\u0010\u001b\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c\"\u0018\u0010\u0004\u001a\u00020\u0001*\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001f"}, d2 = {"Lcom/revenuecat/purchases/LogLevel$Companion;", "", io.flutter.plugins.firebase.analytics.Constants.ENABLED, "Lcom/revenuecat/purchases/LogLevel;", "debugLogsEnabled", "(Lcom/revenuecat/purchases/LogLevel$Companion;Z)Lcom/revenuecat/purchases/LogLevel;", "Lkotlin/Function0;", "", "messageBuilder", "Lo5/H;", "verboseLog", "(Lkotlin/jvm/functions/Function0;)V", "debugLog", "infoLog", "warnLog", "", "throwable", "errorLog", "(Ljava/lang/Throwable;Lkotlin/jvm/functions/Function0;)V", FirebaseAnalytics.Param.LEVEL, "Lkotlin/Function2;", "logger", "logIfEnabled", "(Lcom/revenuecat/purchases/LogLevel;LB5/o;Lkotlin/jvm/functions/Function0;)V", "Lcom/revenuecat/purchases/PurchasesError;", "error", "(Lcom/revenuecat/purchases/PurchasesError;)V", "PURCHASES_LOG_TAG", "Ljava/lang/String;", "getDebugLogsEnabled", "(Lcom/revenuecat/purchases/LogLevel;)Z", "purchases_defaultsRelease"}, k = 2, mv = {1, 8, 0})
public final class LogUtilsKt {
    private static final String PURCHASES_LOG_TAG = "[Purchases]";

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PurchasesErrorCode.values().length];
            try {
                iArr[PurchasesErrorCode.UnknownError.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PurchasesErrorCode.NetworkError.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PurchasesErrorCode.ReceiptAlreadyInUseError.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PurchasesErrorCode.UnexpectedBackendResponseError.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PurchasesErrorCode.InvalidAppUserIdError.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PurchasesErrorCode.OperationAlreadyInProgressError.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PurchasesErrorCode.UnknownBackendError.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[PurchasesErrorCode.LogOutWithAnonymousUserError.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[PurchasesErrorCode.ConfigurationError.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[PurchasesErrorCode.UnsupportedError.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[PurchasesErrorCode.EmptySubscriberAttributesError.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[PurchasesErrorCode.CustomerInfoError.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[PurchasesErrorCode.SignatureVerificationError.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[PurchasesErrorCode.InvalidSubscriberAttributesError.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[PurchasesErrorCode.PurchaseCancelledError.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[PurchasesErrorCode.StoreProblemError.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[PurchasesErrorCode.PurchaseNotAllowedError.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[PurchasesErrorCode.PurchaseInvalidError.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[PurchasesErrorCode.ProductNotAvailableForPurchaseError.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[PurchasesErrorCode.ProductAlreadyPurchasedError.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[PurchasesErrorCode.InvalidReceiptError.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[PurchasesErrorCode.MissingReceiptFileError.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[PurchasesErrorCode.InvalidAppleSubscriptionKeyError.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[PurchasesErrorCode.IneligibleError.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[PurchasesErrorCode.InsufficientPermissionsError.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[PurchasesErrorCode.PaymentPendingError.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[PurchasesErrorCode.InvalidCredentialsError.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void debugLog(Function0 messageBuilder) {
        AbstractC2304t.f(messageBuilder, "messageBuilder");
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.d("[Purchases] - " + logLevel.name(), (String) messageBuilder.invoke());
        }
    }

    public static final LogLevel debugLogsEnabled(LogLevel.Companion companion, boolean z7) {
        AbstractC2304t.f(companion, "<this>");
        return z7 ? LogLevel.DEBUG : LogLevel.INFO;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x002f A[PHI: r4
      0x002f: PHI (r4v4 kotlin.jvm.functions.Function0) = (r4v0 kotlin.jvm.functions.Function0), (r4v5 kotlin.jvm.functions.Function0) binds: [B:40:0x016f, B:6:0x002a] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void errorLog(com.revenuecat.purchases.PurchasesError r5) {
        /*
            Method dump skipped, instruction units count: 712
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.LogUtilsKt.errorLog(com.revenuecat.purchases.PurchasesError):void");
    }

    public static /* synthetic */ void errorLog$default(Throwable th, Function0 messageBuilder, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            th = null;
        }
        AbstractC2304t.f(messageBuilder, "messageBuilder");
        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) messageBuilder.invoke(), th);
    }

    public static final boolean getDebugLogsEnabled(LogLevel logLevel) {
        AbstractC2304t.f(logLevel, "<this>");
        return logLevel.compareTo(LogLevel.DEBUG) <= 0;
    }

    public static final void infoLog(Function0 messageBuilder) {
        AbstractC2304t.f(messageBuilder, "messageBuilder");
        LogLevel logLevel = LogLevel.INFO;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.i("[Purchases] - " + logLevel.name(), (String) messageBuilder.invoke());
        }
    }

    private static final void logIfEnabled(LogLevel logLevel, o oVar, Function0 function0) {
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            oVar.invoke("[Purchases] - " + logLevel.name(), function0.invoke());
        }
    }

    public static final void verboseLog(Function0 messageBuilder) {
        AbstractC2304t.f(messageBuilder, "messageBuilder");
        LogLevel logLevel = LogLevel.VERBOSE;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.v("[Purchases] - " + logLevel.name(), (String) messageBuilder.invoke());
        }
    }

    public static final void warnLog(Function0 messageBuilder) {
        AbstractC2304t.f(messageBuilder, "messageBuilder");
        LogLevel logLevel = LogLevel.WARN;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.w("[Purchases] - " + logLevel.name(), (String) messageBuilder.invoke());
        }
    }

    public static final void errorLog(Throwable th, Function0 messageBuilder) {
        AbstractC2304t.f(messageBuilder, "messageBuilder");
        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) messageBuilder.invoke(), th);
    }
}
