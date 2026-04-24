package G3;

import K3.AbstractC0612b;

/* JADX INFO: loaded from: classes.dex */
public final class f implements Comparable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f2436c = b("", "");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2438b;

    public f(String str, String str2) {
        this.f2437a = str;
        this.f2438b = str2;
    }

    public static f b(String str, String str2) {
        return new f(str, str2);
    }

    public static f c(String str) {
        t tVarV = t.v(str);
        boolean z7 = false;
        if (tVarV.q() > 3 && tVarV.m(0).equals("projects") && tVarV.m(2).equals("databases")) {
            z7 = true;
        }
        AbstractC0612b.d(z7, "Tried to parse an invalid resource name: %s", tVarV);
        return new f(tVarV.m(1), tVarV.m(3));
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(f fVar) {
        int iCompareTo = this.f2437a.compareTo(fVar.f2437a);
        return iCompareTo != 0 ? iCompareTo : this.f2438b.compareTo(fVar.f2438b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        return this.f2437a.equals(fVar.f2437a) && this.f2438b.equals(fVar.f2438b);
    }

    public String h() {
        return this.f2438b;
    }

    public int hashCode() {
        return (this.f2437a.hashCode() * 31) + this.f2438b.hashCode();
    }

    public String i() {
        return this.f2437a;
    }

    public String toString() {
        return "DatabaseId(" + this.f2437a + ", " + this.f2438b + ")";
    }
}
