package com.revenuecat.purchases.utils.serializers;

import com.revenuecat.purchases.utils.Iso8601Utils;
import java.util.Date;
import k7.b;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;
import m7.d;
import m7.e;
import m7.k;
import n7.f;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/revenuecat/purchases/utils/serializers/ISO8601DateSerializer;", "Lk7/b;", "Ljava/util/Date;", "<init>", "()V", "Ln7/e;", "decoder", "deserialize", "(Ln7/e;)Ljava/util/Date;", "Ln7/f;", "encoder", "value", "Lo5/H;", "serialize", "(Ln7/f;Ljava/util/Date;)V", "Lm7/e;", "getDescriptor", "()Lm7/e;", "descriptor", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
public final class ISO8601DateSerializer implements b {
    public static final ISO8601DateSerializer INSTANCE = new ISO8601DateSerializer();

    private ISO8601DateSerializer() {
    }

    @Override // k7.b, k7.k, k7.a
    public e getDescriptor() {
        return k.b("Date", d.i.f21508a);
    }

    @Override // k7.a
    public Date deserialize(n7.e decoder) {
        AbstractC2304t.f(decoder, "decoder");
        Date date = Iso8601Utils.parse(decoder.q());
        AbstractC2304t.e(date, "parse(isoDateString)");
        return date;
    }

    @Override // k7.k
    public void serialize(f encoder, Date value) {
        AbstractC2304t.f(encoder, "encoder");
        AbstractC2304t.f(value, "value");
        String isoDateString = Iso8601Utils.format(value);
        AbstractC2304t.e(isoDateString, "isoDateString");
        encoder.E(isoDateString);
    }
}
