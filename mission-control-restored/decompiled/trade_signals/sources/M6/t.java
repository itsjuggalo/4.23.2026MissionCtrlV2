package M6;

import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t f5438b = new t("IN", 0, "in");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final t f5439c = new t("OUT", 1, "out");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final t f5440d = new t("INV", 2, "");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ t[] f5441e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f5442f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5443a;

    static {
        t[] tVarArrA = a();
        f5441e = tVarArrA;
        f5442f = AbstractC2875b.a(tVarArrA);
    }

    public t(String str, int i8, String str2) {
        this.f5443a = str2;
    }

    public static final /* synthetic */ t[] a() {
        return new t[]{f5438b, f5439c, f5440d};
    }

    public static t valueOf(String str) {
        return (t) Enum.valueOf(t.class, str);
    }

    public static t[] values() {
        return (t[]) f5441e.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f5443a;
    }
}
