package com.revenuecat.purchases.utils.serializers;

import E5.n;
import F5.I;
import Q5.k;
import W5.l;
import java.lang.Enum;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import n6.b;
import p6.d;
import p6.e;
import p6.h;
import q6.f;

/* JADX INFO: loaded from: classes2.dex */
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

        @Override // Q5.k
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
        this.descriptor = h.a(enumName, d.i.f22070a);
    }

    @Override // n6.b, n6.h, n6.a
    public e getDescriptor() {
        return this.descriptor;
    }

    @Override // n6.a
    public T deserialize(q6.e decoder) {
        r.f(decoder, "decoder");
        T t7 = this.valuesByType.get(decoder.o());
        return t7 == null ? this.defaultValue : t7;
    }

    @Override // n6.h
    public void serialize(f encoder, T value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        throw new n("Serialization is not implemented because it is not needed.");
    }

    public /* synthetic */ EnumDeserializerWithDefault(Enum r12, k kVar, int i7, AbstractC2148j abstractC2148j) {
        this(r12, (i7 & 2) != 0 ? AnonymousClass1.INSTANCE : kVar);
    }

    public EnumDeserializerWithDefault(T defaultValue, k typeForValue) {
        r.f(defaultValue, "defaultValue");
        r.f(typeForValue, "typeForValue");
        Object[] enumConstants = defaultValue.getClass().getEnumConstants();
        r.e(enumConstants, "defaultValue::class.java.enumConstants");
        LinkedHashMap linkedHashMap = new LinkedHashMap(l.b(I.b(enumConstants.length), 16));
        for (Object obj : enumConstants) {
            linkedHashMap.put(typeForValue.invoke(obj), obj);
        }
        this(linkedHashMap, defaultValue);
    }
}
