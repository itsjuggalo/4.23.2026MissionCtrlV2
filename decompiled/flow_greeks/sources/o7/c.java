package o7;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f17529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f17530c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f17531d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f17532e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g f17533f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set f17534g;

    public static b c(Class cls) {
        return new b(cls, new Class[0]);
    }

    public static b d(Class cls, Class... clsArr) {
        return new b(cls, clsArr);
    }

    public static b e(e0 e0Var) {
        return new b(e0Var, new e0[0]);
    }

    public static b f(e0 e0Var, e0... e0VarArr) {
        return new b(e0Var, e0VarArr);
    }

    public static c l(final Object obj, Class cls) {
        return m(cls).f(new g() { // from class: o7.a
            @Override // o7.g
            public final Object create(d dVar) {
                return c.b(obj, dVar);
            }
        }).d();
    }

    public static b m(Class cls) {
        return c(cls).g();
    }

    public static c q(final Object obj, Class cls, Class... clsArr) {
        return d(cls, clsArr).f(new g() { // from class: o7.b
            @Override // o7.g
            public final Object create(d dVar) {
                return c.a(obj, dVar);
            }
        }).d();
    }

    public Set g() {
        return this.f17530c;
    }

    public g h() {
        return this.f17533f;
    }

    public String i() {
        return this.f17528a;
    }

    public Set j() {
        return this.f17529b;
    }

    public Set k() {
        return this.f17534g;
    }

    public boolean n() {
        return this.f17531d == 1;
    }

    public boolean o() {
        return this.f17531d == 2;
    }

    public boolean p() {
        return this.f17532e == 0;
    }

    public c r(g gVar) {
        return new c(this.f17528a, this.f17529b, this.f17530c, this.f17531d, this.f17532e, gVar, this.f17534g);
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.f17529b.toArray()) + ">{" + this.f17531d + ", type=" + this.f17532e + ", deps=" + Arrays.toString(this.f17530c.toArray()) + "}";
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f17535a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Set f17536b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Set f17537c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f17538d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f17539e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public g f17540f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Set f17541g;

        public b b(q qVar) {
            d0.c(qVar, "Null dependency");
            j(qVar.c());
            this.f17537c.add(qVar);
            return this;
        }

        public b c() {
            return i(1);
        }

        public c d() {
            d0.d(this.f17540f != null, "Missing required property: factory.");
            return new c(this.f17535a, new HashSet(this.f17536b), new HashSet(this.f17537c), this.f17538d, this.f17539e, this.f17540f, this.f17541g);
        }

        public b e() {
            return i(2);
        }

        public b f(g gVar) {
            this.f17540f = (g) d0.c(gVar, "Null factory");
            return this;
        }

        public final b g() {
            this.f17539e = 1;
            return this;
        }

        public b h(String str) {
            this.f17535a = str;
            return this;
        }

        public final b i(int i10) {
            d0.d(this.f17538d == 0, "Instantiation type has already been set.");
            this.f17538d = i10;
            return this;
        }

        public final void j(e0 e0Var) {
            d0.a(!this.f17536b.contains(e0Var), "Components are not allowed to depend on interfaces they themselves provide.");
        }

        public b(Class cls, Class... clsArr) {
            this.f17535a = null;
            HashSet hashSet = new HashSet();
            this.f17536b = hashSet;
            this.f17537c = new HashSet();
            this.f17538d = 0;
            this.f17539e = 0;
            this.f17541g = new HashSet();
            d0.c(cls, "Null interface");
            hashSet.add(e0.b(cls));
            for (Class cls2 : clsArr) {
                d0.c(cls2, "Null interface");
                this.f17536b.add(e0.b(cls2));
            }
        }

        public b(e0 e0Var, e0... e0VarArr) {
            this.f17535a = null;
            HashSet hashSet = new HashSet();
            this.f17536b = hashSet;
            this.f17537c = new HashSet();
            this.f17538d = 0;
            this.f17539e = 0;
            this.f17541g = new HashSet();
            d0.c(e0Var, "Null interface");
            hashSet.add(e0Var);
            for (e0 e0Var2 : e0VarArr) {
                d0.c(e0Var2, "Null interface");
            }
            Collections.addAll(this.f17536b, e0VarArr);
        }
    }

    public c(String str, Set set, Set set2, int i10, int i11, g gVar, Set set3) {
        this.f17528a = str;
        this.f17529b = Collections.unmodifiableSet(set);
        this.f17530c = Collections.unmodifiableSet(set2);
        this.f17531d = i10;
        this.f17532e = i11;
        this.f17533f = gVar;
        this.f17534g = Collections.unmodifiableSet(set3);
    }

    public static /* synthetic */ Object a(Object obj, d dVar) {
        return obj;
    }

    public static /* synthetic */ Object b(Object obj, d dVar) {
        return obj;
    }
}
