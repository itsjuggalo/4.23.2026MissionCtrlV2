package K4;

import I4.e;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final K4.a f4776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f4777b;

    /* JADX INFO: renamed from: K4.b$b, reason: collision with other inner class name */
    public static class C0067b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public K4.a f4778a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e.b f4779b = new e.b();

        public b c() {
            if (this.f4778a != null) {
                return new b(this);
            }
            throw new IllegalStateException("url == null");
        }

        public C0067b d(String str, String str2) {
            this.f4779b.f(str, str2);
            return this;
        }

        public C0067b e(K4.a aVar) {
            if (aVar == null) {
                throw new IllegalArgumentException("url == null");
            }
            this.f4778a = aVar;
            return this;
        }
    }

    public b(C0067b c0067b) {
        this.f4776a = c0067b.f4778a;
        this.f4777b = c0067b.f4779b.c();
    }

    public e a() {
        return this.f4777b;
    }

    public K4.a b() {
        return this.f4776a;
    }

    public String toString() {
        return "Request{url=" + this.f4776a + '}';
    }
}
