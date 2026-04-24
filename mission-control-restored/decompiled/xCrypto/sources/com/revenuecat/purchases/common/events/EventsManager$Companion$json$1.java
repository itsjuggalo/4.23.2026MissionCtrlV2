package com.revenuecat.purchases.common.events;

import K3.d;
import M3.b;
import M3.f;
import W2.E;
import com.revenuecat.purchases.common.events.BackendStoredEvent;
import i3.k;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class EventsManager$Companion$json$1 extends s implements k {
    public static final EventsManager$Companion$json$1 INSTANCE = new EventsManager$Companion$json$1();

    public EventsManager$Companion$json$1() {
        super(1);
    }

    @Override // i3.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((d) obj);
        return E.f5463a;
    }

    public final void invoke(d Json) {
        r.f(Json, "$this$Json");
        f fVar = new f();
        b bVar = new b(G.b(BackendStoredEvent.class), null);
        bVar.b(G.b(BackendStoredEvent.CustomerCenter.class), BackendStoredEvent.CustomerCenter.Companion.serializer());
        bVar.b(G.b(BackendStoredEvent.Paywalls.class), BackendStoredEvent.Paywalls.Companion.serializer());
        bVar.a(fVar);
        Json.g(fVar.f());
        Json.e(false);
    }
}
