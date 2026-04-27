package U;

import X2.AbstractC0769p;
import android.content.Context;
import i3.k;
import java.util.List;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import l3.InterfaceC1591a;
import t3.C1803a0;
import t3.L;
import t3.M;
import t3.S0;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: U.a$a, reason: collision with other inner class name */
    public static final class C0072a extends s implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0072a f5225a = new C0072a();

        public C0072a() {
            super(1);
        }

        @Override // i3.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List invoke(Context it) {
            r.f(it, "it");
            return AbstractC0769p.g();
        }
    }

    public static final InterfaceC1591a a(String name, T.b bVar, k produceMigrations, L scope) {
        r.f(name, "name");
        r.f(produceMigrations, "produceMigrations");
        r.f(scope, "scope");
        return new c(name, bVar, produceMigrations, scope);
    }

    public static /* synthetic */ InterfaceC1591a b(String str, T.b bVar, k kVar, L l4, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            bVar = null;
        }
        if ((i4 & 4) != 0) {
            kVar = C0072a.f5225a;
        }
        if ((i4 & 8) != 0) {
            l4 = M.a(C1803a0.b().plus(S0.b(null, 1, null)));
        }
        return a(str, bVar, kVar, l4);
    }
}
