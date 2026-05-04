package ca;

import com.google.firebase.analytics.connector.AnalyticsConnector;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements r9.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f3758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bd.a f3759b;

    public c(a aVar, bd.a aVar2) {
        this.f3758a = aVar;
        this.f3759b = aVar2;
    }

    public static c a(a aVar, bd.a aVar2) {
        return new c(aVar, aVar2);
    }

    public static aa.c c(a aVar, AnalyticsConnector analyticsConnector) {
        return (aa.c) r9.d.e(aVar.b(analyticsConnector));
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public aa.c get() {
        return c(this.f3758a, (AnalyticsConnector) this.f3759b.get());
    }
}
