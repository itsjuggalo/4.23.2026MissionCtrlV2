package M2;

import K2.AbstractC0363k;
import K2.C0355c;
import K2.S;
import M2.InterfaceC0431l0;
import M2.InterfaceC0443s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class B implements InterfaceC0431l0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f1658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final K2.p0 f1659d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Runnable f1660e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Runnable f1661f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Runnable f1662g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public InterfaceC0431l0.a f1663h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public K2.l0 f1665j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public S.j f1666k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f1667l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final K2.K f1656a = K2.K.a(B.class, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1657b = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Collection f1664i = new LinkedHashSet();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC0431l0.a f1668a;

        public a(InterfaceC0431l0.a aVar) {
            this.f1668a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1668a.c(true);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC0431l0.a f1670a;

        public b(InterfaceC0431l0.a aVar) {
            this.f1670a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1670a.c(false);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC0431l0.a f1672a;

        public c(InterfaceC0431l0.a aVar) {
            this.f1672a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1672a.b();
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ K2.l0 f1674a;

        public d(K2.l0 l0Var) {
            this.f1674a = l0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            B.this.f1663h.d(this.f1674a);
        }
    }

    public class e extends C {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final S.g f1676j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final K2.r f1677k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final AbstractC0363k[] f1678l;

        public /* synthetic */ e(B b4, S.g gVar, AbstractC0363k[] abstractC0363kArr, a aVar) {
            this(gVar, abstractC0363kArr);
        }

        public final Runnable C(InterfaceC0445t interfaceC0445t) {
            K2.r rVarB = this.f1677k.b();
            try {
                r rVarC = interfaceC0445t.c(this.f1676j.c(), this.f1676j.b(), this.f1676j.a(), this.f1678l);
                this.f1677k.f(rVarB);
                return y(rVarC);
            } catch (Throwable th) {
                this.f1677k.f(rVarB);
                throw th;
            }
        }

        @Override // M2.C, M2.r
        public void c(K2.l0 l0Var) {
            super.c(l0Var);
            synchronized (B.this.f1657b) {
                try {
                    if (B.this.f1662g != null) {
                        boolean zRemove = B.this.f1664i.remove(this);
                        if (!B.this.r() && zRemove) {
                            B.this.f1659d.b(B.this.f1661f);
                            if (B.this.f1665j != null) {
                                B.this.f1659d.b(B.this.f1662g);
                                B.this.f1662g = null;
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            B.this.f1659d.a();
        }

        @Override // M2.C, M2.r
        public void n(Y y4) {
            if (this.f1676j.a().j()) {
                y4.a("wait_for_ready");
            }
            super.n(y4);
        }

        @Override // M2.C
        public void w(K2.l0 l0Var) {
            for (AbstractC0363k abstractC0363k : this.f1678l) {
                abstractC0363k.i(l0Var);
            }
        }

        public e(S.g gVar, AbstractC0363k[] abstractC0363kArr) {
            this.f1677k = K2.r.e();
            this.f1676j = gVar;
            this.f1678l = abstractC0363kArr;
        }
    }

    public B(Executor executor, K2.p0 p0Var) {
        this.f1658c = executor;
        this.f1659d = p0Var;
    }

    @Override // M2.InterfaceC0431l0
    public final void b(K2.l0 l0Var) {
        Collection<e> collection;
        Runnable runnable;
        e(l0Var);
        synchronized (this.f1657b) {
            try {
                collection = this.f1664i;
                runnable = this.f1662g;
                this.f1662g = null;
                if (!collection.isEmpty()) {
                    this.f1664i = Collections.EMPTY_LIST;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (runnable != null) {
            for (e eVar : collection) {
                Runnable runnableY = eVar.y(new G(l0Var, InterfaceC0443s.a.REFUSED, eVar.f1678l));
                if (runnableY != null) {
                    runnableY.run();
                }
            }
            this.f1659d.execute(runnable);
        }
    }

    @Override // M2.InterfaceC0445t
    public final r c(K2.a0 a0Var, K2.Z z4, C0355c c0355c, AbstractC0363k[] abstractC0363kArr) {
        r g4;
        try {
            C0452w0 c0452w0 = new C0452w0(a0Var, z4, c0355c);
            S.j jVar = null;
            long j4 = -1;
            while (true) {
                synchronized (this.f1657b) {
                    if (this.f1665j == null) {
                        S.j jVar2 = this.f1666k;
                        if (jVar2 != null) {
                            if (jVar != null && j4 == this.f1667l) {
                                g4 = p(c0452w0, abstractC0363kArr);
                                break;
                            }
                            j4 = this.f1667l;
                            InterfaceC0445t interfaceC0445tK = S.k(jVar2.a(c0452w0), c0355c.j());
                            if (interfaceC0445tK != null) {
                                g4 = interfaceC0445tK.c(c0452w0.c(), c0452w0.b(), c0452w0.a(), abstractC0363kArr);
                                break;
                            }
                            jVar = jVar2;
                        } else {
                            g4 = p(c0452w0, abstractC0363kArr);
                            break;
                        }
                    } else {
                        g4 = new G(this.f1665j, abstractC0363kArr);
                        break;
                    }
                }
            }
            return g4;
        } finally {
            this.f1659d.a();
        }
    }

    @Override // M2.InterfaceC0431l0
    public final void e(K2.l0 l0Var) {
        Runnable runnable;
        synchronized (this.f1657b) {
            try {
                if (this.f1665j != null) {
                    return;
                }
                this.f1665j = l0Var;
                this.f1659d.b(new d(l0Var));
                if (!r() && (runnable = this.f1662g) != null) {
                    this.f1659d.b(runnable);
                    this.f1662g = null;
                }
                this.f1659d.a();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // K2.P
    public K2.K h() {
        return this.f1656a;
    }

    @Override // M2.InterfaceC0431l0
    public final Runnable i(InterfaceC0431l0.a aVar) {
        this.f1663h = aVar;
        this.f1660e = new a(aVar);
        this.f1661f = new b(aVar);
        this.f1662g = new c(aVar);
        return null;
    }

    public final e p(S.g gVar, AbstractC0363k[] abstractC0363kArr) {
        e eVar = new e(this, gVar, abstractC0363kArr, null);
        this.f1664i.add(eVar);
        if (q() == 1) {
            this.f1659d.b(this.f1660e);
        }
        for (AbstractC0363k abstractC0363k : abstractC0363kArr) {
            abstractC0363k.j();
        }
        return eVar;
    }

    public final int q() {
        int size;
        synchronized (this.f1657b) {
            size = this.f1664i.size();
        }
        return size;
    }

    public final boolean r() {
        boolean z4;
        synchronized (this.f1657b) {
            z4 = !this.f1664i.isEmpty();
        }
        return z4;
    }

    public final void s(S.j jVar) {
        Runnable runnable;
        synchronized (this.f1657b) {
            this.f1666k = jVar;
            this.f1667l++;
            if (jVar != null && r()) {
                ArrayList<e> arrayList = new ArrayList(this.f1664i);
                ArrayList arrayList2 = new ArrayList();
                for (e eVar : arrayList) {
                    S.f fVarA = jVar.a(eVar.f1676j);
                    C0355c c0355cA = eVar.f1676j.a();
                    InterfaceC0445t interfaceC0445tK = S.k(fVarA, c0355cA.j());
                    if (interfaceC0445tK != null) {
                        Executor executorE = this.f1658c;
                        if (c0355cA.e() != null) {
                            executorE = c0355cA.e();
                        }
                        Runnable runnableC = eVar.C(interfaceC0445tK);
                        if (runnableC != null) {
                            executorE.execute(runnableC);
                        }
                        arrayList2.add(eVar);
                    }
                }
                synchronized (this.f1657b) {
                    try {
                        if (r()) {
                            this.f1664i.removeAll(arrayList2);
                            if (this.f1664i.isEmpty()) {
                                this.f1664i = new LinkedHashSet();
                            }
                            if (!r()) {
                                this.f1659d.b(this.f1661f);
                                if (this.f1665j != null && (runnable = this.f1662g) != null) {
                                    this.f1659d.b(runnable);
                                    this.f1662g = null;
                                }
                            }
                            this.f1659d.a();
                        }
                    } finally {
                    }
                }
            }
        }
    }
}
