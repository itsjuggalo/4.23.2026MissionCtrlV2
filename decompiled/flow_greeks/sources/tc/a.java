package tc;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import lc.h;
import xc.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends AtomicReferenceArray implements h {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Integer f21877f = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicLong f21879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f21880c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicLong f21881d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f21882e;

    public a(int i10) {
        super(k.a(i10));
        this.f21878a = length() - 1;
        this.f21879b = new AtomicLong();
        this.f21881d = new AtomicLong();
        this.f21882e = Math.min(i10 / 4, f21877f.intValue());
    }

    public int a(long j10) {
        return ((int) j10) & this.f21878a;
    }

    public int b(long j10, int i10) {
        return ((int) j10) & i10;
    }

    public Object c(int i10) {
        return get(i10);
    }

    @Override // lc.i
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public void d(long j10) {
        this.f21881d.lazySet(j10);
    }

    public void e(int i10, Object obj) {
        lazySet(i10, obj);
    }

    public void f(long j10) {
        this.f21879b.lazySet(j10);
    }

    @Override // lc.i
    public boolean isEmpty() {
        return this.f21879b.get() == this.f21881d.get();
    }

    @Override // lc.i
    public boolean offer(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        int i10 = this.f21878a;
        long j10 = this.f21879b.get();
        int iB = b(j10, i10);
        if (j10 >= this.f21880c) {
            long j11 = ((long) this.f21882e) + j10;
            if (c(b(j11, i10)) == null) {
                this.f21880c = j11;
            } else if (c(iB) != null) {
                return false;
            }
        }
        e(iB, obj);
        f(j10 + 1);
        return true;
    }

    @Override // lc.h, lc.i
    public Object poll() {
        long j10 = this.f21881d.get();
        int iA = a(j10);
        Object objC = c(iA);
        if (objC == null) {
            return null;
        }
        d(j10 + 1);
        e(iA, null);
        return objC;
    }
}
