package com.revenuecat.purchases.paywalls.components.properties;

import ch.c;
import ch.d;
import ch.e;
import ch.f;
import com.revenuecat.purchases.ColorAlias;
import com.revenuecat.purchases.ColorAlias$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ColorInfo;
import dh.e0;
import dh.j1;
import dh.s1;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/paywalls/components/properties/ColorInfo.Alias.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo$Alias;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo$Alias;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/paywalls/components/properties/ColorInfo$Alias;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ColorInfo$Alias$$serializer implements e0 {
    public static final ColorInfo$Alias$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        ColorInfo$Alias$$serializer colorInfo$Alias$$serializer = new ColorInfo$Alias$$serializer();
        INSTANCE = colorInfo$Alias$$serializer;
        j1 j1Var = new j1("alias", colorInfo$Alias$$serializer, 1);
        j1Var.g("value", false);
        descriptor = j1Var;
    }

    private ColorInfo$Alias$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        return new b[]{ColorAlias$$serializer.INSTANCE};
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // zg.a
    public ColorInfo.Alias deserialize(e decoder) {
        String strM26unboximpl;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        int i10 = 1;
        s1 s1Var = null;
        Object[] objArr = 0;
        if (cVarB.z()) {
            ColorAlias colorAlias = (ColorAlias) cVarB.h(descriptor2, 0, ColorAlias$$serializer.INSTANCE, null);
            strM26unboximpl = colorAlias != null ? colorAlias.m26unboximpl() : null;
        } else {
            Object[] objArr2 = true;
            int i11 = 0;
            strM26unboximpl = null;
            while (objArr2 != false) {
                int iW = cVarB.w(descriptor2);
                if (iW == -1) {
                    objArr2 = false;
                } else {
                    if (iW != 0) {
                        throw new m(iW);
                    }
                    ColorAlias colorAlias2 = (ColorAlias) cVarB.h(descriptor2, 0, ColorAlias$$serializer.INSTANCE, strM26unboximpl != null ? ColorAlias.m20boximpl(strM26unboximpl) : null);
                    strM26unboximpl = colorAlias2 != null ? colorAlias2.m26unboximpl() : null;
                    i11 = 1;
                }
            }
            i10 = i11;
        }
        cVarB.c(descriptor2);
        return new ColorInfo.Alias(i10, strM26unboximpl, s1Var, objArr == true ? 1 : 0);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, ColorInfo.Alias value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        dVarB.n(descriptor2, 0, ColorAlias$$serializer.INSTANCE, ColorAlias.m20boximpl(value.value));
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
