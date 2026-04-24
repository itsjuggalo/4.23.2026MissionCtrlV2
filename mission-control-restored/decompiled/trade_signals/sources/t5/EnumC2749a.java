package t5;

import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: t5.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class EnumC2749a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnumC2749a f23325a = new EnumC2749a("COROUTINE_SUSPENDED", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EnumC2749a f23326b = new EnumC2749a("UNDECIDED", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final EnumC2749a f23327c = new EnumC2749a("RESUMED", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ EnumC2749a[] f23328d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f23329e;

    static {
        EnumC2749a[] enumC2749aArrA = a();
        f23328d = enumC2749aArrA;
        f23329e = AbstractC2875b.a(enumC2749aArrA);
    }

    public EnumC2749a(String str, int i8) {
    }

    public static final /* synthetic */ EnumC2749a[] a() {
        return new EnumC2749a[]{f23325a, f23326b, f23327c};
    }

    public static EnumC2749a valueOf(String str) {
        return (EnumC2749a) Enum.valueOf(EnumC2749a.class, str);
    }

    public static EnumC2749a[] values() {
        return (EnumC2749a[]) f23328d.clone();
    }
}
