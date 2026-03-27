package i6;

import b6.P;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f16479c;

    public k(Runnable runnable, long j7, i iVar) {
        super(j7, iVar);
        this.f16479c = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f16479c.run();
        } finally {
            this.f16477b.a();
        }
    }

    public String toString() {
        return "Task[" + P.a(this.f16479c) + '@' + P.b(this.f16479c) + ", " + this.f16476a + ", " + this.f16477b + ']';
    }
}
