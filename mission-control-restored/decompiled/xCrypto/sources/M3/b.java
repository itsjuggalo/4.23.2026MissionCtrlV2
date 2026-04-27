package M3;

import W2.o;
import W2.t;
import i3.k;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.r;
import p3.InterfaceC1716c;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC1716c f2683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final F3.b f2684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f2685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k f2686d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public k f2687e;

    public b(InterfaceC1716c baseClass, F3.b bVar) {
        r.f(baseClass, "baseClass");
        this.f2683a = baseClass;
        this.f2684b = bVar;
        this.f2685c = new ArrayList();
    }

    public final void a(f builder) {
        r.f(builder, "builder");
        F3.b bVar = this.f2684b;
        if (bVar != null) {
            InterfaceC1716c interfaceC1716c = this.f2683a;
            f.j(builder, interfaceC1716c, interfaceC1716c, bVar, false, 8, null);
        }
        for (o oVar : this.f2685c) {
            InterfaceC1716c interfaceC1716c2 = (InterfaceC1716c) oVar.a();
            F3.b bVar2 = (F3.b) oVar.b();
            InterfaceC1716c interfaceC1716c3 = this.f2683a;
            r.d(interfaceC1716c2, "null cannot be cast to non-null type kotlin.reflect.KClass<Base of kotlinx.serialization.modules.PolymorphicModuleBuilder.buildTo$lambda$1>");
            r.d(bVar2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            f.j(builder, interfaceC1716c3, interfaceC1716c2, bVar2, false, 8, null);
        }
        k kVar = this.f2686d;
        if (kVar != null) {
            builder.h(this.f2683a, kVar, false);
        }
        k kVar2 = this.f2687e;
        if (kVar2 != null) {
            builder.g(this.f2683a, kVar2, false);
        }
    }

    public final void b(InterfaceC1716c subclass, F3.b serializer) {
        r.f(subclass, "subclass");
        r.f(serializer, "serializer");
        this.f2685c.add(t.a(subclass, serializer));
    }
}
