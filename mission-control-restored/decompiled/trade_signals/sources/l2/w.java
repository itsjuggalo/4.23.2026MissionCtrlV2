package l2;

/* JADX INFO: loaded from: classes.dex */
public final class w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractC2328l f20589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x f20590b;

    public w(x xVar, AbstractC2328l abstractC2328l) {
        this.f20590b = xVar;
        this.f20589a = abstractC2328l;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f20589a.m()) {
            this.f20590b.f20593c.t();
            return;
        }
        try {
            this.f20590b.f20593c.s(this.f20590b.f20592b.a(this.f20589a));
        } catch (C2326j e8) {
            if (e8.getCause() instanceof Exception) {
                this.f20590b.f20593c.r((Exception) e8.getCause());
            } else {
                this.f20590b.f20593c.r(e8);
            }
        } catch (Exception e9) {
            this.f20590b.f20593c.r(e9);
        }
    }
}
