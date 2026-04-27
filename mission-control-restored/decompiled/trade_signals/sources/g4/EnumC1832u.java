package g4;

import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: g4.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC1832u implements y3.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EnumC1832u f18220b = new EnumC1832u("LOG_ENVIRONMENT_UNKNOWN", 0, 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final EnumC1832u f18221c = new EnumC1832u("LOG_ENVIRONMENT_AUTOPUSH", 1, 1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final EnumC1832u f18222d = new EnumC1832u("LOG_ENVIRONMENT_STAGING", 2, 2);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final EnumC1832u f18223e = new EnumC1832u("LOG_ENVIRONMENT_PROD", 3, 3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ EnumC1832u[] f18224f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f18225g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18226a;

    static {
        EnumC1832u[] enumC1832uArrA = a();
        f18224f = enumC1832uArrA;
        f18225g = AbstractC2875b.a(enumC1832uArrA);
    }

    public EnumC1832u(String str, int i8, int i9) {
        this.f18226a = i9;
    }

    public static final /* synthetic */ EnumC1832u[] a() {
        return new EnumC1832u[]{f18220b, f18221c, f18222d, f18223e};
    }

    public static EnumC1832u valueOf(String str) {
        return (EnumC1832u) Enum.valueOf(EnumC1832u.class, str);
    }

    public static EnumC1832u[] values() {
        return (EnumC1832u[]) f18224f.clone();
    }

    @Override // y3.f
    public int d() {
        return this.f18226a;
    }
}
