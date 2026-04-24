package com.revenuecat.purchases.hybridcommon.mappers;

import E5.t;
import F5.J;
import Q5.k;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import java.util.Locale;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class LogHandlerWithMapping implements LogHandler {
    private final k callback;

    public LogHandlerWithMapping(k callback) {
        r.f(callback, "callback");
        this.callback = callback;
    }

    private final void invokeCallback(LogLevel logLevel, String str) {
        k kVar = this.callback;
        String upperCase = logLevel.name().toUpperCase(Locale.ROOT);
        r.e(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        kVar.invoke(J.g(t.a("logLevel", upperCase), t.a("message", str)));
    }

    @Override // com.revenuecat.purchases.LogHandler
    public void d(String tag, String msg) {
        r.f(tag, "tag");
        r.f(msg, "msg");
        invokeCallback(LogLevel.DEBUG, msg);
    }

    @Override // com.revenuecat.purchases.LogHandler
    public void e(String tag, String msg, Throwable th) {
        r.f(tag, "tag");
        r.f(msg, "msg");
        if (th != null) {
            String str = msg + ". Throwable: " + th;
            if (str != null) {
                msg = str;
            }
        }
        invokeCallback(LogLevel.ERROR, msg);
    }

    @Override // com.revenuecat.purchases.LogHandler
    public void i(String tag, String msg) {
        r.f(tag, "tag");
        r.f(msg, "msg");
        invokeCallback(LogLevel.INFO, msg);
    }

    @Override // com.revenuecat.purchases.LogHandler
    public void v(String tag, String msg) {
        r.f(tag, "tag");
        r.f(msg, "msg");
        invokeCallback(LogLevel.VERBOSE, msg);
    }

    @Override // com.revenuecat.purchases.LogHandler
    public void w(String tag, String msg) {
        r.f(tag, "tag");
        r.f(msg, "msg");
        invokeCallback(LogLevel.WARN, msg);
    }
}
