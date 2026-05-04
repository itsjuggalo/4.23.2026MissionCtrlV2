package q7;

import android.os.Bundle;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e implements AnalyticsConnector.AnalyticsConnectorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s7.b f18870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public s7.b f18871b;

    public static void a(s7.b bVar, String str, Bundle bundle) {
        if (bVar == null) {
            return;
        }
        bVar.b(str, bundle);
    }

    public final void b(String str, Bundle bundle) {
        a("clx".equals(bundle.getString("_o")) ? this.f18870a : this.f18871b, str, bundle);
    }

    public void c(s7.b bVar) {
        this.f18871b = bVar;
    }

    public void d(s7.b bVar) {
        this.f18870a = bVar;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener
    public void onMessageTriggered(int i10, Bundle bundle) {
        String string;
        r7.g.f().i(String.format(Locale.US, "Analytics listener received message. ID: %d, Extras: %s", Integer.valueOf(i10), bundle));
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
