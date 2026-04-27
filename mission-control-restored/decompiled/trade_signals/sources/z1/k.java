package z1;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class k implements B1.b {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f24710a = new k();
    }

    public static k a() {
        return a.f24710a;
    }

    public static Executor b() {
        return (Executor) B1.d.d(j.a());
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Executor get() {
        return b();
    }
}
