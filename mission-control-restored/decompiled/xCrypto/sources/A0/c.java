package A0;

import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes.dex */
public interface c extends A0.a {

    public static final class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C0001a f4b = new C0001a(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f5c = new a("NONE");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f6d = new a("FULL");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7a;

        /* JADX INFO: renamed from: A0.c$a$a, reason: collision with other inner class name */
        public static final class C0001a {
            public /* synthetic */ C0001a(AbstractC1585j abstractC1585j) {
                this();
            }

            public C0001a() {
            }
        }

        public a(String str) {
            this.f7a = str;
        }

        public String toString() {
            return this.f7a;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f8b = new a(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f9c = new b("FLAT");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f10d = new b("HALF_OPENED");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f11a;

        public static final class a {
            public /* synthetic */ a(AbstractC1585j abstractC1585j) {
                this();
            }

            public a() {
            }
        }

        public b(String str) {
            this.f11a = str;
        }

        public String toString() {
            return this.f11a;
        }
    }

    a b();

    b c();
}
