package l2;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class I implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractC2328l f20555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ J f20556b;

    public I(J j8, AbstractC2328l abstractC2328l) {
        this.f20556b = j8;
        this.f20555a = abstractC2328l;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            AbstractC2328l abstractC2328lA = this.f20556b.f20558b.a(this.f20555a.k());
            if (abstractC2328lA == null) {
                this.f20556b.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            J j8 = this.f20556b;
            Executor executor = AbstractC2330n.f20576b;
            abstractC2328lA.f(executor, j8);
            abstractC2328lA.d(executor, this.f20556b);
            abstractC2328lA.a(executor, this.f20556b);
        } catch (CancellationException unused) {
            this.f20556b.a();
        } catch (C2326j e8) {
            if (e8.getCause() instanceof Exception) {
                this.f20556b.onFailure((Exception) e8.getCause());
            } else {
                this.f20556b.onFailure(e8);
            }
        } catch (Exception e9) {
            this.f20556b.onFailure(e9);
        }
    }
}
