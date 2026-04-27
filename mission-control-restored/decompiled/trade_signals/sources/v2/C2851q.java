package v2;

import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: v2.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2851q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC2857w f23774a = AbstractC2857w.b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f23775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f23776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f23777d;

    /* JADX INFO: renamed from: v2.q$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23778a;

        static {
            int[] iArr = new int[TimeUnit.values().length];
            f23778a = iArr;
            try {
                iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23778a[TimeUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23778a[TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f23778a[TimeUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f23778a[TimeUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f23778a[TimeUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f23778a[TimeUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static String a(TimeUnit timeUnit) {
        switch (a.f23778a[timeUnit.ordinal()]) {
            case 1:
                return "ns";
            case 2:
                return "μs";
            case 3:
                return "ms";
            case 4:
                return "s";
            case 5:
                return "min";
            case 6:
                return "h";
            case 7:
                return "d";
            default:
                throw new AssertionError();
        }
    }

    public static TimeUnit b(long j8) {
        TimeUnit timeUnit = TimeUnit.DAYS;
        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
        if (timeUnit.convert(j8, timeUnit2) > 0) {
            return timeUnit;
        }
        TimeUnit timeUnit3 = TimeUnit.HOURS;
        if (timeUnit3.convert(j8, timeUnit2) > 0) {
            return timeUnit3;
        }
        TimeUnit timeUnit4 = TimeUnit.MINUTES;
        if (timeUnit4.convert(j8, timeUnit2) > 0) {
            return timeUnit4;
        }
        TimeUnit timeUnit5 = TimeUnit.SECONDS;
        if (timeUnit5.convert(j8, timeUnit2) > 0) {
            return timeUnit5;
        }
        TimeUnit timeUnit6 = TimeUnit.MILLISECONDS;
        if (timeUnit6.convert(j8, timeUnit2) > 0) {
            return timeUnit6;
        }
        TimeUnit timeUnit7 = TimeUnit.MICROSECONDS;
        return timeUnit7.convert(j8, timeUnit2) > 0 ? timeUnit7 : timeUnit2;
    }

    public static C2851q c() {
        return new C2851q();
    }

    public long d(TimeUnit timeUnit) {
        return timeUnit.convert(e(), TimeUnit.NANOSECONDS);
    }

    public final long e() {
        return this.f23775b ? (this.f23774a.a() - this.f23777d) + this.f23776c : this.f23776c;
    }

    public C2851q f() {
        this.f23776c = 0L;
        this.f23775b = false;
        return this;
    }

    public C2851q g() {
        AbstractC2848n.u(!this.f23775b, "This stopwatch is already running.");
        this.f23775b = true;
        this.f23777d = this.f23774a.a();
        return this;
    }

    public String toString() {
        long jE = e();
        TimeUnit timeUnitB = b(jE);
        return AbstractC2847m.b(jE / TimeUnit.NANOSECONDS.convert(1L, timeUnitB)) + " " + a(timeUnitB);
    }
}
