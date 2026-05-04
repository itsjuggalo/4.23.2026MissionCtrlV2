package com.revenuecat.purchases.models;

import ch.c;
import ch.d;
import ch.e;
import ch.f;
import com.revenuecat.purchases.models.Checksum;
import dh.e0;
import dh.j1;
import dh.w1;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/models/Checksum.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/models/Checksum;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/models/Checksum;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/models/Checksum;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Checksum$$serializer implements e0 {
    public static final Checksum$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        Checksum$$serializer checksum$$serializer = new Checksum$$serializer();
        INSTANCE = checksum$$serializer;
        j1 j1Var = new j1("com.revenuecat.purchases.models.Checksum", checksum$$serializer, 2);
        j1Var.g("algo", false);
        j1Var.g("value", false);
        descriptor = j1Var;
    }

    private Checksum$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        return new b[]{Checksum.$childSerializers[0], w1.f8244a};
    }

    @Override // zg.a
    public Checksum deserialize(e decoder) {
        Checksum.Algorithm algorithm;
        String strS;
        int i10;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        b[] bVarArr = Checksum.$childSerializers;
        if (cVarB.z()) {
            algorithm = (Checksum.Algorithm) cVarB.h(descriptor2, 0, bVarArr[0], null);
            strS = cVarB.s(descriptor2, 1);
            i10 = 3;
        } else {
            boolean z10 = true;
            int i11 = 0;
            Checksum.Algorithm algorithm2 = null;
            String strS2 = null;
            while (z10) {
                int iW = cVarB.w(descriptor2);
                if (iW == -1) {
                    z10 = false;
                } else if (iW == 0) {
                    algorithm2 = (Checksum.Algorithm) cVarB.h(descriptor2, 0, bVarArr[0], algorithm2);
                    i11 |= 1;
                } else {
                    if (iW != 1) {
                        throw new m(iW);
                    }
                    strS2 = cVarB.s(descriptor2, 1);
                    i11 |= 2;
                }
            }
            algorithm = algorithm2;
            strS = strS2;
            i10 = i11;
        }
        cVarB.c(descriptor2);
        return new Checksum(i10, algorithm, strS, null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, Checksum value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        Checksum.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
