package W2;

import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes3.dex */
public final class y implements Comparable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f5508b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f5509a;

    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public a() {
        }
    }

    public /* synthetic */ y(long j4) {
        this.f5509a = j4;
    }

    public static final /* synthetic */ y a(long j4) {
        return new y(j4);
    }

    public static boolean g(long j4, Object obj) {
        return (obj instanceof y) && j4 == ((y) obj).k();
    }

    public static int h(long j4) {
        return Long.hashCode(j4);
    }

    public static String i(long j4) {
        return G.c(j4, 10);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return G.b(k(), ((y) obj).k());
    }

    public boolean equals(Object obj) {
        return g(this.f5509a, obj);
    }

    public int hashCode() {
        return h(this.f5509a);
    }

    public final /* synthetic */ long k() {
        return this.f5509a;
    }

    public String toString() {
        return i(this.f5509a);
    }

    public static long c(long j4) {
        return j4;
    }
}
