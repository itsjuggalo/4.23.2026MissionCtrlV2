package com.revenuecat.purchases.paywalls.components.properties;

import com.revenuecat.purchases.paywalls.components.properties.CornerRadiuses;
import k7.b;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;
import m7.e;
import n7.f;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\u00020\u00128\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/CornerRadiusesSerializer;", "Lk7/b;", "Lcom/revenuecat/purchases/paywalls/components/properties/CornerRadiuses;", "<init>", "()V", "Ln7/f;", "encoder", "value", "Lo5/H;", "serialize", "(Ln7/f;Lcom/revenuecat/purchases/paywalls/components/properties/CornerRadiuses;)V", "Ln7/e;", "decoder", "deserialize", "(Ln7/e;)Lcom/revenuecat/purchases/paywalls/components/properties/CornerRadiuses;", "Lcom/revenuecat/purchases/paywalls/components/properties/CornerRadiuses$Dp;", "serializer", "Lk7/b;", "Lm7/e;", "descriptor", "Lm7/e;", "getDescriptor", "()Lm7/e;", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
public final class CornerRadiusesSerializer implements b {
    public static final CornerRadiusesSerializer INSTANCE = new CornerRadiusesSerializer();
    private static final e descriptor;
    private static final b serializer;

    static {
        b bVarSerializer = CornerRadiuses.Dp.INSTANCE.serializer();
        serializer = bVarSerializer;
        descriptor = bVarSerializer.getDescriptor();
    }

    private CornerRadiusesSerializer() {
    }

    @Override // k7.a
    public CornerRadiuses deserialize(n7.e decoder) {
        AbstractC2304t.f(decoder, "decoder");
        return (CornerRadiuses) decoder.v(serializer);
    }

    @Override // k7.b, k7.k, k7.a
    public e getDescriptor() {
        return descriptor;
    }

    @Override // k7.k
    public void serialize(f encoder, CornerRadiuses value) {
        AbstractC2304t.f(encoder, "encoder");
        AbstractC2304t.f(value, "value");
    }
}
