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
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.BackgroundDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.Border$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shadow$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.ShapeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class PartialTabsComponent$$serializer implements C {
    public static final PartialTabsComponent$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        PartialTabsComponent$$serializer partialTabsComponent$$serializer = new PartialTabsComponent$$serializer();
        INSTANCE = partialTabsComponent$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.components.PartialTabsComponent", partialTabsComponent$$serializer, 9);
        c0327b0.l("visible", true);
        c0327b0.l("size", true);
        c0327b0.l("padding", true);
        c0327b0.l("margin", true);
        c0327b0.l("background_color", true);
        c0327b0.l("background", true);
        c0327b0.l("shape", true);
        c0327b0.l("border", true);
        c0327b0.l("shadow", true);
        descriptor = c0327b0;
    }

    private PartialTabsComponent$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        b bVarP = a.p(C0335h.f929a);
        b bVarP2 = a.p(Size$$serializer.INSTANCE);
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new b[]{bVarP, bVarP2, a.p(padding$$serializer), a.p(padding$$serializer), a.p(ColorScheme$$serializer.INSTANCE), a.p(BackgroundDeserializer.INSTANCE), a.p(ShapeDeserializer.INSTANCE), a.p(Border$$serializer.INSTANCE), a.p(Shadow$$serializer.INSTANCE)};
    }

    @Override // F3.a
    public PartialTabsComponent deserialize(e decoder) {
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
            objY7 = cVarD.y(descriptor2, 1, Size$$serializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            objY8 = cVarD.y(descriptor2, 2, padding$$serializer, null);
            objY9 = cVarD.y(descriptor2, 3, padding$$serializer, null);
            objY6 = cVarD.y(descriptor2, 4, ColorScheme$$serializer.INSTANCE, null);
            objY5 = cVarD.y(descriptor2, 5, BackgroundDeserializer.INSTANCE, null);
            objY4 = cVarD.y(descriptor2, 6, ShapeDeserializer.INSTANCE, null);
            objY2 = cVarD.y(descriptor2, 7, Border$$serializer.INSTANCE, null);
            objY3 = cVarD.y(descriptor2, 8, Shadow$$serializer.INSTANCE, null);
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
                        objY16 = cVarD.y(descriptor2, 1, Size$$serializer.INSTANCE, objY16);
                        i6 |= 2;
                        i5 = 7;
                        break;
                    case 2:
                        objY17 = cVarD.y(descriptor2, 2, Padding$$serializer.INSTANCE, objY17);
                        i6 |= 4;
                        i5 = 7;
                        break;
                    case 3:
                        objY18 = cVarD.y(descriptor2, 3, Padding$$serializer.INSTANCE, objY18);
                        i6 |= 8;
                        i5 = 7;
                        break;
                    case 4:
                        objY15 = cVarD.y(descriptor2, 4, ColorScheme$$serializer.INSTANCE, objY15);
                        i6 |= 16;
                        i5 = 7;
                        break;
                    case 5:
                        objY14 = cVarD.y(descriptor2, 5, BackgroundDeserializer.INSTANCE, objY14);
                        i6 |= 32;
                        i5 = 7;
                        break;
                    case 6:
                        objY13 = cVarD.y(descriptor2, 6, ShapeDeserializer.INSTANCE, objY13);
                        i6 |= 64;
                        break;
                    case 7:
                        objY11 = cVarD.y(descriptor2, i5, Border$$serializer.INSTANCE, objY11);
                        i6 |= UserMetadata.MAX_ROLLOUT_ASSIGNMENTS;
                        break;
                    case 8:
                        objY12 = cVarD.y(descriptor2, 8, Shadow$$serializer.INSTANCE, objY12);
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
        return new PartialTabsComponent(i4, (Boolean) objY, (Size) objY7, (Padding) objY8, (Padding) objY9, (ColorScheme) objY6, (Background) objY5, (Shape) objY4, (Border) objY2, (Shadow) objY3, (k0) null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, PartialTabsComponent value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        PartialTabsComponent.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
