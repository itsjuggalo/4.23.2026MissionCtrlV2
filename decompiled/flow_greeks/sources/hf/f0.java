package hf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f0 f11336a = new f0("PLAIN", 0) { // from class: hf.f0.b
        {
            kotlin.jvm.internal.k kVar = null;
        }

        @Override // hf.f0
        public String b(String string) {
            kotlin.jvm.internal.t.f(string, "string");
            return string;
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f0 f11337b = new f0("HTML", 1) { // from class: hf.f0.a
        {
            kotlin.jvm.internal.k kVar = null;
        }

        @Override // hf.f0
        public String b(String string) {
            kotlin.jvm.internal.t.f(string, "string");
            return kg.z.F(kg.z.F(string, "<", "&lt;", false, 4, null), ">", "&gt;", false, 4, null);
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ f0[] f11338c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ jd.a f11339d;

    static {
        f0[] f0VarArrA = a();
        f11338c = f0VarArrA;
        f11339d = jd.b.a(f0VarArrA);
    }

    public /* synthetic */ f0(String str, int i10, kotlin.jvm.internal.k kVar) {
        this(str, i10);
    }

    public static final /* synthetic */ f0[] a() {
        return new f0[]{f11336a, f11337b};
    }

    public static f0 valueOf(String str) {
        return (f0) Enum.valueOf(f0.class, str);
    }

    public static f0[] values() {
        return (f0[]) f11338c.clone();
    }

    public abstract String b(String str);

    public f0(String str, int i10) {
    }
}
