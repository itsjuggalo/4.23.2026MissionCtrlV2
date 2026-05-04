package wd;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public interface l extends b {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f23902a = new a("INSTANCE", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f23903b = new a("EXTENSION_RECEIVER", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f23904c = new a("VALUE", 2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ a[] f23905d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ jd.a f23906e;

        static {
            a[] aVarArrA = a();
            f23905d = aVarArrA;
            f23906e = jd.b.a(aVarArrA);
        }

        public a(String str, int i10) {
        }

        public static final /* synthetic */ a[] a() {
            return new a[]{f23902a, f23903b, f23904c};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f23905d.clone();
        }
    }

    boolean a();

    int getIndex();

    String getName();

    q getType();

    a h();

    boolean p();
}
