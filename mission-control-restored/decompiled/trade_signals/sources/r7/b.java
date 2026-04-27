package r7;

import B5.k;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2489q;
import o5.w;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final I5.d f22922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k7.b f22923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f22924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k f22925d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public k f22926e;

    public b(I5.d baseClass, k7.b bVar) {
        AbstractC2304t.f(baseClass, "baseClass");
        this.f22922a = baseClass;
        this.f22923b = bVar;
        this.f22924c = new ArrayList();
    }

    public final void a(f builder) {
        AbstractC2304t.f(builder, "builder");
        k7.b bVar = this.f22923b;
        if (bVar != null) {
            I5.d dVar = this.f22922a;
            f.j(builder, dVar, dVar, bVar, false, 8, null);
        }
        for (C2489q c2489q : this.f22924c) {
            I5.d dVar2 = (I5.d) c2489q.a();
            k7.b bVar2 = (k7.b) c2489q.b();
            I5.d dVar3 = this.f22922a;
            AbstractC2304t.d(dVar2, "null cannot be cast to non-null type kotlin.reflect.KClass<Base of kotlinx.serialization.modules.PolymorphicModuleBuilder>");
            AbstractC2304t.d(bVar2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            f.j(builder, dVar3, dVar2, bVar2, false, 8, null);
        }
        k kVar = this.f22925d;
        if (kVar != null) {
            builder.h(this.f22922a, kVar, false);
        }
        k kVar2 = this.f22926e;
        if (kVar2 != null) {
            builder.g(this.f22922a, kVar2, false);
        }
    }

    public final void b(I5.d subclass, k7.b serializer) {
        AbstractC2304t.f(subclass, "subclass");
        AbstractC2304t.f(serializer, "serializer");
        this.f22924c.add(w.a(subclass, serializer));
    }
}
