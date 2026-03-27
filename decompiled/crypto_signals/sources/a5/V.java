package a5;

/* JADX INFO: loaded from: classes.dex */
public abstract class V extends AbstractC0317y {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f4100f = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f4101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4102d;
    public H4.f e;

    public final void j(boolean z6) {
        long j4 = this.f4101c - (z6 ? 4294967296L : 1L);
        this.f4101c = j4;
        if (j4 <= 0 && this.f4102d) {
            shutdown();
        }
    }

    public abstract Thread k();

    public final void l(boolean z6) {
        this.f4101c = (z6 ? 4294967296L : 1L) + this.f4101c;
        if (z6) {
            return;
        }
        this.f4102d = true;
    }

    public abstract long m();

    public final boolean n() {
        H4.f fVar = this.e;
        if (fVar == null) {
            return false;
        }
        J j4 = (J) (fVar.isEmpty() ? null : fVar.removeFirst());
        if (j4 == null) {
            return false;
        }
        j4.run();
        return true;
    }

    public void o(long j4, S s6) {
        D.f4083n.t(j4, s6);
    }

    public abstract void shutdown();
}
