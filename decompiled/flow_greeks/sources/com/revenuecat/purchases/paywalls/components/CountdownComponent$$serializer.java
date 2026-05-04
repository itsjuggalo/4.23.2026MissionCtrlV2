package com.revenuecat.purchases.paywalls.components;

import ah.a;
import ch.c;
import ch.d;
import ch.e;
import ch.f;
import com.revenuecat.purchases.paywalls.components.CountdownComponent;
import dh.e0;
import dh.j1;
import dh.s1;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/paywalls/components/CountdownComponent.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/paywalls/components/CountdownComponent;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/paywalls/components/CountdownComponent;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/paywalls/components/CountdownComponent;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CountdownComponent$$serializer implements e0 {
    public static final CountdownComponent$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        CountdownComponent$$serializer countdownComponent$$serializer = new CountdownComponent$$serializer();
        INSTANCE = countdownComponent$$serializer;
        j1 j1Var = new j1("countdown", countdownComponent$$serializer, 5);
        j1Var.g("style", false);
        j1Var.g("count_from", true);
        j1Var.g("countdown_stack", false);
        j1Var.g("end_stack", true);
        j1Var.g("fallback", true);
        descriptor = j1Var;
    }

    private CountdownComponent$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        b bVar = CountdownComponent.$childSerializers[1];
        StackComponent$$serializer stackComponent$$serializer = StackComponent$$serializer.INSTANCE;
        return new b[]{CountdownComponent$CountdownStyle$$serializer.INSTANCE, bVar, stackComponent$$serializer, a.p(stackComponent$$serializer), a.p(stackComponent$$serializer)};
    }

    @Override // zg.a
    public CountdownComponent deserialize(e decoder) {
        int i10;
        CountdownComponent.CountdownStyle countdownStyle;
        CountdownComponent.CountFrom countFrom;
        StackComponent stackComponent;
        StackComponent stackComponent2;
        StackComponent stackComponent3;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        b[] bVarArr = CountdownComponent.$childSerializers;
        CountdownComponent.CountdownStyle countdownStyle2 = null;
        if (cVarB.z()) {
            CountdownComponent.CountdownStyle countdownStyle3 = (CountdownComponent.CountdownStyle) cVarB.h(descriptor2, 0, CountdownComponent$CountdownStyle$$serializer.INSTANCE, null);
            CountdownComponent.CountFrom countFrom2 = (CountdownComponent.CountFrom) cVarB.h(descriptor2, 1, bVarArr[1], null);
            StackComponent$$serializer stackComponent$$serializer = StackComponent$$serializer.INSTANCE;
            StackComponent stackComponent4 = (StackComponent) cVarB.h(descriptor2, 2, stackComponent$$serializer, null);
            countFrom = countFrom2;
            countdownStyle = countdownStyle3;
            stackComponent2 = (StackComponent) cVarB.n(descriptor2, 3, stackComponent$$serializer, null);
            stackComponent3 = (StackComponent) cVarB.n(descriptor2, 4, stackComponent$$serializer, null);
            stackComponent = stackComponent4;
            i10 = 31;
        } else {
            boolean z10 = true;
            int i11 = 0;
            CountdownComponent.CountFrom countFrom3 = null;
            StackComponent stackComponent5 = null;
            StackComponent stackComponent6 = null;
            StackComponent stackComponent7 = null;
            while (z10) {
                int iW = cVarB.w(descriptor2);
                if (iW == -1) {
                    z10 = false;
                } else if (iW == 0) {
                    countdownStyle2 = (CountdownComponent.CountdownStyle) cVarB.h(descriptor2, 0, CountdownComponent$CountdownStyle$$serializer.INSTANCE, countdownStyle2);
                    i11 |= 1;
                } else if (iW == 1) {
                    countFrom3 = (CountdownComponent.CountFrom) cVarB.h(descriptor2, 1, bVarArr[1], countFrom3);
                    i11 |= 2;
                } else if (iW == 2) {
                    stackComponent5 = (StackComponent) cVarB.h(descriptor2, 2, StackComponent$$serializer.INSTANCE, stackComponent5);
                    i11 |= 4;
                } else if (iW == 3) {
                    stackComponent6 = (StackComponent) cVarB.n(descriptor2, 3, StackComponent$$serializer.INSTANCE, stackComponent6);
                    i11 |= 8;
                } else {
                    if (iW != 4) {
                        throw new m(iW);
                    }
                    stackComponent7 = (StackComponent) cVarB.n(descriptor2, 4, StackComponent$$serializer.INSTANCE, stackComponent7);
                    i11 |= 16;
                }
            }
            i10 = i11;
            countdownStyle = countdownStyle2;
            countFrom = countFrom3;
            stackComponent = stackComponent5;
            stackComponent2 = stackComponent6;
            stackComponent3 = stackComponent7;
        }
        cVarB.c(descriptor2);
        return new CountdownComponent(i10, countdownStyle, countFrom, stackComponent, stackComponent2, stackComponent3, (s1) null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, CountdownComponent value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        CountdownComponent.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
