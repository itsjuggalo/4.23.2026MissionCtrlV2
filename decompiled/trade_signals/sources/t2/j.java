package t2;

import l2.C2329m;

/* JADX INFO: loaded from: classes.dex */
public abstract class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2329m f23295a;

    public j() {
        this.f23295a = null;
    }

    public abstract void a();

    public final C2329m b() {
        return this.f23295a;
    }

    public final void c(Exception exc) {
        C2329m c2329m = this.f23295a;
        if (c2329m != null) {
            c2329m.d(exc);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            a();
        } catch (Exception e8) {
            c(e8);
        }
    }

    public j(C2329m c2329m) {
        this.f23295a = c2329m;
    }
}
