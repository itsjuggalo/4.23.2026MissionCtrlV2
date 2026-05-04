package com.revenuecat.purchases.paywalls.events;

import ch.c;
import ch.d;
import ch.e;
import ch.f;
import com.revenuecat.purchases.paywalls.events.PaywallEvent;
import dh.e0;
import dh.j1;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/paywalls/events/PaywallEvent.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/paywalls/events/PaywallEvent;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/paywalls/events/PaywallEvent;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/paywalls/events/PaywallEvent;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PaywallEvent$$serializer implements e0 {
    public static final PaywallEvent$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        PaywallEvent$$serializer paywallEvent$$serializer = new PaywallEvent$$serializer();
        INSTANCE = paywallEvent$$serializer;
        j1 j1Var = new j1("com.revenuecat.purchases.paywalls.events.PaywallEvent", paywallEvent$$serializer, 3);
        j1Var.g("creationData", false);
        j1Var.g("data", false);
        j1Var.g("type", false);
        descriptor = j1Var;
    }

    private PaywallEvent$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        return new b[]{PaywallEvent$CreationData$$serializer.INSTANCE, PaywallEvent$Data$$serializer.INSTANCE, PaywallEvent.$childSerializers[2]};
    }

    @Override // zg.a
    public PaywallEvent deserialize(e decoder) {
        int i10;
        PaywallEvent.CreationData creationData;
        PaywallEvent.Data data;
        PaywallEventType paywallEventType;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        b[] bVarArr = PaywallEvent.$childSerializers;
        PaywallEvent.CreationData creationData2 = null;
        if (cVarB.z()) {
            PaywallEvent.CreationData creationData3 = (PaywallEvent.CreationData) cVarB.h(descriptor2, 0, PaywallEvent$CreationData$$serializer.INSTANCE, null);
            PaywallEvent.Data data2 = (PaywallEvent.Data) cVarB.h(descriptor2, 1, PaywallEvent$Data$$serializer.INSTANCE, null);
            paywallEventType = (PaywallEventType) cVarB.h(descriptor2, 2, bVarArr[2], null);
            creationData = creationData3;
            i10 = 7;
            data = data2;
        } else {
            boolean z10 = true;
            int i11 = 0;
            PaywallEvent.Data data3 = null;
            PaywallEventType paywallEventType2 = null;
            while (z10) {
                int iW = cVarB.w(descriptor2);
                if (iW == -1) {
                    z10 = false;
                } else if (iW == 0) {
                    creationData2 = (PaywallEvent.CreationData) cVarB.h(descriptor2, 0, PaywallEvent$CreationData$$serializer.INSTANCE, creationData2);
                    i11 |= 1;
                } else if (iW == 1) {
                    data3 = (PaywallEvent.Data) cVarB.h(descriptor2, 1, PaywallEvent$Data$$serializer.INSTANCE, data3);
                    i11 |= 2;
                } else {
                    if (iW != 2) {
                        throw new m(iW);
                    }
                    paywallEventType2 = (PaywallEventType) cVarB.h(descriptor2, 2, bVarArr[2], paywallEventType2);
                    i11 |= 4;
                }
            }
            i10 = i11;
            creationData = creationData2;
            data = data3;
            paywallEventType = paywallEventType2;
        }
        cVarB.c(descriptor2);
        return new PaywallEvent(i10, creationData, data, paywallEventType, null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, PaywallEvent value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        PaywallEvent.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
