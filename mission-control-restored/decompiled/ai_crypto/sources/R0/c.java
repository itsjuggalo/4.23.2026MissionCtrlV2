package R0;

import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: loaded from: classes.dex */
public interface c extends R0.a {

    public static final class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C0076a f4625b = new C0076a(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f4626c = new a("NONE");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f4627d = new a("FULL");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f4628a;

        /* JADX INFO: renamed from: R0.c$a$a, reason: collision with other inner class name */
        public static final class C0076a {
            public /* synthetic */ C0076a(AbstractC2148j abstractC2148j) {
                this();
            }

            public C0076a() {
            }
        }

        public a(String str) {
            this.f4628a = str;
        }

        public String toString() {
            return this.f4628a;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f4629b = new a(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f4630c = new b("FLAT");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f4631d = new b("HALF_OPENED");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f4632a;

        public static final class a {
            public /* synthetic */ a(AbstractC2148j abstractC2148j) {
                this();
            }

            public a() {
            }
        }

        public b(String str) {
            this.f4632a = str;
        }

        public String toString() {
            return this.f4632a;
        }
    }

    a b();

    b getState();
}
