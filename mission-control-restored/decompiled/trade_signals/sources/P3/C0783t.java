package P3;

import java.util.concurrent.Executor;

/* JADX INFO: renamed from: P3.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0783t implements E3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0781q f6425a;

    public C0783t(C0781q c0781q) {
        this.f6425a = c0781q;
    }

    public static C0783t a(C0781q c0781q) {
        return new C0783t(c0781q);
    }

    public static Executor c(C0781q c0781q) {
        return (Executor) E3.d.e(c0781q.c());
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Executor get() {
        return c(this.f6425a);
    }
}
