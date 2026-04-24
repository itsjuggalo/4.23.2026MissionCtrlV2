package P3;

import java.util.concurrent.Executor;

/* JADX INFO: renamed from: P3.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0781q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f6420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f6421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f6422c;

    public C0781q(Executor executor, Executor executor2, Executor executor3) {
        this.f6422c = executor;
        this.f6420a = executor2;
        this.f6421b = executor3;
    }

    public Executor a() {
        return this.f6420a;
    }

    public Executor b() {
        return this.f6421b;
    }

    public Executor c() {
        return this.f6422c;
    }
}
