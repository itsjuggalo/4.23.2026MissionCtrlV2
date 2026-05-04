package com.revenuecat.purchases.utils.serializers;

import bh.e;
import cd.p;
import ch.f;
import eh.c0;
import eh.e0;
import eh.h;
import eh.i;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t;
import pd.k;
import zg.a;
import zg.b;
import zg.j;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003BO\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012 \u0010\b\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00030\u00070\u0006\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018R.\u0010\b\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00030\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0019R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001aR\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0018R\u001a\u0010\u001c\u001a\u00020\u001b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/revenuecat/purchases/utils/serializers/SealedDeserializerWithDefault;", "", "T", "Lzg/b;", "", "serialName", "", "Lkotlin/Function0;", "serializerByType", "Lkotlin/Function1;", "defaultValue", "typeDiscriminator", "<init>", "(Ljava/lang/String;Ljava/util/Map;Lpd/k;Ljava/lang/String;)V", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Ljava/lang/Object;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Ljava/lang/Object;)V", "Ljava/lang/String;", "Ljava/util/Map;", "Lpd/k;", "Lbh/e;", "descriptor", "Lbh/e;", "getDescriptor", "()Lbh/e;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class SealedDeserializerWithDefault<T> implements b {
    private final k defaultValue;
    private final e descriptor;
    private final String serialName;
    private final Map<String, Function0> serializerByType;
    private final String typeDiscriminator;

    /* JADX WARN: Multi-variable type inference failed */
    public SealedDeserializerWithDefault(String serialName, Map<String, ? extends Function0> serializerByType, k defaultValue, String typeDiscriminator) {
        t.f(serialName, "serialName");
        t.f(serializerByType, "serializerByType");
        t.f(defaultValue, "defaultValue");
        t.f(typeDiscriminator, "typeDiscriminator");
        this.serialName = serialName;
        this.serializerByType = serializerByType;
        this.defaultValue = defaultValue;
        this.typeDiscriminator = typeDiscriminator;
        this.descriptor = bh.k.c(serialName, new e[0], new SealedDeserializerWithDefault$descriptor$1(this));
    }

    @Override // zg.a
    public T deserialize(ch.e decoder) {
        T t10;
        e0 e0VarO;
        t.f(decoder, "decoder");
        String strA = null;
        h hVar = decoder instanceof h ? (h) decoder : null;
        if (hVar == null) {
            throw new j("Can only deserialize " + this.serialName + " from JSON, got: " + n0.b(decoder.getClass()));
        }
        c0 c0VarN = eh.j.n(hVar.i());
        i iVar = (i) c0VarN.get(this.typeDiscriminator);
        if (iVar != null && (e0VarO = eh.j.o(iVar)) != null) {
            strA = e0VarO.a();
        }
        Function0 function0 = this.serializerByType.get(strA);
        if (function0 != null && (t10 = (T) hVar.d().c((a) function0.invoke(), c0VarN)) != null) {
            return t10;
        }
        k kVar = this.defaultValue;
        if (strA == null) {
            strA = "null";
        }
        return (T) kVar.invoke(strA);
    }

    @Override // zg.b, zg.k, zg.a
    public e getDescriptor() {
        return this.descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, T value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        throw new p("Serialization is not implemented because it is not needed.");
    }

    public /* synthetic */ SealedDeserializerWithDefault(String str, Map map, k kVar, String str2, int i10, kotlin.jvm.internal.k kVar2) {
        this(str, map, kVar, (i10 & 8) != 0 ? "type" : str2);
    }
}
