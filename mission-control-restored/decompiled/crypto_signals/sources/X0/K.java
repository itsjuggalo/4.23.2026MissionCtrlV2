package X0;

import android.util.SparseArray;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class K {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final K f3430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ K[] f3431b;

    static {
        K k6 = new K("DEFAULT", 0);
        f3430a = k6;
        K k7 = new K("UNMETERED_ONLY", 1);
        K k8 = new K("UNMETERED_OR_DAILY", 2);
        K k9 = new K("FAST_IF_RADIO_AWAKE", 3);
        K k10 = new K("NEVER", 4);
        K k11 = new K("UNRECOGNIZED", 5);
        f3431b = new K[]{k6, k7, k8, k9, k10, k11};
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, k6);
        sparseArray.put(1, k7);
        sparseArray.put(2, k8);
        sparseArray.put(3, k9);
        sparseArray.put(4, k10);
        sparseArray.put(-1, k11);
    }

    public static K valueOf(String str) {
        return (K) Enum.valueOf(K.class, str);
    }

    public static K[] values() {
        return (K[]) f3431b.clone();
    }
}
