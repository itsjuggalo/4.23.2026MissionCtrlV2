package K2;

import android.util.SparseArray;

/* JADX INFO: loaded from: classes.dex */
public enum J {
    OK(0),
    CANCELLED(1),
    UNKNOWN(2),
    INVALID_ARGUMENT(3),
    DEADLINE_EXCEEDED(4),
    /* JADX INFO: Fake field, exist only in values array */
    NOT_FOUND(5),
    ALREADY_EXISTS(6),
    /* JADX INFO: Fake field, exist only in values array */
    PERMISSION_DENIED(7),
    /* JADX INFO: Fake field, exist only in values array */
    RESOURCE_EXHAUSTED(8),
    FAILED_PRECONDITION(9),
    ABORTED(10),
    /* JADX INFO: Fake field, exist only in values array */
    OUT_OF_RANGE(11),
    /* JADX INFO: Fake field, exist only in values array */
    UNIMPLEMENTED(12),
    INTERNAL(13),
    UNAVAILABLE(14),
    /* JADX INFO: Fake field, exist only in values array */
    DATA_LOSS(15),
    UNAUTHENTICATED(16);


    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final SparseArray f849q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f851a;

    static {
        SparseArray sparseArray = new SparseArray();
        for (J j4 : values()) {
            J j6 = (J) sparseArray.get(j4.f851a);
            if (j6 != null) {
                throw new IllegalStateException("Code value duplication between " + j6 + "&" + j4.name());
            }
            sparseArray.put(j4.f851a, j4);
        }
        f849q = sparseArray;
    }

    J(int i) {
        this.f851a = i;
    }
}
