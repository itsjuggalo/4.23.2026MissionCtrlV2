package com.revenuecat.purchases.paywalls.components.common;

import F3.b;
import F3.j;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.C;
import J3.C0327b0;
import J3.k0;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.paywalls.components.PartialComponent;
import java.util.List;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class ComponentOverride$$serializer<T> implements C {
    private final /* synthetic */ C0327b0 descriptor;
    private final /* synthetic */ b typeSerial0;

    private ComponentOverride$$serializer() {
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.components.common.ComponentOverride", this, 2);
        c0327b0.l("conditions", false);
        c0327b0.l(DiagnosticsEntry.PROPERTIES_KEY, false);
        this.descriptor = c0327b0;
    }

    private final b getTypeSerial0() {
        return this.typeSerial0;
    }

    @Override // J3.C
    public b[] childSerializers() {
        return new b[]{ComponentOverride.$childSerializers[0], this.typeSerial0};
    }

    @Override // F3.a
    public ComponentOverride<T> deserialize(e decoder) {
        Object objM;
        Object objM2;
        int i4;
        r.f(decoder, "decoder");
        H3.e descriptor = getDescriptor();
        c cVarD = decoder.d(descriptor);
        b[] bVarArr = ComponentOverride.$childSerializers;
        k0 k0Var = null;
        if (cVarD.w()) {
            objM = cVarD.m(descriptor, 0, bVarArr[0], null);
            objM2 = cVarD.m(descriptor, 1, this.typeSerial0, null);
            i4 = 3;
        } else {
            boolean z4 = true;
            int i5 = 0;
            Object objM3 = null;
            Object objM4 = null;
            while (z4) {
                int i6 = cVarD.i(descriptor);
                if (i6 == -1) {
                    z4 = false;
                } else if (i6 == 0) {
                    objM3 = cVarD.m(descriptor, 0, bVarArr[0], objM3);
                    i5 |= 1;
                } else {
                    if (i6 != 1) {
                        throw new j(i6);
                    }
                    objM4 = cVarD.m(descriptor, 1, this.typeSerial0, objM4);
                    i5 |= 2;
                }
            }
            objM = objM3;
            objM2 = objM4;
            i4 = i5;
        }
        cVarD.c(descriptor);
        return new ComponentOverride<>(i4, (List) objM, (PartialComponent) objM2, k0Var);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return this.descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, ComponentOverride<T> value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor = getDescriptor();
        d dVarD = encoder.d(descriptor);
        ComponentOverride.write$Self(value, dVarD, descriptor, this.typeSerial0);
        dVarD.c(descriptor);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return new b[]{this.typeSerial0};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ComponentOverride$$serializer(b typeSerial0) {
        this();
        r.f(typeSerial0, "typeSerial0");
        this.typeSerial0 = typeSerial0;
    }
}
