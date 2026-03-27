package com.revenuecat.purchases.utils.serializers;

import java.net.URL;
import kotlin.jvm.internal.r;
import n6.b;
import p6.d;
import p6.e;
import p6.h;
import q6.f;

/* JADX INFO: loaded from: classes2.dex */
public final class URLSerializer implements b {
    public static final URLSerializer INSTANCE = new URLSerializer();
    private static final e descriptor = h.a("URL", d.i.f22070a);

    private URLSerializer() {
    }

    @Override // n6.b, n6.h, n6.a
    public e getDescriptor() {
        return descriptor;
    }

    @Override // n6.a
    public URL deserialize(q6.e decoder) {
        r.f(decoder, "decoder");
        return new URL(decoder.o());
    }

    @Override // n6.h
    public void serialize(f encoder, URL value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        String string = value.toString();
        r.e(string, "value.toString()");
        encoder.F(string);
    }
}
