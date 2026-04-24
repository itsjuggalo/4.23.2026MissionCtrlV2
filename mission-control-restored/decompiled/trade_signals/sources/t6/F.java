package t6;

import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public abstract class F {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final F f23354a = new F("PLAIN", 0) { // from class: t6.F.b
        {
            AbstractC2296k abstractC2296k = null;
        }

        @Override // t6.F
        public String b(String string) {
            AbstractC2304t.f(string, "string");
            return string;
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final F f23355b = new F("HTML", 1) { // from class: t6.F.a
        {
            AbstractC2296k abstractC2296k = null;
        }

        @Override // t6.F
        public String b(String string) {
            AbstractC2304t.f(string, "string");
            return V6.A.E(V6.A.E(string, "<", "&lt;", false, 4, null), ">", "&gt;", false, 4, null);
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ F[] f23356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f23357d;

    static {
        F[] fArrA = a();
        f23356c = fArrA;
        f23357d = AbstractC2875b.a(fArrA);
    }

    public F(String str, int i8) {
    }

    public static final /* synthetic */ F[] a() {
        return new F[]{f23354a, f23355b};
    }

    public static F valueOf(String str) {
        return (F) Enum.valueOf(F.class, str);
    }

    public static F[] values() {
        return (F[]) f23356c.clone();
    }

    public abstract String b(String str);

    public /* synthetic */ F(String str, int i8, AbstractC2296k abstractC2296k) {
        this(str, i8);
    }
}
