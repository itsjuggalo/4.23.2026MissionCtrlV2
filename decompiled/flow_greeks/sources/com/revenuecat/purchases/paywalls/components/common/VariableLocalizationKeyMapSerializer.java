package com.revenuecat.purchases.paywalls.components.common;

import ah.a;
import bh.e;
import ch.f;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.utils.MapExtensionsKt;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.s0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import pd.k;
import zg.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R&\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\u00020\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/VariableLocalizationKeyMapSerializer;", "Lzg/b;", "", "Lcom/revenuecat/purchases/paywalls/components/common/VariableLocalizationKey;", "", "<init>", "()V", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Ljava/util/Map;)V", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Ljava/util/Map;", "delegate", "Lzg/b;", "Lbh/e;", "descriptor", "Lbh/e;", "getDescriptor", "()Lbh/e;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VariableLocalizationKeyMapSerializer implements b {
    public static final VariableLocalizationKeyMapSerializer INSTANCE = new VariableLocalizationKeyMapSerializer();
    private static final b delegate;
    private static final e descriptor;

    /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.common.VariableLocalizationKeyMapSerializer$deserialize$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010&\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/revenuecat/purchases/paywalls/components/common/VariableLocalizationKey;", "<name for destructuring parameter 0>", "", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass1 extends v implements k {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // pd.k
        public final VariableLocalizationKey invoke(Map.Entry<String, String> entry) {
            t.f(entry, "<name for destructuring parameter 0>");
            try {
                String upperCase = entry.getKey().toUpperCase(Locale.ROOT);
                t.e(upperCase, "toUpperCase(...)");
                return VariableLocalizationKey.valueOf(upperCase);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
    }

    static {
        s0 s0Var = s0.f14953a;
        b bVarI = a.i(a.D(s0Var), a.D(s0Var));
        delegate = bVarI;
        descriptor = bVarI.getDescriptor();
    }

    private VariableLocalizationKeyMapSerializer() {
    }

    @Override // zg.b, zg.k, zg.a
    public e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, Map<VariableLocalizationKey, String> value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
    }

    @Override // zg.a
    public Map<VariableLocalizationKey, String> deserialize(ch.e decoder) {
        t.f(decoder, "decoder");
        return MapExtensionsKt.mapNotNullKeys((Map) decoder.E(delegate), AnonymousClass1.INSTANCE);
    }
}
