package com.revenuecat.purchases.paywalls.components;

import ah.a;
import cd.z;
import ch.c;
import ch.d;
import ch.e;
import ch.f;
import com.revenuecat.purchases.paywalls.components.CarouselComponent;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import dh.e0;
import dh.g2;
import dh.j1;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/paywalls/components/CarouselComponent.PageControl.Indicator.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl$Indicator;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl$Indicator;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl$Indicator;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CarouselComponent$PageControl$Indicator$$serializer implements e0 {
    public static final CarouselComponent$PageControl$Indicator$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        CarouselComponent$PageControl$Indicator$$serializer carouselComponent$PageControl$Indicator$$serializer = new CarouselComponent$PageControl$Indicator$$serializer();
        INSTANCE = carouselComponent$PageControl$Indicator$$serializer;
        j1 j1Var = new j1("com.revenuecat.purchases.paywalls.components.CarouselComponent.PageControl.Indicator", carouselComponent$PageControl$Indicator$$serializer, 5);
        j1Var.g("width", false);
        j1Var.g("height", false);
        j1Var.g("color", false);
        j1Var.g("stroke_color", true);
        j1Var.g("stroke_width", true);
        descriptor = j1Var;
    }

    private CarouselComponent$PageControl$Indicator$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        g2 g2Var = g2.f8147a;
        ColorScheme$$serializer colorScheme$$serializer = ColorScheme$$serializer.INSTANCE;
        return new b[]{g2Var, g2Var, colorScheme$$serializer, a.p(colorScheme$$serializer), a.p(g2Var)};
    }

    @Override // zg.a
    public CarouselComponent.PageControl.Indicator deserialize(e decoder) {
        int i10;
        z zVar;
        z zVar2;
        ColorScheme colorScheme;
        ColorScheme colorScheme2;
        z zVar3;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        z zVar4 = null;
        if (cVarB.z()) {
            g2 g2Var = g2.f8147a;
            z zVar5 = (z) cVarB.h(descriptor2, 0, g2Var, null);
            z zVar6 = (z) cVarB.h(descriptor2, 1, g2Var, null);
            ColorScheme$$serializer colorScheme$$serializer = ColorScheme$$serializer.INSTANCE;
            ColorScheme colorScheme3 = (ColorScheme) cVarB.h(descriptor2, 2, colorScheme$$serializer, null);
            ColorScheme colorScheme4 = (ColorScheme) cVarB.n(descriptor2, 3, colorScheme$$serializer, null);
            zVar3 = (z) cVarB.n(descriptor2, 4, g2Var, null);
            colorScheme2 = colorScheme4;
            i10 = 31;
            colorScheme = colorScheme3;
            zVar2 = zVar6;
            zVar = zVar5;
        } else {
            boolean z10 = true;
            int i11 = 0;
            z zVar7 = null;
            ColorScheme colorScheme5 = null;
            ColorScheme colorScheme6 = null;
            z zVar8 = null;
            while (z10) {
                int iW = cVarB.w(descriptor2);
                if (iW == -1) {
                    z10 = false;
                } else if (iW == 0) {
                    zVar4 = (z) cVarB.h(descriptor2, 0, g2.f8147a, zVar4);
                    i11 |= 1;
                } else if (iW == 1) {
                    zVar7 = (z) cVarB.h(descriptor2, 1, g2.f8147a, zVar7);
                    i11 |= 2;
                } else if (iW == 2) {
                    colorScheme5 = (ColorScheme) cVarB.h(descriptor2, 2, ColorScheme$$serializer.INSTANCE, colorScheme5);
                    i11 |= 4;
                } else if (iW == 3) {
                    colorScheme6 = (ColorScheme) cVarB.n(descriptor2, 3, ColorScheme$$serializer.INSTANCE, colorScheme6);
                    i11 |= 8;
                } else {
                    if (iW != 4) {
                        throw new m(iW);
                    }
                    zVar8 = (z) cVarB.n(descriptor2, 4, g2.f8147a, zVar8);
                    i11 |= 16;
                }
            }
            i10 = i11;
            zVar = zVar4;
            zVar2 = zVar7;
            colorScheme = colorScheme5;
            colorScheme2 = colorScheme6;
            zVar3 = zVar8;
        }
        cVarB.c(descriptor2);
        return new CarouselComponent.PageControl.Indicator(i10, zVar, zVar2, colorScheme, colorScheme2, zVar3, null, null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, CarouselComponent.PageControl.Indicator value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        CarouselComponent.PageControl.Indicator.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
