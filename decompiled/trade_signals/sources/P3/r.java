package P3;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class r implements E3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0781q f6423a;

    public r(C0781q c0781q) {
        this.f6423a = c0781q;
    }

    public static r a(C0781q c0781q) {
        return new r(c0781q);
    }

    public static Executor c(C0781q c0781q) {
        return (Executor) E3.d.e(c0781q.a());
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Executor get() {
        return c(this.f6423a);
    }
}
