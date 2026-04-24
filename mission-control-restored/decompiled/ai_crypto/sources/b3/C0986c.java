package b3;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: renamed from: b3.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0986c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f8521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f8522c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8523d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f8524e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final InterfaceC0990g f8525f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set f8526g;

    public static b c(C0982E c0982e) {
        return new b(c0982e, new C0982E[0]);
    }

    public static b d(C0982E c0982e, C0982E... c0982eArr) {
        return new b(c0982e, c0982eArr);
    }

    public static b e(Class cls) {
        return new b(cls, new Class[0]);
    }

    public static b f(Class cls, Class... clsArr) {
        return new b(cls, clsArr);
    }

    public static C0986c l(final Object obj, Class cls) {
        return m(cls).f(new InterfaceC0990g() { // from class: b3.a
            @Override // b3.InterfaceC0990g
            public final Object a(InterfaceC0987d interfaceC0987d) {
                return C0986c.q(obj, interfaceC0987d);
            }
        }).d();
    }

    public static b m(Class cls) {
        return e(cls).g();
    }

    public static C0986c s(final Object obj, Class cls, Class... clsArr) {
        return f(cls, clsArr).f(new InterfaceC0990g() { // from class: b3.b
            @Override // b3.InterfaceC0990g
            public final Object a(InterfaceC0987d interfaceC0987d) {
                return C0986c.r(obj, interfaceC0987d);
            }
        }).d();
    }

    public Set g() {
        return this.f8522c;
    }

    public InterfaceC0990g h() {
        return this.f8525f;
    }

    public String i() {
        return this.f8520a;
    }

    public Set j() {
        return this.f8521b;
    }

    public Set k() {
        return this.f8526g;
    }

    public boolean n() {
        return this.f8523d == 1;
    }

    public boolean o() {
        return this.f8523d == 2;
    }

    public boolean p() {
        return this.f8524e == 0;
    }

    public C0986c t(InterfaceC0990g interfaceC0990g) {
        return new C0986c(this.f8520a, this.f8521b, this.f8522c, this.f8523d, this.f8524e, interfaceC0990g, this.f8526g);
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.f8521b.toArray()) + ">{" + this.f8523d + ", type=" + this.f8524e + ", deps=" + Arrays.toString(this.f8522c.toArray()) + "}";
    }

    /* JADX INFO: renamed from: b3.c$b */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Set f8528b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Set f8529c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8530d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f8531e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public InterfaceC0990g f8532f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Set f8533g;

        public b b(q qVar) {
            AbstractC0981D.c(qVar, "Null dependency");
            j(qVar.c());
            this.f8529c.add(qVar);
            return this;
        }

        public b c() {
            return i(1);
        }

        public C0986c d() {
            AbstractC0981D.d(this.f8532f != null, "Missing required property: factory.");
            return new C0986c(this.f8527a, new HashSet(this.f8528b), new HashSet(this.f8529c), this.f8530d, this.f8531e, this.f8532f, this.f8533g);
        }

        public b e() {
            return i(2);
        }

        public b f(InterfaceC0990g interfaceC0990g) {
            this.f8532f = (InterfaceC0990g) AbstractC0981D.c(interfaceC0990g, "Null factory");
            return this;
        }

        public final b g() {
            this.f8531e = 1;
            return this;
        }

        public b h(String str) {
            this.f8527a = str;
            return this;
        }

        public final b i(int i7) {
            AbstractC0981D.d(this.f8530d == 0, "Instantiation type has already been set.");
            this.f8530d = i7;
            return this;
        }

        public final void j(C0982E c0982e) {
            AbstractC0981D.a(!this.f8528b.contains(c0982e), "Components are not allowed to depend on interfaces they themselves provide.");
        }

        public b(Class cls, Class... clsArr) {
            this.f8527a = null;
            HashSet hashSet = new HashSet();
            this.f8528b = hashSet;
            this.f8529c = new HashSet();
            this.f8530d = 0;
            this.f8531e = 0;
            this.f8533g = new HashSet();
            AbstractC0981D.c(cls, "Null interface");
            hashSet.add(C0982E.b(cls));
            for (Class cls2 : clsArr) {
                AbstractC0981D.c(cls2, "Null interface");
                this.f8528b.add(C0982E.b(cls2));
            }
        }

        public b(C0982E c0982e, C0982E... c0982eArr) {
            this.f8527a = null;
            HashSet hashSet = new HashSet();
            this.f8528b = hashSet;
            this.f8529c = new HashSet();
            this.f8530d = 0;
            this.f8531e = 0;
            this.f8533g = new HashSet();
            AbstractC0981D.c(c0982e, "Null interface");
            hashSet.add(c0982e);
            for (C0982E c0982e2 : c0982eArr) {
                AbstractC0981D.c(c0982e2, "Null interface");
            }
            Collections.addAll(this.f8528b, c0982eArr);
        }
    }

    public C0986c(String str, Set set, Set set2, int i7, int i8, InterfaceC0990g interfaceC0990g, Set set3) {
        this.f8520a = str;
        this.f8521b = Collections.unmodifiableSet(set);
        this.f8522c = Collections.unmodifiableSet(set2);
        this.f8523d = i7;
        this.f8524e = i8;
        this.f8525f = interfaceC0990g;
        this.f8526g = Collections.unmodifiableSet(set3);
    }

    public static /* synthetic */ Object q(Object obj, InterfaceC0987d interfaceC0987d) {
        return obj;
    }

    public static /* synthetic */ Object r(Object obj, InterfaceC0987d interfaceC0987d) {
        return obj;
    }
}
