package i3;

import i3.h;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import m3.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f11594a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f11595b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bumptech.glide.d f11596c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f11597d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f11598e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f11599f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Class f11600g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public h.e f11601h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public g3.h f11602i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Map f11603j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Class f11604k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f11605l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f11606m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public g3.f f11607n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.bumptech.glide.g f11608o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public j f11609p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f11610q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f11611r;

    public void a() {
        this.f11596c = null;
        this.f11597d = null;
        this.f11607n = null;
        this.f11600g = null;
        this.f11604k = null;
        this.f11602i = null;
        this.f11608o = null;
        this.f11603j = null;
        this.f11609p = null;
        this.f11594a.clear();
        this.f11605l = false;
        this.f11595b.clear();
        this.f11606m = false;
    }

    public j3.b b() {
        return this.f11596c.a();
    }

    public List c() {
        if (!this.f11606m) {
            this.f11606m = true;
            this.f11595b.clear();
            List listG = g();
            int size = listG.size();
            for (int i10 = 0; i10 < size; i10++) {
                n.a aVar = (n.a) listG.get(i10);
                if (!this.f11595b.contains(aVar.f15803a)) {
                    this.f11595b.add(aVar.f15803a);
                }
                for (int i11 = 0; i11 < aVar.f15804b.size(); i11++) {
                    if (!this.f11595b.contains(aVar.f15804b.get(i11))) {
                        this.f11595b.add((g3.f) aVar.f15804b.get(i11));
                    }
                }
            }
        }
        return this.f11595b;
    }

    public k3.a d() {
        return this.f11601h.a();
    }

    public j e() {
        return this.f11609p;
    }

    public int f() {
        return this.f11599f;
    }

    public List g() {
        if (!this.f11605l) {
            this.f11605l = true;
            this.f11594a.clear();
            List listI = this.f11596c.h().i(this.f11597d);
            int size = listI.size();
            for (int i10 = 0; i10 < size; i10++) {
                n.a aVarB = ((m3.n) listI.get(i10)).b(this.f11597d, this.f11598e, this.f11599f, this.f11602i);
                if (aVarB != null) {
                    this.f11594a.add(aVarB);
                }
            }
        }
        return this.f11594a;
    }

    public t h(Class cls) {
        return this.f11596c.h().h(cls, this.f11600g, this.f11604k);
    }

    public Class i() {
        return this.f11597d.getClass();
    }

    public List j(File file) {
        return this.f11596c.h().i(file);
    }

    public g3.h k() {
        return this.f11602i;
    }

    public com.bumptech.glide.g l() {
        return this.f11608o;
    }

    public List m() {
        return this.f11596c.h().j(this.f11597d.getClass(), this.f11600g, this.f11604k);
    }

    public g3.k n(v vVar) {
        return this.f11596c.h().k(vVar);
    }

    public com.bumptech.glide.load.data.e o(Object obj) {
        return this.f11596c.h().l(obj);
    }

    public g3.f p() {
        return this.f11607n;
    }

    public g3.d q(Object obj) {
        return this.f11596c.h().m(obj);
    }

    public Class r() {
        return this.f11604k;
    }

    public g3.l s(Class cls) {
        g3.l lVar = (g3.l) this.f11603j.get(cls);
        if (lVar == null) {
            Iterator it = this.f11603j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    lVar = (g3.l) entry.getValue();
                    break;
                }
            }
        }
        if (lVar != null) {
            return lVar;
        }
        if (!this.f11603j.isEmpty() || !this.f11610q) {
            return o3.e.c();
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    public int t() {
        return this.f11598e;
    }

    public boolean u(Class cls) {
        return h(cls) != null;
    }

    public void v(com.bumptech.glide.d dVar, Object obj, g3.f fVar, int i10, int i11, j jVar, Class cls, Class cls2, com.bumptech.glide.g gVar, g3.h hVar, Map map, boolean z10, boolean z11, h.e eVar) {
        this.f11596c = dVar;
        this.f11597d = obj;
        this.f11607n = fVar;
        this.f11598e = i10;
        this.f11599f = i11;
        this.f11609p = jVar;
        this.f11600g = cls;
        this.f11601h = eVar;
        this.f11604k = cls2;
        this.f11608o = gVar;
        this.f11602i = hVar;
        this.f11603j = map;
        this.f11610q = z10;
        this.f11611r = z11;
    }

    public boolean w(v vVar) {
        return this.f11596c.h().n(vVar);
    }

    public boolean x() {
        return this.f11611r;
    }

    public boolean y(g3.f fVar) {
        List listG = g();
        int size = listG.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (((n.a) listG.get(i10)).f15803a.equals(fVar)) {
                return true;
            }
        }
        return false;
    }
}
