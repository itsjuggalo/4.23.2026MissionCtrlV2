package S1;

import java.util.Objects;

/* JADX INFO: renamed from: S1.t3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0681t3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n7 f4942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ S3 f4943b;

    public RunnableC0681t3(S3 s32, n7 n7Var) {
        this.f4942a = n7Var;
        Objects.requireNonNull(s32);
        this.f4943b = s32;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        S3 s32 = this.f4943b;
        s32.e0().D();
        s32.e0().h0(this.f4942a);
    }
}
