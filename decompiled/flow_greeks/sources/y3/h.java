package y3;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import c4.l;
import com.bumptech.glide.c;
import i3.j;
import i3.k;
import i3.q;
import i3.v;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements c, z3.c, g {
    public static final boolean E = Log.isLoggable("GlideRequest", 2);
    public int A;
    public int B;
    public boolean C;
    public RuntimeException D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f25222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f25223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d4.c f25224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f25225d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f25226e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f25227f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f25228g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bumptech.glide.d f25229h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Object f25230i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Class f25231j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final y3.a f25232k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f25233l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f25234m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.bumptech.glide.g f25235n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final z3.d f25236o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List f25237p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final a4.c f25238q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Executor f25239r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public v f25240s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public k.d f25241t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f25242u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile k f25243v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public a f25244w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Drawable f25245x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Drawable f25246y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Drawable f25247z;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum a {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    public h(Context context, com.bumptech.glide.d dVar, Object obj, Object obj2, Class cls, y3.a aVar, int i10, int i11, com.bumptech.glide.g gVar, z3.d dVar2, e eVar, List list, d dVar3, k kVar, a4.c cVar, Executor executor) {
        this.f25223b = E ? String.valueOf(super.hashCode()) : null;
        this.f25224c = d4.c.a();
        this.f25225d = obj;
        this.f25228g = context;
        this.f25229h = dVar;
        this.f25230i = obj2;
        this.f25231j = cls;
        this.f25232k = aVar;
        this.f25233l = i10;
        this.f25234m = i11;
        this.f25235n = gVar;
        this.f25236o = dVar2;
        this.f25226e = eVar;
        this.f25237p = list;
        this.f25227f = dVar3;
        this.f25243v = kVar;
        this.f25238q = cVar;
        this.f25239r = executor;
        this.f25244w = a.PENDING;
        if (this.D == null && dVar.f().a(c.C0092c.class)) {
            this.D = new RuntimeException("Glide request origin trace");
        }
    }

    public static int v(int i10, float f10) {
        return i10 == Integer.MIN_VALUE ? i10 : Math.round(f10 * i10);
    }

    public static h y(Context context, com.bumptech.glide.d dVar, Object obj, Object obj2, Class cls, y3.a aVar, int i10, int i11, com.bumptech.glide.g gVar, z3.d dVar2, e eVar, List list, d dVar3, k kVar, a4.c cVar, Executor executor) {
        return new h(context, dVar, obj, obj2, cls, aVar, i10, i11, gVar, dVar2, eVar, list, dVar3, kVar, cVar, executor);
    }

    public final void A(v vVar, Object obj, g3.a aVar, boolean z10) {
        boolean zA;
        boolean zS = s();
        this.f25244w = a.COMPLETE;
        this.f25240s = vVar;
        if (this.f25229h.g() <= 3) {
            Log.d("Glide", "Finished loading " + obj.getClass().getSimpleName() + " from " + aVar + " for " + this.f25230i + " with size [" + this.A + "x" + this.B + "] in " + c4.g.a(this.f25242u) + " ms");
        }
        x();
        boolean z11 = true;
        this.C = true;
        try {
            List list = this.f25237p;
            if (list != null) {
                Iterator it = list.iterator();
                zA = false;
                while (it.hasNext()) {
                    Object obj2 = obj;
                    g3.a aVar2 = aVar;
                    zA |= ((e) it.next()).a(obj2, this.f25230i, this.f25236o, aVar2, zS);
                    obj = obj2;
                    aVar = aVar2;
                }
            } else {
                zA = false;
            }
            Object obj3 = obj;
            g3.a aVar3 = aVar;
            e eVar = this.f25226e;
            if (eVar == null || !eVar.a(obj3, this.f25230i, this.f25236o, aVar3, zS)) {
                z11 = false;
            }
            if (!(z11 | zA)) {
                this.f25236o.c(obj3, this.f25238q.a(aVar3, zS));
            }
            this.C = false;
            d4.b.f("GlideRequest", this.f25222a);
        } catch (Throwable th) {
            this.C = false;
            throw th;
        }
    }

    public final void B() {
        if (l()) {
            Drawable drawableQ = this.f25230i == null ? q() : null;
            if (drawableQ == null) {
                drawableQ = p();
            }
            if (drawableQ == null) {
                drawableQ = r();
            }
            this.f25236o.g(drawableQ);
        }
    }

    @Override // y3.g
    public void a(q qVar) {
        z(qVar, 5);
    }

    @Override // y3.c
    public boolean b() {
        boolean z10;
        synchronized (this.f25225d) {
            z10 = this.f25244w == a.COMPLETE;
        }
        return z10;
    }

    @Override // y3.g
    public void c(v vVar, g3.a aVar, boolean z10) {
        this.f25224c.c();
        v vVar2 = null;
        try {
            synchronized (this.f25225d) {
                try {
                    this.f25241t = null;
                    if (vVar == null) {
                        a(new q("Expected to receive a Resource<R> with an object of " + this.f25231j + " inside, but instead got null."));
                        return;
                    }
                    Object obj = vVar.get();
                    try {
                        if (obj == null || !this.f25231j.isAssignableFrom(obj.getClass())) {
                            this.f25240s = null;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Expected to receive an object of ");
                            sb2.append(this.f25231j);
                            sb2.append(" but instead got ");
                            sb2.append(obj != null ? obj.getClass() : "");
                            sb2.append("{");
                            sb2.append(obj);
                            sb2.append("} inside Resource{");
                            sb2.append(vVar);
                            sb2.append("}.");
                            sb2.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
                            a(new q(sb2.toString()));
                        } else if (m()) {
                            A(vVar, obj, aVar, z10);
                            return;
                        } else {
                            this.f25240s = null;
                            this.f25244w = a.COMPLETE;
                            d4.b.f("GlideRequest", this.f25222a);
                        }
                        this.f25243v.k(vVar);
                    } catch (Throwable th) {
                        vVar2 = vVar;
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            if (vVar2 != null) {
                this.f25243v.k(vVar2);
            }
            throw th3;
        }
    }

    @Override // y3.c
    public void clear() {
        synchronized (this.f25225d) {
            try {
                j();
                this.f25224c.c();
                a aVar = this.f25244w;
                a aVar2 = a.CLEARED;
                if (aVar == aVar2) {
                    return;
                }
                n();
                v vVar = this.f25240s;
                if (vVar != null) {
                    this.f25240s = null;
                } else {
                    vVar = null;
                }
                if (k()) {
                    this.f25236o.k(r());
                }
                d4.b.f("GlideRequest", this.f25222a);
                this.f25244w = aVar2;
                if (vVar != null) {
                    this.f25243v.k(vVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // y3.c
    public boolean d(c cVar) {
        int i10;
        int i11;
        Object obj;
        Class cls;
        y3.a aVar;
        com.bumptech.glide.g gVar;
        int size;
        int i12;
        int i13;
        Object obj2;
        Class cls2;
        y3.a aVar2;
        com.bumptech.glide.g gVar2;
        int size2;
        if (!(cVar instanceof h)) {
            return false;
        }
        synchronized (this.f25225d) {
            try {
                i10 = this.f25233l;
                i11 = this.f25234m;
                obj = this.f25230i;
                cls = this.f25231j;
                aVar = this.f25232k;
                gVar = this.f25235n;
                List list = this.f25237p;
                size = list != null ? list.size() : 0;
            } finally {
            }
        }
        h hVar = (h) cVar;
        synchronized (hVar.f25225d) {
            try {
                i12 = hVar.f25233l;
                i13 = hVar.f25234m;
                obj2 = hVar.f25230i;
                cls2 = hVar.f25231j;
                aVar2 = hVar.f25232k;
                gVar2 = hVar.f25235n;
                List list2 = hVar.f25237p;
                size2 = list2 != null ? list2.size() : 0;
            } finally {
            }
        }
        return i10 == i12 && i11 == i13 && l.c(obj, obj2) && cls.equals(cls2) && l.b(aVar, aVar2) && gVar == gVar2 && size == size2;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // z3.c
    public void e(int i10, int i11) throws Throwable {
        Object obj;
        h hVar = this;
        hVar.f25224c.c();
        Object obj2 = hVar.f25225d;
        synchronized (obj2) {
            try {
                try {
                    boolean z10 = E;
                    if (z10) {
                        hVar.u("Got onSizeReady in " + c4.g.a(hVar.f25242u));
                    }
                    if (hVar.f25244w == a.WAITING_FOR_SIZE) {
                        a aVar = a.RUNNING;
                        hVar.f25244w = aVar;
                        float fW = hVar.f25232k.w();
                        hVar.A = v(i10, fW);
                        hVar.B = v(i11, fW);
                        if (z10) {
                            hVar.u("finished setup for calling load in " + c4.g.a(hVar.f25242u));
                        }
                        try {
                            k kVar = hVar.f25243v;
                            com.bumptech.glide.d dVar = hVar.f25229h;
                            try {
                                Object obj3 = hVar.f25230i;
                                g3.f fVarV = hVar.f25232k.v();
                                try {
                                    int i12 = hVar.A;
                                    int i13 = hVar.B;
                                    Class clsT = hVar.f25232k.t();
                                    Class cls = hVar.f25231j;
                                    try {
                                        com.bumptech.glide.g gVar = hVar.f25235n;
                                        j jVarH = hVar.f25232k.h();
                                        Map mapY = hVar.f25232k.y();
                                        boolean zI = hVar.f25232k.I();
                                        boolean zF = hVar.f25232k.F();
                                        g3.h hVarN = hVar.f25232k.n();
                                        boolean zD = hVar.f25232k.D();
                                        boolean zA = hVar.f25232k.A();
                                        boolean z11 = hVar.f25232k.z();
                                        boolean zM = hVar.f25232k.m();
                                        Executor executor = hVar.f25239r;
                                        Object obj4 = obj2;
                                        try {
                                            hVar.f25241t = kVar.f(dVar, obj3, fVarV, i12, i13, clsT, cls, gVar, jVarH, mapY, zI, zF, hVarN, zD, zA, z11, zM, hVar, executor);
                                            if (hVar.f25244w != aVar) {
                                                hVar.f25241t = null;
                                            }
                                            if (z10) {
                                                hVar.u("finished onSizeReady in " + c4.g.a(hVar.f25242u));
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            obj = obj4;
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        obj = obj2;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    obj = obj2;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                obj = obj2;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            obj = obj2;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    obj = obj2;
                }
            } catch (Throwable th7) {
                th = th7;
                obj = hVar;
            }
        }
    }

    @Override // y3.g
    public Object f() {
        this.f25224c.c();
        return this.f25225d;
    }

    @Override // y3.c
    public boolean g() {
        boolean z10;
        synchronized (this.f25225d) {
            z10 = this.f25244w == a.CLEARED;
        }
        return z10;
    }

    @Override // y3.c
    public void h() {
        synchronized (this.f25225d) {
            try {
                j();
                this.f25224c.c();
                this.f25242u = c4.g.b();
                Object obj = this.f25230i;
                if (obj == null) {
                    if (l.t(this.f25233l, this.f25234m)) {
                        this.A = this.f25233l;
                        this.B = this.f25234m;
                    }
                    z(new q("Received null model"), q() == null ? 5 : 3);
                    return;
                }
                a aVar = this.f25244w;
                a aVar2 = a.RUNNING;
                if (aVar == aVar2) {
                    throw new IllegalArgumentException("Cannot restart a running request");
                }
                if (aVar == a.COMPLETE) {
                    c(this.f25240s, g3.a.MEMORY_CACHE, false);
                    return;
                }
                o(obj);
                this.f25222a = d4.b.b("GlideRequest");
                a aVar3 = a.WAITING_FOR_SIZE;
                this.f25244w = aVar3;
                if (l.t(this.f25233l, this.f25234m)) {
                    e(this.f25233l, this.f25234m);
                } else {
                    this.f25236o.f(this);
                }
                a aVar4 = this.f25244w;
                if ((aVar4 == aVar2 || aVar4 == aVar3) && l()) {
                    this.f25236o.i(r());
                }
                if (E) {
                    u("finished run method in " + c4.g.a(this.f25242u));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // y3.c
    public boolean i() {
        boolean z10;
        synchronized (this.f25225d) {
            z10 = this.f25244w == a.COMPLETE;
        }
        return z10;
    }

    @Override // y3.c
    public boolean isRunning() {
        boolean z10;
        synchronized (this.f25225d) {
            try {
                a aVar = this.f25244w;
                z10 = aVar == a.RUNNING || aVar == a.WAITING_FOR_SIZE;
            } finally {
            }
        }
        return z10;
    }

    public final void j() {
        if (this.C) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    public final boolean k() {
        d dVar = this.f25227f;
        return dVar == null || dVar.c(this);
    }

    public final boolean l() {
        d dVar = this.f25227f;
        return dVar == null || dVar.f(this);
    }

    public final boolean m() {
        d dVar = this.f25227f;
        return dVar == null || dVar.e(this);
    }

    public final void n() {
        j();
        this.f25224c.c();
        this.f25236o.b(this);
        k.d dVar = this.f25241t;
        if (dVar != null) {
            dVar.a();
            this.f25241t = null;
        }
    }

    public final void o(Object obj) {
        List<e> list = this.f25237p;
        if (list == null) {
            return;
        }
        for (e eVar : list) {
        }
    }

    public final Drawable p() {
        if (this.f25245x == null) {
            Drawable drawableJ = this.f25232k.j();
            this.f25245x = drawableJ;
            if (drawableJ == null && this.f25232k.i() > 0) {
                this.f25245x = t(this.f25232k.i());
            }
        }
        return this.f25245x;
    }

    @Override // y3.c
    public void pause() {
        synchronized (this.f25225d) {
            try {
                if (isRunning()) {
                    clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Drawable q() {
        if (this.f25247z == null) {
            Drawable drawableK = this.f25232k.k();
            this.f25247z = drawableK;
            if (drawableK == null && this.f25232k.l() > 0) {
                this.f25247z = t(this.f25232k.l());
            }
        }
        return this.f25247z;
    }

    public final Drawable r() {
        if (this.f25246y == null) {
            Drawable drawableQ = this.f25232k.q();
            this.f25246y = drawableQ;
            if (drawableQ == null && this.f25232k.r() > 0) {
                this.f25246y = t(this.f25232k.r());
            }
        }
        return this.f25246y;
    }

    public final boolean s() {
        d dVar = this.f25227f;
        return dVar == null || !dVar.getRoot().b();
    }

    public final Drawable t(int i10) {
        return r3.d.a(this.f25228g, i10, this.f25232k.x() != null ? this.f25232k.x() : this.f25228g.getTheme());
    }

    public String toString() {
        Object obj;
        Class cls;
        synchronized (this.f25225d) {
            obj = this.f25230i;
            cls = this.f25231j;
        }
        return super.toString() + "[model=" + obj + ", transcodeClass=" + cls + "]";
    }

    public final void u(String str) {
        Log.v("GlideRequest", str + " this: " + this.f25223b);
    }

    public final void w() {
        d dVar = this.f25227f;
        if (dVar != null) {
            dVar.a(this);
        }
    }

    public final void x() {
        d dVar = this.f25227f;
        if (dVar != null) {
            dVar.j(this);
        }
    }

    public final void z(q qVar, int i10) {
        boolean zB;
        this.f25224c.c();
        synchronized (this.f25225d) {
            try {
                qVar.k(this.D);
                int iG = this.f25229h.g();
                if (iG <= i10) {
                    Log.w("Glide", "Load failed for [" + this.f25230i + "] with dimensions [" + this.A + "x" + this.B + "]", qVar);
                    if (iG <= 4) {
                        qVar.g("Glide");
                    }
                }
                this.f25241t = null;
                this.f25244w = a.FAILED;
                w();
                boolean z10 = true;
                this.C = true;
                try {
                    List list = this.f25237p;
                    if (list != null) {
                        Iterator it = list.iterator();
                        zB = false;
                        while (it.hasNext()) {
                            zB |= ((e) it.next()).b(qVar, this.f25230i, this.f25236o, s());
                        }
                    } else {
                        zB = false;
                    }
                    e eVar = this.f25226e;
                    if (eVar == null || !eVar.b(qVar, this.f25230i, this.f25236o, s())) {
                        z10 = false;
                    }
                    if (!(zB | z10)) {
                        B();
                    }
                    this.C = false;
                    d4.b.f("GlideRequest", this.f25222a);
                } catch (Throwable th) {
                    this.C = false;
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
