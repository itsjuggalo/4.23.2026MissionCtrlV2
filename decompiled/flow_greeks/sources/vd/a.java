package vd;

import dd.p;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements Iterable, qd.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0405a f23376d = new C0405a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char f23377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char f23378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f23379c;

    /* JADX INFO: renamed from: vd.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0405a {
        public /* synthetic */ C0405a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public C0405a() {
        }
    }

    public a(char c10, char c11, int i10) {
        if (i10 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i10 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f23377a = c10;
        this.f23378b = (char) kd.c.c(c10, c11, i10);
        this.f23379c = i10;
    }

    public final char e() {
        return this.f23377a;
    }

    public final char f() {
        return this.f23378b;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public p iterator() {
        return new b(this.f23377a, this.f23378b, this.f23379c);
    }
}
