package r;

import java.util.HashMap;
import java.util.Map;
import r.C2571b;

/* JADX INFO: renamed from: r.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2570a extends C2571b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap f22339e = new HashMap();

    @Override // r.C2571b
    public C2571b.c b(Object obj) {
        return (C2571b.c) this.f22339e.get(obj);
    }

    public boolean contains(Object obj) {
        return this.f22339e.containsKey(obj);
    }

    @Override // r.C2571b
    public Object j(Object obj, Object obj2) {
        C2571b.c cVarB = b(obj);
        if (cVarB != null) {
            return cVarB.f22345b;
        }
        this.f22339e.put(obj, h(obj, obj2));
        return null;
    }

    @Override // r.C2571b
    public Object k(Object obj) {
        Object objK = super.k(obj);
        this.f22339e.remove(obj);
        return objK;
    }

    public Map.Entry l(Object obj) {
        if (contains(obj)) {
            return ((C2571b.c) this.f22339e.get(obj)).f22347d;
        }
        return null;
    }
}
