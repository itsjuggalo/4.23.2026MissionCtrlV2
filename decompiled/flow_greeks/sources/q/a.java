package q;

import java.util.HashMap;
import java.util.Map;
import q.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap f18687e = new HashMap();

    @Override // q.b
    public b.c c(Object obj) {
        return (b.c) this.f18687e.get(obj);
    }

    public boolean contains(Object obj) {
        return this.f18687e.containsKey(obj);
    }

    @Override // q.b
    public Object g(Object obj, Object obj2) {
        b.c cVarC = c(obj);
        if (cVarC != null) {
            return cVarC.f18693b;
        }
        this.f18687e.put(obj, f(obj, obj2));
        return null;
    }

    @Override // q.b
    public Object p(Object obj) {
        Object objP = super.p(obj);
        this.f18687e.remove(obj);
        return objP;
    }

    public Map.Entry q(Object obj) {
        if (contains(obj)) {
            return ((b.c) this.f18687e.get(obj)).f18695d;
        }
        return null;
    }
}
