package gh;

import cd.o;
import gh.a;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.t0;
import pd.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f10775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f10776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f10777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f10778d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map f10779e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f10780f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Map class2ContextualFactory, Map polyBase2Serializers, Map polyBase2DefaultSerializerProvider, Map polyBase2NamedSerializers, Map polyBase2DefaultDeserializerProvider, boolean z10) {
        super(null);
        t.f(class2ContextualFactory, "class2ContextualFactory");
        t.f(polyBase2Serializers, "polyBase2Serializers");
        t.f(polyBase2DefaultSerializerProvider, "polyBase2DefaultSerializerProvider");
        t.f(polyBase2NamedSerializers, "polyBase2NamedSerializers");
        t.f(polyBase2DefaultDeserializerProvider, "polyBase2DefaultDeserializerProvider");
        this.f10775a = class2ContextualFactory;
        this.f10776b = polyBase2Serializers;
        this.f10777c = polyBase2DefaultSerializerProvider;
        this.f10778d = polyBase2NamedSerializers;
        this.f10779e = polyBase2DefaultDeserializerProvider;
        this.f10780f = z10;
    }

    @Override // gh.e
    public void a(i collector) {
        t.f(collector, "collector");
        for (Map.Entry entry : this.f10775a.entrySet()) {
            wd.d dVar = (wd.d) entry.getKey();
            a aVar = (a) entry.getValue();
            if (aVar instanceof a.C0195a) {
                t.d(dVar, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                zg.b bVarB = ((a.C0195a) aVar).b();
                t.d(bVarB, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
                collector.b(dVar, bVarB);
            } else {
                if (!(aVar instanceof a.b)) {
                    throw new o();
                }
                collector.d(dVar, ((a.b) aVar).b());
            }
        }
        for (Map.Entry entry2 : this.f10776b.entrySet()) {
            wd.d dVar2 = (wd.d) entry2.getKey();
            for (Map.Entry entry3 : ((Map) entry2.getValue()).entrySet()) {
                wd.d dVar3 = (wd.d) entry3.getKey();
                zg.b bVar = (zg.b) entry3.getValue();
                t.d(dVar2, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                t.d(dVar3, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                t.d(bVar, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                collector.a(dVar2, dVar3, bVar);
            }
        }
        for (Map.Entry entry4 : this.f10777c.entrySet()) {
            wd.d dVar4 = (wd.d) entry4.getKey();
            k kVar = (k) entry4.getValue();
            t.d(dVar4, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            t.d(kVar, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"value\")] kotlin.Any, kotlinx.serialization.SerializationStrategy<kotlin.Any>?>");
            collector.c(dVar4, (k) t0.c(kVar, 1));
        }
        for (Map.Entry entry5 : this.f10779e.entrySet()) {
            wd.d dVar5 = (wd.d) entry5.getKey();
            k kVar2 = (k) entry5.getValue();
            t.d(dVar5, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            t.d(kVar2, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"className\")] kotlin.String?, kotlinx.serialization.DeserializationStrategy<kotlin.Any>?>");
            collector.e(dVar5, (k) t0.c(kVar2, 1));
        }
    }

    @Override // gh.e
    public zg.b b(wd.d kClass, List typeArgumentsSerializers) {
        t.f(kClass, "kClass");
        t.f(typeArgumentsSerializers, "typeArgumentsSerializers");
        a aVar = (a) this.f10775a.get(kClass);
        zg.b bVarA = aVar != null ? aVar.a(typeArgumentsSerializers) : null;
        if (bVarA != null) {
            return bVarA;
        }
        return null;
    }

    @Override // gh.e
    public zg.a d(wd.d baseClass, String str) {
        t.f(baseClass, "baseClass");
        Map map = (Map) this.f10778d.get(baseClass);
        zg.b bVar = map != null ? (zg.b) map.get(str) : null;
        if (bVar == null) {
            bVar = null;
        }
        if (bVar != null) {
            return bVar;
        }
        Object obj = this.f10779e.get(baseClass);
        k kVar = t0.g(obj, 1) ? (k) obj : null;
        if (kVar != null) {
            return (zg.a) kVar.invoke(str);
        }
        return null;
    }

    @Override // gh.e
    public zg.k e(wd.d baseClass, Object value) {
        t.f(baseClass, "baseClass");
        t.f(value, "value");
        if (!baseClass.l(value)) {
            return null;
        }
        Map map = (Map) this.f10776b.get(baseClass);
        zg.b bVar = map != null ? (zg.b) map.get(n0.b(value.getClass())) : null;
        if (bVar == null) {
            bVar = null;
        }
        if (bVar != null) {
            return bVar;
        }
        Object obj = this.f10777c.get(baseClass);
        k kVar = t0.g(obj, 1) ? (k) obj : null;
        if (kVar != null) {
            return (zg.k) kVar.invoke(value);
        }
        return null;
    }
}
