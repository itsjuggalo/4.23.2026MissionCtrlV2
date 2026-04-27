package q6;

import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f22785a = new k("BEGINNING", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k f22786b = new k("MIDDLE", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final k f22787c = new k("AFTER_DOT", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ k[] f22788d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f22789e;

    static {
        k[] kVarArrA = a();
        f22788d = kVarArrA;
        f22789e = AbstractC2875b.a(kVarArrA);
    }

    public k(String str, int i8) {
    }

    public static final /* synthetic */ k[] a() {
        return new k[]{f22785a, f22786b, f22787c};
    }

    public static k valueOf(String str) {
        return (k) Enum.valueOf(k.class, str);
    }

    public static k[] values() {
        return (k[]) f22788d.clone();
    }
}
