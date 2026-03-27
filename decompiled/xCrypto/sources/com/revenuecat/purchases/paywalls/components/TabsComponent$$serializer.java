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
import com.revenuecat.purchases.paywalls.components.TabsComponent;
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
import java.util.List;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class TabsComponent$$serializer implements C {
    public static final TabsComponent$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        TabsComponent$$serializer tabsComponent$$serializer = new TabsComponent$$serializer();
        INSTANCE = tabsComponent$$serializer;
        C0327b0 c0327b0 = new C0327b0("tabs", tabsComponent$$serializer, 12);
        c0327b0.l("visible", true);
        c0327b0.l("size", true);
        c0327b0.l("padding", true);
        c0327b0.l("margin", true);
        c0327b0.l("background_color", true);
        c0327b0.l("background", true);
        c0327b0.l("shape", true);
        c0327b0.l("border", true);
        c0327b0.l("shadow", true);
        c0327b0.l("control", false);
        c0327b0.l("tabs", false);
        c0327b0.l("overrides", true);
        descriptor = c0327b0;
    }

    private TabsComponent$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        b[] bVarArr = TabsComponent.$childSerializers;
        b bVarP = a.p(C0335h.f929a);
        b bVarP2 = a.p(ColorScheme$$serializer.INSTANCE);
        b bVarP3 = a.p(BackgroundDeserializer.INSTANCE);
        b bVarP4 = a.p(ShapeDeserializer.INSTANCE);
        b bVarP5 = a.p(Border$$serializer.INSTANCE);
        b bVarP6 = a.p(Shadow$$serializer.INSTANCE);
        b bVar = bVarArr[9];
        b bVar2 = bVarArr[10];
        b bVar3 = bVarArr[11];
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new b[]{bVarP, Size$$serializer.INSTANCE, padding$$serializer, padding$$serializer, bVarP2, bVarP3, bVarP4, bVarP5, bVarP6, bVar, bVar2, bVar3};
    }

    @Override // F3.a
    public TabsComponent deserialize(e decoder) {
        Object objM;
        Object objY;
        Object objY2;
        Object objY3;
        Object objY4;
        Object objM2;
        Object objY5;
        Object objM3;
        int i4;
        Object objM4;
        Object objM5;
        Object obj;
        Object objY6;
        b[] bVarArr;
        Object objY7;
        Object obj2;
        b[] bVarArr2;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        b[] bVarArr3 = TabsComponent.$childSerializers;
        if (cVarD.w()) {
            objY = cVarD.y(descriptor2, 0, C0335h.f929a, null);
            objM5 = cVarD.m(descriptor2, 1, Size$$serializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            objM4 = cVarD.m(descriptor2, 2, padding$$serializer, null);
            objM3 = cVarD.m(descriptor2, 3, padding$$serializer, null);
            objY5 = cVarD.y(descriptor2, 4, ColorScheme$$serializer.INSTANCE, null);
            objY4 = cVarD.y(descriptor2, 5, BackgroundDeserializer.INSTANCE, null);
            objY3 = cVarD.y(descriptor2, 6, ShapeDeserializer.INSTANCE, null);
            objY2 = cVarD.y(descriptor2, 7, Border$$serializer.INSTANCE, null);
            objY6 = cVarD.y(descriptor2, 8, Shadow$$serializer.INSTANCE, null);
            Object objM6 = cVarD.m(descriptor2, 9, bVarArr3[9], null);
            Object objM7 = cVarD.m(descriptor2, 10, bVarArr3[10], null);
            objM2 = cVarD.m(descriptor2, 11, bVarArr3[11], null);
            i4 = 4095;
            obj = objM6;
            objM = objM7;
        } else {
            int i5 = 11;
            Object objY8 = null;
            Object objY9 = null;
            Object objY10 = null;
            Object objY11 = null;
            Object objM8 = null;
            Object objY12 = null;
            Object objM9 = null;
            Object obj3 = null;
            int i6 = 10;
            int i7 = 9;
            boolean z4 = true;
            Object objM10 = null;
            objM = null;
            Object objM11 = null;
            int i8 = 0;
            Object objM12 = null;
            while (z4) {
                int i9 = i5;
                int i10 = cVarD.i(descriptor2);
                switch (i10) {
                    case -1:
                        bVarArr = bVarArr3;
                        objY7 = obj3;
                        obj2 = objY8;
                        z4 = false;
                        objY8 = obj2;
                        i5 = 11;
                        i7 = 9;
                        i6 = 10;
                        obj3 = objY7;
                        bVarArr3 = bVarArr;
                        break;
                    case 0:
                        bVarArr = bVarArr3;
                        Object obj4 = obj3;
                        obj2 = objY8;
                        objY7 = cVarD.y(descriptor2, 0, C0335h.f929a, obj4);
                        i8 |= 1;
                        objY8 = obj2;
                        i5 = 11;
                        i7 = 9;
                        i6 = 10;
                        obj3 = objY7;
                        bVarArr3 = bVarArr;
                        break;
                    case 1:
                        bVarArr2 = bVarArr3;
                        objM12 = cVarD.m(descriptor2, 1, Size$$serializer.INSTANCE, objM12);
                        i8 |= 2;
                        bVarArr3 = bVarArr2;
                        i5 = 11;
                        i7 = 9;
                        i6 = 10;
                        break;
                    case 2:
                        bVarArr2 = bVarArr3;
                        objM11 = cVarD.m(descriptor2, 2, Padding$$serializer.INSTANCE, objM11);
                        i8 |= 4;
                        bVarArr3 = bVarArr2;
                        i5 = 11;
                        i7 = 9;
                        i6 = 10;
                        break;
                    case 3:
                        bVarArr2 = bVarArr3;
                        objM9 = cVarD.m(descriptor2, 3, Padding$$serializer.INSTANCE, objM9);
                        i8 |= 8;
                        bVarArr3 = bVarArr2;
                        i5 = 11;
                        i7 = 9;
                        i6 = 10;
                        break;
                    case 4:
                        bVarArr2 = bVarArr3;
                        objY11 = cVarD.y(descriptor2, 4, ColorScheme$$serializer.INSTANCE, objY11);
                        i8 |= 16;
                        bVarArr3 = bVarArr2;
                        i5 = 11;
                        i7 = 9;
                        i6 = 10;
                        break;
                    case 5:
                        bVarArr2 = bVarArr3;
                        objY12 = cVarD.y(descriptor2, 5, BackgroundDeserializer.INSTANCE, objY12);
                        i8 |= 32;
                        bVarArr3 = bVarArr2;
                        i5 = 11;
                        i7 = 9;
                        i6 = 10;
                        break;
                    case 6:
                        bVarArr2 = bVarArr3;
                        objY10 = cVarD.y(descriptor2, 6, ShapeDeserializer.INSTANCE, objY10);
                        i8 |= 64;
                        bVarArr3 = bVarArr2;
                        i5 = 11;
                        i7 = 9;
                        i6 = 10;
                        break;
                    case 7:
                        bVarArr2 = bVarArr3;
                        objY9 = cVarD.y(descriptor2, 7, Border$$serializer.INSTANCE, objY9);
                        i8 |= UserMetadata.MAX_ROLLOUT_ASSIGNMENTS;
                        bVarArr3 = bVarArr2;
                        i5 = 11;
                        i7 = 9;
                        i6 = 10;
                        break;
                    case 8:
                        bVarArr2 = bVarArr3;
                        objY8 = cVarD.y(descriptor2, 8, Shadow$$serializer.INSTANCE, objY8);
                        i8 |= 256;
                        bVarArr3 = bVarArr2;
                        i5 = 11;
                        i7 = 9;
                        i6 = 10;
                        break;
                    case 9:
                        b[] bVarArr4 = bVarArr3;
                        objM8 = cVarD.m(descriptor2, i7, bVarArr4[i7], objM8);
                        i8 |= 512;
                        bVarArr3 = bVarArr4;
                        i5 = 11;
                        i6 = 10;
                        break;
                    case 10:
                        b[] bVarArr5 = bVarArr3;
                        objM = cVarD.m(descriptor2, i6, bVarArr5[i6], objM);
                        i8 |= UserMetadata.MAX_ATTRIBUTE_SIZE;
                        bVarArr3 = bVarArr5;
                        i5 = 11;
                        break;
                    case 11:
                        bVarArr = bVarArr3;
                        objM10 = cVarD.m(descriptor2, i9, bVarArr3[i9], objM10);
                        i8 |= 2048;
                        i5 = i9;
                        bVarArr3 = bVarArr;
                        break;
                    default:
                        throw new j(i10);
                }
            }
            Object obj5 = obj3;
            Object obj6 = objY8;
            objY = obj5;
            objY2 = objY9;
            objY3 = objY10;
            objY4 = objY12;
            objM2 = objM10;
            objY5 = objY11;
            objM3 = objM9;
            i4 = i8;
            objM4 = objM11;
            objM5 = objM12;
            obj = objM8;
            objY6 = obj6;
        }
        cVarD.c(descriptor2);
        return new TabsComponent(i4, (Boolean) objY, (Size) objM5, (Padding) objM4, (Padding) objM3, (ColorScheme) objY5, (Background) objY4, (Shape) objY3, (Border) objY2, (Shadow) objY6, (TabsComponent.TabControl) obj, (List) objM, (List) objM2, (k0) null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, TabsComponent value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        TabsComponent.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
