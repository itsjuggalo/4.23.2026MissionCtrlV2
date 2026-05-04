package com.revenuecat.purchases.paywalls.components.properties;

import ch.c;
import ch.d;
import ch.e;
import ch.f;
import dh.e0;
import dh.j1;
import dh.t;
import kotlin.Metadata;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/paywalls/components/properties/Shadow.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Shadow$$serializer implements e0 {
    public static final Shadow$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        Shadow$$serializer shadow$$serializer = new Shadow$$serializer();
        INSTANCE = shadow$$serializer;
        j1 j1Var = new j1("com.revenuecat.purchases.paywalls.components.properties.Shadow", shadow$$serializer, 4);
        j1Var.g("color", false);
        j1Var.g("radius", false);
        j1Var.g("x", false);
        j1Var.g("y", false);
        descriptor = j1Var;
    }

    private Shadow$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        t tVar = t.f8221a;
        return new b[]{ColorScheme$$serializer.INSTANCE, tVar, tVar, tVar};
    }

    @Override // zg.a
    public Shadow deserialize(e decoder) {
        int i10;
        ColorScheme colorScheme;
        double dK;
        double d10;
        double d11;
        kotlin.jvm.internal.t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        ColorScheme colorScheme2 = null;
        if (cVarB.z()) {
            ColorScheme colorScheme3 = (ColorScheme) cVarB.h(descriptor2, 0, ColorScheme$$serializer.INSTANCE, null);
            double dK2 = cVarB.k(descriptor2, 1);
            double dK3 = cVarB.k(descriptor2, 2);
            colorScheme = colorScheme3;
            dK = cVarB.k(descriptor2, 3);
            d10 = dK2;
            d11 = dK3;
            i10 = 15;
        } else {
            double dK4 = 0.0d;
            boolean z10 = true;
            int i11 = 0;
            double dK5 = 0.0d;
            double dK6 = 0.0d;
            while (z10) {
                int iW = cVarB.w(descriptor2);
                if (iW == -1) {
                    z10 = false;
                } else if (iW == 0) {
                    colorScheme2 = (ColorScheme) cVarB.h(descriptor2, 0, ColorScheme$$serializer.INSTANCE, colorScheme2);
                    i11 |= 1;
                } else if (iW == 1) {
                    dK5 = cVarB.k(descriptor2, 1);
                    i11 |= 2;
                } else if (iW == 2) {
                    dK6 = cVarB.k(descriptor2, 2);
                    i11 |= 4;
                } else {
                    if (iW != 3) {
                        throw new m(iW);
                    }
                    dK4 = cVarB.k(descriptor2, 3);
                    i11 |= 8;
                }
            }
            i10 = i11;
            colorScheme = colorScheme2;
            dK = dK4;
            d10 = dK5;
            d11 = dK6;
        }
        cVarB.c(descriptor2);
        return new Shadow(i10, colorScheme, d10, d11, dK, null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, Shadow value) {
        kotlin.jvm.internal.t.f(encoder, "encoder");
        kotlin.jvm.internal.t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        Shadow.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
