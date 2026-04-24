package com.revenuecat.purchases.blockstore;

import W2.E;
import W2.p;
import Z2.e;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import i3.k;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class BlockstoreHelper$storeUserIdIfNeeded$6$1 extends s implements k {
    final /* synthetic */ e $cont;
    final /* synthetic */ String $userId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlockstoreHelper$storeUserIdIfNeeded$6$1(e eVar, String str) {
        super(1);
        this.$cont = eVar;
        this.$userId = str;
    }

    @Override // i3.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Integer) obj);
        return E.f5463a;
    }

    public final void invoke(Integer num) {
        String str = this.$userId;
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.d("[Purchases] - " + logLevel.name(), "Block store: User ID: " + str + " stored in Block store.");
        }
        e eVar = this.$cont;
        p.a aVar = p.f5487b;
        eVar.resumeWith(p.b(E.f5463a));
    }
}
