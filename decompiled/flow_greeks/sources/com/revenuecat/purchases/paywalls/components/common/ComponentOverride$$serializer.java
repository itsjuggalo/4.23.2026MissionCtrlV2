package com.revenuecat.purchases.paywalls.components.common;

import ch.c;
import ch.d;
import ch.e;
import ch.f;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.paywalls.components.PartialComponent;
import dh.e0;
import dh.j1;
import dh.s1;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000*\u0004\b\u0001\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0017\b\u0017\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u001a\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ&\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u000bR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00068BXÂ\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00198VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"com/revenuecat/purchases/paywalls/components/common/ComponentOverride.$serializer", "T", "Ldh/e0;", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride;", "<init>", "()V", "Lzg/b;", "typeSerial0", "(Lzg/b;)V", "", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride;)V", "typeParametersSerializers", "getTypeSerial0", "()Lzg/b;", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ComponentOverride$$serializer<T> implements e0 {
    private final /* synthetic */ j1 descriptor;
    private final /* synthetic */ b typeSerial0;

    private ComponentOverride$$serializer() {
        j1 j1Var = new j1("com.revenuecat.purchases.paywalls.components.common.ComponentOverride", this, 2);
        j1Var.g("conditions", false);
        j1Var.g(DiagnosticsEntry.PROPERTIES_KEY, false);
        this.descriptor = j1Var;
    }

    private final b getTypeSerial0() {
        return this.typeSerial0;
    }

    @Override // dh.e0
    public b[] childSerializers() {
        return new b[]{ComponentOverride.$childSerializers[0], this.typeSerial0};
    }

    @Override // zg.a
    public ComponentOverride<T> deserialize(e decoder) {
        List list;
        PartialComponent partialComponent;
        int i10;
        t.f(decoder, "decoder");
        bh.e descriptor = getDescriptor();
        c cVarB = decoder.b(descriptor);
        b[] bVarArr = ComponentOverride.$childSerializers;
        s1 s1Var = null;
        if (cVarB.z()) {
            list = (List) cVarB.h(descriptor, 0, bVarArr[0], null);
            partialComponent = (PartialComponent) cVarB.h(descriptor, 1, this.typeSerial0, null);
            i10 = 3;
        } else {
            boolean z10 = true;
            int i11 = 0;
            List list2 = null;
            PartialComponent partialComponent2 = null;
            while (z10) {
                int iW = cVarB.w(descriptor);
                if (iW == -1) {
                    z10 = false;
                } else if (iW == 0) {
                    list2 = (List) cVarB.h(descriptor, 0, bVarArr[0], list2);
                    i11 |= 1;
                } else {
                    if (iW != 1) {
                        throw new m(iW);
                    }
                    partialComponent2 = (PartialComponent) cVarB.h(descriptor, 1, this.typeSerial0, partialComponent2);
                    i11 |= 2;
                }
            }
            list = list2;
            partialComponent = partialComponent2;
            i10 = i11;
        }
        cVarB.c(descriptor);
        return new ComponentOverride<>(i10, list, partialComponent, s1Var);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return this.descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, ComponentOverride<T> value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor = getDescriptor();
        d dVarB = encoder.b(descriptor);
        ComponentOverride.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor, this.typeSerial0);
        dVarB.c(descriptor);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return new b[]{this.typeSerial0};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ComponentOverride$$serializer(b typeSerial0) {
        this();
        t.f(typeSerial0, "typeSerial0");
        this.typeSerial0 = typeSerial0;
    }
}
