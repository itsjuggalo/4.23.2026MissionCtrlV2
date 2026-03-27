package O2;

import S3.a;
import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S3.a f5916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Q2.a f5917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile R2.b f5918c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f5919d;

    public d(S3.a aVar) {
        this(aVar, new R2.c(), new Q2.f());
    }

    public static AnalyticsConnector.AnalyticsConnectorHandle j(AnalyticsConnector analyticsConnector, e eVar) {
        AnalyticsConnector.AnalyticsConnectorHandle analyticsConnectorHandleRegisterAnalyticsConnectorListener = analyticsConnector.registerAnalyticsConnectorListener("clx", eVar);
        if (analyticsConnectorHandleRegisterAnalyticsConnectorListener == null) {
            P2.g.f().b("Could not register AnalyticsConnectorListener with Crashlytics origin.");
            analyticsConnectorHandleRegisterAnalyticsConnectorListener = analyticsConnector.registerAnalyticsConnectorListener(AppMeasurement.CRASH_ORIGIN, eVar);
            if (analyticsConnectorHandleRegisterAnalyticsConnectorListener != null) {
                P2.g.f().k("A new version of the Google Analytics for Firebase SDK is now available. For improved performance and compatibility with Crashlytics, please update to the latest version.");
            }
        }
        return analyticsConnectorHandleRegisterAnalyticsConnectorListener;
    }

    public Q2.a d() {
        return new Q2.a() { // from class: O2.b
            @Override // Q2.a
            public final void a(String str, Bundle bundle) {
                this.f5914a.g(str, bundle);
            }
        };
    }

    public R2.b e() {
        return new R2.b() { // from class: O2.a
            @Override // R2.b
            public final void a(R2.a aVar) {
                this.f5913a.h(aVar);
            }
        };
    }

    public final void f() {
        this.f5916a.a(new a.InterfaceC0108a() { // from class: O2.c
            @Override // S3.a.InterfaceC0108a
            public final void a(S3.b bVar) {
                this.f5915a.i(bVar);
            }
        });
    }

    public final /* synthetic */ void g(String str, Bundle bundle) {
        this.f5917b.a(str, bundle);
    }

    public final /* synthetic */ void h(R2.a aVar) {
        synchronized (this) {
            try {
                if (this.f5918c instanceof R2.c) {
                    this.f5919d.add(aVar);
                }
                this.f5918c.a(aVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final /* synthetic */ void i(S3.b bVar) {
        P2.g.f().b("AnalyticsConnector now available.");
        AnalyticsConnector analyticsConnector = (AnalyticsConnector) bVar.get();
        Q2.e eVar = new Q2.e(analyticsConnector);
        e eVar2 = new e();
        if (j(analyticsConnector, eVar2) == null) {
            P2.g.f().k("Could not register Firebase Analytics listener; a listener is already registered.");
            return;
        }
        P2.g.f().b("Registered Firebase Analytics listener.");
        Q2.d dVar = new Q2.d();
        Q2.c cVar = new Q2.c(eVar, 500, TimeUnit.MILLISECONDS);
        synchronized (this) {
            try {
                Iterator it = this.f5919d.iterator();
                while (it.hasNext()) {
                    dVar.a((R2.a) it.next());
                }
                eVar2.c(dVar);
                eVar2.d(cVar);
                this.f5918c = dVar;
                this.f5917b = cVar;
            } finally {
            }
        }
    }

    public d(S3.a aVar, R2.b bVar, Q2.a aVar2) {
        this.f5916a = aVar;
        this.f5918c = bVar;
        this.f5919d = new ArrayList();
        this.f5917b = aVar2;
        f();
    }
}
