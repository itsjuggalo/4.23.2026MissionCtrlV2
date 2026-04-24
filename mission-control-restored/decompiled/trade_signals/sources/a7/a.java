package a7;

import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10173a = new a("SUSPEND", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f10174b = new a("DROP_OLDEST", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f10175c = new a("DROP_LATEST", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ a[] f10176d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f10177e;

    static {
        a[] aVarArrA = a();
        f10176d = aVarArrA;
        f10177e = AbstractC2875b.a(aVarArrA);
    }

    public a(String str, int i8) {
    }

    public static final /* synthetic */ a[] a() {
        return new a[]{f10173a, f10174b, f10175c};
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f10176d.clone();
    }
}
