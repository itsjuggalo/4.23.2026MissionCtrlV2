package com.revenuecat.purchases.utils.serializers;

import F3.a;
import F3.b;
import H3.e;
import H3.h;
import I3.f;
import K3.g;
import K3.i;
import K3.u;
import K3.w;
import W2.n;
import i3.k;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
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

    @Override // F3.a
    public T deserialize(I3.e decoder) {
        T t4;
        w wVarO;
        r.f(decoder, "decoder");
        String strF = null;
        g gVar = decoder instanceof g ? (g) decoder : null;
        if (gVar == null) {
            throw new F3.g("Can only deserialize " + this.serialName + " from JSON, got: " + G.b(decoder.getClass()));
        }
        u uVarN = i.n(gVar.k());
        K3.h hVar = (K3.h) uVarN.get(this.typeDiscriminator);
        if (hVar != null && (wVarO = i.o(hVar)) != null) {
            strF = wVarO.f();
        }
        Function0 function0 = this.serializerByType.get(strF);
        if (function0 != null && (t4 = (T) gVar.b().c((a) function0.invoke(), uVarN)) != null) {
            return t4;
        }
        k kVar = this.defaultValue;
        if (strF == null) {
            strF = "null";
        }
        return (T) kVar.invoke(strF);
    }

    @Override // F3.b, F3.h, F3.a
    public e getDescriptor() {
        return this.descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, T value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        throw new n("Serialization is not implemented because it is not needed.");
    }

    public /* synthetic */ SealedDeserializerWithDefault(String str, Map map, k kVar, String str2, int i4, AbstractC1585j abstractC1585j) {
        this(str, map, kVar, (i4 & 8) != 0 ? "type" : str2);
    }
}
