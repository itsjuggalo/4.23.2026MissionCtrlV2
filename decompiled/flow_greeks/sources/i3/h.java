package i3;

import android.os.Build;
import android.os.Process;
import android.util.Log;
import com.bumptech.glide.c;
import com.bumptech.glide.h;
import d4.a;
import i3.f;
import i3.i;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class h implements f.a, Runnable, Comparable, a.f {
    public static final g3.g I = g3.g.e("glide_thread_priority_override");
    public g3.f A;
    public Object B;
    public g3.a C;
    public com.bumptech.glide.load.data.d D;
    public volatile i3.f E;
    public volatile boolean F;
    public volatile boolean G;
    public boolean H;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f11615d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final s0.c f11616e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bumptech.glide.d f11619h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public g3.f f11620i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.bumptech.glide.g f11621j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public n f11622k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f11623l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f11624m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public j f11625n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public g3.h f11626o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public b f11627p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f11628q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public EnumC0221h f11629r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public g f11630s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f11631t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f11632u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f11633v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public com.bumptech.glide.e f11634w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Supplier f11635x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Thread f11636y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public g3.f f11637z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i3.g f11612a = new i3.g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f11613b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d4.c f11614c = d4.c.a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f11617f = new d();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final f f11618g = new f();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11638a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f11639b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f11640c;

        static {
            int[] iArr = new int[g3.c.values().length];
            f11640c = iArr;
            try {
                iArr[g3.c.SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11640c[g3.c.TRANSFORMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[EnumC0221h.values().length];
            f11639b = iArr2;
            try {
                iArr2[EnumC0221h.RESOURCE_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11639b[EnumC0221h.DATA_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11639b[EnumC0221h.SOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f11639b[EnumC0221h.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f11639b[EnumC0221h.INITIALIZE.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[g.values().length];
            f11638a = iArr3;
            try {
                iArr3[g.INITIALIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f11638a[g.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f11638a[g.DECODE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface b {
        void a(q qVar);

        void c(v vVar, g3.a aVar, boolean z10);

        void d(h hVar);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class c implements i.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g3.a f11641a;

        public c(g3.a aVar) {
            this.f11641a = aVar;
        }

        @Override // i3.i.a
        public v a(v vVar) {
            return h.this.L(this.f11641a, vVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public g3.f f11643a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public g3.k f11644b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public u f11645c;

        public void a() {
            this.f11643a = null;
            this.f11644b = null;
            this.f11645c = null;
        }

        public void b(e eVar, g3.h hVar) {
            d4.b.a("DecodeJob.encode");
            try {
                eVar.a().a(this.f11643a, new i3.e(this.f11644b, this.f11645c, hVar));
            } finally {
                this.f11645c.g();
                d4.b.e();
            }
        }

        public boolean c() {
            return this.f11645c != null;
        }

        public void d(g3.f fVar, g3.k kVar, u uVar) {
            this.f11643a = fVar;
            this.f11644b = kVar;
            this.f11645c = uVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface e {
        k3.a a();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f11646a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f11647b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f11648c;

        public final boolean a(boolean z10) {
            return (this.f11648c || z10 || this.f11647b) && this.f11646a;
        }

        public synchronized boolean b() {
            this.f11647b = true;
            return a(false);
        }

        public synchronized boolean c() {
            this.f11648c = true;
            return a(false);
        }

        public synchronized boolean d(boolean z10) {
            this.f11646a = true;
            return a(z10);
        }

        public synchronized void e() {
            this.f11647b = false;
            this.f11646a = false;
            this.f11648c = false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum g {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* JADX INFO: renamed from: i3.h$h, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum EnumC0221h {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    public h(e eVar, s0.c cVar) {
        this.f11615d = eVar;
        this.f11616e = cVar;
    }

    public final void A(String str, long j10, String str2) {
        String str3;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(" in ");
        sb2.append(c4.g.a(j10));
        sb2.append(", load key: ");
        sb2.append(this.f11622k);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb2.append(str3);
        sb2.append(", thread: ");
        sb2.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sb2.toString());
    }

    public final void B(v vVar, g3.a aVar, boolean z10) {
        if (this.f11634w.a(c.d.class)) {
            T();
        }
        X();
        this.f11627p.c(vVar, aVar, z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void E(v vVar, g3.a aVar, boolean z10) {
        u uVar;
        d4.b.a("DecodeJob.notifyEncodeAndRelease");
        try {
            if (vVar instanceof r) {
                ((r) vVar).a();
            }
            if (this.f11617f.c()) {
                vVar = u.e(vVar);
                uVar = vVar;
            } else {
                uVar = 0;
            }
            B(vVar, aVar, z10);
            this.f11629r = EnumC0221h.ENCODE;
            try {
                if (this.f11617f.c()) {
                    this.f11617f.b(this.f11615d, this.f11626o);
                }
                H();
                d4.b.e();
            } finally {
                if (uVar != 0) {
                    uVar.g();
                }
            }
        } catch (Throwable th) {
            d4.b.e();
            throw th;
        }
    }

    public final void G() {
        if (this.f11634w.a(c.d.class)) {
            T();
        }
        X();
        this.f11627p.a(new q("Failed to load resource", new ArrayList(this.f11613b)));
        K();
    }

    public final void H() {
        if (this.f11618g.b()) {
            R();
        }
    }

    public final void K() {
        if (this.f11618g.c()) {
            R();
        }
    }

    public v L(g3.a aVar, v vVar) {
        v vVarA;
        g3.l lVar;
        g3.c cVarB;
        g3.f dVar;
        Class<?> cls = vVar.get().getClass();
        g3.k kVarN = null;
        if (aVar != g3.a.RESOURCE_DISK_CACHE) {
            g3.l lVarS = this.f11612a.s(cls);
            lVar = lVarS;
            vVarA = lVarS.a(this.f11619h, vVar, this.f11623l, this.f11624m);
        } else {
            vVarA = vVar;
            lVar = null;
        }
        if (!vVar.equals(vVarA)) {
            vVar.b();
        }
        if (this.f11612a.w(vVarA)) {
            kVarN = this.f11612a.n(vVarA);
            cVarB = kVarN.b(this.f11626o);
        } else {
            cVarB = g3.c.NONE;
        }
        g3.k kVar = kVarN;
        if (!this.f11625n.d(!this.f11612a.y(this.f11637z), aVar, cVarB)) {
            return vVarA;
        }
        if (kVar == null) {
            throw new h.d(vVarA.get().getClass());
        }
        int i10 = a.f11640c[cVarB.ordinal()];
        if (i10 == 1) {
            dVar = new i3.d(this.f11637z, this.f11620i);
        } else {
            if (i10 != 2) {
                throw new IllegalArgumentException("Unknown strategy: " + cVarB);
            }
            dVar = new x(this.f11612a.b(), this.f11637z, this.f11620i, this.f11623l, this.f11624m, lVar, cls, this.f11626o);
        }
        u uVarE = u.e(vVarA);
        this.f11617f.d(dVar, kVar, uVarE);
        return uVarE;
    }

    public void M(boolean z10) {
        if (this.f11618g.d(z10)) {
            R();
        }
    }

    public final void R() {
        this.f11618g.e();
        this.f11617f.a();
        this.f11612a.a();
        this.F = false;
        this.f11619h = null;
        this.f11620i = null;
        this.f11626o = null;
        this.f11621j = null;
        this.f11622k = null;
        this.f11627p = null;
        this.f11629r = null;
        this.E = null;
        this.f11636y = null;
        this.f11637z = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.f11631t = 0L;
        this.G = false;
        this.f11633v = null;
        this.f11613b.clear();
        this.f11616e.a(this);
    }

    public final void S(g gVar) {
        this.f11630s = gVar;
        this.f11627p.d(this);
    }

    public final void T() {
        if (!this.f11634w.a(c.d.class)) {
            throw new IllegalStateException("OverrideGlideThreadPriority experiment is not enabled.");
        }
        Supplier supplier = this.f11635x;
        if (supplier == null || supplier.get() == null) {
            return;
        }
        try {
            Process.setThreadPriority(Process.myTid(), 9);
        } catch (IllegalArgumentException | SecurityException e10) {
            this.f11635x = null;
            if (Log.isLoggable("DecodeJob", 2)) {
                Log.v("DecodeJob", "Failed to set thread priority; using default priority for any subsequent jobs.", e10);
            }
        }
    }

    public final void U() {
        this.f11636y = Thread.currentThread();
        this.f11631t = c4.g.b();
        boolean zB = false;
        while (!this.G && this.E != null && !(zB = this.E.b())) {
            this.f11629r = s(this.f11629r);
            this.E = q();
            if (this.f11629r == EnumC0221h.SOURCE) {
                S(g.SWITCH_TO_SOURCE_SERVICE);
                return;
            }
        }
        if ((this.f11629r == EnumC0221h.FINISHED || this.G) && !zB) {
            G();
        }
    }

    public final v V(Object obj, g3.a aVar, t tVar) {
        g3.h hVarU = u(aVar);
        com.bumptech.glide.load.data.e eVarL = this.f11619h.h().l(obj);
        try {
            return tVar.a(eVarL, hVarU, this.f11623l, this.f11624m, new c(aVar));
        } finally {
            eVarL.b();
        }
    }

    public final void W() {
        int i10 = a.f11638a[this.f11630s.ordinal()];
        if (i10 == 1) {
            this.f11629r = s(EnumC0221h.INITIALIZE);
            this.E = q();
            U();
        } else if (i10 == 2) {
            U();
        } else {
            if (i10 == 3) {
                o();
                return;
            }
            throw new IllegalStateException("Unrecognized run reason: " + this.f11630s);
        }
    }

    public final void X() {
        Throwable th;
        this.f11614c.c();
        if (!this.F) {
            this.F = true;
            return;
        }
        if (this.f11613b.isEmpty()) {
            th = null;
        } else {
            List list = this.f11613b;
            th = (Throwable) list.get(list.size() - 1);
        }
        throw new IllegalStateException("Already notified", th);
    }

    public boolean Y() {
        EnumC0221h enumC0221hS = s(EnumC0221h.INITIALIZE);
        return enumC0221hS == EnumC0221h.RESOURCE_CACHE || enumC0221hS == EnumC0221h.DATA_CACHE;
    }

    @Override // i3.f.a
    public void a(g3.f fVar, Exception exc, com.bumptech.glide.load.data.d dVar, g3.a aVar) {
        dVar.b();
        q qVar = new q("Fetching data failed", exc);
        qVar.j(fVar, aVar, dVar.a());
        this.f11613b.add(qVar);
        if (Thread.currentThread() != this.f11636y) {
            S(g.SWITCH_TO_SOURCE_SERVICE);
        } else {
            U();
        }
    }

    public void b() {
        this.G = true;
        i3.f fVar = this.E;
        if (fVar != null) {
            fVar.cancel();
        }
    }

    @Override // i3.f.a
    public void c(g3.f fVar, Object obj, com.bumptech.glide.load.data.d dVar, g3.a aVar, g3.f fVar2) {
        this.f11637z = fVar;
        this.B = obj;
        this.D = dVar;
        this.C = aVar;
        this.A = fVar2;
        this.H = fVar != this.f11612a.c().get(0);
        if (Thread.currentThread() != this.f11636y) {
            S(g.DECODE_DATA);
            return;
        }
        d4.b.a("DecodeJob.decodeFromRetrievedData");
        try {
            o();
        } finally {
            d4.b.e();
        }
    }

    @Override // i3.f.a
    public void h() {
        S(g.SWITCH_TO_SOURCE_SERVICE);
    }

    @Override // d4.a.f
    public d4.c i() {
        return this.f11614c;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public int compareTo(h hVar) {
        int iV = v() - hVar.v();
        return iV == 0 ? this.f11628q - hVar.f11628q : iV;
    }

    public final v l(com.bumptech.glide.load.data.d dVar, Object obj, g3.a aVar) {
        if (obj == null) {
            dVar.b();
            return null;
        }
        try {
            long jB = c4.g.b();
            v vVarM = m(obj, aVar);
            if (Log.isLoggable("DecodeJob", 2)) {
                y("Decoded result " + vVarM, jB);
            }
            return vVarM;
        } finally {
            dVar.b();
        }
    }

    public final v m(Object obj, g3.a aVar) {
        return V(obj, aVar, this.f11612a.h(obj.getClass()));
    }

    public final void o() {
        Supplier supplier;
        if (Log.isLoggable("DecodeJob", 2)) {
            A("Retrieved data", this.f11631t, "data: " + this.B + ", cache key: " + this.f11637z + ", fetcher: " + this.D);
        }
        v vVarL = null;
        if (this.f11634w.a(c.d.class) && (supplier = this.f11635x) != null && supplier.get() != null) {
            try {
                Process.setThreadPriority(Process.myTid(), ((Integer) this.f11635x.get()).intValue());
            } catch (IllegalArgumentException | SecurityException e10) {
                this.f11635x = null;
                if (Log.isLoggable("DecodeJob", 2)) {
                    Log.v("DecodeJob", "Failed to set thread priority; using default priority for any subsequent jobs.", e10);
                }
            }
        }
        try {
            vVarL = l(this.D, this.B, this.C);
        } catch (q e11) {
            e11.i(this.A, this.C);
            this.f11613b.add(e11);
        }
        if (vVarL != null) {
            E(vVarL, this.C, this.H);
        } else {
            U();
        }
    }

    public final i3.f q() {
        int i10 = a.f11639b[this.f11629r.ordinal()];
        if (i10 == 1) {
            return new w(this.f11612a, this);
        }
        if (i10 == 2) {
            return new i3.c(this.f11612a, this);
        }
        if (i10 == 3) {
            return new z(this.f11612a, this);
        }
        if (i10 == 4) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.f11629r);
    }

    @Override // java.lang.Runnable
    public void run() {
        d4.b.c("DecodeJob#run(reason=%s, model=%s)", this.f11630s, this.f11633v);
        com.bumptech.glide.load.data.d dVar = this.D;
        try {
            try {
                try {
                    if (this.G) {
                        G();
                        if (dVar != null) {
                            dVar.b();
                        }
                        d4.b.e();
                        return;
                    }
                    W();
                    if (dVar != null) {
                        dVar.b();
                    }
                    d4.b.e();
                } catch (i3.b e10) {
                    throw e10;
                }
            } catch (Throwable th) {
                if (Log.isLoggable("DecodeJob", 3)) {
                    Log.d("DecodeJob", "DecodeJob threw unexpectedly, isCancelled: " + this.G + ", stage: " + this.f11629r, th);
                }
                if (this.f11629r != EnumC0221h.ENCODE) {
                    this.f11613b.add(th);
                    G();
                }
                if (!this.G) {
                    throw th;
                }
                throw th;
            }
        } catch (Throwable th2) {
            if (dVar != null) {
                dVar.b();
            }
            d4.b.e();
            throw th2;
        }
    }

    public final EnumC0221h s(EnumC0221h enumC0221h) {
        int i10 = a.f11639b[enumC0221h.ordinal()];
        if (i10 == 1) {
            return this.f11625n.a() ? EnumC0221h.DATA_CACHE : s(EnumC0221h.DATA_CACHE);
        }
        if (i10 == 2) {
            return this.f11632u ? EnumC0221h.FINISHED : EnumC0221h.SOURCE;
        }
        if (i10 == 3 || i10 == 4) {
            return EnumC0221h.FINISHED;
        }
        if (i10 == 5) {
            return this.f11625n.b() ? EnumC0221h.RESOURCE_CACHE : s(EnumC0221h.RESOURCE_CACHE);
        }
        throw new IllegalArgumentException("Unrecognized stage: " + enumC0221h);
    }

    public final g3.h u(g3.a aVar) {
        g3.h hVar = this.f11626o;
        if (Build.VERSION.SDK_INT < 26) {
            return hVar;
        }
        boolean z10 = aVar == g3.a.RESOURCE_DISK_CACHE || this.f11612a.x();
        g3.g gVar = p3.p.f18266j;
        Boolean bool = (Boolean) hVar.c(gVar);
        if (bool != null && (!bool.booleanValue() || z10)) {
            return hVar;
        }
        g3.h hVar2 = new g3.h();
        hVar2.d(this.f11626o);
        hVar2.e(gVar, Boolean.valueOf(z10));
        return hVar2;
    }

    public final int v() {
        return this.f11621j.ordinal();
    }

    public h w(com.bumptech.glide.d dVar, Object obj, n nVar, g3.f fVar, int i10, int i11, Class cls, Class cls2, com.bumptech.glide.g gVar, j jVar, Map map, boolean z10, boolean z11, boolean z12, g3.h hVar, b bVar, int i12) {
        this.f11612a.v(dVar, obj, fVar, i10, i11, jVar, cls, cls2, gVar, hVar, map, z10, z11, this.f11615d);
        this.f11619h = dVar;
        this.f11620i = fVar;
        this.f11621j = gVar;
        this.f11622k = nVar;
        this.f11623l = i10;
        this.f11624m = i11;
        this.f11625n = jVar;
        this.f11632u = z12;
        this.f11626o = hVar;
        this.f11627p = bVar;
        this.f11628q = i12;
        this.f11630s = g.INITIALIZE;
        this.f11633v = obj;
        this.f11634w = dVar.f();
        this.f11635x = (Supplier) hVar.c(I);
        return this;
    }

    public final void y(String str, long j10) {
        A(str, j10, null);
    }
}
