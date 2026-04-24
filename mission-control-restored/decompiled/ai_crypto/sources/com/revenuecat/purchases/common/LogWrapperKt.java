package com.revenuecat.purchases.common;

import F5.v;
import com.revenuecat.purchases.LogHandler;
import k4.C2105D;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
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

    public static final void log(LogIntent intent, String message) {
        r.f(intent, "intent");
        r.f(message, "message");
        String str = v.R(intent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + message;
        switch (WhenMappings.$EnumSwitchMapping$0[intent.ordinal()]) {
            case 1:
                LogUtilsKt.debugLog(str);
                break;
            case 2:
                LogUtilsKt.errorLog$default(str, null, 2, null);
                break;
            case 3:
                LogUtilsKt.warnLog(str);
                break;
            case 4:
                LogUtilsKt.infoLog(str);
                break;
            case 5:
                LogUtilsKt.debugLog(str);
                break;
            case 6:
                LogUtilsKt.errorLog$default(str, null, 2, null);
                break;
            case 7:
                LogUtilsKt.infoLog(str);
                break;
            case 8:
                LogUtilsKt.debugLog(str);
                break;
            case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                LogUtilsKt.debugLog(str);
                break;
            case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                LogUtilsKt.warnLog(str);
                break;
            case 11:
                LogUtilsKt.warnLog(str);
                break;
            case 12:
                LogUtilsKt.errorLog$default(str, null, 2, null);
                break;
        }
    }

    public static final void setCurrentLogHandler(LogHandler logHandler) {
        r.f(logHandler, "<set-?>");
        currentLogHandler = logHandler;
    }
}
