package S1;

import java.util.Objects;

/* JADX INFO: renamed from: S1.v3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0697v3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0590i f4997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n7 f4998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ S3 f4999c;

    public RunnableC0697v3(S3 s32, C0590i c0590i, n7 n7Var) {
        this.f4997a = c0590i;
        this.f4998b = n7Var;
        Objects.requireNonNull(s32);
        this.f4999c = s32;
    }

    @Override // java.lang.Runnable
    public final void run() {
        S3 s32 = this.f4999c;
        s32.e0().D();
        C0590i c0590i = this.f4997a;
        if (c0590i.f4669c.i() == null) {
            s32.e0().l0(c0590i, this.f4998b);
        } else {
            s32.e0().j0(c0590i, this.f4998b);
        }
    }
}
