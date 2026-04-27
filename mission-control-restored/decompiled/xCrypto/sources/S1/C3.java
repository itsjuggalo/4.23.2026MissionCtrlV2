package S1;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class C3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n7 f3891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ S3 f3892b;

    public C3(S3 s32, n7 n7Var) {
        this.f3891a = n7Var;
        Objects.requireNonNull(s32);
        this.f3892b = s32;
    }

    @Override // java.lang.Runnable
    public final void run() {
        S3 s32 = this.f3892b;
        s32.e0().D();
        s32.e0().a0(this.f3891a);
    }
}
