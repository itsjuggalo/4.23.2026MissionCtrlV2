package f5;

import Y4.i;
import j5.k;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: renamed from: f5.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1758a extends AtomicReferenceArray implements i {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Integer f17549f = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicLong f17551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f17552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicLong f17553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f17554e;

    public C1758a(int i8) {
        super(k.a(i8));
        this.f17550a = length() - 1;
        this.f17551b = new AtomicLong();
        this.f17553d = new AtomicLong();
        this.f17554e = Math.min(i8 / 4, f17549f.intValue());
    }

    public int a(long j8) {
        return ((int) j8) & this.f17550a;
    }

    public int b(long j8, int i8) {
        return ((int) j8) & i8;
    }

    public Object c(int i8) {
        return get(i8);
    }

    @Override // Y4.j
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public void d(long j8) {
        this.f17553d.lazySet(j8);
    }

    public void e(int i8, Object obj) {
        lazySet(i8, obj);
    }

    public void f(long j8) {
        this.f17551b.lazySet(j8);
    }

    @Override // Y4.j
    public boolean isEmpty() {
        return this.f17551b.get() == this.f17553d.get();
    }

    @Override // Y4.j
    public boolean offer(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        int i8 = this.f17550a;
        long j8 = this.f17551b.get();
        int iB = b(j8, i8);
        if (j8 >= this.f17552c) {
            long j9 = ((long) this.f17554e) + j8;
            if (c(b(j9, i8)) == null) {
                this.f17552c = j9;
            } else if (c(iB) != null) {
                return false;
            }
        }
        e(iB, obj);
        f(j8 + 1);
        return true;
    }

    @Override // Y4.i, Y4.j
    public Object poll() {
        long j8 = this.f17553d.get();
        int iA = a(j8);
        Object objC = c(iA);
        if (objC == null) {
            return null;
        }
        d(j8 + 1);
        e(iA, null);
        return objC;
    }
}
