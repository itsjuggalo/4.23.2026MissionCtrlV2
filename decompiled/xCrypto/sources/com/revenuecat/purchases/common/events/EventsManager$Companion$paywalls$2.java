package com.revenuecat.purchases.common.events;

import com.revenuecat.purchases.paywalls.events.PaywallStoredEvent;
import i3.k;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class EventsManager$Companion$paywalls$2 extends o implements k {
    public EventsManager$Companion$paywalls$2(Object obj) {
        super(1, obj, PaywallStoredEvent.Companion.class, "fromString", "fromString(Ljava/lang/String;)Lcom/revenuecat/purchases/paywalls/events/PaywallStoredEvent;", 0);
    }

    @Override // i3.k
    public final PaywallStoredEvent invoke(String p02) {
        r.f(p02, "p0");
        return ((PaywallStoredEvent.Companion) this.receiver).fromString(p02);
    }
}
