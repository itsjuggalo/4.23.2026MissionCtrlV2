package M2;

import Q2.n;

/* JADX INFO: loaded from: classes.dex */
public final class e implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f1070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1071d;
    public final long e;

    public e(String str, int i, n nVar, int i6, long j4) {
        this.f1068a = str;
        this.f1069b = i;
        this.f1070c = nVar;
        this.f1071d = i6;
        this.e = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f1069b == eVar.f1069b && this.f1071d == eVar.f1071d && this.e == eVar.e && this.f1068a.equals(eVar.f1068a)) {
            return this.f1070c.equals(eVar.f1070c);
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = ((((this.f1068a.hashCode() * 31) + this.f1069b) * 31) + this.f1071d) * 31;
        long j4 = this.e;
        return this.f1070c.f2688a.hashCode() + ((iHashCode + ((int) (j4 ^ (j4 >>> 32)))) * 31);
    }
}
