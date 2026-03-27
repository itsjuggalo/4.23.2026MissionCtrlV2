package com.revenuecat.purchases.common;

import E5.E;
import Q5.k;
import com.revenuecat.purchases.common.events.BackendEvent;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import s6.d;
import u6.f;

/* JADX INFO: loaded from: classes2.dex */
public final class JsonProvider$Companion$defaultJson$1 extends s implements k {
    public static final JsonProvider$Companion$defaultJson$1 INSTANCE = new JsonProvider$Companion$defaultJson$1();

    public JsonProvider$Companion$defaultJson$1() {
        super(1);
    }

    @Override // Q5.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((d) obj);
        return E.f1657a;
    }

    public final void invoke(d Json) {
        r.f(Json, "$this$Json");
        f fVar = new f();
        u6.b bVar = new u6.b(H.b(BackendEvent.class), null);
        bVar.b(H.b(BackendEvent.CustomerCenter.class), BackendEvent.CustomerCenter.Companion.serializer());
        bVar.b(H.b(BackendEvent.Paywalls.class), BackendEvent.Paywalls.Companion.serializer());
        bVar.a(fVar);
        Json.g(fVar.f());
        Json.c("discriminator");
        Json.d(false);
        Json.f(true);
    }
}
