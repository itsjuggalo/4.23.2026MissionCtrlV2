package q3;

import com.google.protobuf.J;

/* JADX INFO: renamed from: q3.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC0940d implements J {
    ORDER_UNSPECIFIED(0),
    ASCENDING(1),
    DESCENDING(2),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9275a;

    EnumC0940d(int i) {
        this.f9275a = i;
    }

    @Override // com.google.protobuf.J
    public final int a() {
        if (this != UNRECOGNIZED) {
            return this.f9275a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
