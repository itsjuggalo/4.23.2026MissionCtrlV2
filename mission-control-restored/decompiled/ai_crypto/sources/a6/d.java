package a6;

import java.util.concurrent.TimeUnit;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f6407b = new d("NANOSECONDS", 0, TimeUnit.NANOSECONDS);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f6408c = new d("MICROSECONDS", 1, TimeUnit.MICROSECONDS);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f6409d = new d("MILLISECONDS", 2, TimeUnit.MILLISECONDS);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f6410e = new d("SECONDS", 3, TimeUnit.SECONDS);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f6411f = new d("MINUTES", 4, TimeUnit.MINUTES);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d f6412g = new d("HOURS", 5, TimeUnit.HOURS);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d f6413h = new d("DAYS", 6, TimeUnit.DAYS);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ d[] f6414i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ K5.a f6415j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TimeUnit f6416a;

    static {
        d[] dVarArrA = a();
        f6414i = dVarArrA;
        f6415j = K5.b.a(dVarArrA);
    }

    public d(String str, int i7, TimeUnit timeUnit) {
        this.f6416a = timeUnit;
    }

    public static final /* synthetic */ d[] a() {
        return new d[]{f6407b, f6408c, f6409d, f6410e, f6411f, f6412g, f6413h};
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f6414i.clone();
    }

    public final TimeUnit b() {
        return this.f6416a;
    }
}
