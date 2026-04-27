package com.revenuecat.purchases.hybridcommon.mappers;

import B5.k;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import io.flutter.plugins.firebase.database.Constants;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;
import o5.w;
import p5.M;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u001e\u0010\u0006\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00050\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0010J\u001f\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0010J\u001f\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0010R,\u0010\u0006\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00050\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/revenuecat/purchases/hybridcommon/mappers/LogHandlerWithMapping;", "Lcom/revenuecat/purchases/LogHandler;", "Lkotlin/Function1;", "", "", "Lo5/H;", "callback", "<init>", "(LB5/k;)V", "Lcom/revenuecat/purchases/LogLevel;", "logLevel", "msg", "invokeCallback", "(Lcom/revenuecat/purchases/LogLevel;Ljava/lang/String;)V", "tag", "d", "(Ljava/lang/String;Ljava/lang/String;)V", "", "throwable", "e", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "i", "v", "w", "LB5/k;", "hybridcommon_release"}, k = 1, mv = {1, 8, 0})
public final class LogHandlerWithMapping implements LogHandler {
    private final k callback;

    public LogHandlerWithMapping(k callback) {
        AbstractC2304t.f(callback, "callback");
        this.callback = callback;
    }

    private final void invokeCallback(LogLevel logLevel, String msg) {
        k kVar = this.callback;
        String upperCase = logLevel.name().toUpperCase(Locale.ROOT);
        AbstractC2304t.e(upperCase, "toUpperCase(...)");
        kVar.invoke(M.k(w.a("logLevel", upperCase), w.a(Constants.ERROR_MESSAGE, msg)));
    }

    @Override // com.revenuecat.purchases.LogHandler
    public void d(String tag, String msg) {
        AbstractC2304t.f(tag, "tag");
        AbstractC2304t.f(msg, "msg");
        invokeCallback(LogLevel.DEBUG, msg);
    }

    @Override // com.revenuecat.purchases.LogHandler
    public void e(String tag, String msg, Throwable throwable) {
        AbstractC2304t.f(tag, "tag");
        AbstractC2304t.f(msg, "msg");
        if (throwable != null) {
            String str = msg + ". Throwable: " + throwable;
            if (str != null) {
                msg = str;
            }
        }
        invokeCallback(LogLevel.ERROR, msg);
    }

    @Override // com.revenuecat.purchases.LogHandler
    public void i(String tag, String msg) {
        AbstractC2304t.f(tag, "tag");
        AbstractC2304t.f(msg, "msg");
        invokeCallback(LogLevel.INFO, msg);
    }

    @Override // com.revenuecat.purchases.LogHandler
    public void v(String tag, String msg) {
        AbstractC2304t.f(tag, "tag");
        AbstractC2304t.f(msg, "msg");
        invokeCallback(LogLevel.VERBOSE, msg);
    }

    @Override // com.revenuecat.purchases.LogHandler
    public void w(String tag, String msg) {
        AbstractC2304t.f(tag, "tag");
        AbstractC2304t.f(msg, "msg");
        invokeCallback(LogLevel.WARN, msg);
    }
}
