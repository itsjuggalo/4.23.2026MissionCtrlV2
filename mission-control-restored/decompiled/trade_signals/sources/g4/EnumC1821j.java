package g4;

import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: g4.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC1821j implements y3.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EnumC1821j f18194b = new EnumC1821j("EVENT_TYPE_UNKNOWN", 0, 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final EnumC1821j f18195c = new EnumC1821j("SESSION_START", 1, 1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ EnumC1821j[] f18196d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f18197e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18198a;

    static {
        EnumC1821j[] enumC1821jArrA = a();
        f18196d = enumC1821jArrA;
        f18197e = AbstractC2875b.a(enumC1821jArrA);
    }

    public EnumC1821j(String str, int i8, int i9) {
        this.f18198a = i9;
    }

    public static final /* synthetic */ EnumC1821j[] a() {
        return new EnumC1821j[]{f18194b, f18195c};
    }

    public static EnumC1821j valueOf(String str) {
        return (EnumC1821j) Enum.valueOf(EnumC1821j.class, str);
    }

    public static EnumC1821j[] values() {
        return (EnumC1821j[]) f18196d.clone();
    }

    @Override // y3.f
    public int d() {
        return this.f18198a;
    }
}
