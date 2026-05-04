package ua;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w0 f22631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y0 f22632b;

    public n0(w0 timeProvider, y0 uuidGenerator) {
        kotlin.jvm.internal.t.f(timeProvider, "timeProvider");
        kotlin.jvm.internal.t.f(uuidGenerator, "uuidGenerator");
        this.f22631a = timeProvider;
        this.f22632b = uuidGenerator;
    }

    public final SessionDetails a(SessionDetails sessionDetails) {
        String firstSessionId;
        String strB = b();
        if (sessionDetails == null || (firstSessionId = sessionDetails.getFirstSessionId()) == null) {
            firstSessionId = strB;
        }
        return new SessionDetails(strB, firstSessionId, sessionDetails != null ? sessionDetails.getSessionIndex() + 1 : 0, this.f22631a.a().getUs());
    }

    public final String b() {
        String string = this.f22632b.next().toString();
        kotlin.jvm.internal.t.e(string, "toString(...)");
        String lowerCase = kg.z.F(string, "-", "", false, 4, null).toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.t.e(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }
}
