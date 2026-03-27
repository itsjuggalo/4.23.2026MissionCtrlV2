package i1;

import V0.d;
import android.util.SparseArray;
import java.util.HashMap;

/* JADX INFO: renamed from: i1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0646a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SparseArray f6710a = new SparseArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap f6711b;

    static {
        HashMap map = new HashMap();
        f6711b = map;
        map.put(d.f3186a, 0);
        map.put(d.f3187b, 1);
        map.put(d.f3188c, 2);
        for (d dVar : map.keySet()) {
            f6710a.append(((Integer) f6711b.get(dVar)).intValue(), dVar);
        }
    }

    public static int a(d dVar) {
        Integer num = (Integer) f6711b.get(dVar);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + dVar);
    }

    public static d b(int i) {
        d dVar = (d) f6710a.get(i);
        if (dVar != null) {
            return dVar;
        }
        throw new IllegalArgumentException(a3.d.f(i, "Unknown Priority for value "));
    }
}
