package H5;

import kotlin.jvm.internal.AbstractC2296k;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends b implements H5.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f3962e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f3963f = new d(1, 0);

    public static final class a {
        public a() {
        }

        public final d a() {
            return d.f3963f;
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public d(int i8, int i9) {
        super(i8, i9, 1);
    }

    @Override // H5.a
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public Integer d() {
        return Integer.valueOf(f());
    }

    @Override // H5.a
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public Integer a() {
        return Integer.valueOf(e());
    }

    @Override // H5.b
    public boolean equals(Object obj) {
        if (obj instanceof d) {
            if (!isEmpty() || !((d) obj).isEmpty()) {
                d dVar = (d) obj;
                if (e() != dVar.e() || f() != dVar.f()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // H5.b
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (e() * 31) + f();
    }

    @Override // H5.b, H5.a
    public boolean isEmpty() {
        return e() > f();
    }

    @Override // H5.b
    public String toString() {
        return e() + ".." + f();
    }
}
