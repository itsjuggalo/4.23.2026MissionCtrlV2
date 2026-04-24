package M2;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: renamed from: M2.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0700c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f5288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f5289c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f5290d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f5291e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g f5292f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set f5293g;

    public C0700c(String str, Set set, Set set2, int i8, int i9, g gVar, Set set3) {
        this.f5287a = str;
        this.f5288b = Collections.unmodifiableSet(set);
        this.f5289c = Collections.unmodifiableSet(set2);
        this.f5290d = i8;
        this.f5291e = i9;
        this.f5292f = gVar;
        this.f5293g = Collections.unmodifiableSet(set3);
    }

    public static b c(E e8) {
        return new b(e8, new E[0]);
    }

    public static b d(E e8, E... eArr) {
        return new b(e8, eArr);
    }

    public static b e(Class cls) {
        return new b(cls, new Class[0]);
    }

    public static b f(Class cls, Class... clsArr) {
        return new b(cls, clsArr);
    }

    public static C0700c l(final Object obj, Class cls) {
        return m(cls).f(new g() { // from class: M2.a
            @Override // M2.g
            public final Object create(InterfaceC0701d interfaceC0701d) {
                return C0700c.q(obj, interfaceC0701d);
            }
        }).d();
    }

    public static b m(Class cls) {
        return e(cls).g();
    }

    public static C0700c s(final Object obj, Class cls, Class... clsArr) {
        return f(cls, clsArr).f(new g() { // from class: M2.b
            @Override // M2.g
            public final Object create(InterfaceC0701d interfaceC0701d) {
                return C0700c.r(obj, interfaceC0701d);
            }
        }).d();
    }

    public Set g() {
        return this.f5289c;
    }

    public g h() {
        return this.f5292f;
    }

    public String i() {
        return this.f5287a;
    }

    public Set j() {
        return this.f5288b;
    }

    public Set k() {
        return this.f5293g;
    }

    public boolean n() {
        return this.f5290d == 1;
    }

    public boolean o() {
        return this.f5290d == 2;
    }

    public boolean p() {
        return this.f5291e == 0;
    }

    public C0700c t(g gVar) {
        return new C0700c(this.f5287a, this.f5288b, this.f5289c, this.f5290d, this.f5291e, gVar, this.f5293g);
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.f5288b.toArray()) + ">{" + this.f5290d + ", type=" + this.f5291e + ", deps=" + Arrays.toString(this.f5289c.toArray()) + "}";
    }

    /* JADX INFO: renamed from: M2.c$b */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f5294a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Set f5295b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Set f5296c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f5297d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f5298e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public g f5299f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Set f5300g;

        public b(E e8, E... eArr) {
            this.f5294a = null;
            HashSet hashSet = new HashSet();
            this.f5295b = hashSet;
            this.f5296c = new HashSet();
            this.f5297d = 0;
            this.f5298e = 0;
            this.f5300g = new HashSet();
            D.c(e8, "Null interface");
            hashSet.add(e8);
            for (E e9 : eArr) {
                D.c(e9, "Null interface");
            }
            Collections.addAll(this.f5295b, eArr);
        }

        public b b(q qVar) {
            D.c(qVar, "Null dependency");
            j(qVar.c());
            this.f5296c.add(qVar);
            return this;
        }

        public b c() {
            return i(1);
        }

        public C0700c d() {
            D.d(this.f5299f != null, "Missing required property: factory.");
            return new C0700c(this.f5294a, new HashSet(this.f5295b), new HashSet(this.f5296c), this.f5297d, this.f5298e, this.f5299f, this.f5300g);
        }

        public b e() {
            return i(2);
        }

        public b f(g gVar) {
            this.f5299f = (g) D.c(gVar, "Null factory");
            return this;
        }

        public final b g() {
            this.f5298e = 1;
            return this;
        }

        public b h(String str) {
            this.f5294a = str;
            return this;
        }

        public final b i(int i8) {
            D.d(this.f5297d == 0, "Instantiation type has already been set.");
            this.f5297d = i8;
            return this;
        }

        public final void j(E e8) {
            D.a(!this.f5295b.contains(e8), "Components are not allowed to depend on interfaces they themselves provide.");
        }

        public b(Class cls, Class... clsArr) {
            this.f5294a = null;
            HashSet hashSet = new HashSet();
            this.f5295b = hashSet;
            this.f5296c = new HashSet();
            this.f5297d = 0;
            this.f5298e = 0;
            this.f5300g = new HashSet();
            D.c(cls, "Null interface");
            hashSet.add(E.b(cls));
            for (Class cls2 : clsArr) {
                D.c(cls2, "Null interface");
                this.f5295b.add(E.b(cls2));
            }
        }
    }

    public static /* synthetic */ Object q(Object obj, InterfaceC0701d interfaceC0701d) {
        return obj;
    }

    public static /* synthetic */ Object r(Object obj, InterfaceC0701d interfaceC0701d) {
        return obj;
    }
}
