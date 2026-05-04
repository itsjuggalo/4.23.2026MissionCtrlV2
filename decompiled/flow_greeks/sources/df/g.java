package df;

import cf.a;
import dd.a0;
import dd.g0;
import dd.n0;
import dd.r;
import dd.s;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import vd.l;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g implements bf.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f8103d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f8104e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final List f8105f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Map f8106g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f8107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f8108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f8109c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(k kVar) {
            this();
        }

        public a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8110a;

        static {
            int[] iArr = new int[a.e.c.EnumC0076c.values().length];
            try {
                iArr[a.e.c.EnumC0076c.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[a.e.c.EnumC0076c.INTERNAL_TO_CLASS_ID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[a.e.c.EnumC0076c.DESC_TO_CLASS_ID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f8110a = iArr;
        }
    }

    static {
        String strI0 = a0.i0(r.n('k', 'o', 't', 'l', 'i', 'n'), "", null, null, 0, null, null, 62, null);
        f8104e = strI0;
        List listN = r.n(strI0 + "/Any", strI0 + "/Nothing", strI0 + "/Unit", strI0 + "/Throwable", strI0 + "/Number", strI0 + "/Byte", strI0 + "/Double", strI0 + "/Float", strI0 + "/Int", strI0 + "/Long", strI0 + "/Short", strI0 + "/Boolean", strI0 + "/Char", strI0 + "/CharSequence", strI0 + "/String", strI0 + "/Comparable", strI0 + "/Enum", strI0 + "/Array", strI0 + "/ByteArray", strI0 + "/DoubleArray", strI0 + "/FloatArray", strI0 + "/IntArray", strI0 + "/LongArray", strI0 + "/ShortArray", strI0 + "/BooleanArray", strI0 + "/CharArray", strI0 + "/Cloneable", strI0 + "/Annotation", strI0 + "/collections/Iterable", strI0 + "/collections/MutableIterable", strI0 + "/collections/Collection", strI0 + "/collections/MutableCollection", strI0 + "/collections/List", strI0 + "/collections/MutableList", strI0 + "/collections/Set", strI0 + "/collections/MutableSet", strI0 + "/collections/Map", strI0 + "/collections/MutableMap", strI0 + "/collections/Map.Entry", strI0 + "/collections/MutableMap.MutableEntry", strI0 + "/collections/Iterator", strI0 + "/collections/MutableIterator", strI0 + "/collections/ListIterator", strI0 + "/collections/MutableListIterator");
        f8105f = listN;
        Iterable<g0> iterableQ0 = a0.Q0(listN);
        LinkedHashMap linkedHashMap = new LinkedHashMap(l.b(n0.d(s.u(iterableQ0, 10)), 16));
        for (g0 g0Var : iterableQ0) {
            linkedHashMap.put((String) g0Var.d(), Integer.valueOf(g0Var.c()));
        }
        f8106g = linkedHashMap;
    }

    public g(String[] strings, Set localNameIndices, List records) {
        t.f(strings, "strings");
        t.f(localNameIndices, "localNameIndices");
        t.f(records, "records");
        this.f8107a = strings;
        this.f8108b = localNameIndices;
        this.f8109c = records;
    }

    @Override // bf.c
    public String a(int i10) {
        return getString(i10);
    }

    @Override // bf.c
    public boolean b(int i10) {
        return this.f8108b.contains(Integer.valueOf(i10));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0032  */
    @Override // bf.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String getString(int r15) {
        /*
            Method dump skipped, instruction units count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: df.g.getString(int):java.lang.String");
    }
}
