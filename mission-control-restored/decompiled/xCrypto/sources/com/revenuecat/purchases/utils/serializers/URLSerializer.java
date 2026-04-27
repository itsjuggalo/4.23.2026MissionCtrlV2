package com.revenuecat.purchases.utils.serializers;

import F3.b;
import H3.d;
import H3.e;
import H3.h;
import I3.f;
import java.net.URL;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class URLSerializer implements b {
    public static final URLSerializer INSTANCE = new URLSerializer();
    private static final e descriptor = h.a("URL", d.i.f742a);

    private URLSerializer() {
    }

    @Override // F3.b, F3.h, F3.a
    public e getDescriptor() {
        return descriptor;
    }

    @Override // F3.a
    public URL deserialize(I3.e decoder) {
        r.f(decoder, "decoder");
        return new URL(decoder.q());
    }

    @Override // F3.h
    public void serialize(f encoder, URL value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        String string = value.toString();
        r.e(string, "value.toString()");
        encoder.F(string);
    }
}
