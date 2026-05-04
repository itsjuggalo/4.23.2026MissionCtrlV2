package com.revenuecat.purchases.paywalls.events;

import ch.c;
import ch.d;
import ch.e;
import ch.f;
import dh.e0;
import dh.h;
import dh.j0;
import dh.j1;
import dh.w1;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/paywalls/events/PaywallPostReceiptData.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/paywalls/events/PaywallPostReceiptData;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/paywalls/events/PaywallPostReceiptData;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/paywalls/events/PaywallPostReceiptData;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PaywallPostReceiptData$$serializer implements e0 {
    public static final PaywallPostReceiptData$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        PaywallPostReceiptData$$serializer paywallPostReceiptData$$serializer = new PaywallPostReceiptData$$serializer();
        INSTANCE = paywallPostReceiptData$$serializer;
        j1 j1Var = new j1("com.revenuecat.purchases.paywalls.events.PaywallPostReceiptData", paywallPostReceiptData$$serializer, 6);
        j1Var.g("session_id", false);
        j1Var.g("revision", false);
        j1Var.g("display_mode", false);
        j1Var.g("dark_mode", false);
        j1Var.g("locale", false);
        j1Var.g("offering_id", false);
        descriptor = j1Var;
    }

    private PaywallPostReceiptData$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        w1 w1Var = w1.f8244a;
        return new b[]{w1Var, j0.f8162a, w1Var, h.f8149a, w1Var, w1Var};
    }

    @Override // zg.a
    public PaywallPostReceiptData deserialize(e decoder) {
        String strS;
        String strS2;
        boolean z10;
        String str;
        String str2;
        int i10;
        int i11;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        if (cVarB.z()) {
            strS = cVarB.s(descriptor2, 0);
            int iC = cVarB.C(descriptor2, 1);
            String strS3 = cVarB.s(descriptor2, 2);
            boolean zB = cVarB.B(descriptor2, 3);
            String strS4 = cVarB.s(descriptor2, 4);
            strS2 = cVarB.s(descriptor2, 5);
            z10 = zB;
            str = strS4;
            str2 = strS3;
            i10 = iC;
            i11 = 63;
        } else {
            strS = null;
            String strS5 = null;
            String strS6 = null;
            String strS7 = null;
            boolean z11 = true;
            boolean zB2 = false;
            int iC2 = 0;
            int i12 = 0;
            while (z11) {
                int iW = cVarB.w(descriptor2);
                switch (iW) {
                    case -1:
                        z11 = false;
                        continue;
                    case 0:
                        strS = cVarB.s(descriptor2, 0);
                        i12 |= 1;
                        continue;
                    case 1:
                        iC2 = cVarB.C(descriptor2, 1);
                        i12 |= 2;
                        break;
                    case 2:
                        strS7 = cVarB.s(descriptor2, 2);
                        i12 |= 4;
                        break;
                    case 3:
                        zB2 = cVarB.B(descriptor2, 3);
                        i12 |= 8;
                        break;
                    case 4:
                        strS6 = cVarB.s(descriptor2, 4);
                        i12 |= 16;
                        break;
                    case 5:
                        strS5 = cVarB.s(descriptor2, 5);
                        i12 |= 32;
                        break;
                    default:
                        throw new m(iW);
                }
            }
            strS2 = strS5;
            z10 = zB2;
            str = strS6;
            str2 = strS7;
            i10 = iC2;
            i11 = i12;
        }
        String str3 = strS;
        cVarB.c(descriptor2);
        return new PaywallPostReceiptData(i11, str3, i10, str2, z10, str, strS2, null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, PaywallPostReceiptData value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        PaywallPostReceiptData.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
