package o5;

import io.flutter.embedding.android.KeyboardMap;
import kotlin.jvm.internal.AbstractC2296k;

/* JADX INFO: loaded from: classes2.dex */
public final class z implements Comparable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f22000b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f22001a;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public /* synthetic */ z(int i8) {
        this.f22001a = i8;
    }

    public static final /* synthetic */ z a(int i8) {
        return new z(i8);
    }

    public static boolean g(int i8, Object obj) {
        return (obj instanceof z) && i8 == ((z) obj).l();
    }

    public static int i(int i8) {
        return Integer.hashCode(i8);
    }

    public static String k(int i8) {
        return String.valueOf(((long) i8) & KeyboardMap.kValueMask);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return AbstractC2472J.a(l(), ((z) obj).l());
    }

    public boolean equals(Object obj) {
        return g(this.f22001a, obj);
    }

    public int hashCode() {
        return i(this.f22001a);
    }

    public final /* synthetic */ int l() {
        return this.f22001a;
    }

    public String toString() {
        return k(this.f22001a);
    }

    public static int b(int i8) {
        return i8;
    }
}
