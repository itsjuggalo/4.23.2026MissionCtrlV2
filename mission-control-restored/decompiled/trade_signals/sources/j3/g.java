package j3;

import h3.C1875k;
import k3.C2270d;
import k3.InterfaceC2275i;
import p3.C2548b;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final InterfaceC2275i f20006b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final InterfaceC2275i f20007c = new b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C2270d f20008d = new C2270d(Boolean.TRUE);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C2270d f20009e = new C2270d(Boolean.FALSE);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2270d f20010a;

    public class a implements InterfaceC2275i {
        @Override // k3.InterfaceC2275i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean a(Boolean bool) {
            return !bool.booleanValue();
        }
    }

    public class b implements InterfaceC2275i {
        @Override // k3.InterfaceC2275i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean a(Boolean bool) {
            return bool.booleanValue();
        }
    }

    public class c implements C2270d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C2270d.c f20011a;

        public c(C2270d.c cVar) {
            this.f20011a = cVar;
        }

        @Override // k3.C2270d.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Object a(C1875k c1875k, Boolean bool, Object obj) {
            return !bool.booleanValue() ? this.f20011a.a(c1875k, null, obj) : obj;
        }
    }

    public g() {
        this.f20010a = C2270d.d();
    }

    public g a(C2548b c2548b) {
        C2270d c2270dH = this.f20010a.H(c2548b);
        if (c2270dH == null) {
            c2270dH = new C2270d((Boolean) this.f20010a.getValue());
        } else if (c2270dH.getValue() == null && this.f20010a.getValue() != null) {
            c2270dH = c2270dH.N(C1875k.O(), (Boolean) this.f20010a.getValue());
        }
        return new g(c2270dH);
    }

    public Object b(Object obj, C2270d.c cVar) {
        return this.f20010a.n(obj, new c(cVar));
    }

    public g c(C1875k c1875k) {
        return this.f20010a.M(c1875k, f20006b) != null ? this : new g(this.f20010a.O(c1875k, f20009e));
    }

    public g d(C1875k c1875k) {
        if (this.f20010a.M(c1875k, f20006b) == null) {
            return this.f20010a.M(c1875k, f20007c) != null ? this : new g(this.f20010a.O(c1875k, f20008d));
        }
        throw new IllegalArgumentException("Can't prune path that was kept previously!");
    }

    public boolean e() {
        return this.f20010a.a(f20007c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof g) && this.f20010a.equals(((g) obj).f20010a);
    }

    public boolean f(C1875k c1875k) {
        Boolean bool = (Boolean) this.f20010a.J(c1875k);
        return (bool == null || bool.booleanValue()) ? false : true;
    }

    public boolean g(C1875k c1875k) {
        Boolean bool = (Boolean) this.f20010a.J(c1875k);
        return bool != null && bool.booleanValue();
    }

    public int hashCode() {
        return this.f20010a.hashCode();
    }

    public String toString() {
        return "{PruneForest:" + this.f20010a.toString() + "}";
    }

    public g(C2270d c2270d) {
        this.f20010a = c2270d;
    }
}
