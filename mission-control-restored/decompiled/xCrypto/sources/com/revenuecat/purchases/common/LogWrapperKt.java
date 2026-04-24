package com.revenuecat.purchases.common;

import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class LogWrapperKt {
    private static LogHandler currentLogHandler = new DefaultLogHandler();

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
        r.f(intent, "intent");
        r.f(messageBuilder, "messageBuilder");
        LogWrapperKt$log$fullMessageBuilder$1 logWrapperKt$log$fullMessageBuilder$1 = new LogWrapperKt$log$fullMessageBuilder$1(intent, messageBuilder);
        switch (WhenMappings.$EnumSwitchMapping$0[intent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler2 = getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler2.d("[Purchases] - " + logLevel.name(), (String) logWrapperKt$log$fullMessageBuilder$1.invoke());
                }
                break;
            case 2:
                getCurrentLogHandler().e("[Purchases] - ERROR", (String) logWrapperKt$log$fullMessageBuilder$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler3 = getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler3.w("[Purchases] - " + logLevel2.name(), (String) logWrapperKt$log$fullMessageBuilder$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler4 = getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel3.name(), (String) logWrapperKt$log$fullMessageBuilder$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                LogHandler currentLogHandler5 = getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    currentLogHandler5.d("[Purchases] - " + logLevel4.name(), (String) logWrapperKt$log$fullMessageBuilder$1.invoke());
                }
                break;
            case 6:
                getCurrentLogHandler().e("[Purchases] - ERROR", (String) logWrapperKt$log$fullMessageBuilder$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler6 = getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler6.i("[Purchases] - " + logLevel5.name(), (String) logWrapperKt$log$fullMessageBuilder$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                LogHandler currentLogHandler7 = getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    currentLogHandler7.d("[Purchases] - " + logLevel6.name(), (String) logWrapperKt$log$fullMessageBuilder$1.invoke());
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                LogHandler currentLogHandler8 = getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    currentLogHandler8.d("[Purchases] - " + logLevel7.name(), (String) logWrapperKt$log$fullMessageBuilder$1.invoke());
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler9 = getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler9.w("[Purchases] - " + logLevel8.name(), (String) logWrapperKt$log$fullMessageBuilder$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler10 = getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler10.w("[Purchases] - " + logLevel9.name(), (String) logWrapperKt$log$fullMessageBuilder$1.invoke());
                }
                break;
            case 12:
                getCurrentLogHandler().e("[Purchases] - ERROR", (String) logWrapperKt$log$fullMessageBuilder$1.invoke(), null);
                break;
        }
    }

    public static final void setCurrentLogHandler(LogHandler logHandler) {
        r.f(logHandler, "<set-?>");
        currentLogHandler = logHandler;
    }
}
