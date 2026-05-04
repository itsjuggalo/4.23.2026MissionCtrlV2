package rb;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import rb.l;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o f19654b = new o(new l.a(), l.b.f19636a);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentMap f19655a = new ConcurrentHashMap();

    public o(n... nVarArr) {
        for (n nVar : nVarArr) {
            this.f19655a.put(nVar.a(), nVar);
        }
    }

    public static o a() {
        return f19654b;
    }

    public n b(String str) {
        return (n) this.f19655a.get(str);
    }
}
