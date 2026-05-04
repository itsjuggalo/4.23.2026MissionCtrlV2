package p8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import m8.m;
import o8.e;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f18419a = new HashMap();

    public List a() {
        return new ArrayList(this.f18419a.values());
    }

    public void b(o8.c cVar) {
        e.a aVarJ = cVar.j();
        r8.b bVarI = cVar.i();
        e.a aVar = e.a.CHILD_ADDED;
        m.g(aVarJ == aVar || aVarJ == e.a.CHILD_CHANGED || aVarJ == e.a.CHILD_REMOVED, "Only child changes supported for tracking");
        m.f(true ^ cVar.i().s());
        if (!this.f18419a.containsKey(bVarI)) {
            this.f18419a.put(cVar.i(), cVar);
            return;
        }
        o8.c cVar2 = (o8.c) this.f18419a.get(bVarI);
        e.a aVarJ2 = cVar2.j();
        if (aVarJ == aVar && aVarJ2 == e.a.CHILD_REMOVED) {
            this.f18419a.put(cVar.i(), o8.c.d(bVarI, cVar.k(), cVar2.k()));
            return;
        }
        e.a aVar2 = e.a.CHILD_REMOVED;
        if (aVarJ == aVar2 && aVarJ2 == aVar) {
            this.f18419a.remove(bVarI);
            return;
        }
        if (aVarJ == aVar2 && aVarJ2 == e.a.CHILD_CHANGED) {
            this.f18419a.put(bVarI, o8.c.g(bVarI, cVar2.l()));
            return;
        }
        e.a aVar3 = e.a.CHILD_CHANGED;
        if (aVarJ == aVar3 && aVarJ2 == aVar) {
            this.f18419a.put(bVarI, o8.c.b(bVarI, cVar.k()));
            return;
        }
        if (aVarJ == aVar3 && aVarJ2 == aVar3) {
            this.f18419a.put(bVarI, o8.c.d(bVarI, cVar.k(), cVar2.l()));
            return;
        }
        throw new IllegalStateException("Illegal combination of changes: " + cVar + " occurred after " + cVar2);
    }
}
