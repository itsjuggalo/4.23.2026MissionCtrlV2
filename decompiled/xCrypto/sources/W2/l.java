package W2;

import c3.AbstractC0878b;
import c3.InterfaceC0877a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f5480a = new l("SYNCHRONIZED", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l f5481b = new l("PUBLICATION", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final l f5482c = new l("NONE", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ l[] f5483d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC0877a f5484e;

    static {
        l[] lVarArrA = a();
        f5483d = lVarArrA;
        f5484e = AbstractC0878b.a(lVarArrA);
    }

    public l(String str, int i4) {
    }

    public static final /* synthetic */ l[] a() {
        return new l[]{f5480a, f5481b, f5482c};
    }

    public static l valueOf(String str) {
        return (l) Enum.valueOf(l.class, str);
    }

    public static l[] values() {
        return (l[]) f5483d.clone();
    }
}
