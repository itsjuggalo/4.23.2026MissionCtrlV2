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
import java.util.List;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class StackComponent$$serializer implements C {
    public static final StackComponent$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        StackComponent$$serializer stackComponent$$serializer = new StackComponent$$serializer();
        INSTANCE = stackComponent$$serializer;
        C0327b0 c0327b0 = new C0327b0("stack", stackComponent$$serializer, 15);
        c0327b0.l("components", false);
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
        c0327b0.l("overrides", true);
        descriptor = c0327b0;
    }

    private StackComponent$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        b[] bVarArr = StackComponent.$childSerializers;
        b bVar = bVarArr[0];
        b bVarP = a.p(C0335h.f929a);
        b bVar2 = bVarArr[2];
        b bVarP2 = a.p(B.f862a);
        b bVarP3 = a.p(ColorScheme$$serializer.INSTANCE);
        b bVarP4 = a.p(BackgroundDeserializer.INSTANCE);
        b bVarP5 = a.p(ShapeDeserializer.INSTANCE);
        b bVarP6 = a.p(Border$$serializer.INSTANCE);
        b bVarP7 = a.p(Shadow$$serializer.INSTANCE);
        b bVarP8 = a.p(Badge$$serializer.INSTANCE);
        b bVarP9 = a.p(StackOverflowDeserializer.INSTANCE);
        b bVar3 = bVarArr[14];
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new b[]{bVar, bVarP, bVar2, Size$$serializer.INSTANCE, bVarP2, bVarP3, bVarP4, padding$$serializer, padding$$serializer, bVarP5, bVarP6, bVarP7, bVarP8, bVarP9, bVar3};
    }

    @Override // F3.a
    public StackComponent deserialize(e decoder) {
        int i4;
        Object objM;
        Object obj;
        Object obj2;
        Object obj3;
        Object objY;
        Object objY2;
        Object obj4;
        Object objM2;
        Object objM3;
        Object objY3;
        Object objY4;
        Object obj5;
        Object objY5;
        Object objY6;
        Object objM4;
        Object obj6;
        Object objM5;
        Object obj7;
        Object obj8;
        Object obj9;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        b[] bVarArr = StackComponent.$childSerializers;
        if (cVarD.w()) {
            Object objM6 = cVarD.m(descriptor2, 0, bVarArr[0], null);
            Object objY7 = cVarD.y(descriptor2, 1, C0335h.f929a, null);
            Object objM7 = cVarD.m(descriptor2, 2, bVarArr[2], null);
            objM4 = cVarD.m(descriptor2, 3, Size$$serializer.INSTANCE, null);
            objY6 = cVarD.y(descriptor2, 4, B.f862a, null);
            objY4 = cVarD.y(descriptor2, 5, ColorScheme$$serializer.INSTANCE, null);
            objY3 = cVarD.y(descriptor2, 6, BackgroundDeserializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            objM3 = cVarD.m(descriptor2, 7, padding$$serializer, null);
            objM2 = cVarD.m(descriptor2, 8, padding$$serializer, null);
            objY2 = cVarD.y(descriptor2, 9, ShapeDeserializer.INSTANCE, null);
            objY = cVarD.y(descriptor2, 10, Border$$serializer.INSTANCE, null);
            Object objY8 = cVarD.y(descriptor2, 11, Shadow$$serializer.INSTANCE, null);
            objY5 = cVarD.y(descriptor2, 12, Badge$$serializer.INSTANCE, null);
            Object objY9 = cVarD.y(descriptor2, 13, StackOverflowDeserializer.INSTANCE, null);
            i4 = 32767;
            objM = cVarD.m(descriptor2, 14, bVarArr[14], null);
            obj2 = objM7;
            obj = objY7;
            obj4 = objM6;
            obj5 = objY9;
            obj3 = objY8;
        } else {
            int i5 = 14;
            boolean z4 = true;
            Object objM8 = null;
            Object objM9 = null;
            Object objY10 = null;
            Object objY11 = null;
            Object objM10 = null;
            Object objM11 = null;
            Object objY12 = null;
            Object objY13 = null;
            Object objY14 = null;
            Object objY15 = null;
            Object objY16 = null;
            Object objY17 = null;
            Object obj10 = null;
            int i6 = 2;
            i4 = 0;
            Object objY18 = null;
            Object objM12 = null;
            while (z4) {
                int i7 = i5;
                int i8 = cVarD.i(descriptor2);
                switch (i8) {
                    case -1:
                        obj6 = objM8;
                        objM5 = obj10;
                        obj7 = objY18;
                        z4 = false;
                        objY18 = obj7;
                        i5 = 14;
                        i6 = 2;
                        obj10 = objM5;
                        objM8 = obj6;
                        break;
                    case 0:
                        obj6 = objM8;
                        Object obj11 = objY18;
                        b bVar = bVarArr[0];
                        Object obj12 = obj10;
                        obj7 = obj11;
                        objM5 = cVarD.m(descriptor2, 0, bVar, obj12);
                        i4 |= 1;
                        objY18 = obj7;
                        i5 = 14;
                        i6 = 2;
                        obj10 = objM5;
                        objM8 = obj6;
                        break;
                    case 1:
                        i4 |= 2;
                        objY18 = cVarD.y(descriptor2, 1, C0335h.f929a, objY18);
                        objM8 = objM8;
                        objY16 = objY16;
                        i5 = 14;
                        i6 = 2;
                        break;
                    case 2:
                        obj8 = objY18;
                        obj9 = objM8;
                        objM9 = cVarD.m(descriptor2, i6, bVarArr[i6], objM9);
                        i4 |= 4;
                        objM8 = obj9;
                        objY18 = obj8;
                        i5 = 14;
                        break;
                    case 3:
                        obj8 = objY18;
                        obj9 = objM8;
                        objM12 = cVarD.m(descriptor2, 3, Size$$serializer.INSTANCE, objM12);
                        i4 |= 8;
                        objM8 = obj9;
                        objY18 = obj8;
                        i5 = 14;
                        break;
                    case 4:
                        obj8 = objY18;
                        obj9 = objM8;
                        objY13 = cVarD.y(descriptor2, 4, B.f862a, objY13);
                        i4 |= 16;
                        objM8 = obj9;
                        objY18 = obj8;
                        i5 = 14;
                        break;
                    case 5:
                        obj8 = objY18;
                        obj9 = objM8;
                        objY15 = cVarD.y(descriptor2, 5, ColorScheme$$serializer.INSTANCE, objY15);
                        i4 |= 32;
                        objM8 = obj9;
                        objY18 = obj8;
                        i5 = 14;
                        break;
                    case 6:
                        obj8 = objY18;
                        obj9 = objM8;
                        objY12 = cVarD.y(descriptor2, 6, BackgroundDeserializer.INSTANCE, objY12);
                        i4 |= 64;
                        objM8 = obj9;
                        objY18 = obj8;
                        i5 = 14;
                        break;
                    case 7:
                        obj8 = objY18;
                        obj9 = objM8;
                        objM11 = cVarD.m(descriptor2, 7, Padding$$serializer.INSTANCE, objM11);
                        i4 |= UserMetadata.MAX_ROLLOUT_ASSIGNMENTS;
                        objM8 = obj9;
                        objY18 = obj8;
                        i5 = 14;
                        break;
                    case 8:
                        obj8 = objY18;
                        obj9 = objM8;
                        objM10 = cVarD.m(descriptor2, 8, Padding$$serializer.INSTANCE, objM10);
                        i4 |= 256;
                        objM8 = obj9;
                        objY18 = obj8;
                        i5 = 14;
                        break;
                    case 9:
                        obj8 = objY18;
                        obj9 = objM8;
                        objY14 = cVarD.y(descriptor2, 9, ShapeDeserializer.INSTANCE, objY14);
                        i4 |= 512;
                        objM8 = obj9;
                        objY18 = obj8;
                        i5 = 14;
                        break;
                    case 10:
                        obj8 = objY18;
                        obj9 = objM8;
                        objY11 = cVarD.y(descriptor2, 10, Border$$serializer.INSTANCE, objY11);
                        i4 |= UserMetadata.MAX_ATTRIBUTE_SIZE;
                        objM8 = obj9;
                        objY18 = obj8;
                        i5 = 14;
                        break;
                    case 11:
                        obj8 = objY18;
                        obj9 = objM8;
                        objY10 = cVarD.y(descriptor2, 11, Shadow$$serializer.INSTANCE, objY10);
                        i4 |= 2048;
                        objM8 = obj9;
                        objY18 = obj8;
                        i5 = 14;
                        break;
                    case 12:
                        obj8 = objY18;
                        objY16 = cVarD.y(descriptor2, 12, Badge$$serializer.INSTANCE, objY16);
                        i4 |= 4096;
                        objM8 = objM8;
                        objY17 = objY17;
                        objY18 = obj8;
                        i5 = 14;
                        break;
                    case 13:
                        obj8 = objY18;
                        obj9 = objM8;
                        objY17 = cVarD.y(descriptor2, 13, StackOverflowDeserializer.INSTANCE, objY17);
                        i4 |= UserMetadata.MAX_INTERNAL_KEY_SIZE;
                        objM8 = obj9;
                        objY18 = obj8;
                        i5 = 14;
                        break;
                    case 14:
                        objM8 = cVarD.m(descriptor2, i7, bVarArr[i7], objM8);
                        i4 |= 16384;
                        i5 = i7;
                        objY18 = objY18;
                        break;
                    default:
                        throw new j(i8);
                }
            }
            objM = objM8;
            Object obj13 = obj10;
            obj = objY18;
            obj2 = objM9;
            obj3 = objY10;
            objY = objY11;
            objY2 = objY14;
            obj4 = obj13;
            objM2 = objM10;
            objM3 = objM11;
            objY3 = objY12;
            objY4 = objY15;
            obj5 = objY17;
            objY5 = objY16;
            objY6 = objY13;
            objM4 = objM12;
        }
        int i9 = i4;
        cVarD.c(descriptor2);
        return new StackComponent(i9, (List) obj4, (Boolean) obj, (Dimension) obj2, (Size) objM4, (Float) objY6, (ColorScheme) objY4, (Background) objY3, (Padding) objM3, (Padding) objM2, (Shape) objY2, (Border) objY, (Shadow) obj3, (Badge) objY5, (StackComponent.Overflow) obj5, (List) objM, (k0) null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, StackComponent value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        StackComponent.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
