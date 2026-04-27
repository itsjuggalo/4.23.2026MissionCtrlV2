package N1;

/* JADX INFO: loaded from: classes.dex */
public abstract class E0 extends D0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1239b;

    public E0(C0138v0 c0138v0) {
        super(c0138v0);
        ((C0138v0) this.f1130a).f1806E++;
    }

    public abstract boolean q();

    public final void r() {
        if (!this.f1239b) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void s() {
        if (this.f1239b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (q()) {
            return;
        }
        ((C0138v0) this.f1130a).f1808G.incrementAndGet();
        this.f1239b = true;
    }
}
