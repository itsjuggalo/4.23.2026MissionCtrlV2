package I5;

import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f4306a = new u("PUBLIC", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final u f4307b = new u("PROTECTED", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final u f4308c = new u("INTERNAL", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final u f4309d = new u("PRIVATE", 3);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ u[] f4310e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f4311f;

    static {
        u[] uVarArrA = a();
        f4310e = uVarArrA;
        f4311f = AbstractC2875b.a(uVarArrA);
    }

    public u(String str, int i8) {
    }

    public static final /* synthetic */ u[] a() {
        return new u[]{f4306a, f4307b, f4308c, f4309d};
    }

    public static u valueOf(String str) {
        return (u) Enum.valueOf(u.class, str);
    }

    public static u[] values() {
        return (u[]) f4310e.clone();
    }
}
