package s3;

import c3.AbstractC0878b;
import c3.InterfaceC0877a;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f14686b = new d("NANOSECONDS", 0, TimeUnit.NANOSECONDS);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f14687c = new d("MICROSECONDS", 1, TimeUnit.MICROSECONDS);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f14688d = new d("MILLISECONDS", 2, TimeUnit.MILLISECONDS);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f14689e = new d("SECONDS", 3, TimeUnit.SECONDS);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f14690f = new d("MINUTES", 4, TimeUnit.MINUTES);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d f14691g = new d("HOURS", 5, TimeUnit.HOURS);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d f14692h = new d("DAYS", 6, TimeUnit.DAYS);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ d[] f14693i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC0877a f14694j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TimeUnit f14695a;

    static {
        d[] dVarArrA = a();
        f14693i = dVarArrA;
        f14694j = AbstractC0878b.a(dVarArrA);
    }

    public d(String str, int i4, TimeUnit timeUnit) {
        this.f14695a = timeUnit;
    }

    public static final /* synthetic */ d[] a() {
        return new d[]{f14686b, f14687c, f14688d, f14689e, f14690f, f14691g, f14692h};
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f14693i.clone();
    }

    public final TimeUnit c() {
        return this.f14695a;
    }
}
