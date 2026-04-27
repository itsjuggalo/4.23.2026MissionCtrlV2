package G6;

import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f3353a = new r("STABLE", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r f3354b = new r("UNSTABLE", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ r[] f3355c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f3356d;

    static {
        r[] rVarArrA = a();
        f3355c = rVarArrA;
        f3356d = AbstractC2875b.a(rVarArrA);
    }

    public r(String str, int i8) {
    }

    public static final /* synthetic */ r[] a() {
        return new r[]{f3353a, f3354b};
    }

    public static r valueOf(String str) {
        return (r) Enum.valueOf(r.class, str);
    }

    public static r[] values() {
        return (r[]) f3355c.clone();
    }
}
