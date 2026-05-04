package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import v3.b;
import v3.p;
import v3.q;
import v3.s;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class k implements ComponentCallbacks2, v3.l {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final y3.f f5242m = (y3.f) y3.f.Y(Bitmap.class).K();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final y3.f f5243n = (y3.f) y3.f.Y(t3.c.class).K();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final y3.f f5244o = (y3.f) ((y3.f) y3.f.Z(i3.j.f11667c).N(g.LOW)).T(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.b f5245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f5246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v3.j f5247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q f5248d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final p f5249e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final s f5250f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Runnable f5251g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final v3.b f5252h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CopyOnWriteArrayList f5253i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public y3.f f5254j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f5255k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f5256l;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k kVar = k.this;
            kVar.f5247c.c(kVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q f5258a;

        public b(q qVar) {
            this.f5258a = qVar;
        }

        @Override // v3.b.a
        public void a(boolean z10) {
            if (z10) {
                synchronized (k.this) {
                    this.f5258a.e();
                }
            }
        }
    }

    public k(com.bumptech.glide.b bVar, v3.j jVar, p pVar, Context context) {
        this(bVar, jVar, pVar, new q(), bVar.g(), context);
    }

    public synchronized boolean A(z3.d dVar) {
        y3.c cVarJ = dVar.j();
        if (cVarJ == null) {
            return true;
        }
        if (!this.f5248d.a(cVarJ)) {
            return false;
        }
        this.f5250f.o(dVar);
        dVar.d(null);
        return true;
    }

    public final void B(z3.d dVar) {
        boolean zA = A(dVar);
        y3.c cVarJ = dVar.j();
        if (zA || this.f5245a.p(dVar) || cVarJ == null) {
            return;
        }
        dVar.d(null);
        cVarJ.clear();
    }

    @Override // v3.l
    public synchronized void a() {
        x();
        this.f5250f.a();
    }

    @Override // v3.l
    public synchronized void e() {
        this.f5250f.e();
        p();
        this.f5248d.b();
        this.f5247c.a(this);
        this.f5247c.a(this.f5252h);
        c4.l.w(this.f5251g);
        this.f5245a.s(this);
    }

    @Override // v3.l
    public synchronized void h() {
        try {
            this.f5250f.h();
            if (this.f5256l) {
                p();
            } else {
                w();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public j l(Class cls) {
        return new j(this.f5245a, this, cls, this.f5246b);
    }

    public j m() {
        return l(Bitmap.class).a(f5242m);
    }

    public j n() {
        return l(Drawable.class);
    }

    public void o(z3.d dVar) {
        if (dVar == null) {
            return;
        }
        B(dVar);
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
        if (i10 == 60 && this.f5255k) {
            v();
        }
    }

    public final synchronized void p() {
        try {
            Iterator it = this.f5250f.m().iterator();
            while (it.hasNext()) {
                o((z3.d) it.next());
            }
            this.f5250f.l();
        } catch (Throwable th) {
            throw th;
        }
    }

    public List q() {
        return this.f5253i;
    }

    public synchronized y3.f r() {
        return this.f5254j;
    }

    public l s(Class cls) {
        return this.f5245a.i().d(cls);
    }

    public j t(Object obj) {
        return n().k0(obj);
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.f5248d + ", treeNode=" + this.f5249e + "}";
    }

    public synchronized void u() {
        this.f5248d.c();
    }

    public synchronized void v() {
        u();
        Iterator it = this.f5249e.a().iterator();
        while (it.hasNext()) {
            ((k) it.next()).u();
        }
    }

    public synchronized void w() {
        this.f5248d.d();
    }

    public synchronized void x() {
        this.f5248d.f();
    }

    public synchronized void y(y3.f fVar) {
        this.f5254j = (y3.f) ((y3.f) fVar.clone()).b();
    }

    public synchronized void z(z3.d dVar, y3.c cVar) {
        this.f5250f.n(dVar);
        this.f5248d.g(cVar);
    }

    public k(com.bumptech.glide.b bVar, v3.j jVar, p pVar, q qVar, v3.c cVar, Context context) {
        this.f5250f = new s();
        a aVar = new a();
        this.f5251g = aVar;
        this.f5245a = bVar;
        this.f5247c = jVar;
        this.f5249e = pVar;
        this.f5248d = qVar;
        this.f5246b = context;
        v3.b bVarA = cVar.a(context.getApplicationContext(), new b(qVar));
        this.f5252h = bVarA;
        bVar.o(this);
        if (c4.l.q()) {
            c4.l.v(aVar);
        } else {
            jVar.c(this);
        }
        jVar.c(bVarA);
        this.f5253i = new CopyOnWriteArrayList(bVar.i().b());
        y(bVar.i().c());
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }
}
