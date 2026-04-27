package I2;

import java.io.Serializable;

/* JADX INFO: renamed from: I2.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0585c extends t implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final H2.e f2955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f2956b;

    public C0585c(H2.e eVar, t tVar) {
        this.f2955a = (H2.e) H2.m.n(eVar);
        this.f2956b = (t) H2.m.n(tVar);
    }

    @Override // I2.t, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.f2956b.compare(this.f2955a.apply(obj), this.f2955a.apply(obj2));
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0585c)) {
            return false;
        }
        C0585c c0585c = (C0585c) obj;
        return this.f2955a.equals(c0585c.f2955a) && this.f2956b.equals(c0585c.f2956b);
    }

    public int hashCode() {
        return H2.i.b(this.f2955a, this.f2956b);
    }

    public String toString() {
        return this.f2956b + ".onResultOf(" + this.f2955a + ")";
    }
}
