package j8;

import com.revenuecat.purchases.common.Constants;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f14135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f14136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f14137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f14138d;

    public void a(x8.a aVar) {
        if (aVar == null) {
            return;
        }
        String str = aVar.a() + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + aVar.b();
        this.f14135a = str;
        this.f14138d = str;
        this.f14136b = false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || q.class != obj.getClass()) {
            return false;
        }
        q qVar = (q) obj;
        if (this.f14136b == qVar.f14136b && this.f14135a.equals(qVar.f14135a)) {
            return this.f14137c.equals(qVar.f14137c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f14135a.hashCode() * 31) + (this.f14136b ? 1 : 0)) * 31) + this.f14137c.hashCode();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("http");
        sb2.append(this.f14136b ? "s" : "");
        sb2.append("://");
        sb2.append(this.f14135a);
        return sb2.toString();
    }
}
