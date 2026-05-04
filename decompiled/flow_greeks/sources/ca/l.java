package ca;

import com.google.firebase.analytics.connector.AnalyticsConnector;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements r9.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f3788a;

    public l(k kVar) {
        this.f3788a = kVar;
    }

    public static l a(k kVar) {
        return new l(kVar);
    }

    public static AnalyticsConnector c(k kVar) {
        return (AnalyticsConnector) r9.d.e(kVar.a());
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public AnalyticsConnector get() {
        return c(this.f3788a);
    }
}
