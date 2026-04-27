package M1;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.api.internal.InterfaceC1182t;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import u0.AbstractC2742a;

/* JADX INFO: loaded from: classes.dex */
public final class g extends AbstractC2742a implements InterfaceC1182t {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Semaphore f3815o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Set f3816p;

    public g(Context context, Set set) {
        super(context);
        this.f3815o = new Semaphore(0);
        this.f3816p = set;
    }

    @Override // u0.AbstractC2742a
    public final /* bridge */ /* synthetic */ Object C() {
        Iterator it = this.f3816p.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            if (((com.google.android.gms.common.api.f) it.next()).g(this)) {
                i7++;
            }
        }
        try {
            this.f3815o.tryAcquire(i7, 5L, TimeUnit.SECONDS);
            return null;
        } catch (InterruptedException e7) {
            Log.i("GACSignInLoader", "Unexpected InterruptedException", e7);
            Thread.currentThread().interrupt();
            return null;
        }
    }

    @Override // u0.AbstractC2743b
    public final void p() {
        this.f3815o.drainPermits();
        h();
    }
}
