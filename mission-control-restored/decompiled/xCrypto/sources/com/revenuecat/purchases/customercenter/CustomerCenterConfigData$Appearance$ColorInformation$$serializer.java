package com.revenuecat.purchases.customercenter;

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
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.paywalls.PaywallColor;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class CustomerCenterConfigData$Appearance$ColorInformation$$serializer implements C {
    public static final CustomerCenterConfigData$Appearance$ColorInformation$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        CustomerCenterConfigData$Appearance$ColorInformation$$serializer customerCenterConfigData$Appearance$ColorInformation$$serializer = new CustomerCenterConfigData$Appearance$ColorInformation$$serializer();
        INSTANCE = customerCenterConfigData$Appearance$ColorInformation$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Appearance.ColorInformation", customerCenterConfigData$Appearance$ColorInformation$$serializer, 5);
        c0327b0.l("accent_color", true);
        c0327b0.l("text_color", true);
        c0327b0.l("background_color", true);
        c0327b0.l("button_text_color", true);
        c0327b0.l("button_background_color", true);
        descriptor = c0327b0;
    }

    private CustomerCenterConfigData$Appearance$ColorInformation$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        PaywallColor.Serializer serializer = PaywallColor.Serializer.INSTANCE;
        return new b[]{a.p(serializer), a.p(serializer), a.p(serializer), a.p(serializer), a.p(serializer)};
    }

    @Override // F3.a
    public CustomerCenterConfigData.Appearance.ColorInformation deserialize(e decoder) {
        Object objY;
        int i4;
        Object objY2;
        Object objY3;
        Object objY4;
        Object objY5;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        Object objY6 = null;
        if (cVarD.w()) {
            PaywallColor.Serializer serializer = PaywallColor.Serializer.INSTANCE;
            objY2 = cVarD.y(descriptor2, 0, serializer, null);
            objY3 = cVarD.y(descriptor2, 1, serializer, null);
            Object objY7 = cVarD.y(descriptor2, 2, serializer, null);
            objY4 = cVarD.y(descriptor2, 3, serializer, null);
            objY5 = cVarD.y(descriptor2, 4, serializer, null);
            objY = objY7;
            i4 = 31;
        } else {
            boolean z4 = true;
            int i5 = 0;
            Object objY8 = null;
            objY = null;
            Object objY9 = null;
            Object objY10 = null;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    z4 = false;
                } else if (i6 == 0) {
                    objY6 = cVarD.y(descriptor2, 0, PaywallColor.Serializer.INSTANCE, objY6);
                    i5 |= 1;
                } else if (i6 == 1) {
                    objY8 = cVarD.y(descriptor2, 1, PaywallColor.Serializer.INSTANCE, objY8);
                    i5 |= 2;
                } else if (i6 == 2) {
                    objY = cVarD.y(descriptor2, 2, PaywallColor.Serializer.INSTANCE, objY);
                    i5 |= 4;
                } else if (i6 == 3) {
                    objY9 = cVarD.y(descriptor2, 3, PaywallColor.Serializer.INSTANCE, objY9);
                    i5 |= 8;
                } else {
                    if (i6 != 4) {
                        throw new j(i6);
                    }
                    objY10 = cVarD.y(descriptor2, 4, PaywallColor.Serializer.INSTANCE, objY10);
                    i5 |= 16;
                }
            }
            i4 = i5;
            objY2 = objY6;
            objY3 = objY8;
            objY4 = objY9;
            objY5 = objY10;
        }
        cVarD.c(descriptor2);
        return new CustomerCenterConfigData.Appearance.ColorInformation(i4, (PaywallColor) objY2, (PaywallColor) objY3, (PaywallColor) objY, (PaywallColor) objY4, (PaywallColor) objY5, (k0) null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, CustomerCenterConfigData.Appearance.ColorInformation value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        CustomerCenterConfigData.Appearance.ColorInformation.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
