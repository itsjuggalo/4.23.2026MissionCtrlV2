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
import J3.k0;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.paywalls.components.ButtonComponent;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class ActionSurrogate$$serializer implements C {
    public static final ActionSurrogate$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        ActionSurrogate$$serializer actionSurrogate$$serializer = new ActionSurrogate$$serializer();
        INSTANCE = actionSurrogate$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.components.ActionSurrogate", actionSurrogate$$serializer, 4);
        c0327b0.l("type", false);
        c0327b0.l(FirebaseAnalytics.Param.DESTINATION, true);
        c0327b0.l("url", true);
        c0327b0.l("sheet", true);
        descriptor = c0327b0;
    }

    private ActionSurrogate$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        return new b[]{ActionTypeSurrogateDeserializer.INSTANCE, a.p(DestinationSurrogateDeserializer.INSTANCE), a.p(UrlSurrogate$$serializer.INSTANCE), a.p(ButtonComponent$Destination$Sheet$$serializer.INSTANCE)};
    }

    @Override // F3.a
    public ActionSurrogate deserialize(e decoder) {
        int i4;
        Object objM;
        Object objY;
        Object objY2;
        Object objY3;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        Object objM2 = null;
        if (cVarD.w()) {
            objM = cVarD.m(descriptor2, 0, ActionTypeSurrogateDeserializer.INSTANCE, null);
            objY = cVarD.y(descriptor2, 1, DestinationSurrogateDeserializer.INSTANCE, null);
            objY2 = cVarD.y(descriptor2, 2, UrlSurrogate$$serializer.INSTANCE, null);
            objY3 = cVarD.y(descriptor2, 3, ButtonComponent$Destination$Sheet$$serializer.INSTANCE, null);
            i4 = 15;
        } else {
            boolean z4 = true;
            int i5 = 0;
            Object objY4 = null;
            Object objY5 = null;
            Object objY6 = null;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    z4 = false;
                } else if (i6 == 0) {
                    objM2 = cVarD.m(descriptor2, 0, ActionTypeSurrogateDeserializer.INSTANCE, objM2);
                    i5 |= 1;
                } else if (i6 == 1) {
                    objY4 = cVarD.y(descriptor2, 1, DestinationSurrogateDeserializer.INSTANCE, objY4);
                    i5 |= 2;
                } else if (i6 == 2) {
                    objY5 = cVarD.y(descriptor2, 2, UrlSurrogate$$serializer.INSTANCE, objY5);
                    i5 |= 4;
                } else {
                    if (i6 != 3) {
                        throw new j(i6);
                    }
                    objY6 = cVarD.y(descriptor2, 3, ButtonComponent$Destination$Sheet$$serializer.INSTANCE, objY6);
                    i5 |= 8;
                }
            }
            Object obj = objM2;
            i4 = i5;
            objM = obj;
            objY = objY4;
            objY2 = objY5;
            objY3 = objY6;
        }
        cVarD.c(descriptor2);
        return new ActionSurrogate(i4, (ActionTypeSurrogate) objM, (DestinationSurrogate) objY, (UrlSurrogate) objY2, (ButtonComponent.Destination.Sheet) objY3, (k0) null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, ActionSurrogate value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        ActionSurrogate.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
