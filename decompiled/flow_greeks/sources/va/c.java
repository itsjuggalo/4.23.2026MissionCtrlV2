package va;

import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public interface c {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f23219a = new a("CRASHLYTICS", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f23220b = new a("PERFORMANCE", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f23221c = new a("MATT_SAYS_HI", 2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ a[] f23222d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ jd.a f23223e;

        static {
            a[] aVarArrA = a();
            f23222d = aVarArrA;
            f23223e = jd.b.a(aVarArrA);
        }

        public a(String str, int i10) {
        }

        public static final /* synthetic */ a[] a() {
            return new a[]{f23219a, f23220b, f23221c};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f23222d.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f23224a;

        public b(String sessionId) {
            t.f(sessionId, "sessionId");
            this.f23224a = sessionId;
        }

        public final String a() {
            return this.f23224a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && t.b(this.f23224a, ((b) obj).f23224a);
        }

        public int hashCode() {
            return this.f23224a.hashCode();
        }

        public String toString() {
            return "SessionDetails(sessionId=" + this.f23224a + ')';
        }
    }

    boolean a();

    a b();

    void c(b bVar);
}
