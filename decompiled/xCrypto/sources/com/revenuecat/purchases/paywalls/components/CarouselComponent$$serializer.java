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
import J3.H;
import J3.k0;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.firestore.index.FirestoreIndexValueWriter;
import com.revenuecat.purchases.paywalls.components.CarouselComponent;
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
import com.revenuecat.purchases.paywalls.components.properties.VerticalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.VerticalAlignmentDeserializer;
import java.util.List;
import kotlin.jvm.internal.r;
import p2.C1698D;

/* JADX INFO: loaded from: classes3.dex */
public final class CarouselComponent$$serializer implements C {
    public static final CarouselComponent$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        CarouselComponent$$serializer carouselComponent$$serializer = new CarouselComponent$$serializer();
        INSTANCE = carouselComponent$$serializer;
        C0327b0 c0327b0 = new C0327b0("carousel", carouselComponent$$serializer, 18);
        c0327b0.l("pages", false);
        c0327b0.l("visible", true);
        c0327b0.l("initial_page_index", true);
        c0327b0.l("page_alignment", false);
        c0327b0.l("size", true);
        c0327b0.l("page_peek", true);
        c0327b0.l("page_spacing", true);
        c0327b0.l("background_color", true);
        c0327b0.l("background", true);
        c0327b0.l("padding", true);
        c0327b0.l("margin", true);
        c0327b0.l("shape", true);
        c0327b0.l("border", true);
        c0327b0.l("shadow", true);
        c0327b0.l("page_control", true);
        c0327b0.l("loop", true);
        c0327b0.l("auto_advance", true);
        c0327b0.l("overrides", true);
        descriptor = c0327b0;
    }

    private CarouselComponent$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        b[] bVarArr = CarouselComponent.$childSerializers;
        b bVar = bVarArr[0];
        C0335h c0335h = C0335h.f929a;
        b bVarP = a.p(c0335h);
        H h4 = H.f874a;
        b bVarP2 = a.p(h4);
        b bVarP3 = a.p(h4);
        b bVarP4 = a.p(B.f862a);
        b bVarP5 = a.p(ColorScheme$$serializer.INSTANCE);
        b bVarP6 = a.p(BackgroundDeserializer.INSTANCE);
        b bVarP7 = a.p(ShapeDeserializer.INSTANCE);
        b bVarP8 = a.p(Border$$serializer.INSTANCE);
        b bVarP9 = a.p(Shadow$$serializer.INSTANCE);
        b bVarP10 = a.p(CarouselComponent$PageControl$$serializer.INSTANCE);
        b bVarP11 = a.p(c0335h);
        b bVarP12 = a.p(CarouselComponent$AutoAdvancePages$$serializer.INSTANCE);
        b bVar2 = bVarArr[17];
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new b[]{bVar, bVarP, bVarP2, VerticalAlignmentDeserializer.INSTANCE, Size$$serializer.INSTANCE, bVarP3, bVarP4, bVarP5, bVarP6, padding$$serializer, padding$$serializer, bVarP7, bVarP8, bVarP9, bVarP10, bVarP11, bVarP12, bVar2};
    }

    @Override // F3.a
    public CarouselComponent deserialize(e decoder) {
        Object objM;
        Object objY;
        Object objY2;
        Object obj;
        Object objM2;
        Object obj2;
        Object obj3;
        Object objY3;
        int i4;
        Object obj4;
        Object objY4;
        Object obj5;
        Object obj6;
        Object obj7;
        Object objY5;
        Object objY6;
        Object objY7;
        Object objY8;
        Object objM3;
        Object obj8;
        Object obj9;
        Object obj10;
        Object obj11;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        b[] bVarArr = CarouselComponent.$childSerializers;
        if (cVarD.w()) {
            Object objM4 = cVarD.m(descriptor2, 0, bVarArr[0], null);
            C0335h c0335h = C0335h.f929a;
            Object objY9 = cVarD.y(descriptor2, 1, c0335h, null);
            H h4 = H.f874a;
            objY8 = cVarD.y(descriptor2, 2, h4, null);
            objM3 = cVarD.m(descriptor2, 3, VerticalAlignmentDeserializer.INSTANCE, null);
            Object objM5 = cVarD.m(descriptor2, 4, Size$$serializer.INSTANCE, null);
            objY7 = cVarD.y(descriptor2, 5, h4, null);
            objY4 = cVarD.y(descriptor2, 6, B.f862a, null);
            objY3 = cVarD.y(descriptor2, 7, ColorScheme$$serializer.INSTANCE, null);
            objY = cVarD.y(descriptor2, 8, BackgroundDeserializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            Object objM6 = cVarD.m(descriptor2, 9, padding$$serializer, null);
            Object objM7 = cVarD.m(descriptor2, 10, padding$$serializer, null);
            Object objY10 = cVarD.y(descriptor2, 11, ShapeDeserializer.INSTANCE, null);
            objY6 = cVarD.y(descriptor2, 12, Border$$serializer.INSTANCE, null);
            objY5 = cVarD.y(descriptor2, 13, Shadow$$serializer.INSTANCE, null);
            Object objY11 = cVarD.y(descriptor2, 14, CarouselComponent$PageControl$$serializer.INSTANCE, null);
            Object objY12 = cVarD.y(descriptor2, 15, c0335h, null);
            obj7 = objY11;
            Object objY13 = cVarD.y(descriptor2, 16, CarouselComponent$AutoAdvancePages$$serializer.INSTANCE, null);
            obj = objY9;
            objM2 = cVarD.m(descriptor2, 17, bVarArr[17], null);
            i4 = 262143;
            obj4 = objM6;
            objY2 = objY10;
            obj6 = objY12;
            objM = objM5;
            obj2 = objM4;
            obj5 = objY13;
            obj3 = objM7;
        } else {
            int i5 = 17;
            int i6 = 0;
            int i7 = 1;
            Object objM8 = null;
            Object objY14 = null;
            Object objY15 = null;
            objM = null;
            Object objY16 = null;
            Object objY17 = null;
            Object objM9 = null;
            Object objM10 = null;
            objY = null;
            Object objY18 = null;
            objY2 = null;
            Object objY19 = null;
            Object objY20 = null;
            Object objY21 = null;
            Object objY22 = null;
            Object objY23 = null;
            Object objM11 = null;
            int i8 = 0;
            Object objM12 = null;
            while (i7 != 0) {
                int i9 = i5;
                int i10 = cVarD.i(descriptor2);
                switch (i10) {
                    case -1:
                        obj8 = objY23;
                        obj9 = objM8;
                        i7 = i6;
                        objY16 = objY16;
                        objM12 = objM12;
                        i5 = 17;
                        i6 = i7;
                        objM8 = obj9;
                        objY23 = obj8;
                        break;
                    case 0:
                        obj8 = objY23;
                        obj9 = objM8;
                        int i11 = i6;
                        objM11 = cVarD.m(descriptor2, i11, bVarArr[i6], objM11);
                        i8 |= 1;
                        objY16 = objY16;
                        objM12 = objM12;
                        i5 = 17;
                        i6 = i11;
                        objM8 = obj9;
                        objY23 = obj8;
                        break;
                    case 1:
                        Object obj12 = objM12;
                        i8 |= 2;
                        objM8 = objM8;
                        i5 = 17;
                        objY16 = cVarD.y(descriptor2, 1, C0335h.f929a, objY16);
                        objY23 = objY23;
                        objM12 = obj12;
                        break;
                    case 2:
                        obj10 = objY16;
                        obj8 = objY23;
                        obj11 = objM8;
                        objY17 = cVarD.y(descriptor2, 2, H.f874a, objY17);
                        i8 |= 4;
                        objM8 = obj11;
                        objY16 = obj10;
                        i5 = 17;
                        objY23 = obj8;
                        break;
                    case 3:
                        obj10 = objY16;
                        obj8 = objY23;
                        obj11 = objM8;
                        objM12 = cVarD.m(descriptor2, 3, VerticalAlignmentDeserializer.INSTANCE, objM12);
                        i8 |= 8;
                        objM8 = obj11;
                        objY16 = obj10;
                        i5 = 17;
                        objY23 = obj8;
                        break;
                    case 4:
                        obj10 = objY16;
                        obj8 = objY23;
                        obj11 = objM8;
                        objM = cVarD.m(descriptor2, 4, Size$$serializer.INSTANCE, objM);
                        i8 |= 16;
                        objM8 = obj11;
                        objY16 = obj10;
                        i5 = 17;
                        objY23 = obj8;
                        break;
                    case 5:
                        obj10 = objY16;
                        obj8 = objY23;
                        obj11 = objM8;
                        objY15 = cVarD.y(descriptor2, 5, H.f874a, objY15);
                        i8 |= 32;
                        objM8 = obj11;
                        objY16 = obj10;
                        i5 = 17;
                        objY23 = obj8;
                        break;
                    case 6:
                        obj10 = objY16;
                        obj8 = objY23;
                        obj11 = objM8;
                        objY18 = cVarD.y(descriptor2, 6, B.f862a, objY18);
                        i8 |= 64;
                        objM8 = obj11;
                        objY16 = obj10;
                        i5 = 17;
                        objY23 = obj8;
                        break;
                    case 7:
                        obj10 = objY16;
                        obj8 = objY23;
                        obj11 = objM8;
                        objY14 = cVarD.y(descriptor2, 7, ColorScheme$$serializer.INSTANCE, objY14);
                        i8 |= UserMetadata.MAX_ROLLOUT_ASSIGNMENTS;
                        objM8 = obj11;
                        objY16 = obj10;
                        i5 = 17;
                        objY23 = obj8;
                        break;
                    case 8:
                        obj10 = objY16;
                        obj8 = objY23;
                        obj11 = objM8;
                        objY = cVarD.y(descriptor2, 8, BackgroundDeserializer.INSTANCE, objY);
                        i8 |= 256;
                        objM8 = obj11;
                        objY16 = obj10;
                        i5 = 17;
                        objY23 = obj8;
                        break;
                    case 9:
                        obj10 = objY16;
                        obj8 = objY23;
                        obj11 = objM8;
                        objM10 = cVarD.m(descriptor2, 9, Padding$$serializer.INSTANCE, objM10);
                        i8 |= 512;
                        objM8 = obj11;
                        objY16 = obj10;
                        i5 = 17;
                        objY23 = obj8;
                        break;
                    case 10:
                        obj10 = objY16;
                        obj8 = objY23;
                        obj11 = objM8;
                        objM9 = cVarD.m(descriptor2, 10, Padding$$serializer.INSTANCE, objM9);
                        i8 |= UserMetadata.MAX_ATTRIBUTE_SIZE;
                        objM8 = obj11;
                        objY16 = obj10;
                        i5 = 17;
                        objY23 = obj8;
                        break;
                    case 11:
                        obj10 = objY16;
                        obj8 = objY23;
                        obj11 = objM8;
                        objY2 = cVarD.y(descriptor2, 11, ShapeDeserializer.INSTANCE, objY2);
                        i8 |= 2048;
                        objM8 = obj11;
                        objY16 = obj10;
                        i5 = 17;
                        objY23 = obj8;
                        break;
                    case 12:
                        obj10 = objY16;
                        obj8 = objY23;
                        obj11 = objM8;
                        objY19 = cVarD.y(descriptor2, 12, Border$$serializer.INSTANCE, objY19);
                        i8 |= 4096;
                        objY20 = objY20;
                        objM8 = obj11;
                        objY16 = obj10;
                        i5 = 17;
                        objY23 = obj8;
                        break;
                    case 13:
                        obj10 = objY16;
                        obj8 = objY23;
                        obj11 = objM8;
                        objY20 = cVarD.y(descriptor2, 13, Shadow$$serializer.INSTANCE, objY20);
                        i8 |= UserMetadata.MAX_INTERNAL_KEY_SIZE;
                        objY21 = objY21;
                        objM8 = obj11;
                        objY16 = obj10;
                        i5 = 17;
                        objY23 = obj8;
                        break;
                    case 14:
                        obj10 = objY16;
                        obj8 = objY23;
                        obj11 = objM8;
                        objY21 = cVarD.y(descriptor2, 14, CarouselComponent$PageControl$$serializer.INSTANCE, objY21);
                        i8 |= 16384;
                        objY22 = objY22;
                        objM8 = obj11;
                        objY16 = obj10;
                        i5 = 17;
                        objY23 = obj8;
                        break;
                    case FirestoreIndexValueWriter.INDEX_TYPE_NUMBER /* 15 */:
                        obj10 = objY16;
                        Object obj13 = objY23;
                        obj11 = objM8;
                        obj8 = obj13;
                        objY22 = cVarD.y(descriptor2, 15, C0335h.f929a, objY22);
                        i8 |= 32768;
                        objM8 = obj11;
                        objY16 = obj10;
                        i5 = 17;
                        objY23 = obj8;
                        break;
                    case 16:
                        i8 |= 65536;
                        objM8 = objM8;
                        objY16 = objY16;
                        objY23 = cVarD.y(descriptor2, 16, CarouselComponent$AutoAdvancePages$$serializer.INSTANCE, objY23);
                        i5 = 17;
                        break;
                    case C1698D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                        objM8 = cVarD.m(descriptor2, i9, bVarArr[i9], objM8);
                        i8 |= 131072;
                        i5 = i9;
                        objY16 = objY16;
                        break;
                    default:
                        throw new j(i10);
                }
            }
            Object obj14 = objM12;
            obj = objY16;
            Object obj15 = objY23;
            objM2 = objM8;
            Object obj16 = objY14;
            obj2 = objM11;
            obj3 = objM9;
            objY3 = obj16;
            i4 = i8;
            obj4 = objM10;
            objY4 = objY18;
            obj5 = obj15;
            obj6 = objY22;
            obj7 = objY21;
            objY5 = objY20;
            objY6 = objY19;
            objY7 = objY15;
            objY8 = objY17;
            objM3 = obj14;
        }
        cVarD.c(descriptor2);
        return new CarouselComponent(i4, (List) obj2, (Boolean) obj, (Integer) objY8, (VerticalAlignment) objM3, (Size) objM, (Integer) objY7, (Float) objY4, (ColorScheme) objY3, (Background) objY, (Padding) obj4, (Padding) obj3, (Shape) objY2, (Border) objY6, (Shadow) objY5, (CarouselComponent.PageControl) obj7, (Boolean) obj6, (CarouselComponent.AutoAdvancePages) obj5, (List) objM2, (k0) null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, CarouselComponent value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        CarouselComponent.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
