package o3;

import X2.H;
import j3.InterfaceC1564a;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: renamed from: o3.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1677h implements Iterable, InterfaceC1564a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f13944d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f13945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f13946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f13947c;

    /* JADX INFO: renamed from: o3.h$a */
    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public a() {
        }
    }

    public AbstractC1677h(long j4, long j5, long j6) {
        if (j6 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j6 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.f13945a = j4;
        this.f13946b = d3.c.d(j4, j5, j6);
        this.f13947c = j6;
    }

    public final long k() {
        return this.f13945a;
    }

    public final long l() {
        return this.f13946b;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public H iterator() {
        return new C1678i(this.f13945a, this.f13946b, this.f13947c);
    }
}
