package W6;

import java.util.concurrent.TimeUnit;
import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f9313b = new d("NANOSECONDS", 0, TimeUnit.NANOSECONDS);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f9314c = new d("MICROSECONDS", 1, TimeUnit.MICROSECONDS);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f9315d = new d("MILLISECONDS", 2, TimeUnit.MILLISECONDS);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f9316e = new d("SECONDS", 3, TimeUnit.SECONDS);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f9317f = new d("MINUTES", 4, TimeUnit.MINUTES);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d f9318g = new d("HOURS", 5, TimeUnit.HOURS);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d f9319h = new d("DAYS", 6, TimeUnit.DAYS);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ d[] f9320i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f9321j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TimeUnit f9322a;

    static {
        d[] dVarArrA = a();
        f9320i = dVarArrA;
        f9321j = AbstractC2875b.a(dVarArrA);
    }

    public d(String str, int i8, TimeUnit timeUnit) {
        this.f9322a = timeUnit;
    }

    public static final /* synthetic */ d[] a() {
        return new d[]{f9313b, f9314c, f9315d, f9316e, f9317f, f9318g, f9319h};
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f9320i.clone();
    }

    public final TimeUnit b() {
        return this.f9322a;
    }
}
