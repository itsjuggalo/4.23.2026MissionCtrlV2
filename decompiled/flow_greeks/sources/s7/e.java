package s7;

import android.os.Bundle;
import com.google.firebase.analytics.connector.AnalyticsConnector;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnalyticsConnector f20060a;

    public e(AnalyticsConnector analyticsConnector) {
        this.f20060a = analyticsConnector;
    }

    @Override // s7.a
    public void a(String str, Bundle bundle) {
        this.f20060a.logEvent("clx", str, bundle);
    }
}
