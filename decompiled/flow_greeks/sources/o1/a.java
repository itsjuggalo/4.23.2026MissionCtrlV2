package o1;

import android.content.Context;
import dd.r;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import ng.c1;
import ng.n0;
import ng.o0;
import ng.t2;
import pd.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: o1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0304a extends v implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0304a f17438a = new C0304a();

        public C0304a() {
            super(1);
        }

        @Override // pd.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List invoke(Context it) {
            t.f(it, "it");
            return r.k();
        }
    }

    public static final sd.c a(String name, m1.b bVar, k produceMigrations, n0 scope) {
        t.f(name, "name");
        t.f(produceMigrations, "produceMigrations");
        t.f(scope, "scope");
        return new c(name, bVar, produceMigrations, scope);
    }

    public static /* synthetic */ sd.c b(String str, m1.b bVar, k kVar, n0 n0Var, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            bVar = null;
        }
        if ((i10 & 4) != 0) {
            kVar = C0304a.f17438a;
        }
        if ((i10 & 8) != 0) {
            n0Var = o0.a(c1.b().plus(t2.b(null, 1, null)));
        }
        return a(str, bVar, kVar, n0Var);
    }
}
