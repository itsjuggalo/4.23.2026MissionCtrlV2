package com.revenuecat.purchases.utils.serializers;

import bh.d;
import bh.e;
import bh.k;
import ch.f;
import com.revenuecat.purchases.utils.Iso8601Utils;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/revenuecat/purchases/utils/serializers/ISO8601DateSerializer;", "Lzg/b;", "Ljava/util/Date;", "<init>", "()V", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Ljava/util/Date;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Ljava/util/Date;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ISO8601DateSerializer implements b {
    public static final ISO8601DateSerializer INSTANCE = new ISO8601DateSerializer();

    private ISO8601DateSerializer() {
    }

    @Override // zg.b, zg.k, zg.a
    public e getDescriptor() {
        return k.b("ISO8601Date", d.i.f3379a);
    }

    @Override // zg.a
    public Date deserialize(ch.e decoder) {
        t.f(decoder, "decoder");
        Date date = Iso8601Utils.parse(decoder.m());
        t.e(date, "parse(isoDateString)");
        return date;
    }

    @Override // zg.k
    public void serialize(f encoder, Date value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        String isoDateString = Iso8601Utils.format(value);
        t.e(isoDateString, "isoDateString");
        encoder.F(isoDateString);
    }
}
