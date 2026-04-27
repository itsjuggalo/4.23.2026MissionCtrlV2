package com.revenuecat.purchases.utils.serializers;

import java.net.URL;
import k7.b;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;
import m7.d;
import m7.e;
import m7.k;
import n7.f;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/revenuecat/purchases/utils/serializers/URLSerializer;", "Lk7/b;", "Ljava/net/URL;", "<init>", "()V", "Ln7/e;", "decoder", "deserialize", "(Ln7/e;)Ljava/net/URL;", "Ln7/f;", "encoder", "value", "Lo5/H;", "serialize", "(Ln7/f;Ljava/net/URL;)V", "Lm7/e;", "descriptor", "Lm7/e;", "getDescriptor", "()Lm7/e;", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
public final class URLSerializer implements b {
    public static final URLSerializer INSTANCE = new URLSerializer();
    private static final e descriptor = k.b("URL", d.i.f21508a);

    private URLSerializer() {
    }

    @Override // k7.b, k7.k, k7.a
    public e getDescriptor() {
        return descriptor;
    }

    @Override // k7.a
    public URL deserialize(n7.e decoder) {
        AbstractC2304t.f(decoder, "decoder");
        return new URL(decoder.q());
    }

    @Override // k7.k
    public void serialize(f encoder, URL value) {
        AbstractC2304t.f(encoder, "encoder");
        AbstractC2304t.f(value, "value");
        String string = value.toString();
        AbstractC2304t.e(string, "value.toString()");
        encoder.E(string);
    }
}
