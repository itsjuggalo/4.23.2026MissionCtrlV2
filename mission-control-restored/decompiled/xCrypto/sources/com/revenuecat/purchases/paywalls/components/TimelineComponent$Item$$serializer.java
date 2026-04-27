package com.revenuecat.purchases.paywalls.components;

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
import com.amazon.a.a.o.b;
import com.revenuecat.purchases.paywalls.components.TimelineComponent;
import java.util.List;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class TimelineComponent$Item$$serializer implements C {
    public static final TimelineComponent$Item$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        TimelineComponent$Item$$serializer timelineComponent$Item$$serializer = new TimelineComponent$Item$$serializer();
        INSTANCE = timelineComponent$Item$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.components.TimelineComponent.Item", timelineComponent$Item$$serializer, 6);
        c0327b0.l(b.f8745S, false);
        c0327b0.l("visible", true);
        c0327b0.l(b.f8755c, true);
        c0327b0.l("icon", false);
        c0327b0.l("connector", true);
        c0327b0.l("overrides", true);
        descriptor = c0327b0;
    }

    private TimelineComponent$Item$$serializer() {
    }

    @Override // J3.C
    public F3.b[] childSerializers() {
        F3.b[] bVarArr = TimelineComponent.Item.$childSerializers;
        TextComponent$$serializer textComponent$$serializer = TextComponent$$serializer.INSTANCE;
        return new F3.b[]{textComponent$$serializer, a.p(C0335h.f929a), a.p(textComponent$$serializer), IconComponent$$serializer.INSTANCE, a.p(TimelineComponent$Connector$$serializer.INSTANCE), bVarArr[5]};
    }

    @Override // F3.a
    public TimelineComponent.Item deserialize(e decoder) {
        int i4;
        Object objM;
        Object objY;
        Object objY2;
        Object objM2;
        Object objY3;
        Object objM3;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        F3.b[] bVarArr = TimelineComponent.Item.$childSerializers;
        int i5 = 3;
        Object objM4 = null;
        if (cVarD.w()) {
            TextComponent$$serializer textComponent$$serializer = TextComponent$$serializer.INSTANCE;
            objM = cVarD.m(descriptor2, 0, textComponent$$serializer, null);
            objY = cVarD.y(descriptor2, 1, C0335h.f929a, null);
            objY2 = cVarD.y(descriptor2, 2, textComponent$$serializer, null);
            objM2 = cVarD.m(descriptor2, 3, IconComponent$$serializer.INSTANCE, null);
            objY3 = cVarD.y(descriptor2, 4, TimelineComponent$Connector$$serializer.INSTANCE, null);
            objM3 = cVarD.m(descriptor2, 5, bVarArr[5], null);
            i4 = 63;
        } else {
            boolean z4 = true;
            int i6 = 0;
            Object objY4 = null;
            Object objY5 = null;
            Object objM5 = null;
            Object objY6 = null;
            Object objM6 = null;
            while (z4) {
                int i7 = cVarD.i(descriptor2);
                switch (i7) {
                    case -1:
                        z4 = false;
                        i5 = 3;
                        break;
                    case 0:
                        objM4 = cVarD.m(descriptor2, 0, TextComponent$$serializer.INSTANCE, objM4);
                        i6 |= 1;
                        i5 = 3;
                        break;
                    case 1:
                        objY4 = cVarD.y(descriptor2, 1, C0335h.f929a, objY4);
                        i6 |= 2;
                        break;
                    case 2:
                        objY5 = cVarD.y(descriptor2, 2, TextComponent$$serializer.INSTANCE, objY5);
                        i6 |= 4;
                        break;
                    case 3:
                        objM5 = cVarD.m(descriptor2, i5, IconComponent$$serializer.INSTANCE, objM5);
                        i6 |= 8;
                        break;
                    case 4:
                        objY6 = cVarD.y(descriptor2, 4, TimelineComponent$Connector$$serializer.INSTANCE, objY6);
                        i6 |= 16;
                        break;
                    case 5:
                        objM6 = cVarD.m(descriptor2, 5, bVarArr[5], objM6);
                        i6 |= 32;
                        break;
                    default:
                        throw new j(i7);
                }
            }
            i4 = i6;
            objM = objM4;
            objY = objY4;
            objY2 = objY5;
            objM2 = objM5;
            objY3 = objY6;
            objM3 = objM6;
        }
        cVarD.c(descriptor2);
        return new TimelineComponent.Item(i4, (TextComponent) objM, (Boolean) objY, (TextComponent) objY2, (IconComponent) objM2, (TimelineComponent.Connector) objY3, (List) objM3, (k0) null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, TimelineComponent.Item value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        TimelineComponent.Item.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public F3.b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
