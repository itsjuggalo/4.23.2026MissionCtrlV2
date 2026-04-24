package S1;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class I3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h7 f3998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n7 f3999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ S3 f4000c;

    public I3(S3 s32, h7 h7Var, n7 n7Var) {
        this.f3998a = h7Var;
        this.f3999b = n7Var;
        Objects.requireNonNull(s32);
        this.f4000c = s32;
    }

    @Override // java.lang.Runnable
    public final void run() {
        S3 s32 = this.f4000c;
        s32.e0().D();
        h7 h7Var = this.f3998a;
        if (h7Var.i() != null) {
            s32.e0().b0(h7Var, this.f3999b);
        } else {
            n7 n7Var = this.f3999b;
            s32.e0().c0(h7Var.f4661b, n7Var);
        }
    }
}
