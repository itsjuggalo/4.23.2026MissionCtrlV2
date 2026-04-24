package N3;

import android.os.Bundle;
import com.google.firebase.analytics.connector.AnalyticsConnector;

/* JADX INFO: loaded from: classes.dex */
public final class E implements AnalyticsConnector.AnalyticsConnectorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public P4.g f5553a;

    public E(P4.g gVar) {
        this.f5553a = gVar;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener
    public void onMessageTriggered(int i8, Bundle bundle) {
        if (i8 == 2) {
            this.f5553a.c(bundle.getString("events"));
        }
    }
}
