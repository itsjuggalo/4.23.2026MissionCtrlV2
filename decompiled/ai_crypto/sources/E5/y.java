package E5;

import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: loaded from: classes2.dex */
public final class y implements Comparable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f1702b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f1703a;

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public a() {
        }
    }

    public /* synthetic */ y(long j7) {
        this.f1703a = j7;
    }

    public static final /* synthetic */ y a(long j7) {
        return new y(j7);
    }

    public static boolean c(long j7, Object obj) {
        return (obj instanceof y) && j7 == ((y) obj).j();
    }

    public static int h(long j7) {
        return Long.hashCode(j7);
    }

    public static String i(long j7) {
        return G.c(j7, 10);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return G.b(j(), ((y) obj).j());
    }

    public boolean equals(Object obj) {
        return c(this.f1703a, obj);
    }

    public int hashCode() {
        return h(this.f1703a);
    }

    public final /* synthetic */ long j() {
        return this.f1703a;
    }

    public String toString() {
        return i(this.f1703a);
    }

    public static long b(long j7) {
        return j7;
    }
}
