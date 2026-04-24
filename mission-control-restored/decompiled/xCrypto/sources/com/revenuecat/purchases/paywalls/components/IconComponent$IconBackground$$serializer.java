package com.revenuecat.purchases.paywalls.components;

import F3.b;
import F3.j;
import G3.a;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.C;
import J3.C0327b0;
import J3.k0;
import com.revenuecat.purchases.paywalls.components.IconComponent;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.Border$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.MaskShape;
import com.revenuecat.purchases.paywalls.components.properties.MaskShapeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shadow$$serializer;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class IconComponent$IconBackground$$serializer implements C {
    public static final IconComponent$IconBackground$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        IconComponent$IconBackground$$serializer iconComponent$IconBackground$$serializer = new IconComponent$IconBackground$$serializer();
        INSTANCE = iconComponent$IconBackground$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.components.IconComponent.IconBackground", iconComponent$IconBackground$$serializer, 4);
        c0327b0.l("color", false);
        c0327b0.l("shape", false);
        c0327b0.l("border", true);
        c0327b0.l("shadow", true);
        descriptor = c0327b0;
    }

    private IconComponent$IconBackground$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        return new b[]{ColorScheme$$serializer.INSTANCE, MaskShapeDeserializer.INSTANCE, a.p(Border$$serializer.INSTANCE), a.p(Shadow$$serializer.INSTANCE)};
    }

    @Override // F3.a
    public IconComponent.IconBackground deserialize(e decoder) {
        int i4;
        Object objM;
        Object objM2;
        Object objY;
        Object objY2;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        Object objM3 = null;
        if (cVarD.w()) {
            objM = cVarD.m(descriptor2, 0, ColorScheme$$serializer.INSTANCE, null);
            objM2 = cVarD.m(descriptor2, 1, MaskShapeDeserializer.INSTANCE, null);
            objY = cVarD.y(descriptor2, 2, Border$$serializer.INSTANCE, null);
            objY2 = cVarD.y(descriptor2, 3, Shadow$$serializer.INSTANCE, null);
            i4 = 15;
        } else {
            boolean z4 = true;
            int i5 = 0;
            Object objM4 = null;
            Object objY3 = null;
            Object objY4 = null;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    z4 = false;
                } else if (i6 == 0) {
                    objM3 = cVarD.m(descriptor2, 0, ColorScheme$$serializer.INSTANCE, objM3);
                    i5 |= 1;
                } else if (i6 == 1) {
                    objM4 = cVarD.m(descriptor2, 1, MaskShapeDeserializer.INSTANCE, objM4);
                    i5 |= 2;
                } else if (i6 == 2) {
                    objY3 = cVarD.y(descriptor2, 2, Border$$serializer.INSTANCE, objY3);
                    i5 |= 4;
                } else {
                    if (i6 != 3) {
                        throw new j(i6);
                    }
                    objY4 = cVarD.y(descriptor2, 3, Shadow$$serializer.INSTANCE, objY4);
                    i5 |= 8;
                }
            }
            Object obj = objM3;
            i4 = i5;
            objM = obj;
            objM2 = objM4;
            objY = objY3;
            objY2 = objY4;
        }
        cVarD.c(descriptor2);
        return new IconComponent.IconBackground(i4, (ColorScheme) objM, (MaskShape) objM2, (Border) objY, (Shadow) objY2, (k0) null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, IconComponent.IconBackground value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        IconComponent.IconBackground.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
