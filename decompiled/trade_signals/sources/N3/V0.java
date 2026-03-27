package N3;

import S3.a;
import android.os.Bundle;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class V0 implements AnalyticsConnector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Object f5637a;

    public static class b implements AnalyticsConnector.AnalyticsConnectorHandle {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Object f5638c = new Object();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Set f5639a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile Object f5640b;

        public b(final String str, final AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener, S3.a aVar) {
            this.f5639a = new HashSet();
            aVar.a(new a.InterfaceC0108a() { // from class: N3.W0
                @Override // S3.a.InterfaceC0108a
                public final void a(S3.b bVar) {
                    this.f5641a.b(str, analyticsConnectorListener, bVar);
                }
            });
        }

        public final /* synthetic */ void b(String str, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener, S3.b bVar) {
            if (this.f5640b == f5638c) {
                return;
            }
            AnalyticsConnector.AnalyticsConnectorHandle analyticsConnectorHandleRegisterAnalyticsConnectorListener = ((AnalyticsConnector) bVar.get()).registerAnalyticsConnectorListener(str, analyticsConnectorListener);
            this.f5640b = analyticsConnectorHandleRegisterAnalyticsConnectorListener;
            synchronized (this) {
                try {
                    if (!this.f5639a.isEmpty()) {
                        analyticsConnectorHandleRegisterAnalyticsConnectorListener.registerEventNames(this.f5639a);
                        this.f5639a = new HashSet();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle
        public void registerEventNames(Set set) {
            Object obj = this.f5640b;
            if (obj == f5638c) {
                return;
            }
            if (obj != null) {
                ((AnalyticsConnector.AnalyticsConnectorHandle) obj).registerEventNames(set);
            } else {
                synchronized (this) {
                    this.f5639a.addAll(set);
                }
            }
        }

        @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle
        public void unregister() {
            Object obj = this.f5640b;
            Object obj2 = f5638c;
            if (obj == obj2) {
                return;
            }
            if (obj != null) {
                ((AnalyticsConnector.AnalyticsConnectorHandle) obj).unregister();
            }
            this.f5640b = obj2;
            synchronized (this) {
                this.f5639a.clear();
            }
        }

        @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle
        public void unregisterEventNames() {
            Object obj = this.f5640b;
            if (obj == f5638c) {
                return;
            }
            if (obj != null) {
                ((AnalyticsConnector.AnalyticsConnectorHandle) obj).unregisterEventNames();
            } else {
                synchronized (this) {
                    this.f5639a.clear();
                }
            }
        }
    }

    public V0(S3.a aVar) {
        this.f5637a = aVar;
        aVar.a(new a.InterfaceC0108a() { // from class: N3.U0
            @Override // S3.a.InterfaceC0108a
            public final void a(S3.b bVar) {
                this.f5636a.b(bVar);
            }
        });
    }

    public final /* synthetic */ void b(S3.b bVar) {
        this.f5637a = bVar.get();
    }

    public final AnalyticsConnector c() {
        Object obj = this.f5637a;
        if (obj instanceof AnalyticsConnector) {
            return (AnalyticsConnector) obj;
        }
        return null;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public List getConditionalUserProperties(String str, String str2) {
        return Collections.emptyList();
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public int getMaxUserProperties(String str) {
        return 0;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public Map getUserProperties(boolean z7) {
        return Collections.emptyMap();
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void logEvent(String str, String str2, Bundle bundle) {
        AnalyticsConnector analyticsConnectorC = c();
        if (analyticsConnectorC != null) {
            analyticsConnectorC.logEvent(str, str2, bundle);
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public AnalyticsConnector.AnalyticsConnectorHandle registerAnalyticsConnectorListener(String str, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        Object obj = this.f5637a;
        return obj instanceof AnalyticsConnector ? ((AnalyticsConnector) obj).registerAnalyticsConnectorListener(str, analyticsConnectorListener) : new b(str, analyticsConnectorListener, (S3.a) obj);
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void setUserProperty(String str, String str2, Object obj) {
        AnalyticsConnector analyticsConnectorC = c();
        if (analyticsConnectorC != null) {
            analyticsConnectorC.setUserProperty(str, str2, obj);
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void setConditionalUserProperty(AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
    }
}
