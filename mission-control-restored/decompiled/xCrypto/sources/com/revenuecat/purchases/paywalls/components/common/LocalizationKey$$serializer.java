package com.revenuecat.purchases.paywalls.components.common;

import F3.b;
import I3.e;
import I3.f;
import J3.C;
import J3.D;
import J3.o0;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class LocalizationKey$$serializer implements C {
    public static final LocalizationKey$$serializer INSTANCE;
    private static final /* synthetic */ D descriptor;

    static {
        LocalizationKey$$serializer localizationKey$$serializer = new LocalizationKey$$serializer();
        INSTANCE = localizationKey$$serializer;
        D d4 = new D("com.revenuecat.purchases.paywalls.components.common.LocalizationKey", localizationKey$$serializer);
        d4.l("value", false);
        descriptor = d4;
    }

    private LocalizationKey$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        return new b[]{o0.f952a};
    }

    @Override // F3.a
    public /* bridge */ /* synthetic */ Object deserialize(e eVar) {
        return LocalizationKey.m193boximpl(m200deserialize4Zn71J0(eVar));
    }

    /* JADX INFO: renamed from: deserialize-4Zn71J0, reason: not valid java name */
    public String m200deserialize4Zn71J0(e decoder) {
        r.f(decoder, "decoder");
        return LocalizationKey.m194constructorimpl(decoder.g(getDescriptor()).q());
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public /* bridge */ /* synthetic */ void serialize(f fVar, Object obj) {
        m201serialize7v81vok(fVar, ((LocalizationKey) obj).m199unboximpl());
    }

    /* JADX INFO: renamed from: serialize-7v81vok, reason: not valid java name */
    public void m201serialize7v81vok(f encoder, String value) {
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
