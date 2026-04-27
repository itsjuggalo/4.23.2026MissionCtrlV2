package H5;

import kotlin.jvm.internal.AbstractC2296k;
import p5.J;
import w5.AbstractC2927c;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e implements Iterable, C5.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f3964d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f3967c;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public e(long j8, long j9, long j10) {
        if (j10 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j10 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.f3965a = j8;
        this.f3966b = AbstractC2927c.d(j8, j9, j10);
        this.f3967c = j10;
    }

    public final long e() {
        return this.f3965a;
    }

    public final long f() {
        return this.f3966b;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public J iterator() {
        return new f(this.f3965a, this.f3966b, this.f3967c);
    }
}
