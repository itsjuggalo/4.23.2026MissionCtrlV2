package x6;

import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: x6.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class EnumC2961b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnumC2961b f24203a = new EnumC2961b("WARNING", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EnumC2961b f24204b = new EnumC2961b("ERROR", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final EnumC2961b f24205c = new EnumC2961b("HIDDEN", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ EnumC2961b[] f24206d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f24207e;

    static {
        EnumC2961b[] enumC2961bArrA = a();
        f24206d = enumC2961bArrA;
        f24207e = AbstractC2875b.a(enumC2961bArrA);
    }

    public EnumC2961b(String str, int i8) {
    }

    public static final /* synthetic */ EnumC2961b[] a() {
        return new EnumC2961b[]{f24203a, f24204b, f24205c};
    }

    public static EnumC2961b valueOf(String str) {
        return (EnumC2961b) Enum.valueOf(EnumC2961b.class, str);
    }

    public static EnumC2961b[] values() {
        return (EnumC2961b[]) f24206d.clone();
    }
}
