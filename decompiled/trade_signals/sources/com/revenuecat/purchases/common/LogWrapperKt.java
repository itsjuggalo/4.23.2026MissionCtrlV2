package com.revenuecat.purchases.common;

import D3.m;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u000e\b\u0004\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0080\bø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\"\"\u0010\t\u001a\u00020\b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000f"}, d2 = {"Lcom/revenuecat/purchases/common/LogIntent;", "intent", "Lkotlin/Function0;", "", "messageBuilder", "Lo5/H;", "log", "(Lcom/revenuecat/purchases/common/LogIntent;Lkotlin/jvm/functions/Function0;)V", "Lcom/revenuecat/purchases/LogHandler;", "currentLogHandler", "Lcom/revenuecat/purchases/LogHandler;", "getCurrentLogHandler", "()Lcom/revenuecat/purchases/LogHandler;", "setCurrentLogHandler", "(Lcom/revenuecat/purchases/LogHandler;)V", "purchases_defaultsRelease"}, k = 2, mv = {1, 8, 0})
public final class LogWrapperKt {
    private static LogHandler currentLogHandler = new DefaultLogHandler();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LogIntent.values().length];
            try {
                iArr[LogIntent.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LogIntent.GOOGLE_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LogIntent.GOOGLE_WARNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LogIntent.INFO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[LogIntent.PURCHASE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[LogIntent.RC_ERROR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[LogIntent.RC_PURCHASE_SUCCESS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[LogIntent.RC_SUCCESS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[LogIntent.USER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[LogIntent.WARNING.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[LogIntent.AMAZON_WARNING.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[LogIntent.AMAZON_ERROR.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final LogHandler getCurrentLogHandler() {
        return currentLogHandler;
    }

    public static final void log(LogIntent intent, Function0 messageBuilder) {
        LogLevel logLevel;
        LogHandler currentLogHandler2;
        StringBuilder sb;
        LogLevel logLevel2;
        LogHandler currentLogHandler3;
        StringBuilder sb2;
        LogLevel logLevel3;
        LogHandler currentLogHandler4;
        StringBuilder sb3;
        AbstractC2304t.f(intent, "intent");
        AbstractC2304t.f(messageBuilder, "messageBuilder");
        LogWrapperKt$log$fullMessageBuilder$1 logWrapperKt$log$fullMessageBuilder$1 = new LogWrapperKt$log$fullMessageBuilder$1(intent, messageBuilder);
        switch (WhenMappings.$EnumSwitchMapping$0[intent.ordinal()]) {
            case 1:
                logLevel = LogLevel.DEBUG;
                currentLogHandler2 = getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    sb = new StringBuilder();
                    sb.append("[Purchases] - ");
                    sb.append(logLevel.name());
                    currentLogHandler2.d(sb.toString(), (String) logWrapperKt$log$fullMessageBuilder$1.invoke());
                }
                break;
            case 2:
            case 6:
            case 12:
                getCurrentLogHandler().e("[Purchases] - ERROR", (String) logWrapperKt$log$fullMessageBuilder$1.invoke(), null);
                break;
            case 3:
                logLevel2 = LogLevel.WARN;
                currentLogHandler3 = getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    sb2 = new StringBuilder();
                    sb2.append("[Purchases] - ");
                    sb2.append(logLevel2.name());
                    currentLogHandler3.w(sb2.toString(), (String) logWrapperKt$log$fullMessageBuilder$1.invoke());
                }
                break;
            case 4:
                logLevel3 = LogLevel.INFO;
                currentLogHandler4 = getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    sb3 = new StringBuilder();
                    sb3.append("[Purchases] - ");
                    sb3.append(logLevel3.name());
                    currentLogHandler4.i(sb3.toString(), (String) logWrapperKt$log$fullMessageBuilder$1.invoke());
                }
                break;
            case 5:
                logLevel = LogLevel.DEBUG;
                currentLogHandler2 = getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    sb = new StringBuilder();
                    sb.append("[Purchases] - ");
                    sb.append(logLevel.name());
                    currentLogHandler2.d(sb.toString(), (String) logWrapperKt$log$fullMessageBuilder$1.invoke());
                }
                break;
            case 7:
                logLevel3 = LogLevel.INFO;
                currentLogHandler4 = getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    sb3 = new StringBuilder();
                    sb3.append("[Purchases] - ");
                    sb3.append(logLevel3.name());
                    currentLogHandler4.i(sb3.toString(), (String) logWrapperKt$log$fullMessageBuilder$1.invoke());
                }
                break;
            case 8:
                logLevel = LogLevel.DEBUG;
                currentLogHandler2 = getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    sb = new StringBuilder();
                    sb.append("[Purchases] - ");
                    sb.append(logLevel.name());
                    currentLogHandler2.d(sb.toString(), (String) logWrapperKt$log$fullMessageBuilder$1.invoke());
                }
                break;
            case 9:
                logLevel = LogLevel.DEBUG;
                currentLogHandler2 = getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    sb = new StringBuilder();
                    sb.append("[Purchases] - ");
                    sb.append(logLevel.name());
                    currentLogHandler2.d(sb.toString(), (String) logWrapperKt$log$fullMessageBuilder$1.invoke());
                }
                break;
            case 10:
                logLevel2 = LogLevel.WARN;
                currentLogHandler3 = getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    sb2 = new StringBuilder();
                    sb2.append("[Purchases] - ");
                    sb2.append(logLevel2.name());
                    currentLogHandler3.w(sb2.toString(), (String) logWrapperKt$log$fullMessageBuilder$1.invoke());
                }
                break;
            case m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                logLevel2 = LogLevel.WARN;
                currentLogHandler3 = getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    sb2 = new StringBuilder();
                    sb2.append("[Purchases] - ");
                    sb2.append(logLevel2.name());
                    currentLogHandler3.w(sb2.toString(), (String) logWrapperKt$log$fullMessageBuilder$1.invoke());
                }
                break;
        }
    }

    public static final void setCurrentLogHandler(LogHandler logHandler) {
        AbstractC2304t.f(logHandler, "<set-?>");
        currentLogHandler = logHandler;
    }
}
