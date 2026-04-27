package m3;

import com.revenuecat.purchases.common.Constants;
import h3.C1875k;
import java.util.Map;
import p3.AbstractC2554h;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1875k f21439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f21440b;

    public i(C1875k c1875k, h hVar) {
        this.f21439a = c1875k;
        this.f21440b = hVar;
    }

    public static i a(C1875k c1875k) {
        return new i(c1875k, h.f21426i);
    }

    public static i b(C1875k c1875k, Map map) {
        return new i(c1875k, h.c(map));
    }

    public AbstractC2554h c() {
        return this.f21440b.d();
    }

    public h d() {
        return this.f21440b;
    }

    public C1875k e() {
        return this.f21439a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.f21439a.equals(iVar.f21439a) && this.f21440b.equals(iVar.f21440b);
    }

    public boolean f() {
        return this.f21440b.p();
    }

    public boolean g() {
        return this.f21440b.u();
    }

    public int hashCode() {
        return (this.f21439a.hashCode() * 31) + this.f21440b.hashCode();
    }

    public String toString() {
        return this.f21439a + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + this.f21440b;
    }
}
