package j3;

import e3.C1478g;
import h3.AbstractC1695i;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: j3.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2059o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2051g f17428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i3.f f17429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f17430c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f17431d = new a(false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f17432e = new a(true);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C2055k f17433f = new C2055k(128);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicMarkableReference f17434g = new AtomicMarkableReference(null, false);

    /* JADX INFO: renamed from: j3.o$a */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicMarkableReference f17435a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicReference f17436b = new AtomicReference(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f17437c;

        public a(boolean z7) {
            this.f17437c = z7;
            this.f17435a = new AtomicMarkableReference(new C2049e(64, z7 ? 8192 : 1024), false);
        }

        public Map b() {
            return ((C2049e) this.f17435a.getReference()).a();
        }

        public final /* synthetic */ void c() throws Throwable {
            this.f17436b.set(null);
            e();
        }

        public final void d() {
            Runnable runnable = new Runnable() { // from class: j3.n
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    this.f17427a.c();
                }
            };
            if (com.amazon.a.a.l.d.a(this.f17436b, null, runnable)) {
                C2059o.this.f17429b.f16263b.f(runnable);
            }
        }

        public final void e() throws Throwable {
            Map mapA;
            synchronized (this) {
                try {
                    if (this.f17435a.isMarked()) {
                        mapA = ((C2049e) this.f17435a.getReference()).a();
                        AtomicMarkableReference atomicMarkableReference = this.f17435a;
                        atomicMarkableReference.set((C2049e) atomicMarkableReference.getReference(), false);
                    } else {
                        mapA = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (mapA != null) {
                C2059o.this.f17428a.r(C2059o.this.f17430c, mapA, this.f17437c);
            }
        }

        public boolean f(String str, String str2) {
            synchronized (this) {
                try {
                    if (!((C2049e) this.f17435a.getReference()).d(str, str2)) {
                        return false;
                    }
                    AtomicMarkableReference atomicMarkableReference = this.f17435a;
                    atomicMarkableReference.set((C2049e) atomicMarkableReference.getReference(), true);
                    d();
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public C2059o(String str, n3.g gVar, i3.f fVar) {
        this.f17430c = str;
        this.f17428a = new C2051g(gVar);
        this.f17429b = fVar;
    }

    public static C2059o k(String str, n3.g gVar, i3.f fVar) {
        C2051g c2051g = new C2051g(gVar);
        C2059o c2059o = new C2059o(str, gVar, fVar);
        ((C2049e) c2059o.f17431d.f17435a.getReference()).e(c2051g.i(str, false));
        ((C2049e) c2059o.f17432e.f17435a.getReference()).e(c2051g.i(str, true));
        c2059o.f17434g.set(c2051g.k(str), false);
        c2059o.f17433f.c(c2051g.j(str));
        return c2059o;
    }

    public static String l(String str, n3.g gVar) {
        return new C2051g(gVar).k(str);
    }

    public Map f(Map map) {
        if (map.isEmpty()) {
            return this.f17431d.b();
        }
        HashMap map2 = new HashMap(this.f17431d.b());
        int i7 = 0;
        for (Map.Entry entry : map.entrySet()) {
            String strC = C2049e.c((String) entry.getKey(), 1024);
            if (map2.size() < 64 || map2.containsKey(strC)) {
                map2.put(strC, C2049e.c((String) entry.getValue(), 1024));
            } else {
                i7++;
            }
        }
        if (i7 > 0) {
            C1478g.f().k("Ignored " + i7 + " keys when adding event specific keys. Maximum allowable: 1024");
        }
        return Collections.unmodifiableMap(map2);
    }

    public Map g() {
        return this.f17432e.b();
    }

    public List h() {
        return this.f17433f.a();
    }

    public String i() {
        return (String) this.f17434g.getReference();
    }

    public final /* synthetic */ void j(String str, Map map, List list) throws Throwable {
        if (i() != null) {
            this.f17428a.t(str, i());
        }
        if (!map.isEmpty()) {
            this.f17428a.q(str, map);
        }
        if (list.isEmpty()) {
            return;
        }
        this.f17428a.s(str, list);
    }

    public final void m() throws Throwable {
        boolean z7;
        String strI;
        synchronized (this.f17434g) {
            try {
                z7 = false;
                if (this.f17434g.isMarked()) {
                    strI = i();
                    this.f17434g.set(strI, false);
                    z7 = true;
                } else {
                    strI = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z7) {
            this.f17428a.t(this.f17430c, strI);
        }
    }

    public boolean n(String str, String str2) {
        return this.f17431d.f(str, str2);
    }

    public boolean o(String str, String str2) {
        return this.f17432e.f(str, str2);
    }

    public void p(final String str) {
        synchronized (this.f17430c) {
            this.f17430c = str;
            final Map mapB = this.f17431d.b();
            final List listB = this.f17433f.b();
            this.f17429b.f16263b.f(new Runnable() { // from class: j3.l
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    this.f17422a.j(str, mapB, listB);
                }
            });
        }
    }

    public void q(String str) {
        String strC = C2049e.c(str, 1024);
        synchronized (this.f17434g) {
            try {
                if (AbstractC1695i.z(strC, (String) this.f17434g.getReference())) {
                    return;
                }
                this.f17434g.set(strC, true);
                this.f17429b.f16263b.f(new Runnable() { // from class: j3.m
                    @Override // java.lang.Runnable
                    public final void run() throws Throwable {
                        this.f17426a.m();
                    }
                });
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
