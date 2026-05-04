package com.revenuecat.purchases.paywalls.components.properties;

import ah.a;
import ch.c;
import ch.d;
import ch.e;
import ch.f;
import dh.e0;
import dh.j1;
import dh.s1;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ThemeImageUrls$$serializer implements e0 {
    public static final ThemeImageUrls$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        ThemeImageUrls$$serializer themeImageUrls$$serializer = new ThemeImageUrls$$serializer();
        INSTANCE = themeImageUrls$$serializer;
        j1 j1Var = new j1("com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls", themeImageUrls$$serializer, 2);
        j1Var.g("light", false);
        j1Var.g("dark", true);
        descriptor = j1Var;
    }

    private ThemeImageUrls$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        ImageUrls$$serializer imageUrls$$serializer = ImageUrls$$serializer.INSTANCE;
        return new b[]{imageUrls$$serializer, a.p(imageUrls$$serializer)};
    }

    @Override // zg.a
    public ThemeImageUrls deserialize(e decoder) {
        ImageUrls imageUrls;
        int i10;
        ImageUrls imageUrls2;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        if (cVarB.z()) {
            ImageUrls$$serializer imageUrls$$serializer = ImageUrls$$serializer.INSTANCE;
            imageUrls2 = (ImageUrls) cVarB.h(descriptor2, 0, imageUrls$$serializer, null);
            imageUrls = (ImageUrls) cVarB.n(descriptor2, 1, imageUrls$$serializer, null);
            i10 = 3;
        } else {
            boolean z10 = true;
            int i11 = 0;
            imageUrls = null;
            ImageUrls imageUrls3 = null;
            while (z10) {
                int iW = cVarB.w(descriptor2);
                if (iW == -1) {
                    z10 = false;
                } else if (iW == 0) {
                    imageUrls3 = (ImageUrls) cVarB.h(descriptor2, 0, ImageUrls$$serializer.INSTANCE, imageUrls3);
                    i11 |= 1;
                } else {
                    if (iW != 1) {
                        throw new m(iW);
                    }
                    imageUrls = (ImageUrls) cVarB.n(descriptor2, 1, ImageUrls$$serializer.INSTANCE, imageUrls);
                    i11 |= 2;
                }
            }
            i10 = i11;
            imageUrls2 = imageUrls3;
        }
        cVarB.c(descriptor2);
        return new ThemeImageUrls(i10, imageUrls2, imageUrls, (s1) null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, ThemeImageUrls value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        ThemeImageUrls.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
