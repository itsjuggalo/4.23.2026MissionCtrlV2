package com.revenuecat.purchases.common;

import cd.h0;
import com.revenuecat.purchases.common.events.BackendEvent;
import eh.e;
import gh.f;
import kotlin.Metadata;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import pd.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Leh/e;", "Lcd/h0;", "invoke", "(Leh/e;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
public final class JsonProvider$Companion$defaultJson$1 extends v implements k {
    public static final JsonProvider$Companion$defaultJson$1 INSTANCE = new JsonProvider$Companion$defaultJson$1();

    public JsonProvider$Companion$defaultJson$1() {
        super(1);
    }

    @Override // pd.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((e) obj);
        return h0.f3852a;
    }

    public final void invoke(e Json) {
        t.f(Json, "$this$Json");
        f fVar = new f();
        gh.b bVar = new gh.b(n0.b(BackendEvent.class), null);
        bVar.b(n0.b(BackendEvent.CustomerCenter.class), BackendEvent.CustomerCenter.INSTANCE.serializer());
        bVar.b(n0.b(BackendEvent.Paywalls.class), BackendEvent.Paywalls.INSTANCE.serializer());
        bVar.a(fVar);
        Json.g(fVar.f());
        Json.c("discriminator");
        Json.d(false);
        Json.f(true);
    }
}
