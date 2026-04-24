package C1;

import android.util.SparseArray;
import java.util.HashMap;
import o1.EnumC2294f;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SparseArray f903a = new SparseArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static HashMap f904b;

    static {
        HashMap map = new HashMap();
        f904b = map;
        map.put(EnumC2294f.DEFAULT, 0);
        f904b.put(EnumC2294f.VERY_LOW, 1);
        f904b.put(EnumC2294f.HIGHEST, 2);
        for (EnumC2294f enumC2294f : f904b.keySet()) {
            f903a.append(((Integer) f904b.get(enumC2294f)).intValue(), enumC2294f);
        }
    }

    public static int a(EnumC2294f enumC2294f) {
        Integer num = (Integer) f904b.get(enumC2294f);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + enumC2294f);
    }

    public static EnumC2294f b(int i7) {
        EnumC2294f enumC2294f = (EnumC2294f) f903a.get(i7);
        if (enumC2294f != null) {
            return enumC2294f;
        }
        throw new IllegalArgumentException("Unknown Priority for value " + i7);
    }
}
