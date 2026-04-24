package U2;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f8151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T2.i f8152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f8153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f8154d = new a(false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f8155e = new a(true);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final k f8156f = new k(128);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicMarkableReference f8157g = new AtomicMarkableReference(null, false);

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicMarkableReference f8158a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicReference f8159b = new AtomicReference(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f8160c;

        public a(boolean z7) {
            this.f8160c = z7;
            this.f8158a = new AtomicMarkableReference(new e(64, z7 ? 8192 : 1024), false);
        }

        public Map b() {
            return ((e) this.f8158a.getReference()).a();
        }

        public final /* synthetic */ void c() throws Throwable {
            this.f8159b.set(null);
            e();
        }

        public final void d() {
            Runnable runnable = new Runnable() { // from class: U2.n
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    this.f8150a.c();
                }
            };
            if (com.amazon.a.a.l.d.a(this.f8159b, null, runnable)) {
                o.this.f8152b.f7947b.f(runnable);
            }
        }

        public final void e() throws Throwable {
            Map mapA;
            synchronized (this) {
                try {
                    if (this.f8158a.isMarked()) {
                        mapA = ((e) this.f8158a.getReference()).a();
                        AtomicMarkableReference atomicMarkableReference = this.f8158a;
                        atomicMarkableReference.set((e) atomicMarkableReference.getReference(), false);
                    } else {
                        mapA = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (mapA != null) {
                o.this.f8151a.r(o.this.f8153c, mapA, this.f8160c);
            }
        }

        public boolean f(String str, String str2) {
            synchronized (this) {
                try {
                    if (!((e) this.f8158a.getReference()).d(str, str2)) {
                        return false;
                    }
                    AtomicMarkableReference atomicMarkableReference = this.f8158a;
                    atomicMarkableReference.set((e) atomicMarkableReference.getReference(), true);
                    d();
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public o(String str, Y2.g gVar, T2.i iVar) {
        this.f8153c = str;
        this.f8151a = new g(gVar);
        this.f8152b = iVar;
    }

    public static o l(String str, Y2.g gVar, T2.i iVar) {
        g gVar2 = new g(gVar);
        o oVar = new o(str, gVar, iVar);
        ((e) oVar.f8154d.f8158a.getReference()).e(gVar2.i(str, false));
        ((e) oVar.f8155e.f8158a.getReference()).e(gVar2.i(str, true));
        oVar.f8157g.set(gVar2.k(str), false);
        oVar.f8156f.c(gVar2.j(str));
        return oVar;
    }

    public static String m(String str, Y2.g gVar) {
        return new g(gVar).k(str);
    }

    public Map f(Map map) {
        if (map.isEmpty()) {
            return this.f8154d.b();
        }
        HashMap map2 = new HashMap(this.f8154d.b());
        int i8 = 0;
        for (Map.Entry entry : map.entrySet()) {
            String strC = e.c((String) entry.getKey(), 1024);
            if (map2.size() < 64 || map2.containsKey(strC)) {
                map2.put(strC, e.c((String) entry.getValue(), 1024));
            } else {
                i8++;
            }
        }
        if (i8 > 0) {
            P2.g.f().k("Ignored " + i8 + " keys when adding event specific keys. Maximum allowable: 1024");
        }
        return Collections.unmodifiableMap(map2);
    }

    public Map g() {
        return this.f8155e.b();
    }

    public List h() {
        return this.f8156f.a();
    }

    public String i() {
        return (String) this.f8157g.getReference();
    }

    public final /* synthetic */ void j(String str, Map map, List list) throws Throwable {
        if (i() != null) {
            this.f8151a.t(str, i());
        }
        if (!map.isEmpty()) {
            this.f8151a.q(str, map);
        }
        if (list.isEmpty()) {
            return;
        }
        this.f8151a.s(str, list);
    }

    public final /* synthetic */ void k(List list) throws Throwable {
        this.f8151a.s(this.f8153c, list);
    }

    public boolean n(String str, String str2) {
        return this.f8155e.f(str, str2);
    }

    public void o(final String str) {
        synchronized (this.f8153c) {
            this.f8153c = str;
            final Map mapB = this.f8154d.b();
            final List listB = this.f8156f.b();
            this.f8152b.f7947b.f(new Runnable() { // from class: U2.l
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    this.f8144a.j(str, mapB, listB);
                }
            });
        }
    }

    public boolean p(List list) {
        synchronized (this.f8156f) {
            try {
                if (!this.f8156f.c(list)) {
                    return false;
                }
                final List listB = this.f8156f.b();
                this.f8152b.f7947b.f(new Runnable() { // from class: U2.m
                    @Override // java.lang.Runnable
                    public final void run() throws Throwable {
                        this.f8148a.k(listB);
                    }
                });
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
