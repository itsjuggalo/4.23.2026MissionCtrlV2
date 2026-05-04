package g5;

import android.content.Context;
import android.util.Log;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends a2.a implements com.google.android.gms.common.api.internal.r {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Semaphore f10061o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Set f10062p;

    public g(Context context, Set set) {
        super(context);
        this.f10061o = new Semaphore(0);
        this.f10062p = set;
    }

    @Override // a2.a
    public final /* bridge */ /* synthetic */ Object C() {
        Iterator it = this.f10062p.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (((com.google.android.gms.common.api.g) it.next()).g(this)) {
                i10++;
            }
        }
        try {
            this.f10061o.tryAcquire(i10, 5L, TimeUnit.SECONDS);
            return null;
        } catch (InterruptedException e10) {
            Log.i("GACSignInLoader", "Unexpected InterruptedException", e10);
            Thread.currentThread().interrupt();
            return null;
        }
    }

    @Override // a2.b
    public final void p() {
        this.f10061o.drainPermits();
        h();
    }
}
