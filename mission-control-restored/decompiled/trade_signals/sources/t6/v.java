package t6;

import java.util.ArrayList;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2296k;
import p5.AbstractC2592n;
import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f23405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set f23406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set f23407d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final v f23408e = new v("VISIBILITY", 0, true);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final v f23409f = new v("MODALITY", 1, true);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final v f23410g = new v("OVERRIDE", 2, true);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final v f23411h = new v("ANNOTATIONS", 3, false);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final v f23412i = new v("INNER", 4, true);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final v f23413j = new v("MEMBER_KIND", 5, true);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final v f23414k = new v("DATA", 6, true);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final v f23415l = new v("INLINE", 7, true);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final v f23416m = new v("EXPECT", 8, true);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final v f23417n = new v("ACTUAL", 9, true);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final v f23418o = new v("CONST", 10, true);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final v f23419p = new v("LATEINIT", 11, true);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final v f23420q = new v("FUN", 12, true);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final v f23421r = new v("VALUE", 13, true);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ v[] f23422s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f23423t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f23424a;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    static {
        v[] vVarArrA = a();
        f23422s = vVarArrA;
        f23423t = AbstractC2875b.a(vVarArrA);
        f23405b = new a(null);
        v[] vVarArrValues = values();
        ArrayList arrayList = new ArrayList();
        for (v vVar : vVarArrValues) {
            if (vVar.f23424a) {
                arrayList.add(vVar);
            }
        }
        f23406c = p5.z.K0(arrayList);
        f23407d = AbstractC2592n.w0(values());
    }

    public v(String str, int i8, boolean z7) {
        this.f23424a = z7;
    }

    public static final /* synthetic */ v[] a() {
        return new v[]{f23408e, f23409f, f23410g, f23411h, f23412i, f23413j, f23414k, f23415l, f23416m, f23417n, f23418o, f23419p, f23420q, f23421r};
    }

    public static v valueOf(String str) {
        return (v) Enum.valueOf(v.class, str);
    }

    public static v[] values() {
        return (v[]) f23422s.clone();
    }
}
