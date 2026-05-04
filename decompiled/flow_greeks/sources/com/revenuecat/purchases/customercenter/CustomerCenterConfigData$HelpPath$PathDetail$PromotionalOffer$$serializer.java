package com.revenuecat.purchases.customercenter;

import ch.c;
import ch.d;
import ch.e;
import ch.f;
import com.amazon.a.a.o.b;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import dh.e0;
import dh.h;
import dh.j1;
import dh.s1;
import dh.w1;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/customercenter/CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer implements e0 {
    public static final CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer customerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer = new CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer();
        INSTANCE = customerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer;
        j1 j1Var = new j1("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer", customerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer, 6);
        j1Var.g("android_offer_id", false);
        j1Var.g("eligible", false);
        j1Var.g(b.S, false);
        j1Var.g("subtitle", false);
        j1Var.g("product_mapping", false);
        j1Var.g("cross_product_promotions", true);
        descriptor = j1Var;
    }

    private CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer() {
    }

    @Override // dh.e0
    public zg.b[] childSerializers() {
        zg.b[] bVarArr = CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer.$childSerializers;
        zg.b bVar = bVarArr[4];
        zg.b bVar2 = bVarArr[5];
        w1 w1Var = w1.f8244a;
        return new zg.b[]{w1Var, h.f8149a, w1Var, w1Var, bVar, bVar2};
    }

    @Override // zg.a
    public CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer deserialize(e decoder) {
        int i10;
        boolean z10;
        String str;
        String str2;
        String str3;
        Map map;
        Map map2;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        zg.b[] bVarArr = CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer.$childSerializers;
        if (cVarB.z()) {
            String strS = cVarB.s(descriptor2, 0);
            boolean zB = cVarB.B(descriptor2, 1);
            String strS2 = cVarB.s(descriptor2, 2);
            String strS3 = cVarB.s(descriptor2, 3);
            Map map3 = (Map) cVarB.h(descriptor2, 4, bVarArr[4], null);
            map2 = (Map) cVarB.h(descriptor2, 5, bVarArr[5], null);
            str = strS;
            str3 = strS3;
            str2 = strS2;
            i10 = 63;
            map = map3;
            z10 = zB;
        } else {
            boolean z11 = true;
            int i11 = 0;
            String strS4 = null;
            String strS5 = null;
            String strS6 = null;
            Map map4 = null;
            Map map5 = null;
            boolean zB2 = false;
            while (z11) {
                int iW = cVarB.w(descriptor2);
                switch (iW) {
                    case -1:
                        z11 = false;
                        continue;
                    case 0:
                        strS4 = cVarB.s(descriptor2, 0);
                        i11 |= 1;
                        continue;
                    case 1:
                        zB2 = cVarB.B(descriptor2, 1);
                        i11 |= 2;
                        break;
                    case 2:
                        strS5 = cVarB.s(descriptor2, 2);
                        i11 |= 4;
                        break;
                    case 3:
                        strS6 = cVarB.s(descriptor2, 3);
                        i11 |= 8;
                        break;
                    case 4:
                        map4 = (Map) cVarB.h(descriptor2, 4, bVarArr[4], map4);
                        i11 |= 16;
                        break;
                    case 5:
                        map5 = (Map) cVarB.h(descriptor2, 5, bVarArr[5], map5);
                        i11 |= 32;
                        break;
                    default:
                        throw new m(iW);
                }
            }
            i10 = i11;
            z10 = zB2;
            str = strS4;
            str2 = strS5;
            str3 = strS6;
            map = map4;
            map2 = map5;
        }
        cVarB.c(descriptor2);
        return new CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer(i10, str, z10, str2, str3, map, map2, (s1) null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public zg.b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
