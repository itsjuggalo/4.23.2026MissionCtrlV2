package com.revenuecat.purchases.common;

import K3.d;
import M3.f;
import W2.E;
import com.revenuecat.purchases.common.events.BackendEvent;
import i3.k;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class JsonProvider$Companion$defaultJson$1 extends s implements k {
    public static final JsonProvider$Companion$defaultJson$1 INSTANCE = new JsonProvider$Companion$defaultJson$1();

    public JsonProvider$Companion$defaultJson$1() {
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
        M3.b bVar = new M3.b(G.b(BackendEvent.class), null);
        bVar.b(G.b(BackendEvent.CustomerCenter.class), BackendEvent.CustomerCenter.Companion.serializer());
        bVar.b(G.b(BackendEvent.Paywalls.class), BackendEvent.Paywalls.Companion.serializer());
        bVar.a(fVar);
        Json.g(fVar.f());
        Json.c("discriminator");
        Json.d(false);
        Json.f(true);
    }
}
