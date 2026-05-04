package com.revenuecat.purchases.paywalls.components;

import ch.c;
import ch.d;
import ch.e;
import ch.f;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import dh.e0;
import dh.h;
import dh.j1;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/paywalls/components/TabControlToggleComponent.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/paywalls/components/TabControlToggleComponent;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/paywalls/components/TabControlToggleComponent;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/paywalls/components/TabControlToggleComponent;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TabControlToggleComponent$$serializer implements e0 {
    public static final TabControlToggleComponent$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        TabControlToggleComponent$$serializer tabControlToggleComponent$$serializer = new TabControlToggleComponent$$serializer();
        INSTANCE = tabControlToggleComponent$$serializer;
        j1 j1Var = new j1("tab_control_toggle", tabControlToggleComponent$$serializer, 5);
        j1Var.g("default_value", false);
        j1Var.g("thumb_color_on", false);
        j1Var.g("thumb_color_off", false);
        j1Var.g("track_color_on", false);
        j1Var.g("track_color_off", false);
        descriptor = j1Var;
    }

    private TabControlToggleComponent$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        ColorScheme$$serializer colorScheme$$serializer = ColorScheme$$serializer.INSTANCE;
        return new b[]{h.f8149a, colorScheme$$serializer, colorScheme$$serializer, colorScheme$$serializer, colorScheme$$serializer};
    }

    @Override // zg.a
    public TabControlToggleComponent deserialize(e decoder) {
        boolean zB;
        int i10;
        ColorScheme colorScheme;
        ColorScheme colorScheme2;
        ColorScheme colorScheme3;
        ColorScheme colorScheme4;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        if (cVarB.z()) {
            zB = cVarB.B(descriptor2, 0);
            ColorScheme$$serializer colorScheme$$serializer = ColorScheme$$serializer.INSTANCE;
            ColorScheme colorScheme5 = (ColorScheme) cVarB.h(descriptor2, 1, colorScheme$$serializer, null);
            ColorScheme colorScheme6 = (ColorScheme) cVarB.h(descriptor2, 2, colorScheme$$serializer, null);
            colorScheme3 = (ColorScheme) cVarB.h(descriptor2, 3, colorScheme$$serializer, null);
            colorScheme4 = (ColorScheme) cVarB.h(descriptor2, 4, colorScheme$$serializer, null);
            colorScheme2 = colorScheme6;
            colorScheme = colorScheme5;
            i10 = 31;
        } else {
            boolean z10 = true;
            zB = false;
            ColorScheme colorScheme7 = null;
            ColorScheme colorScheme8 = null;
            ColorScheme colorScheme9 = null;
            ColorScheme colorScheme10 = null;
            int i11 = 0;
            while (z10) {
                int iW = cVarB.w(descriptor2);
                if (iW == -1) {
                    z10 = false;
                } else if (iW == 0) {
                    zB = cVarB.B(descriptor2, 0);
                    i11 |= 1;
                } else if (iW == 1) {
                    colorScheme7 = (ColorScheme) cVarB.h(descriptor2, 1, ColorScheme$$serializer.INSTANCE, colorScheme7);
                    i11 |= 2;
                } else if (iW == 2) {
                    colorScheme8 = (ColorScheme) cVarB.h(descriptor2, 2, ColorScheme$$serializer.INSTANCE, colorScheme8);
                    i11 |= 4;
                } else if (iW == 3) {
                    colorScheme9 = (ColorScheme) cVarB.h(descriptor2, 3, ColorScheme$$serializer.INSTANCE, colorScheme9);
                    i11 |= 8;
                } else {
                    if (iW != 4) {
                        throw new m(iW);
                    }
                    colorScheme10 = (ColorScheme) cVarB.h(descriptor2, 4, ColorScheme$$serializer.INSTANCE, colorScheme10);
                    i11 |= 16;
                }
            }
            i10 = i11;
            colorScheme = colorScheme7;
            colorScheme2 = colorScheme8;
            colorScheme3 = colorScheme9;
            colorScheme4 = colorScheme10;
        }
        boolean z11 = zB;
        cVarB.c(descriptor2);
        return new TabControlToggleComponent(i10, z11, colorScheme, colorScheme2, colorScheme3, colorScheme4, null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, TabControlToggleComponent value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        TabControlToggleComponent.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
