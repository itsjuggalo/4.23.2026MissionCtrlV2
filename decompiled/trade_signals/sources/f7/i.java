package f7;

import Y6.P;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f17637c;

    public i(Runnable runnable, long j8, boolean z7) {
        super(j8, z7);
        this.f17637c = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f17637c.run();
    }

    public String toString() {
        return "Task[" + P.a(this.f17637c) + '@' + P.b(this.f17637c) + ", " + this.f17635a + ", " + j.c(this.f17636b) + ']';
    }
}
