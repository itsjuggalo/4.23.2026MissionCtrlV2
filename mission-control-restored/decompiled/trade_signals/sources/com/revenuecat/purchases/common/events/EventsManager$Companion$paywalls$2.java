package com.revenuecat.purchases.common.events;

import B5.k;
import com.revenuecat.purchases.paywalls.events.PaywallStoredEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2302q;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public /* synthetic */ class EventsManager$Companion$paywalls$2 extends AbstractC2302q implements k {
    public EventsManager$Companion$paywalls$2(Object obj) {
        super(1, obj, PaywallStoredEvent.Companion.class, "fromString", "fromString(Ljava/lang/String;)Lcom/revenuecat/purchases/paywalls/events/PaywallStoredEvent;", 0);
    }

    @Override // B5.k
    public final PaywallStoredEvent invoke(String p02) {
        AbstractC2304t.f(p02, "p0");
        return ((PaywallStoredEvent.Companion) this.receiver).fromString(p02);
    }
}
