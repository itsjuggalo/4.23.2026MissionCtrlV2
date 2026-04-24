package I5;

import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX INFO: loaded from: classes2.dex */
public interface l extends b {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f4291a = new a("INSTANCE", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f4292b = new a("EXTENSION_RECEIVER", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f4293c = new a("VALUE", 2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ a[] f4294d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ InterfaceC2874a f4295e;

        static {
            a[] aVarArrA = a();
            f4294d = aVarArrA;
            f4295e = AbstractC2875b.a(aVarArrA);
        }

        public a(String str, int i8) {
        }

        public static final /* synthetic */ a[] a() {
            return new a[]{f4291a, f4292b, f4293c};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f4294d.clone();
        }
    }

    int g();

    String getName();

    q getType();

    a i();

    boolean j();

    boolean k();
}
