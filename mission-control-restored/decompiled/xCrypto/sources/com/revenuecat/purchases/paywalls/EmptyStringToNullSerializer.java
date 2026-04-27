package com.revenuecat.purchases.paywalls;

import F3.b;
import H3.d;
import H3.e;
import H3.h;
import I3.f;
import kotlin.jvm.internal.J;
import kotlin.jvm.internal.r;
import r3.AbstractC1753A;

/* JADX INFO: loaded from: classes3.dex */
public final class EmptyStringToNullSerializer implements b {
    public static final EmptyStringToNullSerializer INSTANCE = new EmptyStringToNullSerializer();
    private static final b delegate = G3.a.p(G3.a.D(J.f13414a));
    private static final e descriptor = h.a("EmptyStringToNullSerializer", d.i.f742a);

    private EmptyStringToNullSerializer() {
    }

    @Override // F3.b, F3.h, F3.a
    public e getDescriptor() {
        return descriptor;
    }

    @Override // F3.a
    public String deserialize(I3.e decoder) {
        r.f(decoder, "decoder");
        String str = (String) delegate.deserialize(decoder);
        if (str == null || AbstractC1753A.U(str)) {
            return null;
        }
        return str;
    }

    @Override // F3.h
    public void serialize(f encoder, String str) {
        r.f(encoder, "encoder");
        if (str == null) {
            encoder.F("");
        } else {
            encoder.F(str);
        }
    }
}
