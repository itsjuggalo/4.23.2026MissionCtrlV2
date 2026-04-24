package s3;

/* JADX INFO: renamed from: s3.e0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC1019e0 implements com.google.protobuf.J {
    OPERATOR_UNSPECIFIED(0),
    AND(1),
    OR(2),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9594a;

    EnumC1019e0(int i) {
        this.f9594a = i;
    }

    @Override // com.google.protobuf.J
    public final int a() {
        if (this != UNRECOGNIZED) {
            return this.f9594a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
