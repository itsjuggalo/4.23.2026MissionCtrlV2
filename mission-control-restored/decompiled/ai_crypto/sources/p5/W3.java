package p5;

import kotlin.jvm.internal.AbstractC2148j;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class W3 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f21747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final W3 f21748c = new W3("DATE_INVALID", 0, 0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final W3 f21749d = new W3("EXPIRED", 1, 1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final W3 f21750e = new W3("ID_MISMATCH", 2, 2);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final W3 f21751f = new W3("INVALID", 3, 3);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final W3 f21752g = new W3("NOT_YET_VALID", 4, 4);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final W3 f21753h = new W3("UNTRUSTED", 5, 5);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final W3 f21754i = new W3("UNKNOWN", 6, 6);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ W3[] f21755j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ K5.a f21756k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21757a;

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public final W3 a(int i7) {
            for (W3 w32 : W3.values()) {
                if (w32.b() == i7) {
                    return w32;
                }
            }
            return null;
        }

        public a() {
        }
    }

    static {
        W3[] w3ArrA = a();
        f21755j = w3ArrA;
        f21756k = K5.b.a(w3ArrA);
        f21747b = new a(null);
    }

    public W3(String str, int i7, int i8) {
        this.f21757a = i8;
    }

    public static final /* synthetic */ W3[] a() {
        return new W3[]{f21748c, f21749d, f21750e, f21751f, f21752g, f21753h, f21754i};
    }

    public static W3 valueOf(String str) {
        return (W3) Enum.valueOf(W3.class, str);
    }

    public static W3[] values() {
        return (W3[]) f21755j.clone();
    }

    public final int b() {
        return this.f21757a;
    }
}
