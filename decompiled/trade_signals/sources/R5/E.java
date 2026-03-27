package R5;

import kotlin.jvm.internal.AbstractC2296k;
import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f7196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final E f7197b = new E("FINAL", 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final E f7198c = new E("SEALED", 1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final E f7199d = new E("OPEN", 2);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final E f7200e = new E("ABSTRACT", 3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ E[] f7201f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f7202g;

    public static final class a {
        public a() {
        }

        public final E a(boolean z7, boolean z8, boolean z9) {
            return z7 ? E.f7198c : z8 ? E.f7200e : z9 ? E.f7199d : E.f7197b;
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    static {
        E[] eArrA = a();
        f7201f = eArrA;
        f7202g = AbstractC2875b.a(eArrA);
        f7196a = new a(null);
    }

    public E(String str, int i8) {
    }

    public static final /* synthetic */ E[] a() {
        return new E[]{f7197b, f7198c, f7199d, f7200e};
    }

    public static E valueOf(String str) {
        return (E) Enum.valueOf(E.class, str);
    }

    public static E[] values() {
        return (E[]) f7201f.clone();
    }
}
