package com.revenuecat.purchases.common.events;

import B5.k;
import com.revenuecat.purchases.paywalls.events.PaywallStoredEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2302q;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public /* synthetic */ class EventsManager$Companion$paywalls$1 extends AbstractC2302q implements k {
    public static final EventsManager$Companion$paywalls$1 INSTANCE = new EventsManager$Companion$paywalls$1();

    public EventsManager$Companion$paywalls$1() {
        super(1, PaywallStoredEvent.class, "toString", "toString()Ljava/lang/String;", 0);
    }

    @Override // B5.k
    public final String invoke(PaywallStoredEvent p02) {
        AbstractC2304t.f(p02, "p0");
        return p02.toString();
    }
}
