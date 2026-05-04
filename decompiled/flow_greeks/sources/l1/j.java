package l1;

import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f15057a = new j();

    public final i a(e0 serializer, m1.b bVar, List migrations, ng.n0 scope, Function0 produceFile) {
        kotlin.jvm.internal.t.f(serializer, "serializer");
        kotlin.jvm.internal.t.f(migrations, "migrations");
        kotlin.jvm.internal.t.f(scope, "scope");
        kotlin.jvm.internal.t.f(produceFile, "produceFile");
        return b(new o(serializer, null, produceFile, 2, null), bVar, migrations, scope);
    }

    public final i b(j0 storage, m1.b bVar, List migrations, ng.n0 scope) {
        kotlin.jvm.internal.t.f(storage, "storage");
        kotlin.jvm.internal.t.f(migrations, "migrations");
        kotlin.jvm.internal.t.f(scope, "scope");
        e aVar = bVar;
        if (bVar == null) {
            aVar = new m1.a();
        }
        return new k(storage, dd.q.e(h.f15023a.b(migrations)), aVar, scope);
    }
}
