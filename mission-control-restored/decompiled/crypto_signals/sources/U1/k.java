package U1;

import java.util.Locale;
import java.util.concurrent.TimeUnit;
import s3.D;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3111a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f3113c;

    public /* synthetic */ k() {
    }

    public long a() {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        return timeUnit.convert(this.f3112b ? System.nanoTime() - this.f3113c : 0L, timeUnit);
    }

    public void b() {
        D.p("This stopwatch is already running.", !this.f3112b);
        this.f3112b = true;
        this.f3113c = System.nanoTime();
    }

    public String toString() {
        String str;
        switch (this.f3111a) {
            case 0:
                long jNanoTime = this.f3112b ? System.nanoTime() - this.f3113c : 0L;
                TimeUnit timeUnit = TimeUnit.DAYS;
                TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
                if (timeUnit.convert(jNanoTime, timeUnit2) <= 0) {
                    timeUnit = TimeUnit.HOURS;
                    if (timeUnit.convert(jNanoTime, timeUnit2) <= 0) {
                        timeUnit = TimeUnit.MINUTES;
                        if (timeUnit.convert(jNanoTime, timeUnit2) <= 0) {
                            timeUnit = TimeUnit.SECONDS;
                            if (timeUnit.convert(jNanoTime, timeUnit2) <= 0) {
                                timeUnit = TimeUnit.MILLISECONDS;
                                if (timeUnit.convert(jNanoTime, timeUnit2) <= 0) {
                                    timeUnit = TimeUnit.MICROSECONDS;
                                    if (timeUnit.convert(jNanoTime, timeUnit2) <= 0) {
                                        timeUnit = timeUnit2;
                                    }
                                }
                            }
                        }
                    }
                }
                double dConvert = jNanoTime / timeUnit2.convert(1L, timeUnit);
                StringBuilder sb = new StringBuilder();
                int i = h.f3108a;
                sb.append(String.format(Locale.ROOT, "%.4g", Double.valueOf(dConvert)));
                sb.append(" ");
                switch (j.f3110a[timeUnit.ordinal()]) {
                    case 1:
                        str = "ns";
                        break;
                    case 2:
                        str = "μs";
                        break;
                    case 3:
                        str = "ms";
                        break;
                    case 4:
                        str = "s";
                        break;
                    case 5:
                        str = "min";
                        break;
                    case 6:
                        str = "h";
                        break;
                    case 7:
                        str = "d";
                        break;
                    default:
                        throw new AssertionError();
                }
                sb.append(str);
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public k(long j4, boolean z6) {
        this.f3112b = z6;
        this.f3113c = j4;
    }
}
