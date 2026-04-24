package n5;

import kotlin.jvm.internal.AbstractC2148j;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class K {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f19848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final K f19849c = new K("PLATFORM_ENCODED", 0, 0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final K f19850d = new K("JSON_ENCODED", 1, 1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final K f19851e = new K("UNEXPECTED_STRING", 2, 2);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ K[] f19852f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ K5.a f19853g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19854a;

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public final K a(int i7) {
            for (K k7 : K.values()) {
                if (k7.b() == i7) {
                    return k7;
                }
            }
            return null;
        }

        public a() {
        }
    }

    static {
        K[] kArrA = a();
        f19852f = kArrA;
        f19853g = K5.b.a(kArrA);
        f19848b = new a(null);
    }

    public K(String str, int i7, int i8) {
        this.f19854a = i8;
    }

    public static final /* synthetic */ K[] a() {
        return new K[]{f19849c, f19850d, f19851e};
    }

    public static K valueOf(String str) {
        return (K) Enum.valueOf(K.class, str);
    }

    public static K[] values() {
        return (K[]) f19852f.clone();
    }

    public final int b() {
        return this.f19854a;
    }
}
