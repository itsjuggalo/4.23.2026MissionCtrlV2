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
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class PartialIconComponent$$serializer implements C {
    public static final PartialIconComponent$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        PartialIconComponent$$serializer partialIconComponent$$serializer = new PartialIconComponent$$serializer();
        INSTANCE = partialIconComponent$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.components.PartialIconComponent", partialIconComponent$$serializer, 9);
        c0327b0.l("visible", true);
        c0327b0.l("base_url", true);
        c0327b0.l("icon_name", true);
        c0327b0.l("formats", true);
        c0327b0.l("size", true);
        c0327b0.l("color", true);
        c0327b0.l("padding", true);
        c0327b0.l("margin", true);
        c0327b0.l("icon_background", true);
        descriptor = c0327b0;
    }

    private PartialIconComponent$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        b bVarP = a.p(C0335h.f929a);
        o0 o0Var = o0.f952a;
        b bVarP2 = a.p(o0Var);
        b bVarP3 = a.p(o0Var);
        b bVarP4 = a.p(IconComponent$Formats$$serializer.INSTANCE);
        b bVarP5 = a.p(Size$$serializer.INSTANCE);
        b bVarP6 = a.p(ColorScheme$$serializer.INSTANCE);
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new b[]{bVarP, bVarP2, bVarP3, bVarP4, bVarP5, bVarP6, a.p(padding$$serializer), a.p(padding$$serializer), a.p(IconComponent$IconBackground$$serializer.INSTANCE)};
    }

    @Override // F3.a
    public PartialIconComponent deserialize(e decoder) {
        int i4;
        Object objY;
        Object objY2;
        Object objY3;
        Object objY4;
        Object objY5;
        Object objY6;
        Object objY7;
        Object objY8;
        Object objY9;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        int i5 = 7;
        Object objY10 = null;
        if (cVarD.w()) {
            objY = cVarD.y(descriptor2, 0, C0335h.f929a, null);
            o0 o0Var = o0.f952a;
            objY7 = cVarD.y(descriptor2, 1, o0Var, null);
            objY8 = cVarD.y(descriptor2, 2, o0Var, null);
            objY9 = cVarD.y(descriptor2, 3, IconComponent$Formats$$serializer.INSTANCE, null);
            objY6 = cVarD.y(descriptor2, 4, Size$$serializer.INSTANCE, null);
            objY5 = cVarD.y(descriptor2, 5, ColorScheme$$serializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            objY4 = cVarD.y(descriptor2, 6, padding$$serializer, null);
            objY2 = cVarD.y(descriptor2, 7, padding$$serializer, null);
            objY3 = cVarD.y(descriptor2, 8, IconComponent$IconBackground$$serializer.INSTANCE, null);
            i4 = 511;
        } else {
            boolean z4 = true;
            int i6 = 0;
            Object objY11 = null;
            Object objY12 = null;
            Object objY13 = null;
            Object objY14 = null;
            Object objY15 = null;
            Object objY16 = null;
            Object objY17 = null;
            Object objY18 = null;
            while (z4) {
                int i7 = cVarD.i(descriptor2);
                switch (i7) {
                    case -1:
                        z4 = false;
                        i5 = 7;
                        break;
                    case 0:
                        objY10 = cVarD.y(descriptor2, 0, C0335h.f929a, objY10);
                        i6 |= 1;
                        i5 = 7;
                        break;
                    case 1:
                        objY16 = cVarD.y(descriptor2, 1, o0.f952a, objY16);
                        i6 |= 2;
                        i5 = 7;
                        break;
                    case 2:
                        objY17 = cVarD.y(descriptor2, 2, o0.f952a, objY17);
                        i6 |= 4;
                        i5 = 7;
                        break;
                    case 3:
                        objY18 = cVarD.y(descriptor2, 3, IconComponent$Formats$$serializer.INSTANCE, objY18);
                        i6 |= 8;
                        i5 = 7;
                        break;
                    case 4:
                        objY15 = cVarD.y(descriptor2, 4, Size$$serializer.INSTANCE, objY15);
                        i6 |= 16;
                        i5 = 7;
                        break;
                    case 5:
                        objY14 = cVarD.y(descriptor2, 5, ColorScheme$$serializer.INSTANCE, objY14);
                        i6 |= 32;
                        i5 = 7;
                        break;
                    case 6:
                        objY13 = cVarD.y(descriptor2, 6, Padding$$serializer.INSTANCE, objY13);
                        i6 |= 64;
                        break;
                    case 7:
                        objY11 = cVarD.y(descriptor2, i5, Padding$$serializer.INSTANCE, objY11);
                        i6 |= UserMetadata.MAX_ROLLOUT_ASSIGNMENTS;
                        break;
                    case 8:
                        objY12 = cVarD.y(descriptor2, 8, IconComponent$IconBackground$$serializer.INSTANCE, objY12);
                        i6 |= 256;
                        break;
                    default:
                        throw new j(i7);
                }
            }
            Object obj = objY10;
            i4 = i6;
            objY = obj;
            objY2 = objY11;
            objY3 = objY12;
            objY4 = objY13;
            objY5 = objY14;
            objY6 = objY15;
            objY7 = objY16;
            objY8 = objY17;
            objY9 = objY18;
        }
        cVarD.c(descriptor2);
        return new PartialIconComponent(i4, (Boolean) objY, (String) objY7, (String) objY8, (IconComponent.Formats) objY9, (Size) objY6, (ColorScheme) objY5, (Padding) objY4, (Padding) objY2, (IconComponent.IconBackground) objY3, (k0) null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, PartialIconComponent value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        PartialIconComponent.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
