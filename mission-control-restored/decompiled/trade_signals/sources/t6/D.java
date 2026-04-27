package t6;

import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final D f23344a = new D("ALL", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final D f23345b = new D("ONLY_NON_SYNTHESIZED", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final D f23346c = new D("NONE", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ D[] f23347d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f23348e;

    static {
        D[] dArrA = a();
        f23347d = dArrA;
        f23348e = AbstractC2875b.a(dArrA);
    }

    public D(String str, int i8) {
    }

    public static final /* synthetic */ D[] a() {
        return new D[]{f23344a, f23345b, f23346c};
    }

    public static D valueOf(String str) {
        return (D) Enum.valueOf(D.class, str);
    }

    public static D[] values() {
        return (D[]) f23347d.clone();
    }
}
