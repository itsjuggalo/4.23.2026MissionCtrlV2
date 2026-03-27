package j$.time.format;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Comparator f19739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f19740c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ v f19741a;

    static {
        new ConcurrentHashMap(16, 0.75f, 2);
        f19739b = new u();
    }

    b(v vVar) {
        this.f19741a = vVar;
    }

    public final String b(j$.time.chrono.l lVar, j$.time.temporal.r rVar, long j8, A a8, Locale locale) {
        return this.f19741a.a(j8, a8);
    }

    public final String c(j$.time.temporal.r rVar, long j8, A a8, Locale locale) {
        return this.f19741a.a(j8, a8);
    }

    public final Iterator d(j$.time.chrono.l lVar, j$.time.temporal.r rVar, A a8, Locale locale) {
        return this.f19741a.b(a8);
    }

    public final Iterator e(j$.time.temporal.r rVar, A a8, Locale locale) {
        return this.f19741a.b(a8);
    }
}
