package p5;

import kotlin.jvm.internal.AbstractC2148j;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: p5.p0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class EnumC2480p0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f21937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final EnumC2480p0 f21938c = new EnumC2480p0("ALWAYS", 0, 0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final EnumC2480p0 f21939d = new EnumC2480p0("IF_CONTENT_SCROLLS", 1, 1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final EnumC2480p0 f21940e = new EnumC2480p0("NEVER", 2, 2);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final EnumC2480p0 f21941f = new EnumC2480p0("UNKNOWN", 3, 3);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ EnumC2480p0[] f21942g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ K5.a f21943h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21944a;

    /* JADX INFO: renamed from: p5.p0$a */
    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public final EnumC2480p0 a(int i7) {
            for (EnumC2480p0 enumC2480p0 : EnumC2480p0.values()) {
                if (enumC2480p0.b() == i7) {
                    return enumC2480p0;
                }
            }
            return null;
        }

        public a() {
        }
    }

    static {
        EnumC2480p0[] enumC2480p0ArrA = a();
        f21942g = enumC2480p0ArrA;
        f21943h = K5.b.a(enumC2480p0ArrA);
        f21937b = new a(null);
    }

    public EnumC2480p0(String str, int i7, int i8) {
        this.f21944a = i8;
    }

    public static final /* synthetic */ EnumC2480p0[] a() {
        return new EnumC2480p0[]{f21938c, f21939d, f21940e, f21941f};
    }

    public static EnumC2480p0 valueOf(String str) {
        return (EnumC2480p0) Enum.valueOf(EnumC2480p0.class, str);
    }

    public static EnumC2480p0[] values() {
        return (EnumC2480p0[]) f21942g.clone();
    }

    public final int b() {
        return this.f21944a;
    }
}
