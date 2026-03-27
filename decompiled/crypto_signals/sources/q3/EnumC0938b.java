package q3;

import com.google.protobuf.J;

/* JADX INFO: renamed from: q3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC0938b implements J {
    /* JADX INFO: Fake field, exist only in values array */
    ARRAY_CONFIG_UNSPECIFIED(0),
    CONTAINS(1),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9270a;

    EnumC0938b(int i) {
        this.f9270a = i;
    }

    @Override // com.google.protobuf.J
    public final int a() {
        if (this != UNRECOGNIZED) {
            return this.f9270a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
