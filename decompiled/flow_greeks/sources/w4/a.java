package w4;

import android.util.SparseArray;
import i4.f;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SparseArray f23670a = new SparseArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static HashMap f23671b;

    static {
        HashMap map = new HashMap();
        f23671b = map;
        map.put(f.DEFAULT, 0);
        f23671b.put(f.VERY_LOW, 1);
        f23671b.put(f.HIGHEST, 2);
        for (f fVar : f23671b.keySet()) {
            f23670a.append(((Integer) f23671b.get(fVar)).intValue(), fVar);
        }
    }

    public static int a(f fVar) {
        Integer num = (Integer) f23671b.get(fVar);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + fVar);
    }

    public static f b(int i10) {
        f fVar = (f) f23670a.get(i10);
        if (fVar != null) {
            return fVar;
        }
        throw new IllegalArgumentException("Unknown Priority for value " + i10);
    }
}
