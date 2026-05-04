package com.revenuecat.purchases.paywalls.components;

import ah.a;
import ch.c;
import ch.d;
import ch.e;
import ch.f;
import com.revenuecat.purchases.paywalls.components.CarouselComponent;
import dh.e0;
import dh.j0;
import dh.j1;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/paywalls/components/CarouselComponent.AutoAdvancePages.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CarouselComponent$AutoAdvancePages$$serializer implements e0 {
    public static final CarouselComponent$AutoAdvancePages$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        CarouselComponent$AutoAdvancePages$$serializer carouselComponent$AutoAdvancePages$$serializer = new CarouselComponent$AutoAdvancePages$$serializer();
        INSTANCE = carouselComponent$AutoAdvancePages$$serializer;
        j1 j1Var = new j1("com.revenuecat.purchases.paywalls.components.CarouselComponent.AutoAdvancePages", carouselComponent$AutoAdvancePages$$serializer, 3);
        j1Var.g("ms_time_per_page", false);
        j1Var.g("ms_transition_time", false);
        j1Var.g("transition_type", false);
        descriptor = j1Var;
    }

    private CarouselComponent$AutoAdvancePages$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        b bVarP = a.p(CarouselTransitionTypeDeserializer.INSTANCE);
        j0 j0Var = j0.f8162a;
        return new b[]{j0Var, j0Var, bVarP};
    }

    @Override // zg.a
    public CarouselComponent.AutoAdvancePages deserialize(e decoder) {
        int iC;
        int i10;
        int i11;
        CarouselComponent.AutoAdvancePages.TransitionType transitionType;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        if (cVarB.z()) {
            iC = cVarB.C(descriptor2, 0);
            int iC2 = cVarB.C(descriptor2, 1);
            transitionType = (CarouselComponent.AutoAdvancePages.TransitionType) cVarB.n(descriptor2, 2, CarouselTransitionTypeDeserializer.INSTANCE, null);
            i10 = iC2;
            i11 = 7;
        } else {
            boolean z10 = true;
            iC = 0;
            int i12 = 0;
            CarouselComponent.AutoAdvancePages.TransitionType transitionType2 = null;
            int iC3 = 0;
            while (z10) {
                int iW = cVarB.w(descriptor2);
                if (iW == -1) {
                    z10 = false;
                } else if (iW == 0) {
                    iC = cVarB.C(descriptor2, 0);
                    i12 |= 1;
                } else if (iW == 1) {
                    iC3 = cVarB.C(descriptor2, 1);
                    i12 |= 2;
                } else {
                    if (iW != 2) {
                        throw new m(iW);
                    }
                    transitionType2 = (CarouselComponent.AutoAdvancePages.TransitionType) cVarB.n(descriptor2, 2, CarouselTransitionTypeDeserializer.INSTANCE, transitionType2);
                    i12 |= 4;
                }
            }
            i10 = iC3;
            i11 = i12;
            transitionType = transitionType2;
        }
        int i13 = iC;
        cVarB.c(descriptor2);
        return new CarouselComponent.AutoAdvancePages(i11, i13, i10, transitionType, null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, CarouselComponent.AutoAdvancePages value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        CarouselComponent.AutoAdvancePages.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
