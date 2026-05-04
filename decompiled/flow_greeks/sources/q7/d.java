package q7;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import fa.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fa.a f18866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile s7.a f18867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile t7.b f18868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f18869d;

    public d(fa.a aVar) {
        this(aVar, new t7.c(), new s7.f());
    }

    public static /* synthetic */ void a(d dVar, fa.b bVar) {
        dVar.getClass();
        r7.g.f().b("AnalyticsConnector now available.");
        AnalyticsConnector analyticsConnector = (AnalyticsConnector) bVar.get();
        s7.e eVar = new s7.e(analyticsConnector);
        e eVar2 = new e();
        if (g(analyticsConnector, eVar2) == null) {
            r7.g.f().k("Could not register Firebase Analytics listener; a listener is already registered.");
            return;
        }
        r7.g.f().b("Registered Firebase Analytics listener.");
        s7.d dVar2 = new s7.d();
        s7.c cVar = new s7.c(eVar, 500, TimeUnit.MILLISECONDS);
        synchronized (dVar) {
            try {
                Iterator it = dVar.f18869d.iterator();
                while (it.hasNext()) {
                    dVar2.a((t7.a) it.next());
                }
                eVar2.c(dVar2);
                eVar2.d(cVar);
                dVar.f18868c = dVar2;
                dVar.f18867b = cVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static /* synthetic */ void c(d dVar, t7.a aVar) {
        synchronized (dVar) {
            try {
                if (dVar.f18868c instanceof t7.c) {
                    dVar.f18869d.add(aVar);
                }
                dVar.f18868c.a(aVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static AnalyticsConnector.AnalyticsConnectorHandle g(AnalyticsConnector analyticsConnector, e eVar) {
        AnalyticsConnector.AnalyticsConnectorHandle analyticsConnectorHandleRegisterAnalyticsConnectorListener = analyticsConnector.registerAnalyticsConnectorListener("clx", eVar);
        if (analyticsConnectorHandleRegisterAnalyticsConnectorListener != null) {
            return analyticsConnectorHandleRegisterAnalyticsConnectorListener;
        }
        r7.g.f().b("Could not register AnalyticsConnectorListener with Crashlytics origin.");
        AnalyticsConnector.AnalyticsConnectorHandle analyticsConnectorHandleRegisterAnalyticsConnectorListener2 = analyticsConnector.registerAnalyticsConnectorListener(AppMeasurement.CRASH_ORIGIN, eVar);
        if (analyticsConnectorHandleRegisterAnalyticsConnectorListener2 != null) {
            r7.g.f().k("A new version of the Google Analytics for Firebase SDK is now available. For improved performance and compatibility with Crashlytics, please update to the latest version.");
        }
        return analyticsConnectorHandleRegisterAnalyticsConnectorListener2;
    }

    public s7.a d() {
        return new s7.a() { // from class: q7.b
            @Override // s7.a
            public final void a(String str, Bundle bundle) {
                this.f18864a.f18867b.a(str, bundle);
            }
        };
    }

    public t7.b e() {
        return new t7.b() { // from class: q7.a
            @Override // t7.b
            public final void a(t7.a aVar) {
                d.c(this.f18863a, aVar);
            }
        };
    }

    public final void f() {
        this.f18866a.a(new a.InterfaceC0174a() { // from class: q7.c
            @Override // fa.a.InterfaceC0174a
            public final void a(fa.b bVar) {
                d.a(this.f18865a, bVar);
            }
        });
    }

    public d(fa.a aVar, t7.b bVar, s7.a aVar2) {
        this.f18866a = aVar;
        this.f18868c = bVar;
        this.f18869d = new ArrayList();
        this.f18867b = aVar2;
        f();
    }
}
