package L0;

import kotlin.jvm.internal.AbstractC2296k;

/* JADX INFO: loaded from: classes.dex */
public interface c extends L0.a {

    public static final class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C0068a f4949b = new C0068a(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f4950c = new a("NONE");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f4951d = new a("FULL");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f4952a;

        /* JADX INFO: renamed from: L0.c$a$a, reason: collision with other inner class name */
        public static final class C0068a {
            public C0068a() {
            }

            public /* synthetic */ C0068a(AbstractC2296k abstractC2296k) {
                this();
            }
        }

        public a(String str) {
            this.f4952a = str;
        }

        public String toString() {
            return this.f4952a;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f4953b = new a(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f4954c = new b("FLAT");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f4955d = new b("HALF_OPENED");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f4956a;

        public static final class a {
            public a() {
            }

            public /* synthetic */ a(AbstractC2296k abstractC2296k) {
                this();
            }
        }

        public b(String str) {
            this.f4956a = str;
        }

        public String toString() {
            return this.f4956a;
        }
    }

    a a();

    b b();
}
