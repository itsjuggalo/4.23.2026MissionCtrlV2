package tb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.concurrent.Executor;
import rb.r0;
import tb.k1;
import tb.s;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class b0 implements k1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f20940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final rb.o1 f20941d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Runnable f20942e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Runnable f20943f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Runnable f20944g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public k1.a f20945h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public rb.k1 f20947j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public r0.j f20948k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f20949l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final rb.k0 f20938a = rb.k0.a(b0.class, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f20939b = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Collection f20946i = new LinkedHashSet();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k1.a f20950a;

        public a(k1.a aVar) {
            this.f20950a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f20950a.d(true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k1.a f20952a;

        public b(k1.a aVar) {
            this.f20952a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f20952a.d(false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k1.a f20954a;

        public c(k1.a aVar) {
            this.f20954a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f20954a.b();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ rb.k1 f20956a;

        public d(rb.k1 k1Var) {
            this.f20956a = k1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.this.f20945h.c(this.f20956a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class e extends c0 {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final r0.g f20958j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final rb.r f20959k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final rb.k[] f20960l;

        public /* synthetic */ e(b0 b0Var, r0.g gVar, rb.k[] kVarArr, a aVar) {
            this(gVar, kVarArr);
        }

        public final Runnable A(t tVar) {
            rb.r rVarB = this.f20959k.b();
            try {
                r rVarG = tVar.g(this.f20958j.c(), this.f20958j.b(), this.f20958j.a(), this.f20960l);
                this.f20959k.f(rVarB);
                return w(rVarG);
            } catch (Throwable th) {
                this.f20959k.f(rVarB);
                throw th;
            }
        }

        @Override // tb.c0, tb.r
        public void e(rb.k1 k1Var) {
            super.e(k1Var);
            synchronized (b0.this.f20939b) {
                try {
                    if (b0.this.f20944g != null) {
                        boolean zRemove = b0.this.f20946i.remove(this);
                        if (!b0.this.q() && zRemove) {
                            b0.this.f20941d.b(b0.this.f20943f);
                            if (b0.this.f20947j != null) {
                                b0.this.f20941d.b(b0.this.f20944g);
                                b0.this.f20944g = null;
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            b0.this.f20941d.a();
        }

        @Override // tb.c0, tb.r
        public void l(x0 x0Var) {
            if (this.f20958j.a().j()) {
                x0Var.a("wait_for_ready");
            }
            super.l(x0Var);
        }

        @Override // tb.c0
        public void u(rb.k1 k1Var) {
            for (rb.k kVar : this.f20960l) {
                kVar.i(k1Var);
            }
        }

        public e(r0.g gVar, rb.k[] kVarArr) {
            this.f20959k = rb.r.e();
            this.f20958j = gVar;
            this.f20960l = kVarArr;
        }
    }

    public b0(Executor executor, rb.o1 o1Var) {
        this.f20940c = executor;
        this.f20941d = o1Var;
    }

    @Override // tb.k1
    public final void c(rb.k1 k1Var) {
        Runnable runnable;
        synchronized (this.f20939b) {
            try {
                if (this.f20947j != null) {
                    return;
                }
                this.f20947j = k1Var;
                this.f20941d.b(new d(k1Var));
                if (!q() && (runnable = this.f20944g) != null) {
                    this.f20941d.b(runnable);
                    this.f20944g = null;
                }
                this.f20941d.a();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // tb.k1
    public final Runnable d(k1.a aVar) {
        this.f20945h = aVar;
        this.f20942e = new a(aVar);
        this.f20943f = new b(aVar);
        this.f20944g = new c(aVar);
        return null;
    }

    @Override // rb.p0
    public rb.k0 f() {
        return this.f20938a;
    }

    @Override // tb.t
    public final r g(rb.z0 z0Var, rb.y0 y0Var, rb.c cVar, rb.k[] kVarArr) {
        r g0Var;
        try {
            v1 v1Var = new v1(z0Var, y0Var, cVar);
            r0.j jVar = null;
            long j10 = -1;
            while (true) {
                synchronized (this.f20939b) {
                    if (this.f20947j == null) {
                        r0.j jVar2 = this.f20948k;
                        if (jVar2 != null) {
                            if (jVar != null && j10 == this.f20949l) {
                                g0Var = o(v1Var, kVarArr);
                                break;
                            }
                            j10 = this.f20949l;
                            t tVarK = r0.k(jVar2.a(v1Var), cVar.j());
                            if (tVarK != null) {
                                g0Var = tVarK.g(v1Var.c(), v1Var.b(), v1Var.a(), kVarArr);
                                break;
                            }
                            jVar = jVar2;
                        } else {
                            g0Var = o(v1Var, kVarArr);
                            break;
                        }
                    } else {
                        g0Var = new g0(this.f20947j, kVarArr);
                        break;
                    }
                }
            }
            return g0Var;
        } finally {
            this.f20941d.a();
        }
    }

    @Override // tb.k1
    public final void h(rb.k1 k1Var) {
        Collection<e> collection;
        Runnable runnable;
        c(k1Var);
        synchronized (this.f20939b) {
            try {
                collection = this.f20946i;
                runnable = this.f20944g;
                this.f20944g = null;
                if (!collection.isEmpty()) {
                    this.f20946i = Collections.EMPTY_LIST;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (runnable != null) {
            for (e eVar : collection) {
                Runnable runnableW = eVar.w(new g0(k1Var, s.a.REFUSED, eVar.f20960l));
                if (runnableW != null) {
                    runnableW.run();
                }
            }
            this.f20941d.execute(runnable);
        }
    }

    public final e o(r0.g gVar, rb.k[] kVarArr) {
        e eVar = new e(this, gVar, kVarArr, null);
        this.f20946i.add(eVar);
        if (p() == 1) {
            this.f20941d.b(this.f20942e);
        }
        for (rb.k kVar : kVarArr) {
            kVar.j();
        }
        return eVar;
    }

    public final int p() {
        int size;
        synchronized (this.f20939b) {
            size = this.f20946i.size();
        }
        return size;
    }

    public final boolean q() {
        boolean z10;
        synchronized (this.f20939b) {
            z10 = !this.f20946i.isEmpty();
        }
        return z10;
    }

    public final void r(r0.j jVar) {
        Runnable runnable;
        synchronized (this.f20939b) {
            this.f20948k = jVar;
            this.f20949l++;
            if (jVar != null && q()) {
                ArrayList<e> arrayList = new ArrayList(this.f20946i);
                ArrayList arrayList2 = new ArrayList();
                for (e eVar : arrayList) {
                    r0.f fVarA = jVar.a(eVar.f20958j);
                    rb.c cVarA = eVar.f20958j.a();
                    t tVarK = r0.k(fVarA, cVarA.j());
                    if (tVarK != null) {
                        Executor executorE = this.f20940c;
                        if (cVarA.e() != null) {
                            executorE = cVarA.e();
                        }
                        Runnable runnableA = eVar.A(tVarK);
                        if (runnableA != null) {
                            executorE.execute(runnableA);
                        }
                        arrayList2.add(eVar);
                    }
                }
                synchronized (this.f20939b) {
                    try {
                        if (q()) {
                            this.f20946i.removeAll(arrayList2);
                            if (this.f20946i.isEmpty()) {
                                this.f20946i = new LinkedHashSet();
                            }
                            if (!q()) {
                                this.f20941d.b(this.f20943f);
                                if (this.f20947j != null && (runnable = this.f20944g) != null) {
                                    this.f20941d.b(runnable);
                                    this.f20944g = null;
                                }
                            }
                            this.f20941d.a();
                        }
                    } finally {
                    }
                }
            }
        }
    }
}
