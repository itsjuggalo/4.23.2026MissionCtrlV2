package com.revenuecat.purchases;

import kotlin.jvm.internal.r;
import r6.C;
import r6.D;
import r6.o0;

/* JADX INFO: loaded from: classes.dex */
public final class FontAlias$$serializer implements C {
    public static final FontAlias$$serializer INSTANCE;
    private static final /* synthetic */ D descriptor;

    static {
        FontAlias$$serializer fontAlias$$serializer = new FontAlias$$serializer();
        INSTANCE = fontAlias$$serializer;
        D d7 = new D("com.revenuecat.purchases.FontAlias", fontAlias$$serializer);
        d7.l("value", false);
        descriptor = d7;
    }

    private FontAlias$$serializer() {
    }

    @Override // r6.C
    public n6.b[] childSerializers() {
        return new n6.b[]{o0.f22909a};
    }

    @Override // n6.a
    public /* bridge */ /* synthetic */ Object deserialize(q6.e eVar) {
        return FontAlias.m31boximpl(m38deserializezxJdh0Q(eVar));
    }

    /* JADX INFO: renamed from: deserialize-zxJdh0Q, reason: not valid java name */
    public String m38deserializezxJdh0Q(q6.e decoder) {
        r.f(decoder, "decoder");
        return FontAlias.m32constructorimpl(decoder.x(getDescriptor()).o());
    }

    @Override // n6.b, n6.h, n6.a
    public p6.e getDescriptor() {
        return descriptor;
    }

    @Override // n6.h
    public /* bridge */ /* synthetic */ void serialize(q6.f fVar, Object obj) {
        m39serializepDyximM(fVar, ((FontAlias) obj).m37unboximpl());
    }

    /* JADX INFO: renamed from: serialize-pDyximM, reason: not valid java name */
    public void m39serializepDyximM(q6.f encoder, String value) {
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
