package com.revenuecat.purchases.customercenter;

import ah.a;
import ch.c;
import ch.d;
import ch.e;
import ch.f;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import dh.e0;
import dh.j1;
import dh.s1;
import dh.w1;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/customercenter/CustomerCenterConfigData.ScreenOffering.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$ScreenOffering;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$ScreenOffering;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$ScreenOffering;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CustomerCenterConfigData$ScreenOffering$$serializer implements e0 {
    public static final CustomerCenterConfigData$ScreenOffering$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        CustomerCenterConfigData$ScreenOffering$$serializer customerCenterConfigData$ScreenOffering$$serializer = new CustomerCenterConfigData$ScreenOffering$$serializer();
        INSTANCE = customerCenterConfigData$ScreenOffering$$serializer;
        j1 j1Var = new j1("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.ScreenOffering", customerCenterConfigData$ScreenOffering$$serializer, 3);
        j1Var.g("type", false);
        j1Var.g("offering_id", true);
        j1Var.g("button_text", true);
        descriptor = j1Var;
    }

    private CustomerCenterConfigData$ScreenOffering$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        b bVar = CustomerCenterConfigData.ScreenOffering.$childSerializers[0];
        w1 w1Var = w1.f8244a;
        return new b[]{bVar, a.p(w1Var), a.p(w1Var)};
    }

    @Override // zg.a
    public CustomerCenterConfigData.ScreenOffering deserialize(e decoder) {
        int i10;
        CustomerCenterConfigData.ScreenOffering.ScreenOfferingType screenOfferingType;
        String str;
        String str2;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        b[] bVarArr = CustomerCenterConfigData.ScreenOffering.$childSerializers;
        CustomerCenterConfigData.ScreenOffering.ScreenOfferingType screenOfferingType2 = null;
        if (cVarB.z()) {
            CustomerCenterConfigData.ScreenOffering.ScreenOfferingType screenOfferingType3 = (CustomerCenterConfigData.ScreenOffering.ScreenOfferingType) cVarB.h(descriptor2, 0, bVarArr[0], null);
            w1 w1Var = w1.f8244a;
            String str3 = (String) cVarB.n(descriptor2, 1, w1Var, null);
            screenOfferingType = screenOfferingType3;
            str2 = (String) cVarB.n(descriptor2, 2, w1Var, null);
            i10 = 7;
            str = str3;
        } else {
            boolean z10 = true;
            int i11 = 0;
            String str4 = null;
            String str5 = null;
            while (z10) {
                int iW = cVarB.w(descriptor2);
                if (iW == -1) {
                    z10 = false;
                } else if (iW == 0) {
                    screenOfferingType2 = (CustomerCenterConfigData.ScreenOffering.ScreenOfferingType) cVarB.h(descriptor2, 0, bVarArr[0], screenOfferingType2);
                    i11 |= 1;
                } else if (iW == 1) {
                    str4 = (String) cVarB.n(descriptor2, 1, w1.f8244a, str4);
                    i11 |= 2;
                } else {
                    if (iW != 2) {
                        throw new m(iW);
                    }
                    str5 = (String) cVarB.n(descriptor2, 2, w1.f8244a, str5);
                    i11 |= 4;
                }
            }
            i10 = i11;
            screenOfferingType = screenOfferingType2;
            str = str4;
            str2 = str5;
        }
        cVarB.c(descriptor2);
        return new CustomerCenterConfigData.ScreenOffering(i10, screenOfferingType, str, str2, (s1) null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, CustomerCenterConfigData.ScreenOffering value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        CustomerCenterConfigData.ScreenOffering.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
