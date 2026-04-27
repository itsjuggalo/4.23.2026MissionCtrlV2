package Q2;

import O2.e;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Q2.a f3551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f3552b;

    /* JADX INFO: renamed from: Q2.b$b, reason: collision with other inner class name */
    public static class C0059b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Q2.a f3553a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e.b f3554b = new e.b();

        public b c() {
            if (this.f3553a != null) {
                return new b(this);
            }
            throw new IllegalStateException("url == null");
        }

        public C0059b d(String str, String str2) {
            this.f3554b.f(str, str2);
            return this;
        }

        public C0059b e(Q2.a aVar) {
            if (aVar == null) {
                throw new IllegalArgumentException("url == null");
            }
            this.f3553a = aVar;
            return this;
        }
    }

    public e a() {
        return this.f3552b;
    }

    public Q2.a b() {
        return this.f3551a;
    }

    public String toString() {
        return "Request{url=" + this.f3551a + '}';
    }

    public b(C0059b c0059b) {
        this.f3551a = c0059b.f3553a;
        this.f3552b = c0059b.f3554b.c();
    }
}
