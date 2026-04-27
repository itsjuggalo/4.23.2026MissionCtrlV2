package o5;

import kotlin.jvm.internal.AbstractC2296k;

/* JADX INFO: renamed from: o5.B, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2464B implements Comparable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f21945b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f21946a;

    /* JADX INFO: renamed from: o5.B$a */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public /* synthetic */ C2464B(long j8) {
        this.f21946a = j8;
    }

    public static final /* synthetic */ C2464B a(long j8) {
        return new C2464B(j8);
    }

    public static boolean g(long j8, Object obj) {
        return (obj instanceof C2464B) && j8 == ((C2464B) obj).l();
    }

    public static int i(long j8) {
        return Long.hashCode(j8);
    }

    public static String k(long j8) {
        return AbstractC2472J.c(j8, 10);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return AbstractC2472J.b(l(), ((C2464B) obj).l());
    }

    public boolean equals(Object obj) {
        return g(this.f21946a, obj);
    }

    public int hashCode() {
        return i(this.f21946a);
    }

    public final /* synthetic */ long l() {
        return this.f21946a;
    }

    public String toString() {
        return k(this.f21946a);
    }

    public static long b(long j8) {
        return j8;
    }
}
