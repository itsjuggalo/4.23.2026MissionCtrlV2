package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import h1.C1848c;
import j1.InterfaceC2199b;
import j1.InterfaceC2200c;
import j1.p;
import j1.q;
import j1.s;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import q1.AbstractC2629l;

/* JADX INFO: loaded from: classes.dex */
public class k implements ComponentCallbacks2, j1.l {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final m1.f f14794m = (m1.f) m1.f.Z(Bitmap.class).L();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final m1.f f14795n = (m1.f) m1.f.Z(C1848c.class).L();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final m1.f f14796o = (m1.f) ((m1.f) m1.f.a0(W0.j.f9128c).O(g.LOW)).U(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.b f14797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f14798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j1.j f14799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q f14800d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final p f14801e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final s f14802f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Runnable f14803g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final InterfaceC2199b f14804h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CopyOnWriteArrayList f14805i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public m1.f f14806j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f14807k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f14808l;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k kVar = k.this;
            kVar.f14799c.c(kVar);
        }
    }

    public class b implements InterfaceC2199b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q f14810a;

        public b(q qVar) {
            this.f14810a = qVar;
        }

        @Override // j1.InterfaceC2199b.a
        public void a(boolean z7) {
            if (z7) {
                synchronized (k.this) {
                    this.f14810a.e();
                }
            }
        }
    }

    public k(com.bumptech.glide.b bVar, j1.j jVar, p pVar, Context context) {
        this(bVar, jVar, pVar, new q(), bVar.g(), context);
    }

    public synchronized boolean A(n1.d dVar) {
        m1.c cVarI = dVar.i();
        if (cVarI == null) {
            return true;
        }
        if (!this.f14800d.a(cVarI)) {
            return false;
        }
        this.f14802f.o(dVar);
        dVar.k(null);
        return true;
    }

    public final void B(n1.d dVar) {
        boolean zA = A(dVar);
        m1.c cVarI = dVar.i();
        if (zA || this.f14797a.p(dVar) || cVarI == null) {
            return;
        }
        dVar.k(null);
        cVarI.clear();
    }

    @Override // j1.l
    public synchronized void a() {
        x();
        this.f14802f.a();
    }

    @Override // j1.l
    public synchronized void c() {
        this.f14802f.c();
        p();
        this.f14800d.b();
        this.f14799c.a(this);
        this.f14799c.a(this.f14804h);
        AbstractC2629l.v(this.f14803g);
        this.f14797a.s(this);
    }

    @Override // j1.l
    public synchronized void f() {
        try {
            this.f14802f.f();
            if (this.f14808l) {
                p();
            } else {
                w();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public j l(Class cls) {
        return new j(this.f14797a, this, cls, this.f14798b);
    }

    public j m() {
        return l(Bitmap.class).b(f14794m);
    }

    public j n() {
        return l(Drawable.class);
    }

    public void o(n1.d dVar) {
        if (dVar == null) {
            return;
        }
        B(dVar);
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i8) {
        if (i8 == 60 && this.f14807k) {
            v();
        }
    }

    public final synchronized void p() {
        try {
            Iterator it = this.f14802f.m().iterator();
            while (it.hasNext()) {
                o((n1.d) it.next());
            }
            this.f14802f.l();
        } catch (Throwable th) {
            throw th;
        }
    }

    public List q() {
        return this.f14805i;
    }

    public synchronized m1.f r() {
        return this.f14806j;
    }

    public l s(Class cls) {
        return this.f14797a.i().d(cls);
    }

    public j t(Object obj) {
        return n().l0(obj);
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.f14800d + ", treeNode=" + this.f14801e + "}";
    }

    public synchronized void u() {
        this.f14800d.c();
    }

    public synchronized void v() {
        u();
        Iterator it = this.f14801e.a().iterator();
        while (it.hasNext()) {
            ((k) it.next()).u();
        }
    }

    public synchronized void w() {
        this.f14800d.d();
    }

    public synchronized void x() {
        this.f14800d.f();
    }

    public synchronized void y(m1.f fVar) {
        this.f14806j = (m1.f) ((m1.f) fVar.clone()).c();
    }

    public synchronized void z(n1.d dVar, m1.c cVar) {
        this.f14802f.n(dVar);
        this.f14800d.g(cVar);
    }

    public k(com.bumptech.glide.b bVar, j1.j jVar, p pVar, q qVar, InterfaceC2200c interfaceC2200c, Context context) {
        this.f14802f = new s();
        a aVar = new a();
        this.f14803g = aVar;
        this.f14797a = bVar;
        this.f14799c = jVar;
        this.f14801e = pVar;
        this.f14800d = qVar;
        this.f14798b = context;
        InterfaceC2199b interfaceC2199bA = interfaceC2200c.a(context.getApplicationContext(), new b(qVar));
        this.f14804h = interfaceC2199bA;
        bVar.o(this);
        if (AbstractC2629l.q()) {
            AbstractC2629l.u(aVar);
        } else {
            jVar.c(this);
        }
        jVar.c(interfaceC2199bA);
        this.f14805i = new CopyOnWriteArrayList(bVar.i().b());
        y(bVar.i().c());
    }
}
