package i6;

import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: i6.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class EnumC1975i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnumC1975i f18888a = new EnumC1975i("READ_ONLY", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EnumC1975i f18889b = new EnumC1975i("MUTABLE", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumC1975i[] f18890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f18891d;

    static {
        EnumC1975i[] enumC1975iArrA = a();
        f18890c = enumC1975iArrA;
        f18891d = AbstractC2875b.a(enumC1975iArrA);
    }

    public EnumC1975i(String str, int i8) {
    }

    public static final /* synthetic */ EnumC1975i[] a() {
        return new EnumC1975i[]{f18888a, f18889b};
    }

    public static EnumC1975i valueOf(String str) {
        return (EnumC1975i) Enum.valueOf(EnumC1975i.class, str);
    }

    public static EnumC1975i[] values() {
        return (EnumC1975i[]) f18890c.clone();
    }
}
