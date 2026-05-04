package com.revenuecat.purchases.virtualcurrencies;

import ah.a;
import ch.c;
import ch.d;
import ch.e;
import ch.f;
import com.amazon.a.a.o.b;
import dh.e0;
import dh.j0;
import dh.j1;
import dh.s1;
import dh.w1;
import io.flutter.plugins.firebase.database.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/virtualcurrencies/VirtualCurrency.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrency;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrency;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrency;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VirtualCurrency$$serializer implements e0 {
    public static final VirtualCurrency$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        VirtualCurrency$$serializer virtualCurrency$$serializer = new VirtualCurrency$$serializer();
        INSTANCE = virtualCurrency$$serializer;
        j1 j1Var = new j1("com.revenuecat.purchases.virtualcurrencies.VirtualCurrency", virtualCurrency$$serializer, 4);
        j1Var.g("balance", false);
        j1Var.g("name", false);
        j1Var.g(Constants.ERROR_CODE, false);
        j1Var.g(b.f4549c, true);
        descriptor = j1Var;
    }

    private VirtualCurrency$$serializer() {
    }

    @Override // dh.e0
    public zg.b[] childSerializers() {
        w1 w1Var = w1.f8244a;
        return new zg.b[]{j0.f8162a, w1Var, w1Var, a.p(w1Var)};
    }

    @Override // zg.a
    public VirtualCurrency deserialize(e decoder) {
        int iC;
        int i10;
        String str;
        String str2;
        String str3;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        if (cVarB.z()) {
            iC = cVarB.C(descriptor2, 0);
            String strS = cVarB.s(descriptor2, 1);
            String strS2 = cVarB.s(descriptor2, 2);
            str3 = (String) cVarB.n(descriptor2, 3, w1.f8244a, null);
            str2 = strS2;
            str = strS;
            i10 = 15;
        } else {
            boolean z10 = true;
            iC = 0;
            String strS3 = null;
            String strS4 = null;
            String str4 = null;
            int i11 = 0;
            while (z10) {
                int iW = cVarB.w(descriptor2);
                if (iW == -1) {
                    z10 = false;
                } else if (iW == 0) {
                    iC = cVarB.C(descriptor2, 0);
                    i11 |= 1;
                } else if (iW == 1) {
                    strS3 = cVarB.s(descriptor2, 1);
                    i11 |= 2;
                } else if (iW == 2) {
                    strS4 = cVarB.s(descriptor2, 2);
                    i11 |= 4;
                } else {
                    if (iW != 3) {
                        throw new m(iW);
                    }
                    str4 = (String) cVarB.n(descriptor2, 3, w1.f8244a, str4);
                    i11 |= 8;
                }
            }
            i10 = i11;
            str = strS3;
            str2 = strS4;
            str3 = str4;
        }
        int i12 = iC;
        cVarB.c(descriptor2);
        return new VirtualCurrency(i10, i12, str, str2, str3, (s1) null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, VirtualCurrency value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        VirtualCurrency.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public zg.b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
