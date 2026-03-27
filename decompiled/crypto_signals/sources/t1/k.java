package t1;

import T2.C0242f;
import T2.C0243g;
import android.util.Log;
import e3.v;
import v4.C1260a;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f9896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f9897c;

    public /* synthetic */ k(l lVar, m mVar) {
        this.f9895a = 0;
        this.f9896b = lVar;
        this.f9897c = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9895a) {
            case 0:
                l lVar = (l) this.f9896b;
                int i = ((m) this.f9897c).f9903a;
                synchronized (lVar) {
                    m mVar = (m) lVar.e.get(i);
                    if (mVar != null) {
                        Log.w("MessengerIpcClient", "Timing out request: " + i);
                        lVar.e.remove(i);
                        mVar.b(new v("Timed out waiting for response", null));
                        lVar.c();
                    }
                    break;
                }
                return;
            case 1:
                ((C1260a) this.f9897c).f10650f.unregisterNetworkCallback((C0242f) this.f9896b);
                return;
            default:
                ((C1260a) this.f9897c).e.unregisterReceiver((C0243g) this.f9896b);
                return;
        }
    }

    public /* synthetic */ k(C1260a c1260a, Object obj, int i) {
        this.f9895a = i;
        this.f9897c = c1260a;
        this.f9896b = obj;
    }
}
