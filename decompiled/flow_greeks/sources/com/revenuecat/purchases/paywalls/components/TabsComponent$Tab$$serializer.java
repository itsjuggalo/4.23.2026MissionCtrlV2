package com.revenuecat.purchases.paywalls.components;

import ch.c;
import ch.d;
import ch.e;
import ch.f;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.paywalls.components.TabsComponent;
import dh.e0;
import dh.j1;
import dh.w1;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/paywalls/components/TabsComponent.Tab.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/paywalls/components/TabsComponent$Tab;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/paywalls/components/TabsComponent$Tab;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/paywalls/components/TabsComponent$Tab;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TabsComponent$Tab$$serializer implements e0 {
    public static final TabsComponent$Tab$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        TabsComponent$Tab$$serializer tabsComponent$Tab$$serializer = new TabsComponent$Tab$$serializer();
        INSTANCE = tabsComponent$Tab$$serializer;
        j1 j1Var = new j1("com.revenuecat.purchases.paywalls.components.TabsComponent.Tab", tabsComponent$Tab$$serializer, 2);
        j1Var.g(DiagnosticsEntry.ID_KEY, false);
        j1Var.g("stack", false);
        descriptor = j1Var;
    }

    private TabsComponent$Tab$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        return new b[]{w1.f8244a, StackComponent$$serializer.INSTANCE};
    }

    @Override // zg.a
    public TabsComponent.Tab deserialize(e decoder) {
        String strS;
        StackComponent stackComponent;
        int i10;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        if (cVarB.z()) {
            strS = cVarB.s(descriptor2, 0);
            stackComponent = (StackComponent) cVarB.h(descriptor2, 1, StackComponent$$serializer.INSTANCE, null);
            i10 = 3;
        } else {
            boolean z10 = true;
            int i11 = 0;
            strS = null;
            StackComponent stackComponent2 = null;
            while (z10) {
                int iW = cVarB.w(descriptor2);
                if (iW == -1) {
                    z10 = false;
                } else if (iW == 0) {
                    strS = cVarB.s(descriptor2, 0);
                    i11 |= 1;
                } else {
                    if (iW != 1) {
                        throw new m(iW);
                    }
                    stackComponent2 = (StackComponent) cVarB.h(descriptor2, 1, StackComponent$$serializer.INSTANCE, stackComponent2);
                    i11 |= 2;
                }
            }
            stackComponent = stackComponent2;
            i10 = i11;
        }
        cVarB.c(descriptor2);
        return new TabsComponent.Tab(i10, strS, stackComponent, null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, TabsComponent.Tab value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        TabsComponent.Tab.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
