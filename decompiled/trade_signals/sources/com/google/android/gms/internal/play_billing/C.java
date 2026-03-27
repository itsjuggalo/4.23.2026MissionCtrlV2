package com.google.android.gms.internal.play_billing;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final F f15089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f15090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f15091c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f15092d;

    public C(F f8) {
        A.c(f8, "ticker");
        this.f15089a = f8;
    }

    public static C b(F f8) {
        C c8 = new C(f8);
        c8.e();
        return c8;
    }

    public static C c(F f8) {
        return new C(f8);
    }

    public final long a(TimeUnit timeUnit) {
        return timeUnit.convert(h(), TimeUnit.NANOSECONDS);
    }

    public final C d() {
        this.f15091c = 0L;
        this.f15090b = false;
        return this;
    }

    public final C e() {
        A.e(!this.f15090b, "This stopwatch is already running.");
        this.f15090b = true;
        this.f15092d = this.f15089a.a();
        return this;
    }

    public final C f() {
        long jA = this.f15089a.a();
        A.e(this.f15090b, "This stopwatch is already stopped.");
        this.f15090b = false;
        this.f15091c += jA - this.f15092d;
        return this;
    }

    public final boolean g() {
        return this.f15090b;
    }

    public final long h() {
        return this.f15090b ? (this.f15089a.a() - this.f15092d) + this.f15091c : this.f15091c;
    }

    public final String toString() {
        String str;
        long jH = h();
        TimeUnit timeUnit = TimeUnit.DAYS;
        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
        if (timeUnit.convert(jH, timeUnit2) <= 0) {
            timeUnit = TimeUnit.HOURS;
            if (timeUnit.convert(jH, timeUnit2) <= 0) {
                timeUnit = TimeUnit.MINUTES;
                if (timeUnit.convert(jH, timeUnit2) <= 0) {
                    timeUnit = TimeUnit.SECONDS;
                    if (timeUnit.convert(jH, timeUnit2) <= 0) {
                        timeUnit = TimeUnit.MILLISECONDS;
                        if (timeUnit.convert(jH, timeUnit2) <= 0) {
                            timeUnit = TimeUnit.MICROSECONDS;
                            if (timeUnit.convert(jH, timeUnit2) <= 0) {
                                timeUnit = timeUnit2;
                            }
                        }
                    }
                }
            }
        }
        String str2 = String.format(Locale.ROOT, "%.4g", Double.valueOf(jH / timeUnit2.convert(1L, timeUnit)));
        switch (B.f15087a[timeUnit.ordinal()]) {
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
        return str2 + " " + str;
    }
}
