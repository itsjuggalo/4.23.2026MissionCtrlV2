package Z3;

import x3.InterfaceC2825f;

/* JADX INFO: loaded from: classes.dex */
public enum r implements InterfaceC2825f {
    LOG_ENVIRONMENT_UNKNOWN(0),
    LOG_ENVIRONMENT_AUTOPUSH(1),
    LOG_ENVIRONMENT_STAGING(2),
    LOG_ENVIRONMENT_PROD(3);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5967a;

    r(int i7) {
        this.f5967a = i7;
    }

    @Override // x3.InterfaceC2825f
    public int d() {
        return this.f5967a;
    }
}
