package a1;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class k implements c1.b {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f6094a = new k();
    }

    public static k a() {
        return a.f6094a;
    }

    public static Executor b() {
        return (Executor) c1.d.d(j.a());
    }

    @Override // V2.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Executor get() {
        return b();
    }
}
