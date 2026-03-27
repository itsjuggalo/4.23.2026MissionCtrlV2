package W0;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f9215a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f9216b = new HashMap();

    public l a(U0.f fVar, boolean z7) {
        return (l) b(z7).get(fVar);
    }

    public final Map b(boolean z7) {
        return z7 ? this.f9216b : this.f9215a;
    }

    public void c(U0.f fVar, l lVar) {
        b(lVar.p()).put(fVar, lVar);
    }

    public void d(U0.f fVar, l lVar) {
        Map mapB = b(lVar.p());
        if (lVar.equals(mapB.get(fVar))) {
            mapB.remove(fVar);
        }
    }
}
