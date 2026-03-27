package P3;

import com.google.firebase.analytics.connector.AnalyticsConnector;

/* JADX INFO: renamed from: P3.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0776l implements E3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0775k f6414a;

    public C0776l(C0775k c0775k) {
        this.f6414a = c0775k;
    }

    public static C0776l a(C0775k c0775k) {
        return new C0776l(c0775k);
    }

    public static AnalyticsConnector c(C0775k c0775k) {
        return (AnalyticsConnector) E3.d.e(c0775k.a());
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public AnalyticsConnector get() {
        return c(this.f6414a);
    }
}
