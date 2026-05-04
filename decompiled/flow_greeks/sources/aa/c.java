package aa;

import android.text.TextUtils;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnalyticsConnector f389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final hc.a f390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AnalyticsConnector.AnalyticsConnectorHandle f391c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements cc.h {
        public a() {
        }

        @Override // cc.h
        public void a(cc.g gVar) {
            h2.a("Subscribing to analytics events.");
            c cVar = c.this;
            cVar.f391c = cVar.f389a.registerAnalyticsConnectorListener(AppMeasurement.FIAM_ORIGIN, new e0(gVar));
        }
    }

    public c(AnalyticsConnector analyticsConnector) {
        this.f389a = analyticsConnector;
        hc.a aVarC = cc.f.e(new a(), cc.a.BUFFER).C();
        this.f390b = aVarC;
        aVarC.K();
    }

    public static Set c(ib.e eVar) {
        HashSet hashSet = new HashSet();
        Iterator it = eVar.d0().iterator();
        while (it.hasNext()) {
            for (q9.h hVar : ((hb.c) it.next()).g0()) {
                if (!TextUtils.isEmpty(hVar.a0().b0())) {
                    hashSet.add(hVar.a0().b0());
                }
            }
        }
        if (hashSet.size() > 50) {
            h2.c("Too many contextual triggers defined - limiting to 50");
        }
        return hashSet;
    }

    public hc.a d() {
        return this.f390b;
    }

    public void e(ib.e eVar) {
        Set<String> setC = c(eVar);
        h2.a("Updating contextual triggers for the following analytics events: " + setC);
        this.f391c.registerEventNames(setC);
    }
}
