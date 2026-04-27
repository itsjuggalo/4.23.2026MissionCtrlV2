package W5;

import F5.F;
import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h implements Iterable, R5.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f5459d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f5460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f5461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f5462c;

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public a() {
        }
    }

    public h(long j7, long j8, long j9) {
        if (j9 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j9 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.f5460a = j7;
        this.f5461b = L5.c.d(j7, j8, j9);
        this.f5462c = j9;
    }

    public final long g() {
        return this.f5460a;
    }

    public final long h() {
        return this.f5461b;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public F iterator() {
        return new i(this.f5460a, this.f5461b, this.f5462c);
    }
}
