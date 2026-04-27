package W5;

import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends h implements d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f5467e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final j f5468f = new j(1, 0);

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public a() {
        }
    }

    public j(long j7, long j8) {
        super(j7, j8, 1L);
    }

    public boolean equals(Object obj) {
        if (obj instanceof j) {
            if (!isEmpty() || !((j) obj).isEmpty()) {
                j jVar = (j) obj;
                if (g() != jVar.g() || h() != jVar.h()) {
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
        return (int) ((((long) 31) * (g() ^ (g() >>> 32))) + (h() ^ (h() >>> 32)));
    }

    @Override // W5.d
    public boolean isEmpty() {
        return g() > h();
    }

    @Override // W5.d
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public Long c() {
        return Long.valueOf(h());
    }

    @Override // W5.d
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public Long a() {
        return Long.valueOf(g());
    }

    public String toString() {
        return g() + ".." + h();
    }
}
