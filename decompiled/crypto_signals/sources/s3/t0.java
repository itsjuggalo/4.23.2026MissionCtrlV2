package s3;

/* JADX INFO: loaded from: classes.dex */
public enum t0 implements com.google.protobuf.J {
    OPERATOR_UNSPECIFIED(0),
    IS_NAN(2),
    IS_NULL(3),
    IS_NOT_NAN(4),
    IS_NOT_NULL(5),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9624a;

    t0(int i) {
        this.f9624a = i;
    }

    @Override // com.google.protobuf.J
    public final int a() {
        if (this != UNRECOGNIZED) {
            return this.f9624a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
