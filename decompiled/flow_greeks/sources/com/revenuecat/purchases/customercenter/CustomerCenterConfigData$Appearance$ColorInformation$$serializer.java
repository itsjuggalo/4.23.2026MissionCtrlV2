package com.revenuecat.purchases.customercenter;

import ah.a;
import ch.c;
import ch.d;
import ch.e;
import ch.f;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.paywalls.PaywallColor;
import dh.e0;
import dh.j1;
import dh.s1;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/customercenter/CustomerCenterConfigData.Appearance.ColorInformation.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Appearance$ColorInformation;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Appearance$ColorInformation;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Appearance$ColorInformation;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CustomerCenterConfigData$Appearance$ColorInformation$$serializer implements e0 {
    public static final CustomerCenterConfigData$Appearance$ColorInformation$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        CustomerCenterConfigData$Appearance$ColorInformation$$serializer customerCenterConfigData$Appearance$ColorInformation$$serializer = new CustomerCenterConfigData$Appearance$ColorInformation$$serializer();
        INSTANCE = customerCenterConfigData$Appearance$ColorInformation$$serializer;
        j1 j1Var = new j1("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Appearance.ColorInformation", customerCenterConfigData$Appearance$ColorInformation$$serializer, 5);
        j1Var.g("accent_color", true);
        j1Var.g("text_color", true);
        j1Var.g("background_color", true);
        j1Var.g("button_text_color", true);
        j1Var.g("button_background_color", true);
        descriptor = j1Var;
    }

    private CustomerCenterConfigData$Appearance$ColorInformation$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        PaywallColor.Serializer serializer = PaywallColor.Serializer.INSTANCE;
        return new b[]{a.p(serializer), a.p(serializer), a.p(serializer), a.p(serializer), a.p(serializer)};
    }

    @Override // zg.a
    public CustomerCenterConfigData.Appearance.ColorInformation deserialize(e decoder) {
        int i10;
        PaywallColor paywallColor;
        PaywallColor paywallColor2;
        PaywallColor paywallColor3;
        PaywallColor paywallColor4;
        PaywallColor paywallColor5;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        PaywallColor paywallColor6 = null;
        if (cVarB.z()) {
            PaywallColor.Serializer serializer = PaywallColor.Serializer.INSTANCE;
            PaywallColor paywallColor7 = (PaywallColor) cVarB.n(descriptor2, 0, serializer, null);
            PaywallColor paywallColor8 = (PaywallColor) cVarB.n(descriptor2, 1, serializer, null);
            PaywallColor paywallColor9 = (PaywallColor) cVarB.n(descriptor2, 2, serializer, null);
            PaywallColor paywallColor10 = (PaywallColor) cVarB.n(descriptor2, 3, serializer, null);
            paywallColor5 = (PaywallColor) cVarB.n(descriptor2, 4, serializer, null);
            paywallColor4 = paywallColor10;
            i10 = 31;
            paywallColor3 = paywallColor9;
            paywallColor2 = paywallColor8;
            paywallColor = paywallColor7;
        } else {
            boolean z10 = true;
            int i11 = 0;
            PaywallColor paywallColor11 = null;
            PaywallColor paywallColor12 = null;
            PaywallColor paywallColor13 = null;
            PaywallColor paywallColor14 = null;
            while (z10) {
                int iW = cVarB.w(descriptor2);
                if (iW == -1) {
                    z10 = false;
                } else if (iW == 0) {
                    paywallColor6 = (PaywallColor) cVarB.n(descriptor2, 0, PaywallColor.Serializer.INSTANCE, paywallColor6);
                    i11 |= 1;
                } else if (iW == 1) {
                    paywallColor11 = (PaywallColor) cVarB.n(descriptor2, 1, PaywallColor.Serializer.INSTANCE, paywallColor11);
                    i11 |= 2;
                } else if (iW == 2) {
                    paywallColor12 = (PaywallColor) cVarB.n(descriptor2, 2, PaywallColor.Serializer.INSTANCE, paywallColor12);
                    i11 |= 4;
                } else if (iW == 3) {
                    paywallColor13 = (PaywallColor) cVarB.n(descriptor2, 3, PaywallColor.Serializer.INSTANCE, paywallColor13);
                    i11 |= 8;
                } else {
                    if (iW != 4) {
                        throw new m(iW);
                    }
                    paywallColor14 = (PaywallColor) cVarB.n(descriptor2, 4, PaywallColor.Serializer.INSTANCE, paywallColor14);
                    i11 |= 16;
                }
            }
            i10 = i11;
            paywallColor = paywallColor6;
            paywallColor2 = paywallColor11;
            paywallColor3 = paywallColor12;
            paywallColor4 = paywallColor13;
            paywallColor5 = paywallColor14;
        }
        cVarB.c(descriptor2);
        return new CustomerCenterConfigData.Appearance.ColorInformation(i10, paywallColor, paywallColor2, paywallColor3, paywallColor4, paywallColor5, (s1) null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, CustomerCenterConfigData.Appearance.ColorInformation value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        CustomerCenterConfigData.Appearance.ColorInformation.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
