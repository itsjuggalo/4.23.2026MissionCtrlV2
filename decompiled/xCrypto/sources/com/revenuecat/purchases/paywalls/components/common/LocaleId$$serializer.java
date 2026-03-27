package com.revenuecat.purchases.paywalls.components.common;

import F3.b;
import I3.e;
import I3.f;
import J3.C;
import J3.D;
import J3.o0;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class LocaleId$$serializer implements C {
    public static final LocaleId$$serializer INSTANCE;
    private static final /* synthetic */ D descriptor;

    static {
        LocaleId$$serializer localeId$$serializer = new LocaleId$$serializer();
        INSTANCE = localeId$$serializer;
        D d4 = new D("com.revenuecat.purchases.paywalls.components.common.LocaleId", localeId$$serializer);
        d4.l("value", false);
        descriptor = d4;
    }

    private LocaleId$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        return new b[]{o0.f952a};
    }

    @Override // F3.a
    public /* bridge */ /* synthetic */ Object deserialize(e eVar) {
        return LocaleId.m166boximpl(m173deserialize8pYHj4M(eVar));
    }

    /* JADX INFO: renamed from: deserialize-8pYHj4M, reason: not valid java name */
    public String m173deserialize8pYHj4M(e decoder) {
        r.f(decoder, "decoder");
        return LocaleId.m167constructorimpl(decoder.g(getDescriptor()).q());
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public /* bridge */ /* synthetic */ void serialize(f fVar, Object obj) {
        m174serialize64pKzr8(fVar, ((LocaleId) obj).m172unboximpl());
    }

    /* JADX INFO: renamed from: serialize-64pKzr8, reason: not valid java name */
    public void m174serialize64pKzr8(f encoder, String value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        f fVarF = encoder.f(getDescriptor());
        if (fVarF == null) {
            return;
        }
        fVarF.F(value);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
