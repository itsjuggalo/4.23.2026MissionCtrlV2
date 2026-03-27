package com.revenuecat.purchases.paywalls.components.common;

import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.StackComponent$$serializer;
import com.revenuecat.purchases.paywalls.components.StickyFooterComponent;
import com.revenuecat.purchases.paywalls.components.StickyFooterComponent$$serializer;
import kotlin.jvm.internal.r;
import n6.b;
import n6.j;
import o6.a;
import q6.c;
import q6.d;
import q6.e;
import q6.f;
import r6.C;
import r6.C2613b0;
import r6.k0;

/* JADX INFO: loaded from: classes2.dex */
public final class PaywallComponentsConfig$$serializer implements C {
    public static final PaywallComponentsConfig$$serializer INSTANCE;
    private static final /* synthetic */ C2613b0 descriptor;

    static {
        PaywallComponentsConfig$$serializer paywallComponentsConfig$$serializer = new PaywallComponentsConfig$$serializer();
        INSTANCE = paywallComponentsConfig$$serializer;
        C2613b0 c2613b0 = new C2613b0("com.revenuecat.purchases.paywalls.components.common.PaywallComponentsConfig", paywallComponentsConfig$$serializer, 3);
        c2613b0.l("stack", false);
        c2613b0.l("background", false);
        c2613b0.l("sticky_footer", true);
        descriptor = c2613b0;
    }

    private PaywallComponentsConfig$$serializer() {
    }

    @Override // r6.C
    public b[] childSerializers() {
        return new b[]{StackComponent$$serializer.INSTANCE, BackgroundDeserializer.INSTANCE, a.p(StickyFooterComponent$$serializer.INSTANCE)};
    }

    @Override // n6.a
    public PaywallComponentsConfig deserialize(e decoder) {
        Object objA;
        Object objY;
        int i7;
        Object objA2;
        r.f(decoder, "decoder");
        p6.e descriptor2 = getDescriptor();
        c cVarC = decoder.c(descriptor2);
        Object objA3 = null;
        if (cVarC.w()) {
            objA2 = cVarC.A(descriptor2, 0, StackComponent$$serializer.INSTANCE, null);
            objA = cVarC.A(descriptor2, 1, BackgroundDeserializer.INSTANCE, null);
            objY = cVarC.y(descriptor2, 2, StickyFooterComponent$$serializer.INSTANCE, null);
            i7 = 7;
        } else {
            boolean z7 = true;
            int i8 = 0;
            Object objA4 = null;
            Object objY2 = null;
            while (z7) {
                int iQ = cVarC.q(descriptor2);
                if (iQ == -1) {
                    z7 = false;
                } else if (iQ == 0) {
                    objA3 = cVarC.A(descriptor2, 0, StackComponent$$serializer.INSTANCE, objA3);
                    i8 |= 1;
                } else if (iQ == 1) {
                    objA4 = cVarC.A(descriptor2, 1, BackgroundDeserializer.INSTANCE, objA4);
                    i8 |= 2;
                } else {
                    if (iQ != 2) {
                        throw new j(iQ);
                    }
                    objY2 = cVarC.y(descriptor2, 2, StickyFooterComponent$$serializer.INSTANCE, objY2);
                    i8 |= 4;
                }
            }
            objA = objA4;
            objY = objY2;
            Object obj = objA3;
            i7 = i8;
            objA2 = obj;
        }
        cVarC.b(descriptor2);
        return new PaywallComponentsConfig(i7, (StackComponent) objA2, (Background) objA, (StickyFooterComponent) objY, (k0) null);
    }

    @Override // n6.b, n6.h, n6.a
    public p6.e getDescriptor() {
        return descriptor;
    }

    @Override // n6.h
    public void serialize(f encoder, PaywallComponentsConfig value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        p6.e descriptor2 = getDescriptor();
        d dVarC = encoder.c(descriptor2);
        PaywallComponentsConfig.write$Self(value, dVarC, descriptor2);
        dVarC.b(descriptor2);
    }

    @Override // r6.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
