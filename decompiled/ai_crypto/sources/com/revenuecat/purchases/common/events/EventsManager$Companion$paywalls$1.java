package com.revenuecat.purchases.common.events;

import Q5.k;
import com.revenuecat.purchases.paywalls.events.PaywallStoredEvent;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public /* synthetic */ class EventsManager$Companion$paywalls$1 extends o implements k {
    public static final EventsManager$Companion$paywalls$1 INSTANCE = new EventsManager$Companion$paywalls$1();

    public EventsManager$Companion$paywalls$1() {
        super(1, PaywallStoredEvent.class, "toString", "toString()Ljava/lang/String;", 0);
    }

    @Override // Q5.k
    public final String invoke(PaywallStoredEvent p02) {
        r.f(p02, "p0");
        return p02.toString();
    }
}
