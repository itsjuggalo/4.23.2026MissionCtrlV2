package f9;

import j9.v;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f9420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f9421d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f9422e;

    public e(String str, int i10, v vVar, int i11, long j10) {
        this.f9418a = str;
        this.f9419b = i10;
        this.f9420c = vVar;
        this.f9421d = i11;
        this.f9422e = j10;
    }

    public String a() {
        return this.f9418a;
    }

    public v b() {
        return this.f9420c;
    }

    public int c() {
        return this.f9419b;
    }

    public long d() {
        return this.f9422e;
    }

    public int e() {
        return this.f9421d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f9419b == eVar.f9419b && this.f9421d == eVar.f9421d && this.f9422e == eVar.f9422e && this.f9418a.equals(eVar.f9418a)) {
            return this.f9420c.equals(eVar.f9420c);
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = ((((this.f9418a.hashCode() * 31) + this.f9419b) * 31) + this.f9421d) * 31;
        long j10 = this.f9422e;
        return ((iHashCode + ((int) (j10 ^ (j10 >>> 32)))) * 31) + this.f9420c.hashCode();
    }
}
