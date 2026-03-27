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
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.revenuecat.purchases.paywalls.components.TimelineComponent;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class PartialTimelineComponent$$serializer implements C {
    public static final PartialTimelineComponent$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        PartialTimelineComponent$$serializer partialTimelineComponent$$serializer = new PartialTimelineComponent$$serializer();
        INSTANCE = partialTimelineComponent$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.components.PartialTimelineComponent", partialTimelineComponent$$serializer, 8);
        c0327b0.l("visible", true);
        c0327b0.l("item_spacing", true);
        c0327b0.l("text_spacing", true);
        c0327b0.l("column_gutter", true);
        c0327b0.l("icon_alignment", true);
        c0327b0.l("size", true);
        c0327b0.l("padding", true);
        c0327b0.l("margin", true);
        descriptor = c0327b0;
    }

    private PartialTimelineComponent$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        b bVarP = a.p(C0335h.f929a);
        H h4 = H.f874a;
        b bVarP2 = a.p(h4);
        b bVarP3 = a.p(h4);
        b bVarP4 = a.p(h4);
        b bVarP5 = a.p(TimelineIconAlignmentDeserializer.INSTANCE);
        b bVarP6 = a.p(Size$$serializer.INSTANCE);
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new b[]{bVarP, bVarP2, bVarP3, bVarP4, bVarP5, bVarP6, a.p(padding$$serializer), a.p(padding$$serializer)};
    }

    @Override // F3.a
    public PartialTimelineComponent deserialize(e decoder) {
        int i4;
        Object objY;
        Object objY2;
        Object objY3;
        Object objY4;
        Object objY5;
        Object objY6;
        Object objY7;
        Object objY8;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        int i5 = 7;
        Object objY9 = null;
        if (cVarD.w()) {
            objY = cVarD.y(descriptor2, 0, C0335h.f929a, null);
            H h4 = H.f874a;
            objY5 = cVarD.y(descriptor2, 1, h4, null);
            objY6 = cVarD.y(descriptor2, 2, h4, null);
            objY7 = cVarD.y(descriptor2, 3, h4, null);
            objY8 = cVarD.y(descriptor2, 4, TimelineIconAlignmentDeserializer.INSTANCE, null);
            objY4 = cVarD.y(descriptor2, 5, Size$$serializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            objY3 = cVarD.y(descriptor2, 6, padding$$serializer, null);
            objY2 = cVarD.y(descriptor2, 7, padding$$serializer, null);
            i4 = 255;
        } else {
            boolean z4 = true;
            int i6 = 0;
            Object objY10 = null;
            Object objY11 = null;
            Object objY12 = null;
            Object objY13 = null;
            Object objY14 = null;
            Object objY15 = null;
            Object objY16 = null;
            while (z4) {
                int i7 = cVarD.i(descriptor2);
                switch (i7) {
                    case -1:
                        z4 = false;
                        i5 = 7;
                        break;
                    case 0:
                        objY9 = cVarD.y(descriptor2, 0, C0335h.f929a, objY9);
                        i6 |= 1;
                        i5 = 7;
                        break;
                    case 1:
                        objY13 = cVarD.y(descriptor2, 1, H.f874a, objY13);
                        i6 |= 2;
                        i5 = 7;
                        break;
                    case 2:
                        objY14 = cVarD.y(descriptor2, 2, H.f874a, objY14);
                        i6 |= 4;
                        i5 = 7;
                        break;
                    case 3:
                        objY15 = cVarD.y(descriptor2, 3, H.f874a, objY15);
                        i6 |= 8;
                        i5 = 7;
                        break;
                    case 4:
                        objY16 = cVarD.y(descriptor2, 4, TimelineIconAlignmentDeserializer.INSTANCE, objY16);
                        i6 |= 16;
                        break;
                    case 5:
                        objY12 = cVarD.y(descriptor2, 5, Size$$serializer.INSTANCE, objY12);
                        i6 |= 32;
                        break;
                    case 6:
                        objY11 = cVarD.y(descriptor2, 6, Padding$$serializer.INSTANCE, objY11);
                        i6 |= 64;
                        break;
                    case 7:
                        objY10 = cVarD.y(descriptor2, i5, Padding$$serializer.INSTANCE, objY10);
                        i6 |= UserMetadata.MAX_ROLLOUT_ASSIGNMENTS;
                        break;
                    default:
                        throw new j(i7);
                }
            }
            Object obj = objY9;
            i4 = i6;
            objY = obj;
            objY2 = objY10;
            objY3 = objY11;
            objY4 = objY12;
            objY5 = objY13;
            objY6 = objY14;
            objY7 = objY15;
            objY8 = objY16;
        }
        cVarD.c(descriptor2);
        return new PartialTimelineComponent(i4, (Boolean) objY, (Integer) objY5, (Integer) objY6, (Integer) objY7, (TimelineComponent.IconAlignment) objY8, (Size) objY4, (Padding) objY3, (Padding) objY2, (k0) null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, PartialTimelineComponent value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        PartialTimelineComponent.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
