package com.revenuecat.purchases;

import J3.C;
import J3.D;
import J3.o0;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class FontAlias$$serializer implements C {
    public static final FontAlias$$serializer INSTANCE;
    private static final /* synthetic */ D descriptor;

    static {
        FontAlias$$serializer fontAlias$$serializer = new FontAlias$$serializer();
        INSTANCE = fontAlias$$serializer;
        D d4 = new D("com.revenuecat.purchases.FontAlias", fontAlias$$serializer);
        d4.l("value", false);
        descriptor = d4;
    }

    private FontAlias$$serializer() {
    }

    @Override // J3.C
    public F3.b[] childSerializers() {
        return new F3.b[]{o0.f952a};
    }

    @Override // F3.a
    public /* bridge */ /* synthetic */ Object deserialize(I3.e eVar) {
        return FontAlias.m60boximpl(m67deserializezxJdh0Q(eVar));
    }

    /* JADX INFO: renamed from: deserialize-zxJdh0Q, reason: not valid java name */
    public String m67deserializezxJdh0Q(I3.e decoder) {
        r.f(decoder, "decoder");
        return FontAlias.m61constructorimpl(decoder.g(getDescriptor()).q());
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public /* bridge */ /* synthetic */ void serialize(I3.f fVar, Object obj) {
        m68serializepDyximM(fVar, ((FontAlias) obj).m66unboximpl());
    }

    /* JADX INFO: renamed from: serialize-pDyximM, reason: not valid java name */
    public void m68serializepDyximM(I3.f encoder, String value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        I3.f fVarF = encoder.f(getDescriptor());
        if (fVarF == null) {
            return;
        }
        fVarF.F(value);
    }

    @Override // J3.C
    public F3.b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
