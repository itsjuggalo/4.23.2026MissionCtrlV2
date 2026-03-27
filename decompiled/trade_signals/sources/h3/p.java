package h3;

import com.revenuecat.purchases.common.Constants;
import v3.C2860a;

/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f18578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f18579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f18580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f18581d;

    public void a(C2860a c2860a) {
        if (c2860a == null) {
            return;
        }
        String str = c2860a.a() + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + c2860a.b();
        this.f18578a = str;
        this.f18581d = str;
        this.f18579b = false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p.class != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        if (this.f18579b == pVar.f18579b && this.f18578a.equals(pVar.f18578a)) {
            return this.f18580c.equals(pVar.f18580c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f18578a.hashCode() * 31) + (this.f18579b ? 1 : 0)) * 31) + this.f18580c.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("http");
        sb.append(this.f18579b ? "s" : "");
        sb.append("://");
        sb.append(this.f18578a);
        return sb.toString();
    }
}
