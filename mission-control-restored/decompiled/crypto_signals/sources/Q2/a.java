package Q2;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final c e = new c(0, b.f2660d);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final A.d f2655f = new A.d(7);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f2658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f2659d;

    public a(int i, String str, ArrayList arrayList, c cVar) {
        this.f2656a = i;
        if (str == null) {
            throw new NullPointerException("Null collectionGroup");
        }
        this.f2657b = str;
        this.f2658c = arrayList;
        if (cVar == null) {
            throw new NullPointerException("Null indexState");
        }
        this.f2659d = cVar;
    }

    public final d a() {
        for (d dVar : this.f2658c) {
            if (S.i.b(dVar.f2667b, 3)) {
                return dVar;
            }
        }
        return null;
    }

    public final ArrayList b() {
        ArrayList arrayList = new ArrayList();
        for (d dVar : this.f2658c) {
            if (!S.i.b(dVar.f2667b, 3)) {
                arrayList.add(dVar);
            }
        }
        return arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f2656a == aVar.f2656a && this.f2657b.equals(aVar.f2657b) && this.f2658c.equals(aVar.f2658c) && this.f2659d.equals(aVar.f2659d);
    }

    public final int hashCode() {
        return this.f2659d.hashCode() ^ ((((((this.f2656a ^ 1000003) * 1000003) ^ this.f2657b.hashCode()) * 1000003) ^ this.f2658c.hashCode()) * 1000003);
    }

    public final String toString() {
        return "FieldIndex{indexId=" + this.f2656a + ", collectionGroup=" + this.f2657b + ", segments=" + this.f2658c + ", indexState=" + this.f2659d + "}";
    }
}
