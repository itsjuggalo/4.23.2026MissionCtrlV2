package a4;

import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: a4.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC0892b {

    /* JADX INFO: renamed from: a4.b$a */
    public enum a {
        CRASHLYTICS,
        PERFORMANCE,
        MATT_SAYS_HI
    }

    /* JADX INFO: renamed from: a4.b$b, reason: collision with other inner class name */
    public static final class C0114b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f6314a;

        public C0114b(String sessionId) {
            r.f(sessionId, "sessionId");
            this.f6314a = sessionId;
        }

        public final String a() {
            return this.f6314a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof C0114b) && r.b(this.f6314a, ((C0114b) obj).f6314a);
        }

        public int hashCode() {
            return this.f6314a.hashCode();
        }

        public String toString() {
            return "SessionDetails(sessionId=" + this.f6314a + ')';
        }
    }

    void a(C0114b c0114b);

    boolean b();

    a c();
}
