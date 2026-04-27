package X0;

import android.util.SparseArray;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final A f3424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ A[] f3425b;

    /* JADX INFO: Fake field, exist only in values array */
    A EF0;

    static {
        A a6 = new A("NOT_SET", 0);
        A a7 = new A("EVENT_OVERRIDE", 1);
        f3424a = a7;
        f3425b = new A[]{a6, a7};
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, a6);
        sparseArray.put(5, a7);
    }

    public static A valueOf(String str) {
        return (A) Enum.valueOf(A.class, str);
    }

    public static A[] values() {
        return (A[]) f3425b.clone();
    }
}
