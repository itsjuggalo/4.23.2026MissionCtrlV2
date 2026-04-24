package S1;

/* JADX INFO: loaded from: classes.dex */
public abstract class U3 extends T3 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f4254b;

    public U3(C0658q3 c0658q3) {
        super(c0658q3);
        this.f4245a.k();
    }

    public abstract boolean i();

    public final boolean k() {
        return this.f4254b;
    }

    public final void l() {
        if (!k()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void m() {
        if (this.f4254b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (i()) {
            return;
        }
        this.f4245a.l();
        this.f4254b = true;
    }

    public final void n() {
        if (this.f4254b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        j();
        this.f4245a.l();
        this.f4254b = true;
    }

    public void j() {
    }
}
