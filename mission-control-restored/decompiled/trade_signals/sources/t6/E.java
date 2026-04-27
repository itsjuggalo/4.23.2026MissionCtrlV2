package t6;

import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final E f23349a = new E("PRETTY", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final E f23350b = new E("DEBUG", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final E f23351c = new E("NONE", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ E[] f23352d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f23353e;

    static {
        E[] eArrA = a();
        f23352d = eArrA;
        f23353e = AbstractC2875b.a(eArrA);
    }

    public E(String str, int i8) {
    }

    public static final /* synthetic */ E[] a() {
        return new E[]{f23349a, f23350b, f23351c};
    }

    public static E valueOf(String str) {
        return (E) Enum.valueOf(E.class, str);
    }

    public static E[] values() {
        return (E[]) f23352d.clone();
    }
}
