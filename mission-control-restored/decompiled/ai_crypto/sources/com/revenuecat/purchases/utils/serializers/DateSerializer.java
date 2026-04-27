package com.revenuecat.purchases.utils.serializers;

import java.util.Date;
import kotlin.jvm.internal.r;
import n6.b;
import p6.d;
import p6.e;
import p6.h;
import q6.f;

/* JADX INFO: loaded from: classes2.dex */
public final class DateSerializer implements b {
    public static final DateSerializer INSTANCE = new DateSerializer();

    private DateSerializer() {
    }

    @Override // n6.b, n6.h, n6.a
    public e getDescriptor() {
        return h.a("Date", d.g.f22068a);
    }

    @Override // n6.a
    public Date deserialize(q6.e decoder) {
        r.f(decoder, "decoder");
        return new Date(decoder.r());
    }

    @Override // n6.h
    public void serialize(f encoder, Date value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        encoder.B(value.getTime());
    }
}
