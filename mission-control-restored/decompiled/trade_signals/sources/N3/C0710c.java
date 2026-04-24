package N3;

import android.text.TextUtils;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: renamed from: N3.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0710c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnalyticsConnector f5658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final U4.a f5659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AnalyticsConnector.AnalyticsConnectorHandle f5660c;

    /* JADX INFO: renamed from: N3.c$a */
    public class a implements P4.h {
        public a() {
        }

        @Override // P4.h
        public void a(P4.g gVar) {
            I0.a("Subscribing to analytics events.");
            C0710c c0710c = C0710c.this;
            c0710c.f5660c = c0710c.f5658a.registerAnalyticsConnectorListener(AppMeasurement.FIAM_ORIGIN, new E(gVar));
        }
    }

    public C0710c(AnalyticsConnector analyticsConnector) {
        this.f5658a = analyticsConnector;
        U4.a aVarC = P4.f.e(new a(), P4.a.BUFFER).C();
        this.f5659b = aVarC;
        aVarC.K();
    }

    public static Set c(r4.e eVar) {
        HashSet hashSet = new HashSet();
        Iterator it = eVar.V().iterator();
        while (it.hasNext()) {
            for (D3.h hVar : ((q4.c) it.next()).Y()) {
                if (!TextUtils.isEmpty(hVar.S().T())) {
                    hashSet.add(hVar.S().T());
                }
            }
        }
        if (hashSet.size() > 50) {
            I0.c("Too many contextual triggers defined - limiting to 50");
        }
        return hashSet;
    }

    public U4.a d() {
        return this.f5659b;
    }

    public void e(r4.e eVar) {
        Set<String> setC = c(eVar);
        I0.a("Updating contextual triggers for the following analytics events: " + setC);
        this.f5660c.registerEventNames(setC);
    }
}
