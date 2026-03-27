package com.revenuecat.purchases.common.events;

import i3.k;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class EventsManager$Companion$backendEvents$1 extends s implements k {
    public static final EventsManager$Companion$backendEvents$1 INSTANCE = new EventsManager$Companion$backendEvents$1();

    public EventsManager$Companion$backendEvents$1() {
        super(1);
    }

    @Override // i3.k
    public final String invoke(BackendStoredEvent event) {
        r.f(event, "event");
        return EventsManager.json.b(BackendStoredEvent.Companion.serializer(), event);
    }
}
