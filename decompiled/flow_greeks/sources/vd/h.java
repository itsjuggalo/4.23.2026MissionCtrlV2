package vd;

import dd.k0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class h implements Iterable, qd.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f23396d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f23397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f23398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f23399c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    public h(long j10, long j11, long j12) {
        if (j12 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j12 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.f23397a = j10;
        this.f23398b = kd.c.d(j10, j11, j12);
        this.f23399c = j12;
    }

    public final long e() {
        return this.f23397a;
    }

    public final long f() {
        return this.f23398b;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public k0 iterator() {
        return new i(this.f23397a, this.f23398b, this.f23399c);
    }
}
