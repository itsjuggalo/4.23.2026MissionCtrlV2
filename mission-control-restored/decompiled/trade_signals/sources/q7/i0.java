package q7;

import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class i0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i0 f22883c = new i0("OBJ", 0, '{', '}');

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final i0 f22884d = new i0("LIST", 1, '[', ']');

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final i0 f22885e = new i0("MAP", 2, '{', '}');

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final i0 f22886f = new i0("POLY_OBJ", 3, '[', ']');

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ i0[] f22887g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f22888h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char f22889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char f22890b;

    static {
        i0[] i0VarArrA = a();
        f22887g = i0VarArrA;
        f22888h = AbstractC2875b.a(i0VarArrA);
    }

    public i0(String str, int i8, char c8, char c9) {
        this.f22889a = c8;
        this.f22890b = c9;
    }

    public static final /* synthetic */ i0[] a() {
        return new i0[]{f22883c, f22884d, f22885e, f22886f};
    }

    public static InterfaceC2874a b() {
        return f22888h;
    }

    public static i0 valueOf(String str) {
        return (i0) Enum.valueOf(i0.class, str);
    }

    public static i0[] values() {
        return (i0[]) f22887g.clone();
    }
}
