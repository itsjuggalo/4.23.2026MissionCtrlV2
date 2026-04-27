package q;

import java.util.HashMap;
import java.util.Map;
import q.C2616b;

/* JADX INFO: renamed from: q.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2615a extends C2616b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap f22492e = new HashMap();

    @Override // q.C2616b
    public Object C(Object obj) {
        Object objC = super.C(obj);
        this.f22492e.remove(obj);
        return objC;
    }

    public Map.Entry F(Object obj) {
        if (contains(obj)) {
            return ((C2616b.c) this.f22492e.get(obj)).f22500d;
        }
        return null;
    }

    public boolean contains(Object obj) {
        return this.f22492e.containsKey(obj);
    }

    @Override // q.C2616b
    public C2616b.c d(Object obj) {
        return (C2616b.c) this.f22492e.get(obj);
    }

    @Override // q.C2616b
    public Object n(Object obj, Object obj2) {
        C2616b.c cVarD = d(obj);
        if (cVarD != null) {
            return cVarD.f22498b;
        }
        this.f22492e.put(obj, h(obj, obj2));
        return null;
    }
}
