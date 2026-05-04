package m9;

import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j9.v f16221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f16222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f16223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f16224d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set f16225e;

    public n0(j9.v vVar, Map map, Map map2, Map map3, Set set) {
        this.f16221a = vVar;
        this.f16222b = map;
        this.f16223c = map2;
        this.f16224d = map3;
        this.f16225e = set;
    }

    public Map a() {
        return this.f16224d;
    }

    public Set b() {
        return this.f16225e;
    }

    public j9.v c() {
        return this.f16221a;
    }

    public Map d() {
        return this.f16222b;
    }

    public Map e() {
        return this.f16223c;
    }

    public String toString() {
        return "RemoteEvent{snapshotVersion=" + this.f16221a + ", targetChanges=" + this.f16222b + ", targetMismatches=" + this.f16223c + ", documentUpdates=" + this.f16224d + ", resolvedLimboDocuments=" + this.f16225e + '}';
    }
}
