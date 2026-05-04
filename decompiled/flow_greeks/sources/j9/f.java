package j9;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements Comparable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f14237c = b("", "");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14239b;

    public f(String str, String str2) {
        this.f14238a = str;
        this.f14239b = str2;
    }

    public static f b(String str, String str2) {
        return new f(str, str2);
    }

    public static f c(String str) {
        t tVarB = t.B(str);
        boolean z10 = false;
        if (tVarB.u() > 3 && tVarB.o(0).equals("projects") && tVarB.o(2).equals("databases")) {
            z10 = true;
        }
        n9.b.d(z10, "Tried to parse an invalid resource name: %s", tVarB);
        return new f(tVarB.o(1), tVarB.o(3));
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(f fVar) {
        int iCompareTo = this.f14238a.compareTo(fVar.f14238a);
        return iCompareTo != 0 ? iCompareTo : this.f14239b.compareTo(fVar.f14239b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && f.class == obj.getClass()) {
            f fVar = (f) obj;
            if (this.f14238a.equals(fVar.f14238a) && this.f14239b.equals(fVar.f14239b)) {
                return true;
            }
        }
        return false;
    }

    public String h() {
        return this.f14239b;
    }

    public int hashCode() {
        return (this.f14238a.hashCode() * 31) + this.f14239b.hashCode();
    }

    public String i() {
        return this.f14238a;
    }

    public String toString() {
        return "DatabaseId(" + this.f14238a + ", " + this.f14239b + ")";
    }
}
