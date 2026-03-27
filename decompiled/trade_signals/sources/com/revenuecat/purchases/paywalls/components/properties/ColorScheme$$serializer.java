package com.revenuecat.purchases.paywalls.components.properties;

import k7.b;
import k7.m;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;
import l7.a;
import n7.c;
import n7.d;
import n7.e;
import n7.f;
import o7.C2514k0;
import o7.E;
import o7.t0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/paywalls/components/properties/ColorScheme.$serializer", "Lo7/E;", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "<init>", "()V", "", "Lk7/b;", "childSerializers", "()[Lk7/b;", "Ln7/e;", "decoder", "deserialize", "(Ln7/e;)Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "Ln7/f;", "encoder", "value", "Lo5/H;", "serialize", "(Ln7/f;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;)V", "Lm7/e;", "getDescriptor", "()Lm7/e;", "descriptor", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
public final class ColorScheme$$serializer implements E {
    public static final ColorScheme$$serializer INSTANCE;
    private static final /* synthetic */ C2514k0 descriptor;

    static {
        ColorScheme$$serializer colorScheme$$serializer = new ColorScheme$$serializer();
        INSTANCE = colorScheme$$serializer;
        C2514k0 c2514k0 = new C2514k0("com.revenuecat.purchases.paywalls.components.properties.ColorScheme", colorScheme$$serializer, 2);
        c2514k0.p("light", false);
        c2514k0.p("dark", true);
        descriptor = c2514k0;
    }

    private ColorScheme$$serializer() {
    }

    @Override // o7.E
    public b[] childSerializers() {
        b[] bVarArr = ColorScheme.$childSerializers;
        return new b[]{bVarArr[0], a.p(bVarArr[1])};
    }

    @Override // k7.a
    public ColorScheme deserialize(e decoder) {
        ColorInfo colorInfo;
        ColorInfo colorInfo2;
        int i8;
        AbstractC2304t.f(decoder, "decoder");
        m7.e descriptor2 = getDescriptor();
        c cVarC = decoder.c(descriptor2);
        b[] bVarArr = ColorScheme.$childSerializers;
        t0 t0Var = null;
        if (cVarC.w()) {
            colorInfo2 = (ColorInfo) cVarC.u(descriptor2, 0, bVarArr[0], null);
            colorInfo = (ColorInfo) cVarC.z(descriptor2, 1, bVarArr[1], null);
            i8 = 3;
        } else {
            boolean z7 = true;
            int i9 = 0;
            ColorInfo colorInfo3 = null;
            ColorInfo colorInfo4 = null;
            while (z7) {
                int iE = cVarC.E(descriptor2);
                if (iE == -1) {
                    z7 = false;
                } else if (iE == 0) {
                    colorInfo4 = (ColorInfo) cVarC.u(descriptor2, 0, bVarArr[0], colorInfo4);
                    i9 |= 1;
                } else {
                    if (iE != 1) {
                        throw new m(iE);
                    }
                    colorInfo3 = (ColorInfo) cVarC.z(descriptor2, 1, bVarArr[1], colorInfo3);
                    i9 |= 2;
                }
            }
            colorInfo = colorInfo3;
            colorInfo2 = colorInfo4;
            i8 = i9;
        }
        cVarC.d(descriptor2);
        return new ColorScheme(i8, colorInfo2, colorInfo, t0Var);
    }

    @Override // k7.b, k7.k, k7.a
    public m7.e getDescriptor() {
        return descriptor;
    }

    @Override // k7.k
    public void serialize(f encoder, ColorScheme value) {
        AbstractC2304t.f(encoder, "encoder");
        AbstractC2304t.f(value, "value");
        m7.e descriptor2 = getDescriptor();
        d dVarC = encoder.c(descriptor2);
        ColorScheme.write$Self$purchases_defaultsRelease(value, dVarC, descriptor2);
        dVarC.d(descriptor2);
    }

    @Override // o7.E
    public b[] typeParametersSerializers() {
        return E.a.a(this);
    }
}
