package com.revenuecat.purchases.paywalls.components;

import ah.a;
import ch.c;
import ch.d;
import ch.e;
import ch.f;
import com.revenuecat.purchases.paywalls.components.PaywallTransition;
import dh.e0;
import dh.j1;
import dh.s1;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/paywalls/components/PaywallTransition.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/paywalls/components/PaywallTransition;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/paywalls/components/PaywallTransition;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/paywalls/components/PaywallTransition;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PaywallTransition$$serializer implements e0 {
    public static final PaywallTransition$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        PaywallTransition$$serializer paywallTransition$$serializer = new PaywallTransition$$serializer();
        INSTANCE = paywallTransition$$serializer;
        j1 j1Var = new j1("com.revenuecat.purchases.paywalls.components.PaywallTransition", paywallTransition$$serializer, 3);
        j1Var.g("type", true);
        j1Var.g("displacement_strategy", false);
        j1Var.g("animation", true);
        descriptor = j1Var;
    }

    private PaywallTransition$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        return new b[]{TransitionTypeSerializer.INSTANCE, DisplacementStrategyDeserializer.INSTANCE, a.p(PaywallAnimation$$serializer.INSTANCE)};
    }

    @Override // zg.a
    public PaywallTransition deserialize(e decoder) {
        int i10;
        PaywallTransition.TransitionType transitionType;
        PaywallTransition.DisplacementStrategy displacementStrategy;
        PaywallAnimation paywallAnimation;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        PaywallTransition.TransitionType transitionType2 = null;
        if (cVarB.z()) {
            PaywallTransition.TransitionType transitionType3 = (PaywallTransition.TransitionType) cVarB.h(descriptor2, 0, TransitionTypeSerializer.INSTANCE, null);
            PaywallTransition.DisplacementStrategy displacementStrategy2 = (PaywallTransition.DisplacementStrategy) cVarB.h(descriptor2, 1, DisplacementStrategyDeserializer.INSTANCE, null);
            transitionType = transitionType3;
            paywallAnimation = (PaywallAnimation) cVarB.n(descriptor2, 2, PaywallAnimation$$serializer.INSTANCE, null);
            displacementStrategy = displacementStrategy2;
            i10 = 7;
        } else {
            boolean z10 = true;
            int i11 = 0;
            PaywallTransition.DisplacementStrategy displacementStrategy3 = null;
            PaywallAnimation paywallAnimation2 = null;
            while (z10) {
                int iW = cVarB.w(descriptor2);
                if (iW == -1) {
                    z10 = false;
                } else if (iW == 0) {
                    transitionType2 = (PaywallTransition.TransitionType) cVarB.h(descriptor2, 0, TransitionTypeSerializer.INSTANCE, transitionType2);
                    i11 |= 1;
                } else if (iW == 1) {
                    displacementStrategy3 = (PaywallTransition.DisplacementStrategy) cVarB.h(descriptor2, 1, DisplacementStrategyDeserializer.INSTANCE, displacementStrategy3);
                    i11 |= 2;
                } else {
                    if (iW != 2) {
                        throw new m(iW);
                    }
                    paywallAnimation2 = (PaywallAnimation) cVarB.n(descriptor2, 2, PaywallAnimation$$serializer.INSTANCE, paywallAnimation2);
                    i11 |= 4;
                }
            }
            i10 = i11;
            transitionType = transitionType2;
            displacementStrategy = displacementStrategy3;
            paywallAnimation = paywallAnimation2;
        }
        cVarB.c(descriptor2);
        return new PaywallTransition(i10, transitionType, displacementStrategy, paywallAnimation, (s1) null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, PaywallTransition value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        PaywallTransition.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
