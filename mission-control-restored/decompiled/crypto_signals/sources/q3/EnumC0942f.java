package q3;

import com.google.protobuf.J;

/* JADX INFO: renamed from: q3.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC0942f implements J {
    /* JADX INFO: Fake field, exist only in values array */
    QUERY_SCOPE_UNSPECIFIED(0),
    /* JADX INFO: Fake field, exist only in values array */
    COLLECTION(1),
    COLLECTION_GROUP(2),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9279a;

    EnumC0942f(int i) {
        this.f9279a = i;
    }

    @Override // com.google.protobuf.J
    public final int a() {
        if (this != UNRECOGNIZED) {
            return this.f9279a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
