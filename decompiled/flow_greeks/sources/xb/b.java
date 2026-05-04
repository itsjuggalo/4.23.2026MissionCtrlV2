package xb;

import vb.e;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xb.a f24788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f24789b;

    /* JADX INFO: renamed from: xb.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class C0451b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public xb.a f24790a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e.b f24791b = new e.b();

        public b c() {
            if (this.f24790a != null) {
                return new b(this);
            }
            throw new IllegalStateException("url == null");
        }

        public C0451b d(String str, String str2) {
            this.f24791b.f(str, str2);
            return this;
        }

        public C0451b e(xb.a aVar) {
            if (aVar == null) {
                throw new IllegalArgumentException("url == null");
            }
            this.f24790a = aVar;
            return this;
        }
    }

    public e a() {
        return this.f24789b;
    }

    public xb.a b() {
        return this.f24788a;
    }

    public String toString() {
        return "Request{url=" + this.f24788a + '}';
    }

    public b(C0451b c0451b) {
        this.f24788a = c0451b.f24790a;
        this.f24789b = c0451b.f24791b.c();
    }
}
