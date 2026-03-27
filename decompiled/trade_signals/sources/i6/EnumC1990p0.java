package i6;

import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: i6.p0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class EnumC1990p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnumC1990p0 f18922a = new EnumC1990p0("FLEXIBLE_LOWER", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EnumC1990p0 f18923b = new EnumC1990p0("FLEXIBLE_UPPER", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final EnumC1990p0 f18924c = new EnumC1990p0("INFLEXIBLE", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ EnumC1990p0[] f18925d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f18926e;

    static {
        EnumC1990p0[] enumC1990p0ArrA = a();
        f18925d = enumC1990p0ArrA;
        f18926e = AbstractC2875b.a(enumC1990p0ArrA);
    }

    public EnumC1990p0(String str, int i8) {
    }

    public static final /* synthetic */ EnumC1990p0[] a() {
        return new EnumC1990p0[]{f18922a, f18923b, f18924c};
    }

    public static EnumC1990p0 valueOf(String str) {
        return (EnumC1990p0) Enum.valueOf(EnumC1990p0.class, str);
    }

    public static EnumC1990p0[] values() {
        return (EnumC1990p0[]) f18925d.clone();
    }
}
