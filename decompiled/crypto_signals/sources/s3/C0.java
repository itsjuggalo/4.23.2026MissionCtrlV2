package s3;

/* JADX INFO: loaded from: classes.dex */
public enum C0 implements com.google.protobuf.J {
    NO_CHANGE(0),
    ADD(1),
    REMOVE(2),
    CURRENT(3),
    RESET(4),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9576a;

    C0(int i) {
        this.f9576a = i;
    }

    @Override // com.google.protobuf.J
    public final int a() {
        if (this != UNRECOGNIZED) {
            return this.f9576a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
