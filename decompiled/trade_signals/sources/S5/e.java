package S5;

import kotlin.jvm.internal.AbstractC2296k;
import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f7645b = new e("FIELD", 0, null, 1, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f7646c = new e("FILE", 1, null, 1, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e f7647d = new e("PROPERTY", 2, null, 1, null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f7648e = new e("PROPERTY_GETTER", 3, com.amazon.a.a.o.b.au);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f7649f = new e("PROPERTY_SETTER", 4, "set");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final e f7650g = new e("RECEIVER", 5, null, 1, null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final e f7651h = new e("CONSTRUCTOR_PARAMETER", 6, "param");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final e f7652i = new e("SETTER_PARAMETER", 7, "setparam");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final e f7653j = new e("PROPERTY_DELEGATE_FIELD", 8, "delegate");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ e[] f7654k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f7655l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7656a;

    static {
        e[] eVarArrA = a();
        f7654k = eVarArrA;
        f7655l = AbstractC2875b.a(eVarArrA);
    }

    public e(String str, int i8, String str2) {
        this.f7656a = str2 == null ? Q6.a.f(name()) : str2;
    }

    public static final /* synthetic */ e[] a() {
        return new e[]{f7645b, f7646c, f7647d, f7648e, f7649f, f7650g, f7651h, f7652i, f7653j};
    }

    public static e valueOf(String str) {
        return (e) Enum.valueOf(e.class, str);
    }

    public static e[] values() {
        return (e[]) f7654k.clone();
    }

    public final String b() {
        return this.f7656a;
    }

    public /* synthetic */ e(String str, int i8, String str2, int i9, AbstractC2296k abstractC2296k) {
        this(str, i8, (i9 & 1) != 0 ? null : str2);
    }
}
