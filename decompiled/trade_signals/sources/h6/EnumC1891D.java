package h6;

import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: h6.D, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class EnumC1891D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnumC1891D f18710a = new EnumC1891D("SOURCE", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EnumC1891D f18711b = new EnumC1891D("BINARY", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumC1891D[] f18712c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f18713d;

    static {
        EnumC1891D[] enumC1891DArrA = a();
        f18712c = enumC1891DArrA;
        f18713d = AbstractC2875b.a(enumC1891DArrA);
    }

    public EnumC1891D(String str, int i8) {
    }

    public static final /* synthetic */ EnumC1891D[] a() {
        return new EnumC1891D[]{f18710a, f18711b};
    }

    public static EnumC1891D valueOf(String str) {
        return (EnumC1891D) Enum.valueOf(EnumC1891D.class, str);
    }

    public static EnumC1891D[] values() {
        return (EnumC1891D[]) f18712c.clone();
    }
}
