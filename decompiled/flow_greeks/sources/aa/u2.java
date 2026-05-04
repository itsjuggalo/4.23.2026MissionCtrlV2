package aa;

import aa.u2;
import android.os.Bundle;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import fa.a;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class u2 implements AnalyticsConnector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Object f583a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b implements AnalyticsConnector.AnalyticsConnectorHandle {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Object f584c = new Object();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Set f585a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile Object f586b;

        public static /* synthetic */ void a(b bVar, String str, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener, fa.b bVar2) {
            if (bVar.f586b == f584c) {
                return;
            }
            AnalyticsConnector.AnalyticsConnectorHandle analyticsConnectorHandleRegisterAnalyticsConnectorListener = ((AnalyticsConnector) bVar2.get()).registerAnalyticsConnectorListener(str, analyticsConnectorListener);
            bVar.f586b = analyticsConnectorHandleRegisterAnalyticsConnectorListener;
            synchronized (bVar) {
                try {
                    if (!bVar.f585a.isEmpty()) {
                        analyticsConnectorHandleRegisterAnalyticsConnectorListener.registerEventNames(bVar.f585a);
                        bVar.f585a = new HashSet();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle
        public void registerEventNames(Set set) {
            Object obj = this.f586b;
            if (obj == f584c) {
                return;
            }
            if (obj != null) {
                ((AnalyticsConnector.AnalyticsConnectorHandle) obj).registerEventNames(set);
            } else {
                synchronized (this) {
                    this.f585a.addAll(set);
                }
            }
        }

        @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle
        public void unregister() {
            Object obj = this.f586b;
            Object obj2 = f584c;
            if (obj == obj2) {
                return;
            }
            if (obj != null) {
                ((AnalyticsConnector.AnalyticsConnectorHandle) obj).unregister();
            }
            this.f586b = obj2;
            synchronized (this) {
                this.f585a.clear();
            }
        }

        @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle
        public void unregisterEventNames() {
            Object obj = this.f586b;
            if (obj == f584c) {
                return;
            }
            if (obj != null) {
                ((AnalyticsConnector.AnalyticsConnectorHandle) obj).unregisterEventNames();
            } else {
                synchronized (this) {
                    this.f585a.clear();
                }
            }
        }

        public b(final String str, final AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener, fa.a aVar) {
            this.f585a = new HashSet();
            aVar.a(new a.InterfaceC0174a() { // from class: aa.v2
                @Override // fa.a.InterfaceC0174a
                public final void a(fa.b bVar) {
                    u2.b.a(this.f590a, str, analyticsConnectorListener, bVar);
                }
            });
        }
    }

    public u2(fa.a aVar) {
        this.f583a = aVar;
        aVar.a(new a.InterfaceC0174a() { // from class: aa.t2
            @Override // fa.a.InterfaceC0174a
            public final void a(fa.b bVar) {
                u2.a(this.f579a, bVar);
            }
        });
    }

    public static /* synthetic */ void a(u2 u2Var, fa.b bVar) {
        u2Var.getClass();
        u2Var.f583a = bVar.get();
    }

    public final AnalyticsConnector b() {
        Object obj = this.f583a;
        if (obj instanceof AnalyticsConnector) {
            return (AnalyticsConnector) obj;
        }
        return null;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public List getConditionalUserProperties(String str, String str2) {
        return Collections.EMPTY_LIST;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public int getMaxUserProperties(String str) {
        return 0;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public Map getUserProperties(boolean z10) {
        return Collections.EMPTY_MAP;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void logEvent(String str, String str2, Bundle bundle) {
        AnalyticsConnector analyticsConnectorB = b();
        if (analyticsConnectorB != null) {
            analyticsConnectorB.logEvent(str, str2, bundle);
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public AnalyticsConnector.AnalyticsConnectorHandle registerAnalyticsConnectorListener(String str, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        Object obj = this.f583a;
        return obj instanceof AnalyticsConnector ? ((AnalyticsConnector) obj).registerAnalyticsConnectorListener(str, analyticsConnectorListener) : new b(str, analyticsConnectorListener, (fa.a) obj);
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void setUserProperty(String str, String str2, Object obj) {
        AnalyticsConnector analyticsConnectorB = b();
        if (analyticsConnectorB != null) {
            analyticsConnectorB.setUserProperty(str, str2, obj);
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void setConditionalUserProperty(AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
    }
}
