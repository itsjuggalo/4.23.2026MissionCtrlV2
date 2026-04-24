package R1;

import Q1.C0792d;

/* JADX INFO: loaded from: classes.dex */
public final class h extends UnsupportedOperationException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0792d f7112a;

    public h(C0792d c0792d) {
        this.f7112a = c0792d;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "Missing ".concat(String.valueOf(this.f7112a));
    }
}
