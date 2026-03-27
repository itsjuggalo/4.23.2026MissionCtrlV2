package com.revenuecat.purchases.utils.serializers;

import F3.b;
import H3.d;
import H3.e;
import H3.h;
import I3.f;
import W2.n;
import X2.K;
import i3.k;
import java.lang.Enum;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import o3.AbstractC1681l;

/* JADX INFO: loaded from: classes3.dex */
public abstract class EnumDeserializerWithDefault<T extends Enum<T>> implements b {
    private final T defaultValue;
    private final e descriptor;
    private final String enumName;
    private final Map<String, T> valuesByType;

    /* JADX INFO: renamed from: com.revenuecat.purchases.utils.serializers.EnumDeserializerWithDefault$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements k {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // i3.k
        public final String invoke(T value) {
            r.f(value, "value");
            String lowerCase = value.name().toLowerCase(Locale.ROOT);
            r.e(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            return lowerCase;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EnumDeserializerWithDefault(Map<String, ? extends T> valuesByType, T defaultValue) {
        r.f(valuesByType, "valuesByType");
        r.f(defaultValue, "defaultValue");
        this.valuesByType = valuesByType;
        this.defaultValue = defaultValue;
        String enumName = defaultValue.getClass().getSimpleName();
        this.enumName = enumName;
        r.e(enumName, "enumName");
        this.descriptor = h.a(enumName, d.i.f742a);
    }

    @Override // F3.b, F3.h, F3.a
    public e getDescriptor() {
        return this.descriptor;
    }

    @Override // F3.a
    public T deserialize(I3.e decoder) {
        r.f(decoder, "decoder");
        T t4 = this.valuesByType.get(decoder.q());
        return t4 == null ? this.defaultValue : t4;
    }

    @Override // F3.h
    public void serialize(f encoder, T value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        throw new n("Serialization is not implemented because it is not needed.");
    }

    public /* synthetic */ EnumDeserializerWithDefault(Enum r12, k kVar, int i4, AbstractC1585j abstractC1585j) {
        this(r12, (i4 & 2) != 0 ? AnonymousClass1.INSTANCE : kVar);
    }

    public EnumDeserializerWithDefault(T defaultValue, k typeForValue) {
        r.f(defaultValue, "defaultValue");
        r.f(typeForValue, "typeForValue");
        Object[] enumConstants = defaultValue.getClass().getEnumConstants();
        r.e(enumConstants, "defaultValue::class.java.enumConstants");
        LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC1681l.b(K.b(enumConstants.length), 16));
        for (Object obj : enumConstants) {
            linkedHashMap.put(typeForValue.invoke(obj), obj);
        }
        this(linkedHashMap, defaultValue);
    }
}
