package com.revenuecat.purchases.utils.serializers;

import com.revenuecat.purchases.utils.Iso8601Utils;
import java.util.Date;
import kotlin.jvm.internal.r;
import n6.b;
import p6.d;
import p6.e;
import p6.h;
import q6.f;

/* JADX INFO: loaded from: classes2.dex */
public final class ISO8601DateSerializer implements b {
    public static final ISO8601DateSerializer INSTANCE = new ISO8601DateSerializer();

    private ISO8601DateSerializer() {
    }

    @Override // n6.b, n6.h, n6.a
    public e getDescriptor() {
        return h.a("Date", d.i.f22070a);
    }

    @Override // n6.a
    public Date deserialize(q6.e decoder) {
        r.f(decoder, "decoder");
        Date date = Iso8601Utils.parse(decoder.o());
        r.e(date, "parse(isoDateString)");
        return date;
    }

    @Override // n6.h
    public void serialize(f encoder, Date value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        String isoDateString = Iso8601Utils.format(value);
        r.e(isoDateString, "isoDateString");
        encoder.F(isoDateString);
    }
}
