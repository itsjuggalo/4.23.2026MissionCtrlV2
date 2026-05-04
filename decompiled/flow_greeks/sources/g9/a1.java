package g9;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f10142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j9.q f10143b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum a {
        ASCENDING(1),
        DESCENDING(-1);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f10147a;

        a(int i10) {
            this.f10147a = i10;
        }

        public int b() {
            return this.f10147a;
        }
    }

    public a1(a aVar, j9.q qVar) {
        this.f10142a = aVar;
        this.f10143b = qVar;
    }

    public static a1 d(a aVar, j9.q qVar) {
        return new a1(aVar, qVar);
    }

    public int a(j9.h hVar, j9.h hVar2) {
        int iB;
        int i10;
        if (this.f10143b.equals(j9.q.f14256b)) {
            iB = this.f10142a.b();
            i10 = hVar.getKey().compareTo(hVar2.getKey());
        } else {
            bb.d0 d0VarH = hVar.h(this.f10143b);
            bb.d0 d0VarH2 = hVar2.h(this.f10143b);
            n9.b.d((d0VarH == null || d0VarH2 == null) ? false : true, "Trying to compare documents on fields that don't exist.", new Object[0]);
            iB = this.f10142a.b();
            i10 = j9.y.i(d0VarH, d0VarH2);
        }
        return iB * i10;
    }

    public a b() {
        return this.f10142a;
    }

    public j9.q c() {
        return this.f10143b;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof a1)) {
            a1 a1Var = (a1) obj;
            if (this.f10142a == a1Var.f10142a && this.f10143b.equals(a1Var.f10143b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((899 + this.f10142a.hashCode()) * 31) + this.f10143b.hashCode();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f10142a == a.ASCENDING ? "" : "-");
        sb2.append(this.f10143b.c());
        return sb2.toString();
    }
}
