package I6;

import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class I0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final I0 f4352a = new I0("SUPERTYPE", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final I0 f4353b = new I0("COMMON", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ I0[] f4354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f4355d;

    static {
        I0[] i0ArrA = a();
        f4354c = i0ArrA;
        f4355d = AbstractC2875b.a(i0ArrA);
    }

    public I0(String str, int i8) {
    }

    public static final /* synthetic */ I0[] a() {
        return new I0[]{f4352a, f4353b};
    }

    public static I0 valueOf(String str) {
        return (I0) Enum.valueOf(I0.class, str);
    }

    public static I0[] values() {
        return (I0[]) f4354c.clone();
    }
}
