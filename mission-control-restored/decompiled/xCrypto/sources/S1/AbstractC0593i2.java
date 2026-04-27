package S1;

/* JADX INFO: renamed from: S1.i2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0593i2 extends H1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f4680b;

    public AbstractC0593i2(C0658q3 c0658q3) {
        super(c0658q3);
        this.f4245a.k();
    }

    public final boolean i() {
        return this.f4680b;
    }

    public final void j() {
        if (!i()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void k() {
        if (this.f4680b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (m()) {
            return;
        }
        this.f4245a.l();
        this.f4680b = true;
    }

    public final void l() {
        if (this.f4680b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        n();
        this.f4245a.l();
        this.f4680b = true;
    }

    public abstract boolean m();

    public void n() {
    }
}
