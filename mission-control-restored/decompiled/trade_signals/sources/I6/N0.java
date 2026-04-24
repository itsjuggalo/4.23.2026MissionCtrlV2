package I6;

import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class N0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final N0 f4370e = new N0("INVARIANT", 0, "", true, true, 0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final N0 f4371f = new N0("IN_VARIANCE", 1, "in", true, false, -1);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final N0 f4372g = new N0("OUT_VARIANCE", 2, "out", false, true, 1);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ N0[] f4373h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f4374i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f4376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f4377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f4378d;

    static {
        N0[] n0ArrA = a();
        f4373h = n0ArrA;
        f4374i = AbstractC2875b.a(n0ArrA);
    }

    public N0(String str, int i8, String str2, boolean z7, boolean z8, int i9) {
        this.f4375a = str2;
        this.f4376b = z7;
        this.f4377c = z8;
        this.f4378d = i9;
    }

    public static final /* synthetic */ N0[] a() {
        return new N0[]{f4370e, f4371f, f4372g};
    }

    public static N0 valueOf(String str) {
        return (N0) Enum.valueOf(N0.class, str);
    }

    public static N0[] values() {
        return (N0[]) f4373h.clone();
    }

    public final boolean b() {
        return this.f4377c;
    }

    public final String g() {
        return this.f4375a;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f4375a;
    }
}
