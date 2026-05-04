package com.revenuecat.purchases.paywalls.components.common;

import bh.c;
import bh.e;
import bh.k;
import ch.f;
import com.revenuecat.purchases.paywalls.components.common.LocalizationData;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.j;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR \u0010\u0010\u001a\u00020\u000f8\u0016X\u0096\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u0012\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/LocalizationDataSerializer;", "Lzg/b;", "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationData;", "<init>", "()V", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/paywalls/components/common/LocalizationData;)V", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/paywalls/components/common/LocalizationData;", "Lbh/e;", "descriptor", "Lbh/e;", "getDescriptor", "()Lbh/e;", "getDescriptor$annotations", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class LocalizationDataSerializer implements b {
    public static final LocalizationDataSerializer INSTANCE = new LocalizationDataSerializer();
    private static final e descriptor = k.e("LocalizationData", c.a.f3370a, new e[0], null, 8, null);

    private LocalizationDataSerializer() {
    }

    @Override // zg.b, zg.k, zg.a
    public e getDescriptor() {
        return descriptor;
    }

    @Override // zg.a
    public LocalizationData deserialize(ch.e decoder) {
        t.f(decoder, "decoder");
        try {
            return (LocalizationData) decoder.E(LocalizationData.Text.INSTANCE.serializer());
        } catch (j unused) {
            return (LocalizationData) decoder.E(LocalizationData.Image.INSTANCE.serializer());
        }
    }

    @Override // zg.k
    public void serialize(f encoder, LocalizationData value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        throw new IllegalStateException("Serialization is not implemented as it is not (yet) needed.");
    }

    public static /* synthetic */ void getDescriptor$annotations() {
    }
}
