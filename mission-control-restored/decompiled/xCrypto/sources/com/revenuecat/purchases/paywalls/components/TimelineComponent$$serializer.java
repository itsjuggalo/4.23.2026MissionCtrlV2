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
import J3.H;
import J3.k0;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.revenuecat.purchases.paywalls.components.TimelineComponent;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import java.util.List;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class TimelineComponent$$serializer implements C {
    public static final TimelineComponent$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        TimelineComponent$$serializer timelineComponent$$serializer = new TimelineComponent$$serializer();
        INSTANCE = timelineComponent$$serializer;
        C0327b0 c0327b0 = new C0327b0("timeline", timelineComponent$$serializer, 10);
        c0327b0.l("item_spacing", false);
        c0327b0.l("text_spacing", false);
        c0327b0.l("column_gutter", false);
        c0327b0.l("icon_alignment", false);
        c0327b0.l("visible", true);
        c0327b0.l("size", true);
        c0327b0.l("padding", true);
        c0327b0.l("margin", true);
        c0327b0.l(FirebaseAnalytics.Param.ITEMS, true);
        c0327b0.l("overrides", true);
        descriptor = c0327b0;
    }

    private TimelineComponent$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        b[] bVarArr = TimelineComponent.$childSerializers;
        b bVarP = a.p(C0335h.f929a);
        b bVar = bVarArr[8];
        b bVar2 = bVarArr[9];
        H h4 = H.f874a;
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new b[]{h4, h4, h4, TimelineIconAlignmentDeserializer.INSTANCE, bVarP, Size$$serializer.INSTANCE, padding$$serializer, padding$$serializer, bVar, bVar2};
    }

    @Override // F3.a
    public TimelineComponent deserialize(e decoder) {
        int iH;
        Object objM;
        Object objM2;
        Object objM3;
        Object objM4;
        Object objM5;
        Object objM6;
        Object objY;
        int iH2;
        int i4;
        int iH3;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        b[] bVarArr = TimelineComponent.$childSerializers;
        int i5 = 9;
        if (cVarD.w()) {
            iH = cVarD.h(descriptor2, 0);
            iH3 = cVarD.h(descriptor2, 1);
            iH2 = cVarD.h(descriptor2, 2);
            Object objM7 = cVarD.m(descriptor2, 3, TimelineIconAlignmentDeserializer.INSTANCE, null);
            objY = cVarD.y(descriptor2, 4, C0335h.f929a, null);
            objM6 = cVarD.m(descriptor2, 5, Size$$serializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            Object objM8 = cVarD.m(descriptor2, 6, padding$$serializer, null);
            objM5 = cVarD.m(descriptor2, 7, padding$$serializer, null);
            objM4 = cVarD.m(descriptor2, 8, bVarArr[8], null);
            objM3 = cVarD.m(descriptor2, 9, bVarArr[9], null);
            i4 = 1023;
            objM2 = objM7;
            objM = objM8;
        } else {
            boolean z4 = true;
            iH = 0;
            int i6 = 0;
            int iH4 = 0;
            Object objM9 = null;
            Object objM10 = null;
            objM = null;
            Object objM11 = null;
            Object objM12 = null;
            Object objY2 = null;
            int iH5 = 0;
            objM2 = null;
            while (z4) {
                int i7 = cVarD.i(descriptor2);
                switch (i7) {
                    case -1:
                        z4 = false;
                        break;
                    case 0:
                        i6 |= 1;
                        iH = cVarD.h(descriptor2, 0);
                        i5 = 9;
                        break;
                    case 1:
                        iH4 = cVarD.h(descriptor2, 1);
                        i6 |= 2;
                        i5 = 9;
                        break;
                    case 2:
                        iH5 = cVarD.h(descriptor2, 2);
                        i6 |= 4;
                        i5 = 9;
                        break;
                    case 3:
                        objM2 = cVarD.m(descriptor2, 3, TimelineIconAlignmentDeserializer.INSTANCE, objM2);
                        i6 |= 8;
                        i5 = 9;
                        break;
                    case 4:
                        objY2 = cVarD.y(descriptor2, 4, C0335h.f929a, objY2);
                        i6 |= 16;
                        i5 = 9;
                        break;
                    case 5:
                        objM12 = cVarD.m(descriptor2, 5, Size$$serializer.INSTANCE, objM12);
                        i6 |= 32;
                        i5 = 9;
                        break;
                    case 6:
                        objM = cVarD.m(descriptor2, 6, Padding$$serializer.INSTANCE, objM);
                        i6 |= 64;
                        i5 = 9;
                        break;
                    case 7:
                        objM11 = cVarD.m(descriptor2, 7, Padding$$serializer.INSTANCE, objM11);
                        i6 |= UserMetadata.MAX_ROLLOUT_ASSIGNMENTS;
                        i5 = 9;
                        break;
                    case 8:
                        objM10 = cVarD.m(descriptor2, 8, bVarArr[8], objM10);
                        i6 |= 256;
                        break;
                    case 9:
                        objM9 = cVarD.m(descriptor2, i5, bVarArr[i5], objM9);
                        i6 |= 512;
                        break;
                    default:
                        throw new j(i7);
                }
            }
            objM3 = objM9;
            objM4 = objM10;
            objM5 = objM11;
            objM6 = objM12;
            objY = objY2;
            iH2 = iH5;
            i4 = i6;
            iH3 = iH4;
        }
        int i8 = iH;
        cVarD.c(descriptor2);
        return new TimelineComponent(i4, i8, iH3, iH2, (TimelineComponent.IconAlignment) objM2, (Boolean) objY, (Size) objM6, (Padding) objM, (Padding) objM5, (List) objM4, (List) objM3, (k0) null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, TimelineComponent value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        TimelineComponent.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
