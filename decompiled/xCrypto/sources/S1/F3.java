package S1;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class F3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ J f3948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n7 f3949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ S3 f3950c;

    public F3(S3 s32, J j4, n7 n7Var) {
        this.f3948a = j4;
        this.f3949b = n7Var;
        Objects.requireNonNull(s32);
        this.f3950c = s32;
    }

    @Override // java.lang.Runnable
    public final void run() {
        J j4 = this.f3948a;
        n7 n7Var = this.f3949b;
        S3 s32 = this.f3950c;
        s32.i0(s32.j0(j4, n7Var), n7Var);
    }
}
