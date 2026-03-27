package r1;

import java.util.concurrent.Executor;
import t1.AbstractC2653d;
import t1.InterfaceC2651b;

/* JADX INFO: loaded from: classes.dex */
public final class k implements InterfaceC2651b {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f22429a = new k();
    }

    public static k a() {
        return a.f22429a;
    }

    public static Executor b() {
        return (Executor) AbstractC2653d.d(j.a());
    }

    @Override // D5.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Executor get() {
        return b();
    }
}
