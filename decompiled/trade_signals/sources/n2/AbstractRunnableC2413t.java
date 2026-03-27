package n2;

import l2.C2329m;

/* JADX INFO: renamed from: n2.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractRunnableC2413t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2329m f21595a;

    public AbstractRunnableC2413t() {
        this.f21595a = null;
    }

    public abstract void a();

    public final C2329m b() {
        return this.f21595a;
    }

    public final void c(Exception exc) {
        C2329m c2329m = this.f21595a;
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

    public AbstractRunnableC2413t(C2329m c2329m) {
        this.f21595a = c2329m;
    }
}
