package t6;

import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C f23339a = new C("RENDER_OVERRIDE", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C f23340b = new C("RENDER_OPEN", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C f23341c = new C("RENDER_OPEN_OVERRIDE", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ C[] f23342d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f23343e;

    static {
        C[] cArrA = a();
        f23342d = cArrA;
        f23343e = AbstractC2875b.a(cArrA);
    }

    public C(String str, int i8) {
    }

    public static final /* synthetic */ C[] a() {
        return new C[]{f23339a, f23340b, f23341c};
    }

    public static C valueOf(String str) {
        return (C) Enum.valueOf(C.class, str);
    }

    public static C[] values() {
        return (C[]) f23342d.clone();
    }
}
