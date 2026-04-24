package S5;

import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f7679a = new q("RUNTIME", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q f7680b = new q("BINARY", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q f7681c = new q("SOURCE", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ q[] f7682d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f7683e;

    static {
        q[] qVarArrA = a();
        f7682d = qVarArrA;
        f7683e = AbstractC2875b.a(qVarArrA);
    }

    public q(String str, int i8) {
    }

    public static final /* synthetic */ q[] a() {
        return new q[]{f7679a, f7680b, f7681c};
    }

    public static q valueOf(String str) {
        return (q) Enum.valueOf(q.class, str);
    }

    public static q[] values() {
        return (q[]) f7682d.clone();
    }
}
