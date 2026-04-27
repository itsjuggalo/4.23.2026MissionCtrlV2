package A3;

import t3.P;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f94c;

    public k(Runnable runnable, long j4, i iVar) {
        super(j4, iVar);
        this.f94c = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f94c.run();
        } finally {
            this.f92b.a();
        }
    }

    public String toString() {
        return "Task[" + P.a(this.f94c) + '@' + P.b(this.f94c) + ", " + this.f91a + ", " + this.f92b + ']';
    }
}
