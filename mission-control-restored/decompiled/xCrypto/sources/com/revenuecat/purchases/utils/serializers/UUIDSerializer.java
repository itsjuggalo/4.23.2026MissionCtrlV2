package com.revenuecat.purchases.utils.serializers;

import F3.b;
import H3.d;
import H3.e;
import H3.h;
import I3.f;
import java.util.UUID;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class UUIDSerializer implements b {
    public static final UUIDSerializer INSTANCE = new UUIDSerializer();
    private static final e descriptor = h.a("UUID", d.i.f742a);

    private UUIDSerializer() {
    }

    @Override // F3.b, F3.h, F3.a
    public e getDescriptor() {
        return descriptor;
    }

    @Override // F3.a
    public UUID deserialize(I3.e decoder) {
        r.f(decoder, "decoder");
        UUID uuidFromString = UUID.fromString(decoder.q());
        r.e(uuidFromString, "fromString(decoder.decodeString())");
        return uuidFromString;
    }

    @Override // F3.h
    public void serialize(f encoder, UUID value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        String string = value.toString();
        r.e(string, "value.toString()");
        encoder.F(string);
    }
}
