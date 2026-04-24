package u4;

/* JADX INFO: loaded from: classes.dex */
public enum i0 {
    OK(0),
    CANCELLED(1),
    UNKNOWN(2),
    INVALID_ARGUMENT(3),
    DEADLINE_EXCEEDED(4),
    NOT_FOUND(5),
    ALREADY_EXISTS(6),
    PERMISSION_DENIED(7),
    RESOURCE_EXHAUSTED(8),
    FAILED_PRECONDITION(9),
    ABORTED(10),
    OUT_OF_RANGE(11),
    UNIMPLEMENTED(12),
    INTERNAL(13),
    UNAVAILABLE(14),
    DATA_LOSS(15),
    UNAUTHENTICATED(16);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f10432b;

    i0(int i) {
        this.f10431a = i;
        this.f10432b = Integer.toString(i).getBytes(U1.d.f3106a);
    }

    public final j0 a() {
        return (j0) j0.f10435d.get(this.f10431a);
    }
}
