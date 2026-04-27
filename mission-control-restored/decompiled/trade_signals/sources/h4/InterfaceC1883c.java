package h4;

import kotlin.jvm.internal.AbstractC2304t;
import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX INFO: renamed from: h4.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC1883c {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: renamed from: h4.c$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f18684a = new a("CRASHLYTICS", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f18685b = new a("PERFORMANCE", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f18686c = new a("MATT_SAYS_HI", 2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ a[] f18687d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ InterfaceC2874a f18688e;

        static {
            a[] aVarArrA = a();
            f18687d = aVarArrA;
            f18688e = AbstractC2875b.a(aVarArrA);
        }

        public a(String str, int i8) {
        }

        public static final /* synthetic */ a[] a() {
            return new a[]{f18684a, f18685b, f18686c};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f18687d.clone();
        }
    }

    /* JADX INFO: renamed from: h4.c$b */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f18689a;

        public b(String sessionId) {
            AbstractC2304t.f(sessionId, "sessionId");
            this.f18689a = sessionId;
        }

        public final String a() {
            return this.f18689a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && AbstractC2304t.b(this.f18689a, ((b) obj).f18689a);
        }

        public int hashCode() {
            return this.f18689a.hashCode();
        }

        public String toString() {
            return "SessionDetails(sessionId=" + this.f18689a + ')';
        }
    }

    boolean a();

    a b();

    void c(b bVar);
}
