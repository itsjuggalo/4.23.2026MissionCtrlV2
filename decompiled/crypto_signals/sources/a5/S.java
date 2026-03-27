package a5;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public abstract class S implements Runnable, Comparable, M {
    private volatile Object _heap;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f4094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4095b = -1;

    public S(long j4) {
        this.f4094a = j4;
    }

    @Override // a5.M
    public final void a() {
        synchronized (this) {
            try {
                Object obj = this._heap;
                f5.t tVar = C.f4075b;
                if (obj == tVar) {
                    return;
                }
                T t6 = obj instanceof T ? (T) obj : null;
                if (t6 != null) {
                    synchronized (t6) {
                        Object obj2 = this._heap;
                        if ((obj2 instanceof f5.v ? (f5.v) obj2 : null) != null) {
                            t6.b(this.f4095b);
                        }
                    }
                }
                this._heap = tVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final int c(long j4, T t6, U u6) {
        synchronized (this) {
            if (this._heap == C.f4075b) {
                return 2;
            }
            synchronized (t6) {
                try {
                    S[] sArr = t6.f6537a;
                    S s6 = sArr != null ? sArr[0] : null;
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = U.f4097k;
                    u6.getClass();
                    if (U.f4099m.get(u6) != 0) {
                        return 1;
                    }
                    if (s6 == null) {
                        t6.f4096c = j4;
                    } else {
                        long j6 = s6.f4094a;
                        if (j6 - j4 < 0) {
                            j4 = j6;
                        }
                        if (j4 - t6.f4096c > 0) {
                            t6.f4096c = j4;
                        }
                    }
                    long j7 = this.f4094a;
                    long j8 = t6.f4096c;
                    if (j7 - j8 < 0) {
                        this.f4094a = j8;
                    }
                    t6.a(this);
                    return 0;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        long j4 = this.f4094a - ((S) obj).f4094a;
        if (j4 > 0) {
            return 1;
        }
        return j4 < 0 ? -1 : 0;
    }

    public final void d(T t6) {
        if (this._heap == C.f4075b) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        this._heap = t6;
    }

    public String toString() {
        return "Delayed[nanos=" + this.f4094a + ']';
    }
}
