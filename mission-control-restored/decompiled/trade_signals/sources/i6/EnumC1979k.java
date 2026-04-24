package i6;

import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: i6.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class EnumC1979k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnumC1979k f18895a = new EnumC1979k("FORCE_FLEXIBILITY", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EnumC1979k f18896b = new EnumC1979k("NULLABLE", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final EnumC1979k f18897c = new EnumC1979k("NOT_NULL", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ EnumC1979k[] f18898d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f18899e;

    static {
        EnumC1979k[] enumC1979kArrA = a();
        f18898d = enumC1979kArrA;
        f18899e = AbstractC2875b.a(enumC1979kArrA);
    }

    public EnumC1979k(String str, int i8) {
    }

    public static final /* synthetic */ EnumC1979k[] a() {
        return new EnumC1979k[]{f18895a, f18896b, f18897c};
    }

    public static EnumC1979k valueOf(String str) {
        return (EnumC1979k) Enum.valueOf(EnumC1979k.class, str);
    }

    public static EnumC1979k[] values() {
        return (EnumC1979k[]) f18898d.clone();
    }
}
