package com.revenuecat.purchases.paywalls;

import ch.c;
import ch.d;
import ch.e;
import ch.f;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.paywalls.PaywallData;
import dh.e0;
import dh.j1;
import dh.w1;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/paywalls/PaywallData.Configuration.Tier.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Tier;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Tier;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Tier;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PaywallData$Configuration$Tier$$serializer implements e0 {
    public static final PaywallData$Configuration$Tier$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        PaywallData$Configuration$Tier$$serializer paywallData$Configuration$Tier$$serializer = new PaywallData$Configuration$Tier$$serializer();
        INSTANCE = paywallData$Configuration$Tier$$serializer;
        j1 j1Var = new j1("com.revenuecat.purchases.paywalls.PaywallData.Configuration.Tier", paywallData$Configuration$Tier$$serializer, 3);
        j1Var.g(DiagnosticsEntry.ID_KEY, false);
        j1Var.g("packages", false);
        j1Var.g("default_package", false);
        descriptor = j1Var;
    }

    private PaywallData$Configuration$Tier$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        b bVar = PaywallData.Configuration.Tier.$childSerializers[1];
        w1 w1Var = w1.f8244a;
        return new b[]{w1Var, bVar, w1Var};
    }

    @Override // zg.a
    public PaywallData.Configuration.Tier deserialize(e decoder) {
        int i10;
        String str;
        List list;
        String strS;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        b[] bVarArr = PaywallData.Configuration.Tier.$childSerializers;
        String strS2 = null;
        if (cVarB.z()) {
            String strS3 = cVarB.s(descriptor2, 0);
            list = (List) cVarB.h(descriptor2, 1, bVarArr[1], null);
            str = strS3;
            strS = cVarB.s(descriptor2, 2);
            i10 = 7;
        } else {
            boolean z10 = true;
            int i11 = 0;
            List list2 = null;
            String strS4 = null;
            while (z10) {
                int iW = cVarB.w(descriptor2);
                if (iW == -1) {
                    z10 = false;
                } else if (iW == 0) {
                    strS2 = cVarB.s(descriptor2, 0);
                    i11 |= 1;
                } else if (iW == 1) {
                    list2 = (List) cVarB.h(descriptor2, 1, bVarArr[1], list2);
                    i11 |= 2;
                } else {
                    if (iW != 2) {
                        throw new m(iW);
                    }
                    strS4 = cVarB.s(descriptor2, 2);
                    i11 |= 4;
                }
            }
            i10 = i11;
            str = strS2;
            list = list2;
            strS = strS4;
        }
        cVarB.c(descriptor2);
        return new PaywallData.Configuration.Tier(i10, str, list, strS, null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, PaywallData.Configuration.Tier value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        PaywallData.Configuration.Tier.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
