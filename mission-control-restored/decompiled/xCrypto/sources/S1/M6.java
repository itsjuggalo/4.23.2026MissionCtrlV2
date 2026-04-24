package S1;

/* JADX INFO: loaded from: classes.dex */
public abstract class M6 extends F6 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4115c;

    public M6(b7 b7Var) {
        super(b7Var);
        this.f3955b.d0();
    }

    public final boolean i() {
        return this.f4115c;
    }

    public final void j() {
        if (!i()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void k() {
        if (this.f4115c) {
            throw new IllegalStateException("Can't initialize twice");
        }
        l();
        this.f3955b.e0();
        this.f4115c = true;
    }

    public abstract boolean l();
}
