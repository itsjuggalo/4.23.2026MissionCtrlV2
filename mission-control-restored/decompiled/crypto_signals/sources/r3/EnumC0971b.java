package r3;

import com.google.protobuf.J;

/* JADX INFO: renamed from: r3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC0971b implements J {
    FIRST(0),
    LAST(1),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9468a;

    EnumC0971b(int i) {
        this.f9468a = i;
    }

    @Override // com.google.protobuf.J
    public final int a() {
        if (this != UNRECOGNIZED) {
            return this.f9468a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
