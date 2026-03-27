package x5;

import v5.e;

/* JADX INFO: renamed from: x5.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2828b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2827a f25321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f25322b;

    /* JADX INFO: renamed from: x5.b$b, reason: collision with other inner class name */
    public static class C0392b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public C2827a f25323a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e.b f25324b = new e.b();

        public C2828b c() {
            if (this.f25323a != null) {
                return new C2828b(this);
            }
            throw new IllegalStateException("url == null");
        }

        public C0392b d(String str, String str2) {
            this.f25324b.f(str, str2);
            return this;
        }

        public C0392b e(C2827a c2827a) {
            if (c2827a == null) {
                throw new IllegalArgumentException("url == null");
            }
            this.f25323a = c2827a;
            return this;
        }
    }

    public e a() {
        return this.f25322b;
    }

    public C2827a b() {
        return this.f25321a;
    }

    public String toString() {
        return "Request{url=" + this.f25321a + '}';
    }

    public C2828b(C0392b c0392b) {
        this.f25321a = c0392b.f25323a;
        this.f25322b = c0392b.f25324b.c();
    }
}
