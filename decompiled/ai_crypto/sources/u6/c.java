package u6;

import Q5.k;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.L;
import kotlin.jvm.internal.r;
import u6.a;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f24696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f24697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f24698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f24699d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map f24700e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Map class2ContextualFactory, Map polyBase2Serializers, Map polyBase2DefaultSerializerProvider, Map polyBase2NamedSerializers, Map polyBase2DefaultDeserializerProvider) {
        super(null);
        r.f(class2ContextualFactory, "class2ContextualFactory");
        r.f(polyBase2Serializers, "polyBase2Serializers");
        r.f(polyBase2DefaultSerializerProvider, "polyBase2DefaultSerializerProvider");
        r.f(polyBase2NamedSerializers, "polyBase2NamedSerializers");
        r.f(polyBase2DefaultDeserializerProvider, "polyBase2DefaultDeserializerProvider");
        this.f24696a = class2ContextualFactory;
        this.f24697b = polyBase2Serializers;
        this.f24698c = polyBase2DefaultSerializerProvider;
        this.f24699d = polyBase2NamedSerializers;
        this.f24700e = polyBase2DefaultDeserializerProvider;
    }

    @Override // u6.e
    public void a(h collector) {
        r.f(collector, "collector");
        for (Map.Entry entry : this.f24696a.entrySet()) {
            X5.c cVar = (X5.c) entry.getKey();
            a aVar = (a) entry.getValue();
            if (aVar instanceof a.C0381a) {
                r.d(cVar, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                n6.b bVarB = ((a.C0381a) aVar).b();
                r.d(bVarB, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
                collector.e(cVar, bVarB);
            } else if (aVar instanceof a.b) {
                collector.c(cVar, ((a.b) aVar).b());
            }
        }
        for (Map.Entry entry2 : this.f24697b.entrySet()) {
            X5.c cVar2 = (X5.c) entry2.getKey();
            for (Map.Entry entry3 : ((Map) entry2.getValue()).entrySet()) {
                X5.c cVar3 = (X5.c) entry3.getKey();
                n6.b bVar = (n6.b) entry3.getValue();
                r.d(cVar2, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                r.d(cVar3, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                r.d(bVar, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                collector.d(cVar2, cVar3, bVar);
            }
        }
        for (Map.Entry entry4 : this.f24698c.entrySet()) {
            X5.c cVar4 = (X5.c) entry4.getKey();
            k kVar = (k) entry4.getValue();
            r.d(cVar4, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            r.d(kVar, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'value')] kotlin.Any, kotlinx.serialization.SerializationStrategy<kotlin.Any>?>{ kotlinx.serialization.modules.SerializersModuleKt.PolymorphicSerializerProvider<kotlin.Any> }");
            collector.a(cVar4, (k) L.b(kVar, 1));
        }
        for (Map.Entry entry5 : this.f24700e.entrySet()) {
            X5.c cVar5 = (X5.c) entry5.getKey();
            k kVar2 = (k) entry5.getValue();
            r.d(cVar5, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            r.d(kVar2, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'className')] kotlin.String?, kotlinx.serialization.DeserializationStrategy<out kotlin.Any>?>{ kotlinx.serialization.modules.SerializersModuleKt.PolymorphicDeserializerProvider<out kotlin.Any> }");
            collector.b(cVar5, (k) L.b(kVar2, 1));
        }
    }

    @Override // u6.e
    public n6.b b(X5.c kClass, List typeArgumentsSerializers) {
        r.f(kClass, "kClass");
        r.f(typeArgumentsSerializers, "typeArgumentsSerializers");
        a aVar = (a) this.f24696a.get(kClass);
        n6.b bVarA = aVar != null ? aVar.a(typeArgumentsSerializers) : null;
        if (bVarA != null) {
            return bVarA;
        }
        return null;
    }

    @Override // u6.e
    public n6.a d(X5.c baseClass, String str) {
        r.f(baseClass, "baseClass");
        Map map = (Map) this.f24699d.get(baseClass);
        n6.b bVar = map != null ? (n6.b) map.get(str) : null;
        if (bVar == null) {
            bVar = null;
        }
        if (bVar != null) {
            return bVar;
        }
        Object obj = this.f24700e.get(baseClass);
        k kVar = L.e(obj, 1) ? (k) obj : null;
        if (kVar != null) {
            return (n6.a) kVar.invoke(str);
        }
        return null;
    }

    @Override // u6.e
    public n6.h e(X5.c baseClass, Object value) {
        r.f(baseClass, "baseClass");
        r.f(value, "value");
        if (!baseClass.d(value)) {
            return null;
        }
        Map map = (Map) this.f24697b.get(baseClass);
        n6.b bVar = map != null ? (n6.b) map.get(H.b(value.getClass())) : null;
        if (bVar == null) {
            bVar = null;
        }
        if (bVar != null) {
            return bVar;
        }
        Object obj = this.f24698c.get(baseClass);
        k kVar = L.e(obj, 1) ? (k) obj : null;
        if (kVar != null) {
            return (n6.h) kVar.invoke(value);
        }
        return null;
    }
}
