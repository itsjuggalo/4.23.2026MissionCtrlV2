package g4;

import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: g4.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC1815d implements y3.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EnumC1815d f18178b = new EnumC1815d("COLLECTION_UNKNOWN", 0, 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final EnumC1815d f18179c = new EnumC1815d("COLLECTION_SDK_NOT_INSTALLED", 1, 1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final EnumC1815d f18180d = new EnumC1815d("COLLECTION_ENABLED", 2, 2);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final EnumC1815d f18181e = new EnumC1815d("COLLECTION_DISABLED", 3, 3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final EnumC1815d f18182f = new EnumC1815d("COLLECTION_DISABLED_REMOTE", 4, 4);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final EnumC1815d f18183g = new EnumC1815d("COLLECTION_SAMPLED", 5, 5);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ EnumC1815d[] f18184h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f18185i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18186a;

    static {
        EnumC1815d[] enumC1815dArrA = a();
        f18184h = enumC1815dArrA;
        f18185i = AbstractC2875b.a(enumC1815dArrA);
    }

    public EnumC1815d(String str, int i8, int i9) {
        this.f18186a = i9;
    }

    public static final /* synthetic */ EnumC1815d[] a() {
        return new EnumC1815d[]{f18178b, f18179c, f18180d, f18181e, f18182f, f18183g};
    }

    public static EnumC1815d valueOf(String str) {
        return (EnumC1815d) Enum.valueOf(EnumC1815d.class, str);
    }

    public static EnumC1815d[] values() {
        return (EnumC1815d[]) f18184h.clone();
    }

    @Override // y3.f
    public int d() {
        return this.f18186a;
    }
}
