package S1;

import java.util.Objects;

/* JADX INFO: renamed from: S1.w3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0705w3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0590i f5014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ S3 f5015b;

    public RunnableC0705w3(S3 s32, C0590i c0590i) {
        this.f5014a = c0590i;
        Objects.requireNonNull(s32);
        this.f5015b = s32;
    }

    @Override // java.lang.Runnable
    public final void run() {
        S3 s32 = this.f5015b;
        s32.e0().D();
        C0590i c0590i = this.f5014a;
        if (c0590i.f4669c.i() == null) {
            s32.e0().k0(c0590i);
        } else {
            s32.e0().i0(c0590i);
        }
    }
}
