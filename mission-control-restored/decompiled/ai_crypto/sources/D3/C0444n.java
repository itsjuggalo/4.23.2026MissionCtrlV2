package D3;

import D3.C0443m;
import K3.AbstractC0612b;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/* JADX INFO: renamed from: D3.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0444n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TreeMap f1371a = new TreeMap();

    public void a(C0443m c0443m) {
        G3.k key = c0443m.b().getKey();
        C0443m c0443m2 = (C0443m) this.f1371a.get(key);
        if (c0443m2 == null) {
            this.f1371a.put(key, c0443m);
            return;
        }
        C0443m.a aVarC = c0443m2.c();
        C0443m.a aVarC2 = c0443m.c();
        C0443m.a aVar = C0443m.a.ADDED;
        if (aVarC2 != aVar && aVarC == C0443m.a.METADATA) {
            this.f1371a.put(key, c0443m);
            return;
        }
        if (aVarC2 == C0443m.a.METADATA && aVarC != C0443m.a.REMOVED) {
            this.f1371a.put(key, C0443m.a(aVarC, c0443m.b()));
            return;
        }
        C0443m.a aVar2 = C0443m.a.MODIFIED;
        if (aVarC2 == aVar2 && aVarC == aVar2) {
            this.f1371a.put(key, C0443m.a(aVar2, c0443m.b()));
            return;
        }
        if (aVarC2 == aVar2 && aVarC == aVar) {
            this.f1371a.put(key, C0443m.a(aVar, c0443m.b()));
            return;
        }
        C0443m.a aVar3 = C0443m.a.REMOVED;
        if (aVarC2 == aVar3 && aVarC == aVar) {
            this.f1371a.remove(key);
            return;
        }
        if (aVarC2 == aVar3 && aVarC == aVar2) {
            this.f1371a.put(key, C0443m.a(aVar3, c0443m2.b()));
        } else {
            if (aVarC2 != aVar || aVarC != aVar3) {
                throw AbstractC0612b.a("Unsupported combination of changes %s after %s", aVarC2, aVarC);
            }
            this.f1371a.put(key, C0443m.a(aVar2, c0443m.b()));
        }
    }

    public List b() {
        return new ArrayList(this.f1371a.values());
    }
}
