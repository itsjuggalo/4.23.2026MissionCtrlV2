package com.revenuecat.purchases.common.events;

import i3.k;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class EventsManager$Companion$backendEvents$2 extends s implements k {
    public static final EventsManager$Companion$backendEvents$2 INSTANCE = new EventsManager$Companion$backendEvents$2();

    public EventsManager$Companion$backendEvents$2() {
        super(1);
    }

    @Override // i3.k
    public final BackendStoredEvent invoke(String jsonString) {
        r.f(jsonString, "jsonString");
        return (BackendStoredEvent) EventsManager.json.d(BackendStoredEvent.Companion.serializer(), jsonString);
    }
}
