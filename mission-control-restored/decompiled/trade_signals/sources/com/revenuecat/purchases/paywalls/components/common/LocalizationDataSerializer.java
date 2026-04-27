package com.revenuecat.purchases.paywalls.components.common;

import com.revenuecat.purchases.paywalls.components.common.LocalizationData;
import k7.b;
import k7.j;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;
import m7.c;
import m7.e;
import m7.k;
import n7.f;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR \u0010\u0010\u001a\u00020\u000f8\u0016X\u0096\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u0012\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/LocalizationDataSerializer;", "Lk7/b;", "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationData;", "<init>", "()V", "Ln7/f;", "encoder", "value", "Lo5/H;", "serialize", "(Ln7/f;Lcom/revenuecat/purchases/paywalls/components/common/LocalizationData;)V", "Ln7/e;", "decoder", "deserialize", "(Ln7/e;)Lcom/revenuecat/purchases/paywalls/components/common/LocalizationData;", "Lm7/e;", "descriptor", "Lm7/e;", "getDescriptor", "()Lm7/e;", "getDescriptor$annotations", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
final class LocalizationDataSerializer implements b {
    public static final LocalizationDataSerializer INSTANCE = new LocalizationDataSerializer();
    private static final e descriptor = k.e("LocalizationData", c.a.f21499a, new e[0], null, 8, null);

    private LocalizationDataSerializer() {
    }

    public static /* synthetic */ void getDescriptor$annotations() {
    }

    @Override // k7.a
    public LocalizationData deserialize(n7.e decoder) {
        AbstractC2304t.f(decoder, "decoder");
        try {
            return (LocalizationData) decoder.v(LocalizationData.Text.INSTANCE.serializer());
        } catch (j unused) {
            return (LocalizationData) decoder.v(LocalizationData.Image.INSTANCE.serializer());
        }
    }

    @Override // k7.b, k7.k, k7.a
    public e getDescriptor() {
        return descriptor;
    }

    @Override // k7.k
    public void serialize(f encoder, LocalizationData value) {
        AbstractC2304t.f(encoder, "encoder");
        AbstractC2304t.f(value, "value");
        throw new IllegalStateException("Serialization is not implemented as it is not (yet) needed.".toString());
    }
}
