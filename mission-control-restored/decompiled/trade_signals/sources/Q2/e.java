package Q2;

import android.os.Bundle;
import com.google.firebase.analytics.connector.AnalyticsConnector;

/* JADX INFO: loaded from: classes.dex */
public class e implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnalyticsConnector f6725a;

    public e(AnalyticsConnector analyticsConnector) {
        this.f6725a = analyticsConnector;
    }

    @Override // Q2.a
    public void a(String str, Bundle bundle) {
        this.f6725a.logEvent("clx", str, bundle);
    }
}
