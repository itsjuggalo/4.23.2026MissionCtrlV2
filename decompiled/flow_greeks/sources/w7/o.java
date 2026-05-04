package w7;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;
import w7.o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f23737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v7.i f23738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f23739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f23740d = new a(false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f23741e = new a(true);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final k f23742f = new k(128);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicMarkableReference f23743g = new AtomicMarkableReference(null, false);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicMarkableReference f23744a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicReference f23745b = new AtomicReference(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f23746c;

        public a(boolean z10) {
            this.f23746c = z10;
            this.f23744a = new AtomicMarkableReference(new e(64, z10 ? 8192 : 1024), false);
        }

        public static /* synthetic */ void a(a aVar) throws Throwable {
            aVar.f23745b.set(null);
            aVar.d();
        }

        public Map b() {
            return ((e) this.f23744a.getReference()).a();
        }

        public final void c() {
            Runnable runnable = new Runnable() { // from class: w7.n
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    o.a.a(this.f23736a);
                }
            };
            if (com.amazon.a.a.l.d.a(this.f23745b, null, runnable)) {
                o.this.f23738b.f23153b.e(runnable);
            }
        }

        public final void d() throws Throwable {
            Map mapA;
            synchronized (this) {
                try {
                    if (this.f23744a.isMarked()) {
                        mapA = ((e) this.f23744a.getReference()).a();
                        AtomicMarkableReference atomicMarkableReference = this.f23744a;
                        atomicMarkableReference.set((e) atomicMarkableReference.getReference(), false);
                    } else {
                        mapA = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (mapA != null) {
                o.this.f23737a.r(o.this.f23739c, mapA, this.f23746c);
            }
        }

        public boolean e(String str, String str2) {
            synchronized (this) {
                try {
                    if (!((e) this.f23744a.getReference()).d(str, str2)) {
                        return false;
                    }
                    AtomicMarkableReference atomicMarkableReference = this.f23744a;
                    atomicMarkableReference.set((e) atomicMarkableReference.getReference(), true);
                    c();
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public o(String str, a8.g gVar, v7.i iVar) {
        this.f23739c = str;
        this.f23737a = new g(gVar);
        this.f23738b = iVar;
    }

    public static /* synthetic */ void b(o oVar, String str, Map map, List list) throws Throwable {
        if (oVar.i() != null) {
            oVar.f23737a.t(str, oVar.i());
        }
        if (!map.isEmpty()) {
            oVar.f23737a.q(str, map);
        }
        if (list.isEmpty()) {
            return;
        }
        oVar.f23737a.s(str, list);
    }

    public static o j(String str, a8.g gVar, v7.i iVar) {
        g gVar2 = new g(gVar);
        o oVar = new o(str, gVar, iVar);
        ((e) oVar.f23740d.f23744a.getReference()).e(gVar2.i(str, false));
        ((e) oVar.f23741e.f23744a.getReference()).e(gVar2.i(str, true));
        oVar.f23743g.set(gVar2.k(str), false);
        oVar.f23742f.c(gVar2.j(str));
        return oVar;
    }

    public static String k(String str, a8.g gVar) {
        return new g(gVar).k(str);
    }

    public Map f(Map map) {
        if (map.isEmpty()) {
            return this.f23740d.b();
        }
        HashMap map2 = new HashMap(this.f23740d.b());
        int i10 = 0;
        for (Map.Entry entry : map.entrySet()) {
            String strC = e.c((String) entry.getKey(), 1024);
            if (map2.size() < 64 || map2.containsKey(strC)) {
                map2.put(strC, e.c((String) entry.getValue(), 1024));
            } else {
                i10++;
            }
        }
        if (i10 > 0) {
            r7.g.f().k("Ignored " + i10 + " keys when adding event specific keys. Maximum allowable: 1024");
        }
        return Collections.unmodifiableMap(map2);
    }

    public Map g() {
        return this.f23741e.b();
    }

    public List h() {
        return this.f23742f.a();
    }

    public String i() {
        return (String) this.f23743g.getReference();
    }

    public boolean l(String str, String str2) {
        return this.f23741e.e(str, str2);
    }

    public void m(final String str) {
        synchronized (this.f23739c) {
            this.f23739c = str;
            final Map mapB = this.f23740d.b();
            final List listB = this.f23742f.b();
            this.f23738b.f23153b.e(new Runnable() { // from class: w7.l
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    o.b(this.f23730a, str, mapB, listB);
                }
            });
        }
    }

    public boolean n(List list) {
        synchronized (this.f23742f) {
            try {
                if (!this.f23742f.c(list)) {
                    return false;
                }
                final List listB = this.f23742f.b();
                this.f23738b.f23153b.e(new Runnable() { // from class: w7.m
                    @Override // java.lang.Runnable
                    public final void run() throws Throwable {
                        o oVar = this.f23734a;
                        oVar.f23737a.s(oVar.f23739c, listB);
                    }
                });
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
