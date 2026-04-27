package com.revenuecat.purchases.utils.serializers;

import java.util.UUID;
import kotlin.jvm.internal.r;
import n6.b;
import p6.d;
import p6.e;
import p6.h;
import q6.f;

/* JADX INFO: loaded from: classes2.dex */
public final class UUIDSerializer implements b {
    public static final UUIDSerializer INSTANCE = new UUIDSerializer();
    private static final e descriptor = h.a("UUID", d.i.f22070a);

    private UUIDSerializer() {
    }

    @Override // n6.b, n6.h, n6.a
    public e getDescriptor() {
        return descriptor;
    }

    @Override // n6.a
    public UUID deserialize(q6.e decoder) {
        r.f(decoder, "decoder");
        UUID uuidFromString = UUID.fromString(decoder.o());
        r.e(uuidFromString, "fromString(decoder.decodeString())");
        return uuidFromString;
    }

    @Override // n6.h
    public void serialize(f encoder, UUID value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        String string = value.toString();
        r.e(string, "value.toString()");
        encoder.F(string);
    }
}
