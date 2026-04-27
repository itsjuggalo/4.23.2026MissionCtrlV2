package t6;

import kotlin.jvm.internal.AbstractC2296k;
import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: t6.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class EnumC2753a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final EnumC2753a f23358c = new EnumC2753a("NO_ARGUMENTS", 0, false, false, 3, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final EnumC2753a f23359d = new EnumC2753a("UNLESS_EMPTY", 1, true, false, 2, null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final EnumC2753a f23360e = new EnumC2753a("ALWAYS_PARENTHESIZED", 2, true, true);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ EnumC2753a[] f23361f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f23362g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f23363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f23364b;

    static {
        EnumC2753a[] enumC2753aArrA = a();
        f23361f = enumC2753aArrA;
        f23362g = AbstractC2875b.a(enumC2753aArrA);
    }

    public EnumC2753a(String str, int i8, boolean z7, boolean z8) {
        this.f23363a = z7;
        this.f23364b = z8;
    }

    public static final /* synthetic */ EnumC2753a[] a() {
        return new EnumC2753a[]{f23358c, f23359d, f23360e};
    }

    public static EnumC2753a valueOf(String str) {
        return (EnumC2753a) Enum.valueOf(EnumC2753a.class, str);
    }

    public static EnumC2753a[] values() {
        return (EnumC2753a[]) f23361f.clone();
    }

    public final boolean b() {
        return this.f23363a;
    }

    public final boolean g() {
        return this.f23364b;
    }

    public /* synthetic */ EnumC2753a(String str, int i8, boolean z7, boolean z8, int i9, AbstractC2296k abstractC2296k) {
        this(str, i8, (i9 & 1) != 0 ? false : z7, (i9 & 2) != 0 ? false : z8);
    }
}
