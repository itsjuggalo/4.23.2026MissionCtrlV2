package aa;

import com.revenuecat.purchases.common.networking.HTTPTimeoutManager;
import ib.g;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g.b f472a;

    public h0(g.b bVar) {
        this.f472a = bVar;
    }

    public ib.e a(ib.d dVar) {
        return ((g.b) this.f472a.e(HTTPTimeoutManager.DEFAULT_TIMEOUT_MS, TimeUnit.MILLISECONDS)).j(dVar);
    }
}
