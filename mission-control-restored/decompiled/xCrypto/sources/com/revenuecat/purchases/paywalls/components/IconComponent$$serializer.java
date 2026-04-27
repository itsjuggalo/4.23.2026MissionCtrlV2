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
import J3.C0335h;
import J3.k0;
import J3.o0;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.revenuecat.purchases.paywalls.components.IconComponent;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import java.util.List;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class IconComponent$$serializer implements C {
    public static final IconComponent$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        IconComponent$$serializer iconComponent$$serializer = new IconComponent$$serializer();
        INSTANCE = iconComponent$$serializer;
        C0327b0 c0327b0 = new C0327b0("icon", iconComponent$$serializer, 10);
        c0327b0.l("base_url", false);
        c0327b0.l("icon_name", false);
        c0327b0.l("formats", false);
        c0327b0.l("visible", true);
        c0327b0.l("size", true);
        c0327b0.l("color", true);
        c0327b0.l("padding", true);
        c0327b0.l("margin", true);
        c0327b0.l("icon_background", true);
        c0327b0.l("overrides", true);
        descriptor = c0327b0;
    }

    private IconComponent$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        b[] bVarArr = IconComponent.$childSerializers;
        b bVarP = a.p(C0335h.f929a);
        b bVarP2 = a.p(ColorScheme$$serializer.INSTANCE);
        b bVarP3 = a.p(IconComponent$IconBackground$$serializer.INSTANCE);
        b bVar = bVarArr[9];
        o0 o0Var = o0.f952a;
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new b[]{o0Var, o0Var, IconComponent$Formats$$serializer.INSTANCE, bVarP, Size$$serializer.INSTANCE, bVarP2, padding$$serializer, padding$$serializer, bVarP3, bVar};
    }

    @Override // F3.a
    public IconComponent deserialize(e decoder) {
        Object objM;
        Object objM2;
        Object objM3;
        int i4;
        Object objM4;
        Object objY;
        Object objM5;
        Object objY2;
        Object objY3;
        String str;
        String strV;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        b[] bVarArr = IconComponent.$childSerializers;
        int i5 = 9;
        String strV2 = null;
        if (cVarD.w()) {
            String strV3 = cVarD.v(descriptor2, 0);
            strV = cVarD.v(descriptor2, 1);
            Object objM6 = cVarD.m(descriptor2, 2, IconComponent$Formats$$serializer.INSTANCE, null);
            objY3 = cVarD.y(descriptor2, 3, C0335h.f929a, null);
            Object objM7 = cVarD.m(descriptor2, 4, Size$$serializer.INSTANCE, null);
            objY2 = cVarD.y(descriptor2, 5, ColorScheme$$serializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            Object objM8 = cVarD.m(descriptor2, 6, padding$$serializer, null);
            objM5 = cVarD.m(descriptor2, 7, padding$$serializer, null);
            objY = cVarD.y(descriptor2, 8, IconComponent$IconBackground$$serializer.INSTANCE, null);
            objM4 = cVarD.m(descriptor2, 9, bVarArr[9], null);
            i4 = 1023;
            objM3 = objM6;
            objM2 = objM7;
            objM = objM8;
            str = strV3;
        } else {
            boolean z4 = true;
            int i6 = 0;
            Object objM9 = null;
            Object objY4 = null;
            Object objM10 = null;
            Object objY5 = null;
            objM = null;
            objM2 = null;
            Object objY6 = null;
            objM3 = null;
            String strV4 = null;
            while (z4) {
                int i7 = cVarD.i(descriptor2);
                switch (i7) {
                    case -1:
                        z4 = false;
                        break;
                    case 0:
                        i6 |= 1;
                        strV2 = cVarD.v(descriptor2, 0);
                        i5 = 9;
                        break;
                    case 1:
                        strV4 = cVarD.v(descriptor2, 1);
                        i6 |= 2;
                        i5 = 9;
                        break;
                    case 2:
                        objM3 = cVarD.m(descriptor2, 2, IconComponent$Formats$$serializer.INSTANCE, objM3);
                        i6 |= 4;
                        i5 = 9;
                        break;
                    case 3:
                        objY6 = cVarD.y(descriptor2, 3, C0335h.f929a, objY6);
                        i6 |= 8;
                        i5 = 9;
                        break;
                    case 4:
                        objM2 = cVarD.m(descriptor2, 4, Size$$serializer.INSTANCE, objM2);
                        i6 |= 16;
                        i5 = 9;
                        break;
                    case 5:
                        objY5 = cVarD.y(descriptor2, 5, ColorScheme$$serializer.INSTANCE, objY5);
                        i6 |= 32;
                        i5 = 9;
                        break;
                    case 6:
                        objM = cVarD.m(descriptor2, 6, Padding$$serializer.INSTANCE, objM);
                        i6 |= 64;
                        i5 = 9;
                        break;
                    case 7:
                        objM10 = cVarD.m(descriptor2, 7, Padding$$serializer.INSTANCE, objM10);
                        i6 |= UserMetadata.MAX_ROLLOUT_ASSIGNMENTS;
                        i5 = 9;
                        break;
                    case 8:
                        objY4 = cVarD.y(descriptor2, 8, IconComponent$IconBackground$$serializer.INSTANCE, objY4);
                        i6 |= 256;
                        i5 = 9;
                        break;
                    case 9:
                        objM9 = cVarD.m(descriptor2, i5, bVarArr[i5], objM9);
                        i6 |= 512;
                        break;
                    default:
                        throw new j(i7);
                }
            }
            i4 = i6;
            objM4 = objM9;
            objY = objY4;
            objM5 = objM10;
            objY2 = objY5;
            objY3 = objY6;
            str = strV2;
            strV = strV4;
        }
        cVarD.c(descriptor2);
        return new IconComponent(i4, str, strV, (IconComponent.Formats) objM3, (Boolean) objY3, (Size) objM2, (ColorScheme) objY2, (Padding) objM, (Padding) objM5, (IconComponent.IconBackground) objY, (List) objM4, (k0) null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, IconComponent value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        IconComponent.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
