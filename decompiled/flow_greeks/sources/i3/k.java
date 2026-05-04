package i3;

import android.util.Log;
import d4.a;
import i3.h;
import i3.p;
import java.util.Map;
import java.util.concurrent.Executor;
import k3.a;
import k3.h;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class k implements m, h.a, p.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final boolean f11670i = Log.isLoggable("Engine", 2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f11671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f11672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k3.h f11673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f11674d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final y f11675e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f11676f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f11677g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final i3.a f11678h;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h.e f11679a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final s0.c f11680b = d4.a.d(150, new C0222a());

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f11681c;

        /* JADX INFO: renamed from: i3.k$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class C0222a implements a.d {
            public C0222a() {
            }

            @Override // d4.a.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public h a() {
                a aVar = a.this;
                return new h(aVar.f11679a, aVar.f11680b);
            }
        }

        public a(h.e eVar) {
            this.f11679a = eVar;
        }

        public h a(com.bumptech.glide.d dVar, Object obj, n nVar, g3.f fVar, int i10, int i11, Class cls, Class cls2, com.bumptech.glide.g gVar, j jVar, Map map, boolean z10, boolean z11, boolean z12, g3.h hVar, h.b bVar) {
            h hVar2 = (h) c4.k.e((h) this.f11680b.b());
            int i12 = this.f11681c;
            this.f11681c = i12 + 1;
            return hVar2.w(dVar, obj, nVar, fVar, i10, i11, cls, cls2, gVar, jVar, map, z10, z11, z12, hVar, bVar, i12);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l3.b f11683a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final l3.b f11684b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final l3.b f11685c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final l3.b f11686d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final m f11687e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final p.a f11688f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final s0.c f11689g = d4.a.d(150, new a());

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a implements a.d {
            public a() {
            }

            @Override // d4.a.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public l a() {
                b bVar = b.this;
                return new l(bVar.f11683a, bVar.f11684b, bVar.f11685c, bVar.f11686d, bVar.f11687e, bVar.f11688f, bVar.f11689g);
            }
        }

        public b(l3.b bVar, l3.b bVar2, l3.b bVar3, l3.b bVar4, m mVar, p.a aVar) {
            this.f11683a = bVar;
            this.f11684b = bVar2;
            this.f11685c = bVar3;
            this.f11686d = bVar4;
            this.f11687e = mVar;
            this.f11688f = aVar;
        }

        public l a(g3.f fVar, boolean z10, boolean z11, boolean z12, boolean z13) {
            return ((l) c4.k.e((l) this.f11689g.b())).l(fVar, z10, z11, z12, z13);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c implements h.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a.InterfaceC0251a f11691a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile k3.a f11692b;

        public c(a.InterfaceC0251a interfaceC0251a) {
            this.f11691a = interfaceC0251a;
        }

        @Override // i3.h.e
        public k3.a a() {
            if (this.f11692b == null) {
                synchronized (this) {
                    try {
                        if (this.f11692b == null) {
                            this.f11692b = this.f11691a.build();
                        }
                        if (this.f11692b == null) {
                            this.f11692b = new k3.b();
                        }
                    } finally {
                    }
                }
            }
            return this.f11692b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l f11693a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final y3.g f11694b;

        public d(y3.g gVar, l lVar) {
            this.f11694b = gVar;
            this.f11693a = lVar;
        }

        public void a() {
            synchronized (k.this) {
                this.f11693a.r(this.f11694b);
            }
        }
    }

    public k(k3.h hVar, a.InterfaceC0251a interfaceC0251a, l3.b bVar, l3.b bVar2, l3.b bVar3, l3.b bVar4, boolean z10) {
        this(hVar, interfaceC0251a, bVar, bVar2, bVar3, bVar4, null, null, null, null, null, null, z10);
    }

    public static void j(String str, long j10, g3.f fVar) {
        Log.v("Engine", str + " in " + c4.g.a(j10) + "ms, key: " + fVar);
    }

    @Override // i3.p.a
    public void a(g3.f fVar, p pVar) {
        this.f11678h.d(fVar);
        if (pVar.f()) {
            this.f11673c.d(fVar, pVar);
        } else {
            this.f11675e.a(pVar, false);
        }
    }

    @Override // i3.m
    public synchronized void b(l lVar, g3.f fVar, p pVar) {
        if (pVar != null) {
            try {
                if (pVar.f()) {
                    this.f11678h.a(fVar, pVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f11671a.d(fVar, lVar);
    }

    @Override // i3.m
    public synchronized void c(l lVar, g3.f fVar) {
        this.f11671a.d(fVar, lVar);
    }

    @Override // k3.h.a
    public void d(v vVar) {
        this.f11675e.a(vVar, true);
    }

    public final p e(g3.f fVar) {
        v vVarC = this.f11673c.c(fVar);
        if (vVarC == null) {
            return null;
        }
        return vVarC instanceof p ? (p) vVarC : new p(vVarC, true, true, fVar, this);
    }

    public d f(com.bumptech.glide.d dVar, Object obj, g3.f fVar, int i10, int i11, Class cls, Class cls2, com.bumptech.glide.g gVar, j jVar, Map map, boolean z10, boolean z11, g3.h hVar, boolean z12, boolean z13, boolean z14, boolean z15, y3.g gVar2, Executor executor) {
        long jB = f11670i ? c4.g.b() : 0L;
        n nVarA = this.f11672b.a(obj, fVar, i10, i11, map, cls, cls2, hVar);
        synchronized (this) {
            try {
                p pVarI = i(nVarA, z12, jB);
                if (pVarI == null) {
                    return l(dVar, obj, fVar, i10, i11, cls, cls2, gVar, jVar, map, z10, z11, hVar, z12, z13, z14, z15, gVar2, executor, nVarA, jB);
                }
                gVar2.c(pVarI, g3.a.MEMORY_CACHE, false);
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final p g(g3.f fVar) {
        p pVarE = this.f11678h.e(fVar);
        if (pVarE != null) {
            pVarE.a();
        }
        return pVarE;
    }

    public final p h(g3.f fVar) {
        p pVarE = e(fVar);
        if (pVarE != null) {
            pVarE.a();
            this.f11678h.a(fVar, pVarE);
        }
        return pVarE;
    }

    public final p i(n nVar, boolean z10, long j10) {
        if (!z10) {
            return null;
        }
        p pVarG = g(nVar);
        if (pVarG != null) {
            if (f11670i) {
                j("Loaded resource from active resources", j10, nVar);
            }
            return pVarG;
        }
        p pVarH = h(nVar);
        if (pVarH == null) {
            return null;
        }
        if (f11670i) {
            j("Loaded resource from cache", j10, nVar);
        }
        return pVarH;
    }

    public void k(v vVar) {
        if (!(vVar instanceof p)) {
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
        ((p) vVar).g();
    }

    public final d l(com.bumptech.glide.d dVar, Object obj, g3.f fVar, int i10, int i11, Class cls, Class cls2, com.bumptech.glide.g gVar, j jVar, Map map, boolean z10, boolean z11, g3.h hVar, boolean z12, boolean z13, boolean z14, boolean z15, y3.g gVar2, Executor executor, n nVar, long j10) {
        l lVarA = this.f11671a.a(nVar, z15);
        if (lVarA != null) {
            lVarA.b(gVar2, executor);
            if (f11670i) {
                j("Added to existing load", j10, nVar);
            }
            return new d(gVar2, lVarA);
        }
        l lVarA2 = this.f11674d.a(nVar, z12, z13, z14, z15);
        h hVarA = this.f11677g.a(dVar, obj, nVar, fVar, i10, i11, cls, cls2, gVar, jVar, map, z10, z11, z15, hVar, lVarA2);
        this.f11671a.c(nVar, lVarA2);
        lVarA2.b(gVar2, executor);
        lVarA2.s(hVarA);
        if (f11670i) {
            j("Started new load", j10, nVar);
        }
        return new d(gVar2, lVarA2);
    }

    public k(k3.h hVar, a.InterfaceC0251a interfaceC0251a, l3.b bVar, l3.b bVar2, l3.b bVar3, l3.b bVar4, s sVar, o oVar, i3.a aVar, b bVar5, a aVar2, y yVar, boolean z10) {
        this.f11673c = hVar;
        c cVar = new c(interfaceC0251a);
        this.f11676f = cVar;
        i3.a aVar3 = aVar == null ? new i3.a(z10) : aVar;
        this.f11678h = aVar3;
        aVar3.f(this);
        this.f11672b = oVar == null ? new o() : oVar;
        this.f11671a = sVar == null ? new s() : sVar;
        this.f11674d = bVar5 == null ? new b(bVar, bVar2, bVar3, bVar4, this, this) : bVar5;
        this.f11677g = aVar2 == null ? new a(cVar) : aVar2;
        this.f11675e = yVar == null ? new y() : yVar;
        hVar.e(this);
    }
}
