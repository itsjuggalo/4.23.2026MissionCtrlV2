package P3;

import N3.R0;
import android.app.Application;

/* JADX INFO: loaded from: classes.dex */
public class H {
    public R0 a(Application application) {
        return new R0(application, "fiam_eligible_campaigns_cache_file");
    }

    public R0 b(Application application) {
        return new R0(application, "fiam_impressions_store_file");
    }

    public R0 c(Application application) {
        return new R0(application, "rate_limit_store_file");
    }
}
