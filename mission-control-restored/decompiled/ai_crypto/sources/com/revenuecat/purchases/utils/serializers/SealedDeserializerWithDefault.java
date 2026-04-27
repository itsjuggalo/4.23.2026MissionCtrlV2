package com.revenuecat.purchases.utils.serializers;

import E5.n;
import Q5.k;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.r;
import n6.a;
import n6.b;
import p6.e;
import p6.h;
import q6.f;
import s6.g;
import s6.i;
import s6.u;
import s6.w;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SealedDeserializerWithDefault<T> implements b {
    private final k defaultValue;
    private final e descriptor;
    private final String serialName;
    private final Map<String, Function0> serializerByType;
    private final String typeDiscriminator;

    /* JADX WARN: Multi-variable type inference failed */
    public SealedDeserializerWithDefault(String serialName, Map<String, ? extends Function0> serializerByType, k defaultValue, String typeDiscriminator) {
        r.f(serialName, "serialName");
        r.f(serializerByType, "serializerByType");
        r.f(defaultValue, "defaultValue");
        r.f(typeDiscriminator, "typeDiscriminator");
        this.serialName = serialName;
        this.serializerByType = serializerByType;
        this.defaultValue = defaultValue;
        this.typeDiscriminator = typeDiscriminator;
        this.descriptor = h.b(serialName, new e[0], new SealedDeserializerWithDefault$descriptor$1(this));
    }

    @Override // n6.a
    public T deserialize(q6.e decoder) {
        T t7;
        w wVarO;
        r.f(decoder, "decoder");
        String strA = null;
        g gVar = decoder instanceof g ? (g) decoder : null;
        if (gVar == null) {
            throw new n6.g("Can only deserialize " + this.serialName + " from JSON, got: " + H.b(decoder.getClass()));
        }
        u uVarN = i.n(gVar.j());
        s6.h hVar = (s6.h) uVarN.get(this.typeDiscriminator);
        if (hVar != null && (wVarO = i.o(hVar)) != null) {
            strA = wVarO.a();
        }
        Function0 function0 = this.serializerByType.get(strA);
        if (function0 != null && (t7 = (T) gVar.d().c((a) function0.invoke(), uVarN)) != null) {
            return t7;
        }
        k kVar = this.defaultValue;
        if (strA == null) {
            strA = "null";
        }
        return (T) kVar.invoke(strA);
    }

    @Override // n6.b, n6.h, n6.a
    public e getDescriptor() {
        return this.descriptor;
    }

    @Override // n6.h
    public void serialize(f encoder, T value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        throw new n("Serialization is not implemented because it is not needed.");
    }

    public /* synthetic */ SealedDeserializerWithDefault(String str, Map map, k kVar, String str2, int i7, AbstractC2148j abstractC2148j) {
        this(str, map, kVar, (i7 & 8) != 0 ? "type" : str2);
    }
}
