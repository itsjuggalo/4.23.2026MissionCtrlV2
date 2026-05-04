package com.amazon.a.a.c;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class g implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.amazon.a.a.o.c f4248a = new com.amazon.a.a.o.c("EventManagerImpl");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<b, e<?>> f4249b = new HashMap();

    @Override // com.amazon.a.a.c.f
    public <T extends a> void a(c<T> cVar) {
        com.amazon.a.a.o.a.a.a((Object) cVar, "listener");
        com.amazon.a.a.o.a.a.a();
        b bVarA = cVar.a();
        f4248a.a("Registering listener for event: " + bVarA + ", " + cVar);
        e<?> eVar = this.f4249b.get(bVarA);
        if (eVar == null) {
            eVar = new e<>();
            this.f4249b.put(bVarA, eVar);
        }
        eVar.a(cVar);
    }

    @Override // com.amazon.a.a.c.f
    public void a(a aVar) {
        b bVarA = aVar.a();
        if (com.amazon.a.a.o.c.f4603a) {
            f4248a.a("Posting event: " + bVarA);
        }
        if (!this.f4249b.containsKey(bVarA)) {
            if (com.amazon.a.a.o.c.f4603a) {
                f4248a.a("No registered listeners, returning");
                return;
            }
            return;
        }
        this.f4249b.get(bVarA).a(aVar);
    }
}
