package O2;

import android.os.Bundle;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class e implements AnalyticsConnector.AnalyticsConnectorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Q2.b f5920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Q2.b f5921b;

    public static void a(Q2.b bVar, String str, Bundle bundle) {
        if (bVar == null) {
            return;
        }
        bVar.b(str, bundle);
    }

    public final void b(String str, Bundle bundle) {
        a("clx".equals(bundle.getString("_o")) ? this.f5920a : this.f5921b, str, bundle);
    }

    public void c(Q2.b bVar) {
        this.f5921b = bVar;
    }

    public void d(Q2.b bVar) {
        this.f5920a = bVar;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener
    public void onMessageTriggered(int i8, Bundle bundle) {
        String string;
        P2.g.f().i(String.format(Locale.US, "Analytics listener received message. ID: %d, Extras: %s", Integer.valueOf(i8), bundle));
        if (bundle == null || (string = bundle.getString("name")) == null) {
            return;
        }
        Bundle bundle2 = bundle.getBundle("params");
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        b(string, bundle2);
    }
}
