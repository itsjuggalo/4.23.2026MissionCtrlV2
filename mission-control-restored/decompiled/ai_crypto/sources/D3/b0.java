package D3;

import K3.AbstractC0612b;
import k4.C2105D;

/* JADX INFO: loaded from: classes.dex */
public class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f1253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final G3.q f1254b;

    public enum a {
        ASCENDING(1),
        DESCENDING(-1);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f1258a;

        a(int i7) {
            this.f1258a = i7;
        }

        public int b() {
            return this.f1258a;
        }
    }

    public b0(a aVar, G3.q qVar) {
        this.f1253a = aVar;
        this.f1254b = qVar;
    }

    public static b0 d(a aVar, G3.q qVar) {
        return new b0(aVar, qVar);
    }

    public int a(G3.h hVar, G3.h hVar2) {
        int iB;
        int i7;
        if (this.f1254b.equals(G3.q.f2455b)) {
            iB = this.f1253a.b();
            i7 = hVar.getKey().compareTo(hVar2.getKey());
        } else {
            C2105D c2105dI = hVar.i(this.f1254b);
            C2105D c2105dI2 = hVar2.i(this.f1254b);
            AbstractC0612b.d((c2105dI == null || c2105dI2 == null) ? false : true, "Trying to compare documents on fields that don't exist.", new Object[0]);
            iB = this.f1253a.b();
            i7 = G3.y.i(c2105dI, c2105dI2);
        }
        return iB * i7;
    }

    public a b() {
        return this.f1253a;
    }

    public G3.q c() {
        return this.f1254b;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return this.f1253a == b0Var.f1253a && this.f1254b.equals(b0Var.f1254b);
    }

    public int hashCode() {
        return ((899 + this.f1253a.hashCode()) * 31) + this.f1254b.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1253a == a.ASCENDING ? "" : "-");
        sb.append(this.f1254b.c());
        return sb.toString();
    }
}
