package o8;

import com.revenuecat.purchases.common.Constants;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j8.l f17642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f17643b;

    public i(j8.l lVar, h hVar) {
        this.f17642a = lVar;
        this.f17643b = hVar;
    }

    public static i a(j8.l lVar) {
        return new i(lVar, h.f17629i);
    }

    public static i b(j8.l lVar, Map map) {
        return new i(lVar, h.c(map));
    }

    public r8.h c() {
        return this.f17643b.d();
    }

    public h d() {
        return this.f17643b;
    }

    public j8.l e() {
        return this.f17642a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.f17642a.equals(iVar.f17642a) && this.f17643b.equals(iVar.f17643b);
    }

    public boolean f() {
        return this.f17643b.p();
    }

    public boolean g() {
        return this.f17643b.u();
    }

    public int hashCode() {
        return (this.f17642a.hashCode() * 31) + this.f17643b.hashCode();
    }

    public String toString() {
        return this.f17642a + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + this.f17643b;
    }
}
