package p5;

import kotlin.jvm.internal.AbstractC2148j;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class U {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f21713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final U f21714c = new U("DEBUG", 0, 0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final U f21715d = new U("ERROR", 1, 1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final U f21716e = new U("LOG", 2, 2);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final U f21717f = new U("TIP", 3, 3);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final U f21718g = new U("WARNING", 4, 4);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final U f21719h = new U("UNKNOWN", 5, 5);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ U[] f21720i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ K5.a f21721j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21722a;

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public final U a(int i7) {
            for (U u7 : U.values()) {
                if (u7.b() == i7) {
                    return u7;
                }
            }
            return null;
        }

        public a() {
        }
    }

    static {
        U[] uArrA = a();
        f21720i = uArrA;
        f21721j = K5.b.a(uArrA);
        f21713b = new a(null);
    }

    public U(String str, int i7, int i8) {
        this.f21722a = i8;
    }

    public static final /* synthetic */ U[] a() {
        return new U[]{f21714c, f21715d, f21716e, f21717f, f21718g, f21719h};
    }

    public static U valueOf(String str) {
        return (U) Enum.valueOf(U.class, str);
    }

    public static U[] values() {
        return (U[]) f21720i.clone();
    }

    public final int b() {
        return this.f21722a;
    }
}
