package v1;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.api.internal.InterfaceC0916u;
import e0.AbstractC1225a;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: v1.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1889g extends AbstractC1225a implements InterfaceC0916u {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Semaphore f15299o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Set f15300p;

    public C1889g(Context context, Set set) {
        super(context);
        this.f15299o = new Semaphore(0);
        this.f15300p = set;
    }

    @Override // e0.AbstractC1225a
    public final /* bridge */ /* synthetic */ Object C() {
        Iterator it = this.f15300p.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            if (((com.google.android.gms.common.api.f) it.next()).g(this)) {
                i4++;
            }
        }
        try {
            this.f15299o.tryAcquire(i4, 5L, TimeUnit.SECONDS);
            return null;
        } catch (InterruptedException e4) {
            Log.i("GACSignInLoader", "Unexpected InterruptedException", e4);
            Thread.currentThread().interrupt();
            return null;
        }
    }

    @Override // e0.AbstractC1226b
    public final void p() {
        this.f15299o.drainPermits();
        h();
    }
}
