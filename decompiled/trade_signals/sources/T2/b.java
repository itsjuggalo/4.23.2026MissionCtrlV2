package T2;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import l2.AbstractC2328l;
import l2.AbstractC2331o;
import l2.C2318b;
import l2.C2329m;
import l2.InterfaceC2319c;
import w0.ExecutorC2893k;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Executor f7938a = new ExecutorC2893k();

    public static /* synthetic */ AbstractC2328l b(C2329m c2329m, AtomicBoolean atomicBoolean, C2318b c2318b, AbstractC2328l abstractC2328l) {
        if (abstractC2328l.o()) {
            c2329m.e(abstractC2328l.k());
        } else if (abstractC2328l.j() != null) {
            c2329m.d(abstractC2328l.j());
        } else if (atomicBoolean.getAndSet(true)) {
            c2318b.a();
        }
        return AbstractC2331o.e(null);
    }

    public static AbstractC2328l c(AbstractC2328l abstractC2328l, AbstractC2328l abstractC2328l2) {
        final C2318b c2318b = new C2318b();
        final C2329m c2329m = new C2329m(c2318b.b());
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        InterfaceC2319c interfaceC2319c = new InterfaceC2319c() { // from class: T2.a
            @Override // l2.InterfaceC2319c
            public final Object a(AbstractC2328l abstractC2328l3) {
                return b.b(c2329m, atomicBoolean, c2318b, abstractC2328l3);
            }
        };
        Executor executor = f7938a;
        abstractC2328l.i(executor, interfaceC2319c);
        abstractC2328l2.i(executor, interfaceC2319c);
        return c2329m.a();
    }
}
