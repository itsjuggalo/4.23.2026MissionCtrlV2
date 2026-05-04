package com.revenuecat.purchases.paywalls.components.common;

import ah.a;
import bh.e;
import ch.f;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002 \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J7\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u001e\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ/\u0010\u0010\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R2\u0010\u0012\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00020\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0015\u001a\u00020\u00148\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/LocalizedVariableLocalizationKeyMapSerializer;", "Lzg/b;", "", "Lcom/revenuecat/purchases/paywalls/components/common/LocaleId;", "Lcom/revenuecat/purchases/paywalls/components/common/VariableLocalizationKey;", "", "<init>", "()V", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Ljava/util/Map;)V", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Ljava/util/Map;", "delegate", "Lzg/b;", "Lbh/e;", "descriptor", "Lbh/e;", "getDescriptor", "()Lbh/e;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LocalizedVariableLocalizationKeyMapSerializer implements b {
    public static final LocalizedVariableLocalizationKeyMapSerializer INSTANCE = new LocalizedVariableLocalizationKeyMapSerializer();
    private static final b delegate;
    private static final e descriptor;

    static {
        b bVarI = a.i(LocaleId.INSTANCE.serializer(), VariableLocalizationKeyMapSerializer.INSTANCE);
        delegate = bVarI;
        descriptor = bVarI.getDescriptor();
    }

    private LocalizedVariableLocalizationKeyMapSerializer() {
    }

    @Override // zg.b, zg.k, zg.a
    public e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, Map<LocaleId, ? extends Map<VariableLocalizationKey, String>> value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
    }

    @Override // zg.a
    public Map<LocaleId, Map<VariableLocalizationKey, String>> deserialize(ch.e decoder) {
        t.f(decoder, "decoder");
        return (Map) delegate.deserialize(decoder);
    }
}
