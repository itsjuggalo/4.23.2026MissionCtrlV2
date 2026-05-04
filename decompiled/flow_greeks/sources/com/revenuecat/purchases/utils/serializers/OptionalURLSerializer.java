package com.revenuecat.purchases.utils.serializers;

import ah.a;
import bh.d;
import bh.e;
import bh.k;
import ch.f;
import java.net.MalformedURLException;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u00118\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/revenuecat/purchases/utils/serializers/OptionalURLSerializer;", "Lzg/b;", "Ljava/net/URL;", "<init>", "()V", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Ljava/net/URL;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Ljava/net/URL;)V", "delegate", "Lzg/b;", "Lbh/e;", "descriptor", "Lbh/e;", "getDescriptor", "()Lbh/e;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OptionalURLSerializer implements b {
    public static final OptionalURLSerializer INSTANCE = new OptionalURLSerializer();
    private static final b delegate = a.p(URLSerializer.INSTANCE);
    private static final e descriptor = k.b("URL?", d.i.f3379a);

    private OptionalURLSerializer() {
    }

    @Override // zg.b, zg.k, zg.a
    public e getDescriptor() {
        return descriptor;
    }

    @Override // zg.a
    public URL deserialize(ch.e decoder) {
        t.f(decoder, "decoder");
        try {
            return (URL) delegate.deserialize(decoder);
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    @Override // zg.k
    public void serialize(f encoder, URL value) {
        t.f(encoder, "encoder");
        if (value == null) {
            encoder.F("");
        } else {
            delegate.serialize(encoder, value);
        }
    }
}
