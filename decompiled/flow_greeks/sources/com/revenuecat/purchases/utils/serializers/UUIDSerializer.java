package com.revenuecat.purchases.utils.serializers;

import bh.d;
import bh.e;
import bh.k;
import ch.f;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/revenuecat/purchases/utils/serializers/UUIDSerializer;", "Lzg/b;", "Ljava/util/UUID;", "<init>", "()V", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Ljava/util/UUID;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Ljava/util/UUID;)V", "Lbh/e;", "descriptor", "Lbh/e;", "getDescriptor", "()Lbh/e;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UUIDSerializer implements b {
    public static final UUIDSerializer INSTANCE = new UUIDSerializer();
    private static final e descriptor = k.b("UUID", d.i.f3379a);

    private UUIDSerializer() {
    }

    @Override // zg.b, zg.k, zg.a
    public e getDescriptor() {
        return descriptor;
    }

    @Override // zg.a
    public UUID deserialize(ch.e decoder) {
        t.f(decoder, "decoder");
        UUID uuidFromString = UUID.fromString(decoder.m());
        t.e(uuidFromString, "fromString(decoder.decodeString())");
        return uuidFromString;
    }

    @Override // zg.k
    public void serialize(f encoder, UUID value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        String string = value.toString();
        t.e(string, "value.toString()");
        encoder.F(string);
    }
}
