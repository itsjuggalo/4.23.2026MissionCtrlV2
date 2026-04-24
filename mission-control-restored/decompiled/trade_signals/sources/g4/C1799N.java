package g4;

import java.util.Locale;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: g4.N, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1799N {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC1808X f18062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC1810Z f18063b;

    public C1799N(InterfaceC1808X timeProvider, InterfaceC1810Z uuidGenerator) {
        AbstractC2304t.f(timeProvider, "timeProvider");
        AbstractC2304t.f(uuidGenerator, "uuidGenerator");
        this.f18062a = timeProvider;
        this.f18063b = uuidGenerator;
    }

    public final SessionDetails a(SessionDetails sessionDetails) {
        String firstSessionId;
        String strB = b();
        return new SessionDetails(strB, (sessionDetails == null || (firstSessionId = sessionDetails.getFirstSessionId()) == null) ? strB : firstSessionId, sessionDetails != null ? sessionDetails.getSessionIndex() + 1 : 0, this.f18062a.a().getUs());
    }

    public final String b() {
        String string = this.f18063b.next().toString();
        AbstractC2304t.e(string, "toString(...)");
        String lowerCase = V6.A.E(string, "-", "", false, 4, null).toLowerCase(Locale.ROOT);
        AbstractC2304t.e(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }
}
