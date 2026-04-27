package W5;

import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends e implements d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f5457e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final g f5458f = new g(1, 0);

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public final g a() {
            return g.f5458f;
        }

        public a() {
        }
    }

    public g(int i7, int i8) {
        super(i7, i8, 1);
    }

    @Override // W5.e
    public boolean equals(Object obj) {
        if (obj instanceof g) {
            if (!isEmpty() || !((g) obj).isEmpty()) {
                g gVar = (g) obj;
                if (g() != gVar.g() || h() != gVar.h()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // W5.e
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (g() * 31) + h();
    }

    @Override // W5.e, W5.d
    public boolean isEmpty() {
        return g() > h();
    }

    @Override // W5.d
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public Integer c() {
        return Integer.valueOf(h());
    }

    @Override // W5.d
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Integer a() {
        return Integer.valueOf(g());
    }

    @Override // W5.e
    public String toString() {
        return g() + ".." + h();
    }
}
