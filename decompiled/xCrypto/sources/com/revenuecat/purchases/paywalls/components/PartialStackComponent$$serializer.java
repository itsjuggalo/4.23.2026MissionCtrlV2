package com.revenuecat.purchases.paywalls.components;

import F3.b;
import F3.j;
import G3.a;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.B;
import J3.C;
import J3.C0327b0;
import J3.C0335h;
import J3.k0;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.BackgroundDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Badge;
import com.revenuecat.purchases.paywalls.components.properties.Badge$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.Border$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
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
public final class PartialStackComponent$$serializer implements C {
    public static final PartialStackComponent$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        PartialStackComponent$$serializer partialStackComponent$$serializer = new PartialStackComponent$$serializer();
        INSTANCE = partialStackComponent$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.components.PartialStackComponent", partialStackComponent$$serializer, 13);
        c0327b0.l("visible", true);
        c0327b0.l("dimension", true);
        c0327b0.l("size", true);
        c0327b0.l("spacing", true);
        c0327b0.l("background_color", true);
        c0327b0.l("background", true);
        c0327b0.l("padding", true);
        c0327b0.l("margin", true);
        c0327b0.l("shape", true);
        c0327b0.l("border", true);
        c0327b0.l("shadow", true);
        c0327b0.l("badge", true);
        c0327b0.l("overflow", true);
        descriptor = c0327b0;
    }

    private PartialStackComponent$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        b[] bVarArr = PartialStackComponent.$childSerializers;
        b bVarP = a.p(C0335h.f929a);
        b bVarP2 = a.p(bVarArr[1]);
        b bVarP3 = a.p(Size$$serializer.INSTANCE);
        b bVarP4 = a.p(B.f862a);
        b bVarP5 = a.p(ColorScheme$$serializer.INSTANCE);
        b bVarP6 = a.p(BackgroundDeserializer.INSTANCE);
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new b[]{bVarP, bVarP2, bVarP3, bVarP4, bVarP5, bVarP6, a.p(padding$$serializer), a.p(padding$$serializer), a.p(ShapeDeserializer.INSTANCE), a.p(Border$$serializer.INSTANCE), a.p(Shadow$$serializer.INSTANCE), a.p(Badge$$serializer.INSTANCE), a.p(StackOverflowDeserializer.INSTANCE)};
    }

    @Override // F3.a
    public PartialStackComponent deserialize(e decoder) {
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
        Object objY10;
        Object objY11;
        Object obj;
        Object objY12;
        Object obj2;
        Object obj3;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        b[] bVarArr = PartialStackComponent.$childSerializers;
        if (cVarD.w()) {
            objY = cVarD.y(descriptor2, 0, C0335h.f929a, null);
            objY12 = cVarD.y(descriptor2, 1, bVarArr[1], null);
            Object objY13 = cVarD.y(descriptor2, 2, Size$$serializer.INSTANCE, null);
            objY11 = cVarD.y(descriptor2, 3, B.f862a, null);
            objY10 = cVarD.y(descriptor2, 4, ColorScheme$$serializer.INSTANCE, null);
            objY9 = cVarD.y(descriptor2, 5, BackgroundDeserializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            objY8 = cVarD.y(descriptor2, 6, padding$$serializer, null);
            objY7 = cVarD.y(descriptor2, 7, padding$$serializer, null);
            objY6 = cVarD.y(descriptor2, 8, ShapeDeserializer.INSTANCE, null);
            objY5 = cVarD.y(descriptor2, 9, Border$$serializer.INSTANCE, null);
            objY4 = cVarD.y(descriptor2, 10, Shadow$$serializer.INSTANCE, null);
            objY3 = cVarD.y(descriptor2, 11, Badge$$serializer.INSTANCE, null);
            i4 = 8191;
            objY2 = cVarD.y(descriptor2, 12, StackOverflowDeserializer.INSTANCE, null);
            obj = objY13;
        } else {
            Object objY14 = null;
            Object objY15 = null;
            Object objY16 = null;
            Object objY17 = null;
            Object objY18 = null;
            Object objY19 = null;
            Object objY20 = null;
            Object objY21 = null;
            Object objY22 = null;
            Object objY23 = null;
            Object objY24 = null;
            int i5 = 1;
            boolean z4 = true;
            i4 = 0;
            Object objY25 = null;
            Object objY26 = null;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                switch (i6) {
                    case -1:
                        obj2 = objY14;
                        objY24 = objY24;
                        objY25 = objY25;
                        z4 = false;
                        objY14 = obj2;
                        i5 = 1;
                        break;
                    case 0:
                        obj2 = objY14;
                        i4 |= 1;
                        objY24 = cVarD.y(descriptor2, 0, C0335h.f929a, objY24);
                        objY25 = objY25;
                        objY14 = obj2;
                        i5 = 1;
                        break;
                    case 1:
                        Object obj4 = objY25;
                        int i7 = i5;
                        i4 |= 2;
                        objY25 = cVarD.y(descriptor2, i7, bVarArr[i5], obj4);
                        objY14 = objY14;
                        i5 = i7;
                        break;
                    case 2:
                        obj3 = objY25;
                        objY26 = cVarD.y(descriptor2, 2, Size$$serializer.INSTANCE, objY26);
                        i4 |= 4;
                        objY25 = obj3;
                        break;
                    case 3:
                        obj3 = objY25;
                        objY23 = cVarD.y(descriptor2, 3, B.f862a, objY23);
                        i4 |= 8;
                        objY25 = obj3;
                        break;
                    case 4:
                        obj3 = objY25;
                        objY20 = cVarD.y(descriptor2, 4, ColorScheme$$serializer.INSTANCE, objY20);
                        i4 |= 16;
                        objY25 = obj3;
                        break;
                    case 5:
                        obj3 = objY25;
                        objY22 = cVarD.y(descriptor2, 5, BackgroundDeserializer.INSTANCE, objY22);
                        i4 |= 32;
                        objY25 = obj3;
                        break;
                    case 6:
                        obj3 = objY25;
                        objY19 = cVarD.y(descriptor2, 6, Padding$$serializer.INSTANCE, objY19);
                        i4 |= 64;
                        objY25 = obj3;
                        break;
                    case 7:
                        obj3 = objY25;
                        objY18 = cVarD.y(descriptor2, 7, Padding$$serializer.INSTANCE, objY18);
                        i4 |= UserMetadata.MAX_ROLLOUT_ASSIGNMENTS;
                        objY25 = obj3;
                        break;
                    case 8:
                        obj3 = objY25;
                        objY17 = cVarD.y(descriptor2, 8, ShapeDeserializer.INSTANCE, objY17);
                        i4 |= 256;
                        objY25 = obj3;
                        break;
                    case 9:
                        obj3 = objY25;
                        objY21 = cVarD.y(descriptor2, 9, Border$$serializer.INSTANCE, objY21);
                        i4 |= 512;
                        objY25 = obj3;
                        break;
                    case 10:
                        obj3 = objY25;
                        objY16 = cVarD.y(descriptor2, 10, Shadow$$serializer.INSTANCE, objY16);
                        i4 |= UserMetadata.MAX_ATTRIBUTE_SIZE;
                        objY25 = obj3;
                        break;
                    case 11:
                        obj3 = objY25;
                        objY15 = cVarD.y(descriptor2, 11, Badge$$serializer.INSTANCE, objY15);
                        i4 |= 2048;
                        objY25 = obj3;
                        break;
                    case 12:
                        objY14 = cVarD.y(descriptor2, 12, StackOverflowDeserializer.INSTANCE, objY14);
                        i4 |= 4096;
                        objY25 = objY25;
                        break;
                    default:
                        throw new j(i6);
                }
            }
            Object obj5 = objY24;
            Object obj6 = objY25;
            objY = obj5;
            objY2 = objY14;
            Object obj7 = objY23;
            objY3 = objY15;
            objY4 = objY16;
            objY5 = objY21;
            objY6 = objY17;
            objY7 = objY18;
            objY8 = objY19;
            objY9 = objY22;
            objY10 = objY20;
            objY11 = obj7;
            obj = objY26;
            objY12 = obj6;
        }
        int i8 = i4;
        cVarD.c(descriptor2);
        return new PartialStackComponent(i8, (Boolean) objY, (Dimension) objY12, (Size) obj, (Float) objY11, (ColorScheme) objY10, (Background) objY9, (Padding) objY8, (Padding) objY7, (Shape) objY6, (Border) objY5, (Shadow) objY4, (Badge) objY3, (StackComponent.Overflow) objY2, (k0) null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, PartialStackComponent value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        PartialStackComponent.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
