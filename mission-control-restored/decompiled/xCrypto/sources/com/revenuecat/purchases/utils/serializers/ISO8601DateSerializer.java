package com.revenuecat.purchases.utils.serializers;

import F3.b;
import H3.d;
import H3.e;
import H3.h;
import I3.f;
import com.revenuecat.purchases.utils.Iso8601Utils;
import java.util.Date;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class ISO8601DateSerializer implements b {
    public static final ISO8601DateSerializer INSTANCE = new ISO8601DateSerializer();

    private ISO8601DateSerializer() {
    }

    @Override // F3.b, F3.h, F3.a
    public e getDescriptor() {
        return h.a("Date", d.i.f742a);
    }

    @Override // F3.a
    public Date deserialize(I3.e decoder) {
        r.f(decoder, "decoder");
        Date date = Iso8601Utils.parse(decoder.q());
        r.e(date, "parse(isoDateString)");
        return date;
    }

    @Override // F3.h
    public void serialize(f encoder, Date value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        String isoDateString = Iso8601Utils.format(value);
        r.e(isoDateString, "isoDateString");
        encoder.F(isoDateString);
    }
}
