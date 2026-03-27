package l1;

import X0.f;
import android.util.SparseArray;
import java.util.HashMap;

/* JADX INFO: renamed from: l1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1589a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SparseArray f13442a = new SparseArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static HashMap f13443b;

    static {
        HashMap map = new HashMap();
        f13443b = map;
        map.put(f.DEFAULT, 0);
        f13443b.put(f.VERY_LOW, 1);
        f13443b.put(f.HIGHEST, 2);
        for (f fVar : f13443b.keySet()) {
            f13442a.append(((Integer) f13443b.get(fVar)).intValue(), fVar);
        }
    }

    public static int a(f fVar) {
        Integer num = (Integer) f13443b.get(fVar);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + fVar);
    }

    public static f b(int i4) {
        f fVar = (f) f13442a.get(i4);
        if (fVar != null) {
            return fVar;
        }
        throw new IllegalArgumentException("Unknown Priority for value " + i4);
    }
}
