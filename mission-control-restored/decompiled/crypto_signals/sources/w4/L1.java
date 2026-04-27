package w4;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class L1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f10942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicInteger f10943d;

    public L1(float f6, float f7) {
        AtomicInteger atomicInteger = new AtomicInteger();
        this.f10943d = atomicInteger;
        this.f10942c = (int) (f7 * 1000.0f);
        int i = (int) (f6 * 1000.0f);
        this.f10940a = i;
        this.f10941b = i / 2;
        atomicInteger.set(i);
    }

    public final boolean a() {
        AtomicInteger atomicInteger;
        int i;
        int i6;
        do {
            atomicInteger = this.f10943d;
            i = atomicInteger.get();
            if (i == 0) {
                return false;
            }
            i6 = i - 1000;
        } while (!atomicInteger.compareAndSet(i, Math.max(i6, 0)));
        return i6 > this.f10941b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof L1)) {
            return false;
        }
        L1 l12 = (L1) obj;
        return this.f10940a == l12.f10940a && this.f10942c == l12.f10942c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f10940a), Integer.valueOf(this.f10942c)});
    }
}
