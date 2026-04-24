package p5;

import kotlin.jvm.internal.AbstractC2148j;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: p5.d0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class EnumC2401d0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f21852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final EnumC2401d0 f21853c = new EnumC2401d0("OPEN", 0, 0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final EnumC2401d0 f21854d = new EnumC2401d0("OPEN_MULTIPLE", 1, 1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final EnumC2401d0 f21855e = new EnumC2401d0("SAVE", 2, 2);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final EnumC2401d0 f21856f = new EnumC2401d0("UNKNOWN", 3, 3);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ EnumC2401d0[] f21857g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ K5.a f21858h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21859a;

    /* JADX INFO: renamed from: p5.d0$a */
    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public final EnumC2401d0 a(int i7) {
            for (EnumC2401d0 enumC2401d0 : EnumC2401d0.values()) {
                if (enumC2401d0.b() == i7) {
                    return enumC2401d0;
                }
            }
            return null;
        }

        public a() {
        }
    }

    static {
        EnumC2401d0[] enumC2401d0ArrA = a();
        f21857g = enumC2401d0ArrA;
        f21858h = K5.b.a(enumC2401d0ArrA);
        f21852b = new a(null);
    }

    public EnumC2401d0(String str, int i7, int i8) {
        this.f21859a = i8;
    }

    public static final /* synthetic */ EnumC2401d0[] a() {
        return new EnumC2401d0[]{f21853c, f21854d, f21855e, f21856f};
    }

    public static EnumC2401d0 valueOf(String str) {
        return (EnumC2401d0) Enum.valueOf(EnumC2401d0.class, str);
    }

    public static EnumC2401d0[] values() {
        return (EnumC2401d0[]) f21857g.clone();
    }

    public final int b() {
        return this.f21859a;
    }
}
