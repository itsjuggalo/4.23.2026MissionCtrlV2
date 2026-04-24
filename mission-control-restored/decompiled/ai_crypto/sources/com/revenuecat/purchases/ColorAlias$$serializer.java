package com.revenuecat.purchases;

import kotlin.jvm.internal.r;
import r6.C;
import r6.D;
import r6.o0;

/* JADX INFO: loaded from: classes.dex */
public final class ColorAlias$$serializer implements C {
    public static final ColorAlias$$serializer INSTANCE;
    private static final /* synthetic */ D descriptor;

    static {
        ColorAlias$$serializer colorAlias$$serializer = new ColorAlias$$serializer();
        INSTANCE = colorAlias$$serializer;
        D d7 = new D("com.revenuecat.purchases.ColorAlias", colorAlias$$serializer);
        d7.l("value", false);
        descriptor = d7;
    }

    private ColorAlias$$serializer() {
    }

    @Override // r6.C
    public n6.b[] childSerializers() {
        return new n6.b[]{o0.f22909a};
    }

    @Override // n6.a
    public /* bridge */ /* synthetic */ Object deserialize(q6.e eVar) {
        return ColorAlias.m13boximpl(m20deserializeQzpnlxU(eVar));
    }

    /* JADX INFO: renamed from: deserialize-QzpnlxU, reason: not valid java name */
    public String m20deserializeQzpnlxU(q6.e decoder) {
        r.f(decoder, "decoder");
        return ColorAlias.m14constructorimpl(decoder.x(getDescriptor()).o());
    }

    @Override // n6.b, n6.h, n6.a
    public p6.e getDescriptor() {
        return descriptor;
    }

    @Override // n6.h
    public /* bridge */ /* synthetic */ void serialize(q6.f fVar, Object obj) {
        m21serializevLxeDZI(fVar, ((ColorAlias) obj).m19unboximpl());
    }

    /* JADX INFO: renamed from: serialize-vLxeDZI, reason: not valid java name */
    public void m21serializevLxeDZI(q6.f encoder, String value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        q6.f fVarU = encoder.u(getDescriptor());
        if (fVarU == null) {
            return;
        }
        fVarU.F(value);
    }

    @Override // r6.C
    public n6.b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
