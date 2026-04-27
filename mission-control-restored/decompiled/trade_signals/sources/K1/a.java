package K1;

import android.util.SparseArray;
import java.util.HashMap;
import w1.EnumC2903f;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SparseArray f4732a = new SparseArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static HashMap f4733b;

    static {
        HashMap map = new HashMap();
        f4733b = map;
        map.put(EnumC2903f.DEFAULT, 0);
        f4733b.put(EnumC2903f.VERY_LOW, 1);
        f4733b.put(EnumC2903f.HIGHEST, 2);
        for (EnumC2903f enumC2903f : f4733b.keySet()) {
            f4732a.append(((Integer) f4733b.get(enumC2903f)).intValue(), enumC2903f);
        }
    }

    public static int a(EnumC2903f enumC2903f) {
        Integer num = (Integer) f4733b.get(enumC2903f);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + enumC2903f);
    }

    public static EnumC2903f b(int i8) {
        EnumC2903f enumC2903f = (EnumC2903f) f4732a.get(i8);
        if (enumC2903f != null) {
            return enumC2903f;
        }
        throw new IllegalArgumentException("Unknown Priority for value " + i8);
    }
}
