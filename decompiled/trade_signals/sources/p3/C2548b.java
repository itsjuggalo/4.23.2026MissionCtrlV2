package p3;

import k3.AbstractC2279m;

/* JADX INFO: renamed from: p3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2548b implements Comparable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C2548b f22261b = new C2548b("[MIN_NAME]");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C2548b f22262c = new C2548b("[MAX_KEY]");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C2548b f22263d = new C2548b(".priority");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C2548b f22264e = new C2548b(".info");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22265a;

    /* JADX INFO: renamed from: p3.b$b, reason: collision with other inner class name */
    public static class C0374b extends C2548b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f22266f;

        public C0374b(String str, int i8) {
            super(str);
            this.f22266f = i8;
        }

        @Override // p3.C2548b, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((C2548b) obj);
        }

        @Override // p3.C2548b
        public int q() {
            return this.f22266f;
        }

        @Override // p3.C2548b
        public boolean r() {
            return true;
        }

        @Override // p3.C2548b
        public String toString() {
            return "IntegerChildName(\"" + this.f22265a + "\")";
        }
    }

    public C2548b(String str) {
        this.f22265a = str;
    }

    public static C2548b i(String str) {
        Integer numK = AbstractC2279m.k(str);
        if (numK != null) {
            return new C0374b(str, numK.intValue());
        }
        if (str.equals(".priority")) {
            return f22263d;
        }
        AbstractC2279m.f(!str.contains("/"));
        return new C2548b(str);
    }

    public static C2548b k() {
        return f22264e;
    }

    public static C2548b l() {
        return f22262c;
    }

    public static C2548b m() {
        return f22261b;
    }

    public static C2548b n() {
        return f22263d;
    }

    public String b() {
        return this.f22265a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2548b)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return this.f22265a.equals(((C2548b) obj).f22265a);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public int compareTo(C2548b c2548b) {
        if (this == c2548b) {
            return 0;
        }
        if (this.f22265a.equals("[MIN_NAME]") || c2548b.f22265a.equals("[MAX_KEY]")) {
            return -1;
        }
        if (c2548b.f22265a.equals("[MIN_NAME]") || this.f22265a.equals("[MAX_KEY]")) {
            return 1;
        }
        if (!r()) {
            if (c2548b.r()) {
                return 1;
            }
            return this.f22265a.compareTo(c2548b.f22265a);
        }
        if (!c2548b.r()) {
            return -1;
        }
        int iA = AbstractC2279m.a(q(), c2548b.q());
        return iA == 0 ? AbstractC2279m.a(this.f22265a.length(), c2548b.f22265a.length()) : iA;
    }

    public int hashCode() {
        return this.f22265a.hashCode();
    }

    public int q() {
        return 0;
    }

    public boolean r() {
        return false;
    }

    public boolean t() {
        return equals(f22263d);
    }

    public String toString() {
        return "ChildKey(\"" + this.f22265a + "\")";
    }
}
