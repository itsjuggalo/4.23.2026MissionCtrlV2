package ca;

import aa.q2;
import android.app.Application;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class h0 {
    public q2 a(Application application) {
        return new q2(application, "fiam_eligible_campaigns_cache_file");
    }

    public q2 b(Application application) {
        return new q2(application, "fiam_impressions_store_file");
    }

    public q2 c(Application application) {
        return new q2(application, "rate_limit_store_file");
    }
}
