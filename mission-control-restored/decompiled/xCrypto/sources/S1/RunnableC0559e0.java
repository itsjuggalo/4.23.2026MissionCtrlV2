package S1;

import java.util.Objects;

/* JADX INFO: renamed from: S1.e0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0559e0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f4468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ F0 f4469b;

    public RunnableC0559e0(F0 f02, long j4) {
        this.f4468a = j4;
        Objects.requireNonNull(f02);
        this.f4469b = f02;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4469b.n(this.f4468a);
    }
}
