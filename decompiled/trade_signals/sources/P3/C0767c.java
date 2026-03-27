package P3;

import N3.C0710c;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import n5.InterfaceC2426a;

/* JADX INFO: renamed from: P3.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0767c implements E3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0765a f6395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2426a f6396b;

    public C0767c(C0765a c0765a, InterfaceC2426a interfaceC2426a) {
        this.f6395a = c0765a;
        this.f6396b = interfaceC2426a;
    }

    public static C0767c a(C0765a c0765a, InterfaceC2426a interfaceC2426a) {
        return new C0767c(c0765a, interfaceC2426a);
    }

    public static C0710c c(C0765a c0765a, AnalyticsConnector analyticsConnector) {
        return (C0710c) E3.d.e(c0765a.b(analyticsConnector));
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0710c get() {
        return c(this.f6395a, (AnalyticsConnector) this.f6396b.get());
    }
}
