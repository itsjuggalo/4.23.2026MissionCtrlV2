package Z3;

import x3.InterfaceC2825f;

/* JADX INFO: renamed from: Z3.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC0784d implements InterfaceC2825f {
    COLLECTION_UNKNOWN(0),
    COLLECTION_SDK_NOT_INSTALLED(1),
    COLLECTION_ENABLED(2),
    COLLECTION_DISABLED(3),
    COLLECTION_DISABLED_REMOTE(4),
    COLLECTION_SAMPLED(5);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5931a;

    EnumC0784d(int i7) {
        this.f5931a = i7;
    }

    @Override // x3.InterfaceC2825f
    public int d() {
        return this.f5931a;
    }
}
