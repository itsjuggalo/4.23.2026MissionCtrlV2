package com.revenuecat.purchases.common;

import B5.k;
import com.revenuecat.purchases.common.events.BackendEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.AbstractC2306v;
import kotlin.jvm.internal.O;
import o5.C2470H;
import p7.C2612e;
import r7.f;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lp7/e;", "Lo5/H;", "invoke", "(Lp7/e;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
public final class JsonProvider$Companion$defaultJson$1 extends AbstractC2306v implements k {
    public static final JsonProvider$Companion$defaultJson$1 INSTANCE = new JsonProvider$Companion$defaultJson$1();

    public JsonProvider$Companion$defaultJson$1() {
        super(1);
    }

    @Override // B5.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((C2612e) obj);
        return C2470H.f21956a;
    }

    public final void invoke(C2612e Json) {
        AbstractC2304t.f(Json, "$this$Json");
        f fVar = new f();
        r7.b bVar = new r7.b(O.b(BackendEvent.class), null);
        bVar.b(O.b(BackendEvent.CustomerCenter.class), BackendEvent.CustomerCenter.INSTANCE.serializer());
        bVar.b(O.b(BackendEvent.Paywalls.class), BackendEvent.Paywalls.INSTANCE.serializer());
        bVar.a(fVar);
        Json.g(fVar.f());
        Json.c("discriminator");
        Json.d(false);
        Json.f(true);
    }
}
