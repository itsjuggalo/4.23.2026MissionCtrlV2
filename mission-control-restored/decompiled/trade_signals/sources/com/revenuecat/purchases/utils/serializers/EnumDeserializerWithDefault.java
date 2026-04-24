package com.revenuecat.purchases.utils.serializers;

import B5.k;
import H5.i;
import java.lang.Enum;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import k7.b;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.AbstractC2306v;
import m7.d;
import m7.e;
import n7.f;
import o5.C2488p;
import p5.L;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B#\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\tB'\b\u0016\u0012\u0006\u0010\u0007\u001a\u00028\u0000\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\n¢\u0006\u0004\b\b\u0010\fJ\u0017\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0017R\u0014\u0010\u0007\u001a\u00028\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0018R\u001c\u0010\u001a\u001a\n \u0019*\u0004\u0018\u00010\u00050\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001d\u001a\u00020\u001c8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/revenuecat/purchases/utils/serializers/EnumDeserializerWithDefault;", "", "T", "Lk7/b;", "", "", "valuesByType", "defaultValue", "<init>", "(Ljava/util/Map;Ljava/lang/Enum;)V", "Lkotlin/Function1;", "typeForValue", "(Ljava/lang/Enum;LB5/k;)V", "Ln7/e;", "decoder", "deserialize", "(Ln7/e;)Ljava/lang/Enum;", "Ln7/f;", "encoder", "value", "Lo5/H;", "serialize", "(Ln7/f;Ljava/lang/Enum;)V", "Ljava/util/Map;", "Ljava/lang/Enum;", "kotlin.jvm.PlatformType", "enumName", "Ljava/lang/String;", "Lm7/e;", "descriptor", "Lm7/e;", "getDescriptor", "()Lm7/e;", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
public abstract class EnumDeserializerWithDefault<T extends Enum<T>> implements b {
    private final T defaultValue;
    private final e descriptor;
    private final String enumName;
    private final Map<String, T> valuesByType;

    /* JADX INFO: renamed from: com.revenuecat.purchases.utils.serializers.EnumDeserializerWithDefault$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "T", "", "value", "invoke", "(Ljava/lang/Enum;)Ljava/lang/String;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass1 extends AbstractC2306v implements k {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // B5.k
        public final String invoke(T value) {
            AbstractC2304t.f(value, "value");
            String lowerCase = value.name().toLowerCase(Locale.ROOT);
            AbstractC2304t.e(lowerCase, "toLowerCase(...)");
            return lowerCase;
        }
    }

    public EnumDeserializerWithDefault(T defaultValue, k typeForValue) {
        AbstractC2304t.f(defaultValue, "defaultValue");
        AbstractC2304t.f(typeForValue, "typeForValue");
        Object[] enumConstants = defaultValue.getClass().getEnumConstants();
        AbstractC2304t.e(enumConstants, "defaultValue::class.java.enumConstants");
        LinkedHashMap linkedHashMap = new LinkedHashMap(i.b(L.d(enumConstants.length), 16));
        for (Object obj : enumConstants) {
            linkedHashMap.put(typeForValue.invoke(obj), obj);
        }
        this(linkedHashMap, defaultValue);
    }

    @Override // k7.a
    public T deserialize(n7.e decoder) {
        AbstractC2304t.f(decoder, "decoder");
        T t8 = this.valuesByType.get(decoder.q());
        return t8 == null ? this.defaultValue : t8;
    }

    @Override // k7.b, k7.k, k7.a
    public e getDescriptor() {
        return this.descriptor;
    }

    @Override // k7.k
    public void serialize(f encoder, T value) {
        AbstractC2304t.f(encoder, "encoder");
        AbstractC2304t.f(value, "value");
        throw new C2488p("Serialization is not implemented because it is not needed.");
    }

    public /* synthetic */ EnumDeserializerWithDefault(Enum r12, k kVar, int i8, AbstractC2296k abstractC2296k) {
        this(r12, (i8 & 2) != 0 ? AnonymousClass1.INSTANCE : kVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EnumDeserializerWithDefault(Map<String, ? extends T> valuesByType, T defaultValue) {
        AbstractC2304t.f(valuesByType, "valuesByType");
        AbstractC2304t.f(defaultValue, "defaultValue");
        this.valuesByType = valuesByType;
        this.defaultValue = defaultValue;
        String enumName = defaultValue.getClass().getSimpleName();
        this.enumName = enumName;
        AbstractC2304t.e(enumName, "enumName");
        this.descriptor = m7.k.b(enumName, d.i.f21508a);
    }
}
