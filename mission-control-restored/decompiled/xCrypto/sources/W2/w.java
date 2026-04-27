package W2;

import io.flutter.embedding.android.KeyboardMap;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes3.dex */
public final class w implements Comparable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f5503b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5504a;

    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public a() {
        }
    }

    public /* synthetic */ w(int i4) {
        this.f5504a = i4;
    }

    public static final /* synthetic */ w a(int i4) {
        return new w(i4);
    }

    public static boolean g(int i4, Object obj) {
        return (obj instanceof w) && i4 == ((w) obj).k();
    }

    public static int h(int i4) {
        return Integer.hashCode(i4);
    }

    public static String i(int i4) {
        return String.valueOf(((long) i4) & KeyboardMap.kValueMask);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return G.a(k(), ((w) obj).k());
    }

    public boolean equals(Object obj) {
        return g(this.f5504a, obj);
    }

    public int hashCode() {
        return h(this.f5504a);
    }

    public final /* synthetic */ int k() {
        return this.f5504a;
    }

    public String toString() {
        return i(this.f5504a);
    }

    public static int c(int i4) {
        return i4;
    }
}
