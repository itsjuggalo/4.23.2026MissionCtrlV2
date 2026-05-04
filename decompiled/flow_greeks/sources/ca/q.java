package ca;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f3796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f3797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f3798c;

    public q(Executor executor, Executor executor2, Executor executor3) {
        this.f3798c = executor;
        this.f3796a = executor2;
        this.f3797b = executor3;
    }

    public Executor a() {
        return this.f3796a;
    }

    public Executor b() {
        return this.f3797b;
    }

    public Executor c() {
        return this.f3798c;
    }
}
