package a6;

import kotlin.jvm.internal.AbstractC2296k;
import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class O {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f10080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final O f10081c = new O("IGNORE", 0, "ignore");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final O f10082d = new O("WARN", 1, "warn");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final O f10083e = new O("STRICT", 2, "strict");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ O[] f10084f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f10085g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10086a;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    static {
        O[] oArrA = a();
        f10084f = oArrA;
        f10085g = AbstractC2875b.a(oArrA);
        f10080b = new a(null);
    }

    public O(String str, int i8, String str2) {
        this.f10086a = str2;
    }

    public static final /* synthetic */ O[] a() {
        return new O[]{f10081c, f10082d, f10083e};
    }

    public static O valueOf(String str) {
        return (O) Enum.valueOf(O.class, str);
    }

    public static O[] values() {
        return (O[]) f10084f.clone();
    }

    public final String b() {
        return this.f10086a;
    }

    public final boolean g() {
        return this == f10081c;
    }

    public final boolean i() {
        return this == f10082d;
    }
}
