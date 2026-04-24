package s3;

/* JADX INFO: renamed from: s3.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC1051z implements com.google.protobuf.J {
    SERVER_VALUE_UNSPECIFIED(0),
    REQUEST_TIME(1),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9628a;

    EnumC1051z(int i) {
        this.f9628a = i;
    }

    @Override // com.google.protobuf.J
    public final int a() {
        if (this != UNRECOGNIZED) {
            return this.f9628a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
