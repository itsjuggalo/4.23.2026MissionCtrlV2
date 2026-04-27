package a3;

import c3.AbstractC0878b;
import c3.InterfaceC0877a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: a3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class EnumC0785a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnumC0785a f6186a = new EnumC0785a("COROUTINE_SUSPENDED", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EnumC0785a f6187b = new EnumC0785a("UNDECIDED", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final EnumC0785a f6188c = new EnumC0785a("RESUMED", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ EnumC0785a[] f6189d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC0877a f6190e;

    static {
        EnumC0785a[] enumC0785aArrA = a();
        f6189d = enumC0785aArrA;
        f6190e = AbstractC0878b.a(enumC0785aArrA);
    }

    public EnumC0785a(String str, int i4) {
    }

    public static final /* synthetic */ EnumC0785a[] a() {
        return new EnumC0785a[]{f6186a, f6187b, f6188c};
    }

    public static EnumC0785a valueOf(String str) {
        return (EnumC0785a) Enum.valueOf(EnumC0785a.class, str);
    }

    public static EnumC0785a[] values() {
        return (EnumC0785a[]) f6189d.clone();
    }
}
