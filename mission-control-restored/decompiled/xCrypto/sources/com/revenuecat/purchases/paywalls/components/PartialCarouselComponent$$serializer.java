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
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class PartialCarouselComponent$$serializer implements C {
    public static final PartialCarouselComponent$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        PartialCarouselComponent$$serializer partialCarouselComponent$$serializer = new PartialCarouselComponent$$serializer();
        INSTANCE = partialCarouselComponent$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.components.PartialCarouselComponent", partialCarouselComponent$$serializer, 16);
        c0327b0.l("visible", true);
        c0327b0.l("initial_page_index", true);
        c0327b0.l("page_alignment", true);
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
        descriptor = c0327b0;
    }

    private PartialCarouselComponent$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        C0335h c0335h = C0335h.f929a;
        b bVarP = a.p(c0335h);
        H h4 = H.f874a;
        b bVarP2 = a.p(h4);
        b bVarP3 = a.p(VerticalAlignmentDeserializer.INSTANCE);
        b bVarP4 = a.p(Size$$serializer.INSTANCE);
        b bVarP5 = a.p(h4);
        b bVarP6 = a.p(B.f862a);
        b bVarP7 = a.p(ColorScheme$$serializer.INSTANCE);
        b bVarP8 = a.p(BackgroundDeserializer.INSTANCE);
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new b[]{bVarP, bVarP2, bVarP3, bVarP4, bVarP5, bVarP6, bVarP7, bVarP8, a.p(padding$$serializer), a.p(padding$$serializer), a.p(ShapeDeserializer.INSTANCE), a.p(Border$$serializer.INSTANCE), a.p(Shadow$$serializer.INSTANCE), a.p(CarouselComponent$PageControl$$serializer.INSTANCE), a.p(c0335h), a.p(CarouselComponent$AutoAdvancePages$$serializer.INSTANCE)};
    }

    @Override // F3.a
    public PartialCarouselComponent deserialize(e decoder) {
        int i4;
        Object objY;
        Object obj;
        Object objY2;
        Object obj2;
        Object objY3;
        Object obj3;
        Object objY4;
        Object objY5;
        Object objY6;
        Object objY7;
        Object objY8;
        Object objY9;
        Object objY10;
        Object obj4;
        Object objY11;
        Object objY12;
        Object obj5;
        Object obj6;
        Object objY13;
        Object obj7;
        Object obj8;
        Object obj9;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        if (cVarD.w()) {
            C0335h c0335h = C0335h.f929a;
            Object objY14 = cVarD.y(descriptor2, 0, c0335h, null);
            H h4 = H.f874a;
            Object objY15 = cVarD.y(descriptor2, 1, h4, null);
            Object objY16 = cVarD.y(descriptor2, 2, VerticalAlignmentDeserializer.INSTANCE, null);
            objY2 = cVarD.y(descriptor2, 3, Size$$serializer.INSTANCE, null);
            objY4 = cVarD.y(descriptor2, 4, h4, null);
            objY8 = cVarD.y(descriptor2, 5, B.f862a, null);
            objY12 = cVarD.y(descriptor2, 6, ColorScheme$$serializer.INSTANCE, null);
            objY7 = cVarD.y(descriptor2, 7, BackgroundDeserializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            objY11 = cVarD.y(descriptor2, 8, padding$$serializer, null);
            objY6 = cVarD.y(descriptor2, 9, padding$$serializer, null);
            objY9 = cVarD.y(descriptor2, 10, ShapeDeserializer.INSTANCE, null);
            objY5 = cVarD.y(descriptor2, 11, Border$$serializer.INSTANCE, null);
            objY3 = cVarD.y(descriptor2, 12, Shadow$$serializer.INSTANCE, null);
            Object objY17 = cVarD.y(descriptor2, 13, CarouselComponent$PageControl$$serializer.INSTANCE, null);
            objY10 = cVarD.y(descriptor2, 14, c0335h, null);
            i4 = 65535;
            objY = cVarD.y(descriptor2, 15, CarouselComponent$AutoAdvancePages$$serializer.INSTANCE, null);
            obj3 = objY14;
            obj = objY15;
            obj2 = objY17;
            obj4 = objY16;
        } else {
            boolean z4 = true;
            Object objY18 = null;
            Object objY19 = null;
            Object objY20 = null;
            Object objY21 = null;
            Object objY22 = null;
            Object objY23 = null;
            Object objY24 = null;
            Object objY25 = null;
            Object objY26 = null;
            Object objY27 = null;
            Object objY28 = null;
            Object objY29 = null;
            Object objY30 = null;
            Object objY31 = null;
            Object obj10 = null;
            i4 = 0;
            Object objY32 = null;
            while (z4) {
                int i5 = cVarD.i(descriptor2);
                switch (i5) {
                    case -1:
                        obj5 = objY32;
                        obj6 = objY20;
                        objY13 = obj10;
                        obj7 = objY21;
                        z4 = false;
                        objY20 = obj6;
                        objY21 = obj7;
                        obj10 = objY13;
                        objY32 = obj5;
                        break;
                    case 0:
                        obj5 = objY32;
                        obj6 = objY20;
                        Object obj11 = obj10;
                        obj7 = objY21;
                        objY13 = cVarD.y(descriptor2, 0, C0335h.f929a, obj11);
                        i4 |= 1;
                        objY20 = obj6;
                        objY21 = obj7;
                        obj10 = objY13;
                        objY32 = obj5;
                        break;
                    case 1:
                        obj5 = objY32;
                        i4 |= 2;
                        objY20 = objY20;
                        objY21 = cVarD.y(descriptor2, 1, H.f874a, objY21);
                        objY32 = obj5;
                        break;
                    case 2:
                        obj8 = objY20;
                        obj9 = objY21;
                        objY32 = cVarD.y(descriptor2, 2, VerticalAlignmentDeserializer.INSTANCE, objY32);
                        i4 |= 4;
                        objY20 = obj8;
                        objY21 = obj9;
                        break;
                    case 3:
                        obj8 = objY20;
                        obj9 = objY21;
                        objY19 = cVarD.y(descriptor2, 3, Size$$serializer.INSTANCE, objY19);
                        i4 |= 8;
                        objY20 = obj8;
                        objY21 = obj9;
                        break;
                    case 4:
                        obj8 = objY20;
                        obj9 = objY21;
                        objY18 = cVarD.y(descriptor2, 4, H.f874a, objY18);
                        i4 |= 16;
                        objY20 = obj8;
                        objY21 = obj9;
                        break;
                    case 5:
                        obj8 = objY20;
                        obj9 = objY21;
                        objY26 = cVarD.y(descriptor2, 5, B.f862a, objY26);
                        i4 |= 32;
                        objY20 = obj8;
                        objY21 = obj9;
                        break;
                    case 6:
                        obj8 = objY20;
                        obj9 = objY21;
                        objY28 = cVarD.y(descriptor2, 6, ColorScheme$$serializer.INSTANCE, objY28);
                        i4 |= 64;
                        objY20 = obj8;
                        objY21 = obj9;
                        break;
                    case 7:
                        obj8 = objY20;
                        obj9 = objY21;
                        objY25 = cVarD.y(descriptor2, 7, BackgroundDeserializer.INSTANCE, objY25);
                        i4 |= UserMetadata.MAX_ROLLOUT_ASSIGNMENTS;
                        objY20 = obj8;
                        objY21 = obj9;
                        break;
                    case 8:
                        obj8 = objY20;
                        obj9 = objY21;
                        objY24 = cVarD.y(descriptor2, 8, Padding$$serializer.INSTANCE, objY24);
                        i4 |= 256;
                        objY20 = obj8;
                        objY21 = obj9;
                        break;
                    case 9:
                        obj8 = objY20;
                        obj9 = objY21;
                        objY23 = cVarD.y(descriptor2, 9, Padding$$serializer.INSTANCE, objY23);
                        i4 |= 512;
                        objY20 = obj8;
                        objY21 = obj9;
                        break;
                    case 10:
                        obj8 = objY20;
                        obj9 = objY21;
                        objY27 = cVarD.y(descriptor2, 10, ShapeDeserializer.INSTANCE, objY27);
                        i4 |= UserMetadata.MAX_ATTRIBUTE_SIZE;
                        objY20 = obj8;
                        objY21 = obj9;
                        break;
                    case 11:
                        obj8 = objY20;
                        obj9 = objY21;
                        objY22 = cVarD.y(descriptor2, 11, Border$$serializer.INSTANCE, objY22);
                        i4 |= 2048;
                        objY20 = obj8;
                        objY21 = obj9;
                        break;
                    case 12:
                        obj9 = objY21;
                        objY29 = cVarD.y(descriptor2, 12, Shadow$$serializer.INSTANCE, objY29);
                        i4 |= 4096;
                        objY20 = objY20;
                        objY30 = objY30;
                        objY21 = obj9;
                        break;
                    case 13:
                        obj9 = objY21;
                        objY30 = cVarD.y(descriptor2, 13, CarouselComponent$PageControl$$serializer.INSTANCE, objY30);
                        i4 |= UserMetadata.MAX_INTERNAL_KEY_SIZE;
                        objY20 = objY20;
                        objY31 = objY31;
                        objY21 = obj9;
                        break;
                    case 14:
                        obj9 = objY21;
                        obj8 = objY20;
                        objY31 = cVarD.y(descriptor2, 14, C0335h.f929a, objY31);
                        i4 |= 16384;
                        objY20 = obj8;
                        objY21 = obj9;
                        break;
                    case FirestoreIndexValueWriter.INDEX_TYPE_NUMBER /* 15 */:
                        objY20 = cVarD.y(descriptor2, 15, CarouselComponent$AutoAdvancePages$$serializer.INSTANCE, objY20);
                        i4 |= 32768;
                        objY21 = objY21;
                        break;
                    default:
                        throw new j(i5);
                }
            }
            Object obj12 = objY32;
            objY = objY20;
            Object obj13 = obj10;
            obj = objY21;
            objY2 = objY19;
            obj2 = objY30;
            objY3 = objY29;
            obj3 = obj13;
            objY4 = objY18;
            objY5 = objY22;
            objY6 = objY23;
            objY7 = objY25;
            objY8 = objY26;
            objY9 = objY27;
            objY10 = objY31;
            obj4 = obj12;
            objY11 = objY24;
            objY12 = objY28;
        }
        int i6 = i4;
        cVarD.c(descriptor2);
        return new PartialCarouselComponent(i6, (Boolean) obj3, (Integer) obj, (VerticalAlignment) obj4, (Size) objY2, (Integer) objY4, (Float) objY8, (ColorScheme) objY12, (Background) objY7, (Padding) objY11, (Padding) objY6, (Shape) objY9, (Border) objY5, (Shadow) objY3, (CarouselComponent.PageControl) obj2, (Boolean) objY10, (CarouselComponent.AutoAdvancePages) objY, (k0) null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, PartialCarouselComponent value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        PartialCarouselComponent.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
