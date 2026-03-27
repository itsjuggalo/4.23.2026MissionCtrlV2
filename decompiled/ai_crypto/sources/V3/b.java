package V3;

import U3.K;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f5305b = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V3.a f5306a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public V3.a f5307a = null;

        public b a() {
            return new b(this.f5307a);
        }

        public a b(V3.a aVar) {
            this.f5307a = aVar;
            return this;
        }
    }

    public b(V3.a aVar) {
        this.f5306a = aVar;
    }

    public static a b() {
        return new a();
    }

    public V3.a a() {
        return this.f5306a;
    }

    public byte[] c() {
        return K.a(this);
    }
}
