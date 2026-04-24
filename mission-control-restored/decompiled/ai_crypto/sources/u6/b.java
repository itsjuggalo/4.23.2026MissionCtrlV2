package u6;

import E5.o;
import E5.t;
import Q5.k;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final X5.c f24691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n6.b f24692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f24693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k f24694d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public k f24695e;

    public b(X5.c baseClass, n6.b bVar) {
        r.f(baseClass, "baseClass");
        this.f24691a = baseClass;
        this.f24692b = bVar;
        this.f24693c = new ArrayList();
    }

    public final void a(f builder) {
        r.f(builder, "builder");
        n6.b bVar = this.f24692b;
        if (bVar != null) {
            X5.c cVar = this.f24691a;
            f.j(builder, cVar, cVar, bVar, false, 8, null);
        }
        for (o oVar : this.f24693c) {
            X5.c cVar2 = (X5.c) oVar.a();
            n6.b bVar2 = (n6.b) oVar.b();
            X5.c cVar3 = this.f24691a;
            r.d(cVar2, "null cannot be cast to non-null type kotlin.reflect.KClass<Base of kotlinx.serialization.modules.PolymorphicModuleBuilder.buildTo$lambda$1>");
            r.d(bVar2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            f.j(builder, cVar3, cVar2, bVar2, false, 8, null);
        }
        k kVar = this.f24694d;
        if (kVar != null) {
            builder.h(this.f24691a, kVar, false);
        }
        k kVar2 = this.f24695e;
        if (kVar2 != null) {
            builder.g(this.f24691a, kVar2, false);
        }
    }

    public final void b(X5.c subclass, n6.b serializer) {
        r.f(subclass, "subclass");
        r.f(serializer, "serializer");
        this.f24693c.add(t.a(subclass, serializer));
    }
}
