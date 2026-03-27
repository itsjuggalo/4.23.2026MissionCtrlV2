package com.revenuecat.purchases.utils.serializers;

import F3.b;
import H3.d;
import H3.e;
import H3.h;
import I3.f;
import java.util.Date;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class DateSerializer implements b {
    public static final DateSerializer INSTANCE = new DateSerializer();

    private DateSerializer() {
    }

    @Override // F3.b, F3.h, F3.a
    public e getDescriptor() {
        return h.a("Date", d.g.f740a);
    }

    @Override // F3.a
    public Date deserialize(I3.e decoder) {
        r.f(decoder, "decoder");
        return new Date(decoder.r());
    }

    @Override // F3.h
    public void serialize(f encoder, Date value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        encoder.D(value.getTime());
    }
}
