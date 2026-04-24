package com.revenuecat.purchases.paywalls.components;

import F3.b;
import F3.j;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.C;
import J3.C0327b0;
import J3.C0335h;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class TabControlToggleComponent$$serializer implements C {
    public static final TabControlToggleComponent$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        TabControlToggleComponent$$serializer tabControlToggleComponent$$serializer = new TabControlToggleComponent$$serializer();
        INSTANCE = tabControlToggleComponent$$serializer;
        C0327b0 c0327b0 = new C0327b0("tab_control_toggle", tabControlToggleComponent$$serializer, 5);
        c0327b0.l("default_value", false);
        c0327b0.l("thumb_color_on", false);
        c0327b0.l("thumb_color_off", false);
        c0327b0.l("track_color_on", false);
        c0327b0.l("track_color_off", false);
        descriptor = c0327b0;
    }

    private TabControlToggleComponent$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        ColorScheme$$serializer colorScheme$$serializer = ColorScheme$$serializer.INSTANCE;
        return new b[]{C0335h.f929a, colorScheme$$serializer, colorScheme$$serializer, colorScheme$$serializer, colorScheme$$serializer};
    }

    @Override // F3.a
    public TabControlToggleComponent deserialize(e decoder) {
        boolean zN;
        int i4;
        Object objM;
        Object objM2;
        Object objM3;
        Object objM4;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        if (cVarD.w()) {
            zN = cVarD.n(descriptor2, 0);
            ColorScheme$$serializer colorScheme$$serializer = ColorScheme$$serializer.INSTANCE;
            objM = cVarD.m(descriptor2, 1, colorScheme$$serializer, null);
            objM2 = cVarD.m(descriptor2, 2, colorScheme$$serializer, null);
            objM3 = cVarD.m(descriptor2, 3, colorScheme$$serializer, null);
            objM4 = cVarD.m(descriptor2, 4, colorScheme$$serializer, null);
            i4 = 31;
        } else {
            boolean z4 = true;
            zN = false;
            Object objM5 = null;
            Object objM6 = null;
            Object objM7 = null;
            Object objM8 = null;
            int i5 = 0;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    z4 = false;
                } else if (i6 == 0) {
                    zN = cVarD.n(descriptor2, 0);
                    i5 |= 1;
                } else if (i6 == 1) {
                    objM5 = cVarD.m(descriptor2, 1, ColorScheme$$serializer.INSTANCE, objM5);
                    i5 |= 2;
                } else if (i6 == 2) {
                    objM6 = cVarD.m(descriptor2, 2, ColorScheme$$serializer.INSTANCE, objM6);
                    i5 |= 4;
                } else if (i6 == 3) {
                    objM7 = cVarD.m(descriptor2, 3, ColorScheme$$serializer.INSTANCE, objM7);
                    i5 |= 8;
                } else {
                    if (i6 != 4) {
                        throw new j(i6);
                    }
                    objM8 = cVarD.m(descriptor2, 4, ColorScheme$$serializer.INSTANCE, objM8);
                    i5 |= 16;
                }
            }
            i4 = i5;
            objM = objM5;
            objM2 = objM6;
            objM3 = objM7;
            objM4 = objM8;
        }
        boolean z5 = zN;
        cVarD.c(descriptor2);
        return new TabControlToggleComponent(i4, z5, (ColorScheme) objM, (ColorScheme) objM2, (ColorScheme) objM3, (ColorScheme) objM4, null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, TabControlToggleComponent value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        TabControlToggleComponent.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
