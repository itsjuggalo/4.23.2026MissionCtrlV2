package a5;

/* JADX INFO: loaded from: classes.dex */
public final class Q extends S {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z0 f4093c;

    public Q(long j4, z0 z0Var) {
        super(j4);
        this.f4093c = z0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4093c.run();
    }

    @Override // a5.S
    public final String toString() {
        return super.toString() + this.f4093c;
    }
}
