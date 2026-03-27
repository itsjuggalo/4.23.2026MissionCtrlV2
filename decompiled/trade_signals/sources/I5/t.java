package I5;

import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f4301a = new t("INVARIANT", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t f4302b = new t("IN", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final t f4303c = new t("OUT", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ t[] f4304d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f4305e;

    static {
        t[] tVarArrA = a();
        f4304d = tVarArrA;
        f4305e = AbstractC2875b.a(tVarArrA);
    }

    public t(String str, int i8) {
    }

    public static final /* synthetic */ t[] a() {
        return new t[]{f4301a, f4302b, f4303c};
    }

    public static t valueOf(String str) {
        return (t) Enum.valueOf(t.class, str);
    }

    public static t[] values() {
        return (t[]) f4304d.clone();
    }
}
