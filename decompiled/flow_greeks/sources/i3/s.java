package i3;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f11754a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f11755b = new HashMap();

    public l a(g3.f fVar, boolean z10) {
        return (l) b(z10).get(fVar);
    }

    public final Map b(boolean z10) {
        return z10 ? this.f11755b : this.f11754a;
    }

    public void c(g3.f fVar, l lVar) {
        b(lVar.p()).put(fVar, lVar);
    }

    public void d(g3.f fVar, l lVar) {
        Map mapB = b(lVar.p());
        if (lVar.equals(mapB.get(fVar))) {
            mapB.remove(fVar);
        }
    }
}
