package r8;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b implements Comparable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f19385b = new b("[MIN_NAME]");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f19386c = new b("[MAX_KEY]");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f19387d = new b(".priority");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f19388e = new b(".info");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19389a;

    /* JADX INFO: renamed from: r8.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class C0338b extends b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f19390f;

        public C0338b(String str, int i10) {
            super(str);
            this.f19390f = i10;
        }

        @Override // r8.b, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((b) obj);
        }

        @Override // r8.b
        public int o() {
            return this.f19390f;
        }

        @Override // r8.b
        public boolean q() {
            return true;
        }

        @Override // r8.b
        public String toString() {
            return "IntegerChildName(\"" + this.f19389a + "\")";
        }
    }

    public static b h(String str) {
        Integer numK = m8.m.k(str);
        if (numK != null) {
            return new C0338b(str, numK.intValue());
        }
        if (str.equals(".priority")) {
            return f19387d;
        }
        m8.m.f(!str.contains("/"));
        return new b(str);
    }

    public static b i() {
        return f19388e;
    }

    public static b k() {
        return f19386c;
    }

    public static b l() {
        return f19385b;
    }

    public static b m() {
        return f19387d;
    }

    public String b() {
        return this.f19389a;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(b bVar) {
        if (this == bVar) {
            return 0;
        }
        if (this.f19389a.equals("[MIN_NAME]") || bVar.f19389a.equals("[MAX_KEY]")) {
            return -1;
        }
        if (bVar.f19389a.equals("[MIN_NAME]") || this.f19389a.equals("[MAX_KEY]")) {
            return 1;
        }
        if (!q()) {
            if (bVar.q()) {
                return 1;
            }
            return this.f19389a.compareTo(bVar.f19389a);
        }
        if (!bVar.q()) {
            return -1;
        }
        int iA = m8.m.a(o(), bVar.o());
        return iA == 0 ? m8.m.a(this.f19389a.length(), bVar.f19389a.length()) : iA;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return this.f19389a.equals(((b) obj).f19389a);
    }

    public int hashCode() {
        return this.f19389a.hashCode();
    }

    public int o() {
        return 0;
    }

    public boolean q() {
        return false;
    }

    public boolean s() {
        return equals(f19387d);
    }

    public String toString() {
        return "ChildKey(\"" + this.f19389a + "\")";
    }

    public b(String str) {
        this.f19389a = str;
    }
}
