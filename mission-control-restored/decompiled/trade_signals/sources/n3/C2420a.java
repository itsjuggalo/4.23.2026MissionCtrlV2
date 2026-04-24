package n3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import k3.AbstractC2279m;
import m3.C2376c;
import m3.e;
import p3.C2548b;

/* JADX INFO: renamed from: n3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2420a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f21605a = new HashMap();

    public List a() {
        return new ArrayList(this.f21605a.values());
    }

    public void b(C2376c c2376c) {
        Map map;
        e.a aVarJ = c2376c.j();
        C2548b c2548bI = c2376c.i();
        e.a aVar = e.a.CHILD_ADDED;
        AbstractC2279m.g(aVarJ == aVar || aVarJ == e.a.CHILD_CHANGED || aVarJ == e.a.CHILD_REMOVED, "Only child changes supported for tracking");
        AbstractC2279m.f(true ^ c2376c.i().t());
        if (this.f21605a.containsKey(c2548bI)) {
            C2376c c2376c2 = (C2376c) this.f21605a.get(c2548bI);
            e.a aVarJ2 = c2376c2.j();
            if (aVarJ == aVar && aVarJ2 == e.a.CHILD_REMOVED) {
                this.f21605a.put(c2376c.i(), C2376c.d(c2548bI, c2376c.k(), c2376c2.k()));
                return;
            }
            e.a aVar2 = e.a.CHILD_REMOVED;
            if (aVarJ == aVar2 && aVarJ2 == aVar) {
                this.f21605a.remove(c2548bI);
                return;
            }
            if (aVarJ == aVar2 && aVarJ2 == e.a.CHILD_CHANGED) {
                this.f21605a.put(c2548bI, C2376c.g(c2548bI, c2376c2.l()));
                return;
            }
            e.a aVar3 = e.a.CHILD_CHANGED;
            if (aVarJ == aVar3 && aVarJ2 == aVar) {
                map = this.f21605a;
                c2376c = C2376c.b(c2548bI, c2376c.k());
            } else {
                if (aVarJ != aVar3 || aVarJ2 != aVar3) {
                    throw new IllegalStateException("Illegal combination of changes: " + c2376c + " occurred after " + c2376c2);
                }
                map = this.f21605a;
                c2376c = C2376c.d(c2548bI, c2376c.k(), c2376c2.l());
            }
        } else {
            map = this.f21605a;
            c2548bI = c2376c.i();
        }
        map.put(c2548bI, c2376c);
    }
}
