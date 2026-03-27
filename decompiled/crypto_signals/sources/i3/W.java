package i3;

import java.util.Locale;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class W {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l0 f6879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m0 f6880b;

    public W(l0 timeProvider, m0 uuidGenerator) {
        kotlin.jvm.internal.j.e(timeProvider, "timeProvider");
        kotlin.jvm.internal.j.e(uuidGenerator, "uuidGenerator");
        this.f6879a = timeProvider;
        this.f6880b = uuidGenerator;
    }

    public final N a(N n6) {
        String str;
        this.f6880b.getClass();
        UUID uuidRandomUUID = UUID.randomUUID();
        kotlin.jvm.internal.j.d(uuidRandomUUID, "randomUUID(...)");
        String string = uuidRandomUUID.toString();
        kotlin.jvm.internal.j.d(string, "toString(...)");
        String lowerCase = Y4.l.S(string, "-", "").toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.j.d(lowerCase, "toLowerCase(...)");
        return new N(lowerCase, (n6 == null || (str = n6.f6849b) == null) ? lowerCase : str, n6 != null ? n6.f6850c + 1 : 0, this.f6879a.a().f6979b);
    }
}
