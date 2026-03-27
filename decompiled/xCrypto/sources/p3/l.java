package p3;

import c3.AbstractC0878b;
import c3.InterfaceC0877a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f14144a = new l("PUBLIC", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l f14145b = new l("PROTECTED", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final l f14146c = new l("INTERNAL", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final l f14147d = new l("PRIVATE", 3);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ l[] f14148e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC0877a f14149f;

    static {
        l[] lVarArrA = a();
        f14148e = lVarArrA;
        f14149f = AbstractC0878b.a(lVarArrA);
    }

    public l(String str, int i4) {
    }

    public static final /* synthetic */ l[] a() {
        return new l[]{f14144a, f14145b, f14146c, f14147d};
    }

    public static l valueOf(String str) {
        return (l) Enum.valueOf(l.class, str);
    }

    public static l[] values() {
        return (l[]) f14148e.clone();
    }
}
