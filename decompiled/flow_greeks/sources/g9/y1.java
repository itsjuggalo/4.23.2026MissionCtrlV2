package g9;

import g9.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b1 f10413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j9.m f10414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j9.m f10415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f10416d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f10417e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g8.e f10418f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f10419g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f10420h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f10421i;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum a {
        NONE,
        LOCAL,
        SYNCED
    }

    public y1(b1 b1Var, j9.m mVar, j9.m mVar2, List list, boolean z10, g8.e eVar, boolean z11, boolean z12, boolean z13) {
        this.f10413a = b1Var;
        this.f10414b = mVar;
        this.f10415c = mVar2;
        this.f10416d = list;
        this.f10417e = z10;
        this.f10418f = eVar;
        this.f10419g = z11;
        this.f10420h = z12;
        this.f10421i = z13;
    }

    public static y1 c(b1 b1Var, j9.m mVar, g8.e eVar, boolean z10, boolean z11, boolean z12) {
        ArrayList arrayList = new ArrayList();
        Iterator it = mVar.iterator();
        while (it.hasNext()) {
            arrayList.add(m.a(m.a.ADDED, (j9.h) it.next()));
        }
        return new y1(b1Var, mVar, j9.m.d(b1Var.c()), arrayList, z10, eVar, true, z11, z12);
    }

    public boolean a() {
        return this.f10419g;
    }

    public boolean b() {
        return this.f10420h;
    }

    public List d() {
        return this.f10416d;
    }

    public j9.m e() {
        return this.f10414b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y1)) {
            return false;
        }
        y1 y1Var = (y1) obj;
        if (this.f10417e == y1Var.f10417e && this.f10419g == y1Var.f10419g && this.f10420h == y1Var.f10420h && this.f10413a.equals(y1Var.f10413a) && this.f10418f.equals(y1Var.f10418f) && this.f10414b.equals(y1Var.f10414b) && this.f10415c.equals(y1Var.f10415c) && this.f10421i == y1Var.f10421i) {
            return this.f10416d.equals(y1Var.f10416d);
        }
        return false;
    }

    public g8.e f() {
        return this.f10418f;
    }

    public j9.m g() {
        return this.f10415c;
    }

    public b1 h() {
        return this.f10413a;
    }

    public int hashCode() {
        return (((((((((((((((this.f10413a.hashCode() * 31) + this.f10414b.hashCode()) * 31) + this.f10415c.hashCode()) * 31) + this.f10416d.hashCode()) * 31) + this.f10418f.hashCode()) * 31) + (this.f10417e ? 1 : 0)) * 31) + (this.f10419g ? 1 : 0)) * 31) + (this.f10420h ? 1 : 0)) * 31) + (this.f10421i ? 1 : 0);
    }

    public boolean i() {
        return this.f10421i;
    }

    public boolean j() {
        return !this.f10418f.isEmpty();
    }

    public boolean k() {
        return this.f10417e;
    }

    public String toString() {
        return "ViewSnapshot(" + this.f10413a + ", " + this.f10414b + ", " + this.f10415c + ", " + this.f10416d + ", isFromCache=" + this.f10417e + ", mutatedKeys=" + this.f10418f.size() + ", didSyncStateChange=" + this.f10419g + ", excludesMetadataChanges=" + this.f10420h + ", hasCachedResults=" + this.f10421i + ")";
    }
}
