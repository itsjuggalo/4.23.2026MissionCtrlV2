package S1;

import java.util.Objects;

/* JADX INFO: renamed from: S1.p4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0651p4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f4828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0540b5 f4829b;

    public RunnableC0651p4(C0540b5 c0540b5, long j4) {
        this.f4828a = j4;
        Objects.requireNonNull(c0540b5);
        this.f4829b = c0540b5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0658q3 c0658q3 = this.f4829b.f4245a;
        N2 n22 = c0658q3.x().f4190l;
        long j4 = this.f4828a;
        n22.b(j4);
        c0658q3.a().v().b("Session timeout duration set", Long.valueOf(j4));
    }
}
