package l1;

import java.io.File;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f15301a = new y();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends kotlin.jvm.internal.v implements pd.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ng.n0 f15302a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ng.n0 n0Var) {
            super(1);
            this.f15302a = n0Var;
        }

        @Override // pd.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final t invoke(File it) {
            kotlin.jvm.internal.t.f(it, "it");
            return new x(this.f15302a.g(), it);
        }
    }

    public final i a(e0 serializer, m1.b bVar, List migrations, ng.n0 scope, Function0 produceFile) {
        kotlin.jvm.internal.t.f(serializer, "serializer");
        kotlin.jvm.internal.t.f(migrations, "migrations");
        kotlin.jvm.internal.t.f(scope, "scope");
        kotlin.jvm.internal.t.f(produceFile, "produceFile");
        o oVar = new o(serializer, new a(scope), produceFile);
        List listE = dd.q.e(h.f15023a.b(migrations));
        e aVar = bVar;
        if (bVar == null) {
            aVar = new m1.a();
        }
        return new k(oVar, listE, aVar, scope);
    }
}
