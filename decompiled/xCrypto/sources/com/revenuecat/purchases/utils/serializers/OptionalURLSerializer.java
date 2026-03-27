package com.revenuecat.purchases.utils.serializers;

import F3.b;
import G3.a;
import H3.d;
import H3.e;
import H3.h;
import I3.f;
import java.net.MalformedURLException;
import java.net.URL;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class OptionalURLSerializer implements b {
    public static final OptionalURLSerializer INSTANCE = new OptionalURLSerializer();
    private static final b delegate = a.p(URLSerializer.INSTANCE);
    private static final e descriptor = h.a("URL?", d.i.f742a);

    private OptionalURLSerializer() {
    }

    @Override // F3.b, F3.h, F3.a
    public e getDescriptor() {
        return descriptor;
    }

    @Override // F3.a
    public URL deserialize(I3.e decoder) {
        r.f(decoder, "decoder");
        try {
            return (URL) delegate.deserialize(decoder);
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    @Override // F3.h
    public void serialize(f encoder, URL url) {
        r.f(encoder, "encoder");
        if (url == null) {
            encoder.F("");
        } else {
            delegate.serialize(encoder, url);
        }
    }
}
