package f9;

import j9.k;
import j9.v;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class h implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f9432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f9433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f9434c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f9435d;

    public h(k kVar, v vVar, boolean z10, List list) {
        this.f9432a = kVar;
        this.f9433b = vVar;
        this.f9434c = z10;
        this.f9435d = list;
    }

    public boolean a() {
        return this.f9434c;
    }

    public k b() {
        return this.f9432a;
    }

    public List c() {
        return this.f9435d;
    }

    public v d() {
        return this.f9433b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f9434c == hVar.f9434c && this.f9432a.equals(hVar.f9432a) && this.f9433b.equals(hVar.f9433b)) {
            return this.f9435d.equals(hVar.f9435d);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f9432a.hashCode() * 31) + this.f9433b.hashCode()) * 31) + (this.f9434c ? 1 : 0)) * 31) + this.f9435d.hashCode();
    }
}
