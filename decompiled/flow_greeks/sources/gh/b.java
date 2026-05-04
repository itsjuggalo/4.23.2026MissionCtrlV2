package gh;

import cd.q;
import cd.w;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;
import pd.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wd.d f10770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zg.b f10771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f10772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k f10773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public k f10774e;

    public b(wd.d baseClass, zg.b bVar) {
        t.f(baseClass, "baseClass");
        this.f10770a = baseClass;
        this.f10771b = bVar;
        this.f10772c = new ArrayList();
    }

    public final void a(f builder) {
        t.f(builder, "builder");
        zg.b bVar = this.f10771b;
        if (bVar != null) {
            wd.d dVar = this.f10770a;
            f.j(builder, dVar, dVar, bVar, false, 8, null);
        }
        for (q qVar : this.f10772c) {
            wd.d dVar2 = (wd.d) qVar.a();
            zg.b bVar2 = (zg.b) qVar.b();
            wd.d dVar3 = this.f10770a;
            t.d(dVar2, "null cannot be cast to non-null type kotlin.reflect.KClass<Base of kotlinx.serialization.modules.PolymorphicModuleBuilder>");
            t.d(bVar2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            f.j(builder, dVar3, dVar2, bVar2, false, 8, null);
        }
        k kVar = this.f10773d;
        if (kVar != null) {
            builder.h(this.f10770a, kVar, false);
        }
        k kVar2 = this.f10774e;
        if (kVar2 != null) {
            builder.g(this.f10770a, kVar2, false);
        }
    }

    public final void b(wd.d subclass, zg.b serializer) {
        t.f(subclass, "subclass");
        t.f(serializer, "serializer");
        this.f10772c.add(w.a(subclass, serializer));
    }
}
