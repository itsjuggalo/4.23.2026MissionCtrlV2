package o2;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: renamed from: o2.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2303d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f20026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f20027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TimeInterpolator f20028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f20029d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f20030e;

    public C2303d(long j7, long j8) {
        this.f20028c = null;
        this.f20029d = 0;
        this.f20030e = 1;
        this.f20026a = j7;
        this.f20027b = j8;
    }

    public static C2303d a(ValueAnimator valueAnimator) {
        C2303d c2303d = new C2303d(valueAnimator.getStartDelay(), valueAnimator.getDuration(), e(valueAnimator));
        c2303d.f20029d = valueAnimator.getRepeatCount();
        c2303d.f20030e = valueAnimator.getRepeatMode();
        return c2303d;
    }

    public static TimeInterpolator e(ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        return ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) ? AbstractC2300a.f20020b : interpolator instanceof AccelerateInterpolator ? AbstractC2300a.f20021c : interpolator instanceof DecelerateInterpolator ? AbstractC2300a.f20022d : interpolator;
    }

    public long b() {
        return this.f20026a;
    }

    public long c() {
        return this.f20027b;
    }

    public TimeInterpolator d() {
        TimeInterpolator timeInterpolator = this.f20028c;
        return timeInterpolator != null ? timeInterpolator : AbstractC2300a.f20020b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2303d)) {
            return false;
        }
        C2303d c2303d = (C2303d) obj;
        if (b() == c2303d.b() && c() == c2303d.c() && f() == c2303d.f() && g() == c2303d.g()) {
            return d().getClass().equals(c2303d.d().getClass());
        }
        return false;
    }

    public int f() {
        return this.f20029d;
    }

    public int g() {
        return this.f20030e;
    }

    public int hashCode() {
        return (((((((((int) (b() ^ (b() >>> 32))) * 31) + ((int) (c() ^ (c() >>> 32)))) * 31) + d().getClass().hashCode()) * 31) + f()) * 31) + g();
    }

    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + b() + " duration: " + c() + " interpolator: " + d().getClass() + " repeatCount: " + f() + " repeatMode: " + g() + "}\n";
    }

    public C2303d(long j7, long j8, TimeInterpolator timeInterpolator) {
        this.f20029d = 0;
        this.f20030e = 1;
        this.f20026a = j7;
        this.f20027b = j8;
        this.f20028c = timeInterpolator;
    }
}
