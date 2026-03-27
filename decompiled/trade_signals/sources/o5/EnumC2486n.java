package o5;

import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: o5.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class EnumC2486n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnumC2486n f21974a = new EnumC2486n("SYNCHRONIZED", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EnumC2486n f21975b = new EnumC2486n("PUBLICATION", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final EnumC2486n f21976c = new EnumC2486n("NONE", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ EnumC2486n[] f21977d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f21978e;

    static {
        EnumC2486n[] enumC2486nArrA = a();
        f21977d = enumC2486nArrA;
        f21978e = AbstractC2875b.a(enumC2486nArrA);
    }

    public EnumC2486n(String str, int i8) {
    }

    public static final /* synthetic */ EnumC2486n[] a() {
        return new EnumC2486n[]{f21974a, f21975b, f21976c};
    }

    public static EnumC2486n valueOf(String str) {
        return (EnumC2486n) Enum.valueOf(EnumC2486n.class, str);
    }

    public static EnumC2486n[] values() {
        return (EnumC2486n[]) f21977d.clone();
    }
}
