package hf;

import java.util.ArrayList;
import java.util.Set;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f11373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set f11374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set f11375d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final v f11376e = new v("VISIBILITY", 0, true);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final v f11377f = new v("MODALITY", 1, true);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final v f11378g = new v("OVERRIDE", 2, true);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final v f11379h = new v("ANNOTATIONS", 3, false);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final v f11380i = new v("INNER", 4, true);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final v f11381j = new v("MEMBER_KIND", 5, true);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final v f11382k = new v("DATA", 6, true);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final v f11383l = new v("INLINE", 7, true);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final v f11384m = new v("EXPECT", 8, true);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final v f11385n = new v("ACTUAL", 9, true);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final v f11386o = new v("CONST", 10, true);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final v f11387p = new v("LATEINIT", 11, true);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final v f11388q = new v("FUN", 12, true);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final v f11389r = new v("VALUE", 13, true);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ v[] f11390s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ jd.a f11391t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f11392a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    static {
        v[] vVarArrA = a();
        f11390s = vVarArrA;
        f11391t = jd.b.a(vVarArrA);
        f11373b = new a(null);
        v[] vVarArrValues = values();
        ArrayList arrayList = new ArrayList();
        for (v vVar : vVarArrValues) {
            if (vVar.f11392a) {
                arrayList.add(vVar);
            }
        }
        f11374c = dd.a0.N0(arrayList);
        f11375d = dd.n.L0(values());
    }

    public v(String str, int i10, boolean z10) {
        this.f11392a = z10;
    }

    public static final /* synthetic */ v[] a() {
        return new v[]{f11376e, f11377f, f11378g, f11379h, f11380i, f11381j, f11382k, f11383l, f11384m, f11385n, f11386o, f11387p, f11388q, f11389r};
    }

    public static v valueOf(String str) {
        return (v) Enum.valueOf(v.class, str);
    }

    public static v[] values() {
        return (v[]) f11390s.clone();
    }
}
