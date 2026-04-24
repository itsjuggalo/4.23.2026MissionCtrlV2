package s3;

/* JADX INFO: renamed from: s3.i0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC1027i0 implements com.google.protobuf.J {
    OPERATOR_UNSPECIFIED(0),
    LESS_THAN(1),
    LESS_THAN_OR_EQUAL(2),
    GREATER_THAN(3),
    GREATER_THAN_OR_EQUAL(4),
    EQUAL(5),
    NOT_EQUAL(6),
    ARRAY_CONTAINS(7),
    IN(8),
    ARRAY_CONTAINS_ANY(9),
    NOT_IN(10),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9612a;

    EnumC1027i0(int i) {
        this.f9612a = i;
    }

    @Override // com.google.protobuf.J
    public final int a() {
        if (this != UNRECOGNIZED) {
            return this.f9612a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
