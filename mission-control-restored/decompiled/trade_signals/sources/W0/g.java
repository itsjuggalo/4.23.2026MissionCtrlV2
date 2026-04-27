package W0;

import W0.h;
import a1.n;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f9049a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f9050b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bumptech.glide.d f9051c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f9052d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f9053e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f9054f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Class f9055g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public h.e f9056h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public U0.h f9057i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Map f9058j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Class f9059k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f9060l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f9061m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public U0.f f9062n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.bumptech.glide.g f9063o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public j f9064p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f9065q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f9066r;

    public void a() {
        this.f9051c = null;
        this.f9052d = null;
        this.f9062n = null;
        this.f9055g = null;
        this.f9059k = null;
        this.f9057i = null;
        this.f9063o = null;
        this.f9058j = null;
        this.f9064p = null;
        this.f9049a.clear();
        this.f9060l = false;
        this.f9050b.clear();
        this.f9061m = false;
    }

    public X0.b b() {
        return this.f9051c.a();
    }

    public List c() {
        if (!this.f9061m) {
            this.f9061m = true;
            this.f9050b.clear();
            List listG = g();
            int size = listG.size();
            for (int i8 = 0; i8 < size; i8++) {
                n.a aVar = (n.a) listG.get(i8);
                if (!this.f9050b.contains(aVar.f9865a)) {
                    this.f9050b.add(aVar.f9865a);
                }
                for (int i9 = 0; i9 < aVar.f9866b.size(); i9++) {
                    if (!this.f9050b.contains(aVar.f9866b.get(i9))) {
                        this.f9050b.add(aVar.f9866b.get(i9));
                    }
                }
            }
        }
        return this.f9050b;
    }

    public Y0.a d() {
        return this.f9056h.a();
    }

    public j e() {
        return this.f9064p;
    }

    public int f() {
        return this.f9054f;
    }

    public List g() {
        if (!this.f9060l) {
            this.f9060l = true;
            this.f9049a.clear();
            List listI = this.f9051c.h().i(this.f9052d);
            int size = listI.size();
            for (int i8 = 0; i8 < size; i8++) {
                n.a aVarA = ((a1.n) listI.get(i8)).a(this.f9052d, this.f9053e, this.f9054f, this.f9057i);
                if (aVarA != null) {
                    this.f9049a.add(aVarA);
                }
            }
        }
        return this.f9049a;
    }

    public t h(Class cls) {
        return this.f9051c.h().h(cls, this.f9055g, this.f9059k);
    }

    public Class i() {
        return this.f9052d.getClass();
    }

    public List j(File file) {
        return this.f9051c.h().i(file);
    }

    public U0.h k() {
        return this.f9057i;
    }

    public com.bumptech.glide.g l() {
        return this.f9063o;
    }

    public List m() {
        return this.f9051c.h().j(this.f9052d.getClass(), this.f9055g, this.f9059k);
    }

    public U0.k n(v vVar) {
        return this.f9051c.h().k(vVar);
    }

    public com.bumptech.glide.load.data.e o(Object obj) {
        return this.f9051c.h().l(obj);
    }

    public U0.f p() {
        return this.f9062n;
    }

    public U0.d q(Object obj) {
        return this.f9051c.h().m(obj);
    }

    public Class r() {
        return this.f9059k;
    }

    public U0.l s(Class cls) {
        U0.l lVar = (U0.l) this.f9058j.get(cls);
        if (lVar == null) {
            Iterator it = this.f9058j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    lVar = (U0.l) entry.getValue();
                    break;
                }
            }
        }
        if (lVar != null) {
            return lVar;
        }
        if (!this.f9058j.isEmpty() || !this.f9065q) {
            return c1.n.c();
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    public int t() {
        return this.f9053e;
    }

    public boolean u(Class cls) {
        return h(cls) != null;
    }

    public void v(com.bumptech.glide.d dVar, Object obj, U0.f fVar, int i8, int i9, j jVar, Class cls, Class cls2, com.bumptech.glide.g gVar, U0.h hVar, Map map, boolean z7, boolean z8, h.e eVar) {
        this.f9051c = dVar;
        this.f9052d = obj;
        this.f9062n = fVar;
        this.f9053e = i8;
        this.f9054f = i9;
        this.f9064p = jVar;
        this.f9055g = cls;
        this.f9056h = eVar;
        this.f9059k = cls2;
        this.f9063o = gVar;
        this.f9057i = hVar;
        this.f9058j = map;
        this.f9065q = z7;
        this.f9066r = z8;
    }

    public boolean w(v vVar) {
        return this.f9051c.h().n(vVar);
    }

    public boolean x() {
        return this.f9066r;
    }

    public boolean y(U0.f fVar) {
        List listG = g();
        int size = listG.size();
        for (int i8 = 0; i8 < size; i8++) {
            if (((n.a) listG.get(i8)).f9865a.equals(fVar)) {
                return true;
            }
        }
        return false;
    }
}
