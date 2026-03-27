package l2;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractC2328l f20594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z f20595b;

    public y(z zVar, AbstractC2328l abstractC2328l) {
        this.f20595b = zVar;
        this.f20594a = abstractC2328l;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            AbstractC2328l abstractC2328l = (AbstractC2328l) this.f20595b.f20597b.a(this.f20594a);
            if (abstractC2328l == null) {
                this.f20595b.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            z zVar = this.f20595b;
            Executor executor = AbstractC2330n.f20576b;
            abstractC2328l.f(executor, zVar);
            abstractC2328l.d(executor, this.f20595b);
            abstractC2328l.a(executor, this.f20595b);
        } catch (C2326j e8) {
            if (e8.getCause() instanceof Exception) {
                this.f20595b.f20598c.r((Exception) e8.getCause());
            } else {
                this.f20595b.f20598c.r(e8);
            }
        } catch (Exception e9) {
            this.f20595b.f20598c.r(e9);
        }
    }
}
