package q1;

import android.util.SparseArray;

/* JADX INFO: loaded from: classes.dex */
public enum x {
    DEFAULT(0),
    UNMETERED_ONLY(1),
    UNMETERED_OR_DAILY(2),
    FAST_IF_RADIO_AWAKE(3),
    NEVER(4),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final SparseArray f22299h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f22301a;

    static {
        x xVar = DEFAULT;
        x xVar2 = UNMETERED_ONLY;
        x xVar3 = UNMETERED_OR_DAILY;
        x xVar4 = FAST_IF_RADIO_AWAKE;
        x xVar5 = NEVER;
        x xVar6 = UNRECOGNIZED;
        SparseArray sparseArray = new SparseArray();
        f22299h = sparseArray;
        sparseArray.put(0, xVar);
        sparseArray.put(1, xVar2);
        sparseArray.put(2, xVar3);
        sparseArray.put(3, xVar4);
        sparseArray.put(4, xVar5);
        sparseArray.put(-1, xVar6);
    }

    x(int i7) {
        this.f22301a = i7;
    }
}
