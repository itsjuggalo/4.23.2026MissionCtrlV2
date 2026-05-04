package ug;

import ng.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f23027c;

    public i(Runnable runnable, long j10, boolean z10) {
        super(j10, z10);
        this.f23027c = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f23027c.run();
    }

    public String toString() {
        return "Task[" + r0.a(this.f23027c) + '@' + r0.b(this.f23027c) + ", " + this.f23025a + ", " + j.c(this.f23026b) + ']';
    }
}
