package com.revenuecat.purchases.paywalls.components;

import ah.a;
import ch.c;
import ch.d;
import ch.e;
import ch.f;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.paywalls.components.ButtonComponent;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import dh.e0;
import dh.h;
import dh.j1;
import dh.w1;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/paywalls/components/ButtonComponent.Destination.Sheet.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Sheet;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Sheet;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$Destination$Sheet;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ButtonComponent$Destination$Sheet$$serializer implements e0 {
    public static final ButtonComponent$Destination$Sheet$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        ButtonComponent$Destination$Sheet$$serializer buttonComponent$Destination$Sheet$$serializer = new ButtonComponent$Destination$Sheet$$serializer();
        INSTANCE = buttonComponent$Destination$Sheet$$serializer;
        j1 j1Var = new j1("com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination.Sheet", buttonComponent$Destination$Sheet$$serializer, 5);
        j1Var.g(DiagnosticsEntry.ID_KEY, false);
        j1Var.g("name", false);
        j1Var.g("stack", false);
        j1Var.g("background_blur", false);
        j1Var.g("size", false);
        descriptor = j1Var;
    }

    private ButtonComponent$Destination$Sheet$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        w1 w1Var = w1.f8244a;
        return new b[]{w1Var, a.p(w1Var), StackComponent$$serializer.INSTANCE, h.f8149a, a.p(Size$$serializer.INSTANCE)};
    }

    @Override // zg.a
    public ButtonComponent.Destination.Sheet deserialize(e decoder) {
        boolean zB;
        int i10;
        String str;
        String str2;
        StackComponent stackComponent;
        Size size;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        if (cVarB.z()) {
            String strS = cVarB.s(descriptor2, 0);
            String str3 = (String) cVarB.n(descriptor2, 1, w1.f8244a, null);
            StackComponent stackComponent2 = (StackComponent) cVarB.h(descriptor2, 2, StackComponent$$serializer.INSTANCE, null);
            str = strS;
            zB = cVarB.B(descriptor2, 3);
            size = (Size) cVarB.n(descriptor2, 4, Size$$serializer.INSTANCE, null);
            stackComponent = stackComponent2;
            str2 = str3;
            i10 = 31;
        } else {
            boolean z10 = true;
            boolean zB2 = false;
            String strS2 = null;
            String str4 = null;
            StackComponent stackComponent3 = null;
            Size size2 = null;
            int i11 = 0;
            while (z10) {
                int iW = cVarB.w(descriptor2);
                if (iW == -1) {
                    z10 = false;
                } else if (iW == 0) {
                    strS2 = cVarB.s(descriptor2, 0);
                    i11 |= 1;
                } else if (iW == 1) {
                    str4 = (String) cVarB.n(descriptor2, 1, w1.f8244a, str4);
                    i11 |= 2;
                } else if (iW == 2) {
                    stackComponent3 = (StackComponent) cVarB.h(descriptor2, 2, StackComponent$$serializer.INSTANCE, stackComponent3);
                    i11 |= 4;
                } else if (iW == 3) {
                    zB2 = cVarB.B(descriptor2, 3);
                    i11 |= 8;
                } else {
                    if (iW != 4) {
                        throw new m(iW);
                    }
                    size2 = (Size) cVarB.n(descriptor2, 4, Size$$serializer.INSTANCE, size2);
                    i11 |= 16;
                }
            }
            zB = zB2;
            i10 = i11;
            str = strS2;
            str2 = str4;
            stackComponent = stackComponent3;
            size = size2;
        }
        cVarB.c(descriptor2);
        return new ButtonComponent.Destination.Sheet(i10, str, str2, stackComponent, zB, size, null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, ButtonComponent.Destination.Sheet value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        ButtonComponent.Destination.Sheet.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
