package M3;

import M3.a;
import i3.k;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.K;
import kotlin.jvm.internal.r;
import p3.InterfaceC1716c;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f2688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f2689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f2690c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f2691d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map f2692e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Map class2ContextualFactory, Map polyBase2Serializers, Map polyBase2DefaultSerializerProvider, Map polyBase2NamedSerializers, Map polyBase2DefaultDeserializerProvider) {
        super(null);
        r.f(class2ContextualFactory, "class2ContextualFactory");
        r.f(polyBase2Serializers, "polyBase2Serializers");
        r.f(polyBase2DefaultSerializerProvider, "polyBase2DefaultSerializerProvider");
        r.f(polyBase2NamedSerializers, "polyBase2NamedSerializers");
        r.f(polyBase2DefaultDeserializerProvider, "polyBase2DefaultDeserializerProvider");
        this.f2688a = class2ContextualFactory;
        this.f2689b = polyBase2Serializers;
        this.f2690c = polyBase2DefaultSerializerProvider;
        this.f2691d = polyBase2NamedSerializers;
        this.f2692e = polyBase2DefaultDeserializerProvider;
    }

    @Override // M3.e
    public void a(h collector) {
        r.f(collector, "collector");
        for (Map.Entry entry : this.f2688a.entrySet()) {
            InterfaceC1716c interfaceC1716c = (InterfaceC1716c) entry.getKey();
            a aVar = (a) entry.getValue();
            if (aVar instanceof a.C0047a) {
                r.d(interfaceC1716c, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                F3.b bVarB = ((a.C0047a) aVar).b();
                r.d(bVarB, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
                collector.a(interfaceC1716c, bVarB);
            } else if (aVar instanceof a.b) {
                collector.d(interfaceC1716c, ((a.b) aVar).b());
            }
        }
        for (Map.Entry entry2 : this.f2689b.entrySet()) {
            InterfaceC1716c interfaceC1716c2 = (InterfaceC1716c) entry2.getKey();
            for (Map.Entry entry3 : ((Map) entry2.getValue()).entrySet()) {
                InterfaceC1716c interfaceC1716c3 = (InterfaceC1716c) entry3.getKey();
                F3.b bVar = (F3.b) entry3.getValue();
                r.d(interfaceC1716c2, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                r.d(interfaceC1716c3, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                r.d(bVar, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                collector.c(interfaceC1716c2, interfaceC1716c3, bVar);
            }
        }
        for (Map.Entry entry4 : this.f2690c.entrySet()) {
            InterfaceC1716c interfaceC1716c4 = (InterfaceC1716c) entry4.getKey();
            k kVar = (k) entry4.getValue();
            r.d(interfaceC1716c4, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            r.d(kVar, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'value')] kotlin.Any, kotlinx.serialization.SerializationStrategy<kotlin.Any>?>{ kotlinx.serialization.modules.SerializersModuleKt.PolymorphicSerializerProvider<kotlin.Any> }");
            collector.b(interfaceC1716c4, (k) K.b(kVar, 1));
        }
        for (Map.Entry entry5 : this.f2692e.entrySet()) {
            InterfaceC1716c interfaceC1716c5 = (InterfaceC1716c) entry5.getKey();
            k kVar2 = (k) entry5.getValue();
            r.d(interfaceC1716c5, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            r.d(kVar2, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'className')] kotlin.String?, kotlinx.serialization.DeserializationStrategy<out kotlin.Any>?>{ kotlinx.serialization.modules.SerializersModuleKt.PolymorphicDeserializerProvider<out kotlin.Any> }");
            collector.e(interfaceC1716c5, (k) K.b(kVar2, 1));
        }
    }

    @Override // M3.e
    public F3.b b(InterfaceC1716c kClass, List typeArgumentsSerializers) {
        r.f(kClass, "kClass");
        r.f(typeArgumentsSerializers, "typeArgumentsSerializers");
        a aVar = (a) this.f2688a.get(kClass);
        F3.b bVarA = aVar != null ? aVar.a(typeArgumentsSerializers) : null;
        if (bVarA != null) {
            return bVarA;
        }
        return null;
    }

    @Override // M3.e
    public F3.a d(InterfaceC1716c baseClass, String str) {
        r.f(baseClass, "baseClass");
        Map map = (Map) this.f2691d.get(baseClass);
        F3.b bVar = map != null ? (F3.b) map.get(str) : null;
        if (bVar == null) {
            bVar = null;
        }
        if (bVar != null) {
            return bVar;
        }
        Object obj = this.f2692e.get(baseClass);
        k kVar = K.e(obj, 1) ? (k) obj : null;
        if (kVar != null) {
            return (F3.a) kVar.invoke(str);
        }
        return null;
    }

    @Override // M3.e
    public F3.h e(InterfaceC1716c baseClass, Object value) {
        r.f(baseClass, "baseClass");
        r.f(value, "value");
        if (!baseClass.c(value)) {
            return null;
        }
        Map map = (Map) this.f2689b.get(baseClass);
        F3.b bVar = map != null ? (F3.b) map.get(G.b(value.getClass())) : null;
        if (bVar == null) {
            bVar = null;
        }
        if (bVar != null) {
            return bVar;
        }
        Object obj = this.f2690c.get(baseClass);
        k kVar = K.e(obj, 1) ? (k) obj : null;
        if (kVar != null) {
            return (F3.h) kVar.invoke(value);
        }
        return null;
    }
}
