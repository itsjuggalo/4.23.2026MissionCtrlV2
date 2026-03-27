package r5;

import java.util.Iterator;
import java.util.List;
import r5.AbstractC2591g;

/* JADX INFO: renamed from: r5.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2594j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AbstractC2591g f22693a = new a();

    /* JADX INFO: renamed from: r5.j$b */
    public static class b extends AbstractC2588d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractC2588d f22694a;

        public /* synthetic */ b(AbstractC2588d abstractC2588d, InterfaceC2592h interfaceC2592h, AbstractC2593i abstractC2593i) {
            this(abstractC2588d, interfaceC2592h);
        }

        @Override // r5.AbstractC2588d
        public String a() {
            return this.f22694a.a();
        }

        @Override // r5.AbstractC2588d
        public AbstractC2591g g(a0 a0Var, C2587c c2587c) {
            throw null;
        }

        public b(AbstractC2588d abstractC2588d, InterfaceC2592h interfaceC2592h) {
            this.f22694a = abstractC2588d;
            android.support.v4.media.session.b.a(H2.m.o(interfaceC2592h, "interceptor"));
        }
    }

    public static AbstractC2588d a(AbstractC2588d abstractC2588d, List list) {
        H2.m.o(abstractC2588d, "channel");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            android.support.v4.media.session.b.a(it.next());
            AbstractC2593i abstractC2593i = null;
            abstractC2588d = new b(abstractC2588d, abstractC2593i, abstractC2593i);
        }
        return abstractC2588d;
    }

    /* JADX INFO: renamed from: r5.j$a */
    public class a extends AbstractC2591g {
        @Override // r5.AbstractC2591g
        public void b() {
        }

        @Override // r5.AbstractC2591g
        public void c(int i7) {
        }

        @Override // r5.AbstractC2591g
        public void d(Object obj) {
        }

        @Override // r5.AbstractC2591g
        public void a(String str, Throwable th) {
        }

        @Override // r5.AbstractC2591g
        public void e(AbstractC2591g.a aVar, Z z7) {
        }
    }
}
