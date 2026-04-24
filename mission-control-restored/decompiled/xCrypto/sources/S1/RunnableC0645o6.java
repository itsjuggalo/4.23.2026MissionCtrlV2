package S1;

import java.util.Objects;

/* JADX INFO: renamed from: S1.o6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0645o6 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f4823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0708w6 f4824b;

    public RunnableC0645o6(C0708w6 c0708w6, long j4) {
        this.f4823a = j4;
        Objects.requireNonNull(c0708w6);
        this.f4824b = c0708w6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4824b.s(this.f4823a);
    }
}
