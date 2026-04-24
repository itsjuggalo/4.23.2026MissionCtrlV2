package J3;

import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class N {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final G3.v f3105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f3106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f3107c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f3108d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set f3109e;

    public N(G3.v vVar, Map map, Map map2, Map map3, Set set) {
        this.f3105a = vVar;
        this.f3106b = map;
        this.f3107c = map2;
        this.f3108d = map3;
        this.f3109e = set;
    }

    public Map a() {
        return this.f3108d;
    }

    public Set b() {
        return this.f3109e;
    }

    public G3.v c() {
        return this.f3105a;
    }

    public Map d() {
        return this.f3106b;
    }

    public Map e() {
        return this.f3107c;
    }

    public String toString() {
        return "RemoteEvent{snapshotVersion=" + this.f3105a + ", targetChanges=" + this.f3106b + ", targetMismatches=" + this.f3107c + ", documentUpdates=" + this.f3108d + ", resolvedLimboDocuments=" + this.f3109e + '}';
    }
}
