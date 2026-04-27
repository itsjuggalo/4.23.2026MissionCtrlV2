package H5;

import kotlin.jvm.internal.AbstractC2296k;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends e implements H5.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f3972e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final g f3973f = new g(1, 0);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public g(long j8, long j9) {
        super(j8, j9, 1L);
    }

    @Override // H5.a
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public Long a() {
        return Long.valueOf(e());
    }

    public boolean equals(Object obj) {
        if (obj instanceof g) {
            if (!isEmpty() || !((g) obj).isEmpty()) {
                g gVar = (g) obj;
                if (e() != gVar.e() || f() != gVar.f()) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((((long) 31) * (e() ^ (e() >>> 32))) + (f() ^ (f() >>> 32)));
    }

    @Override // H5.a
    public boolean isEmpty() {
        return e() > f();
    }

    @Override // H5.a
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Long d() {
        return Long.valueOf(f());
    }

    public String toString() {
        return e() + ".." + f();
    }
}
