package q;

import java.util.HashMap;
import java.util.Map;
import q.b;

/* JADX INFO: renamed from: q.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1717a extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap f14150e = new HashMap();

    public boolean contains(Object obj) {
        return this.f14150e.containsKey(obj);
    }

    @Override // q.b
    public b.c f(Object obj) {
        return (b.c) this.f14150e.get(obj);
    }

    @Override // q.b
    public Object m(Object obj, Object obj2) {
        b.c cVarF = f(obj);
        if (cVarF != null) {
            return cVarF.f14156b;
        }
        this.f14150e.put(obj, l(obj, obj2));
        return null;
    }

    @Override // q.b
    public Object n(Object obj) {
        Object objN = super.n(obj);
        this.f14150e.remove(obj);
        return objN;
    }

    public Map.Entry o(Object obj) {
        if (contains(obj)) {
            return ((b.c) this.f14150e.get(obj)).f14158d;
        }
        return null;
    }
}
