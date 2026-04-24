package S1;

import java.util.Objects;

/* JADX INFO: renamed from: S1.s3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0673s3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n7 f4919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ S3 f4920b;

    public RunnableC0673s3(S3 s32, n7 n7Var) {
        this.f4919a = n7Var;
        Objects.requireNonNull(s32);
        this.f4920b = s32;
    }

    @Override // java.lang.Runnable
    public final void run() {
        S3 s32 = this.f4920b;
        s32.e0().D();
        s32.e0().g0(this.f4919a);
    }
}
