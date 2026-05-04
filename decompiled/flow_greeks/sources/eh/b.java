package eh;

import fh.a1;
import fh.c1;
import fh.d1;
import fh.i0;
import fh.j0;
import fh.t0;
import fh.w0;
import fh.x0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements zg.l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f8972d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f8973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gh.e f8974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final fh.v f8975c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends b {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
            super(new g(false, false, false, false, false, false, null, false, false, null, false, false, null, false, false, false, null, 131071, null), gh.g.a(), null);
        }
    }

    public /* synthetic */ b(g gVar, gh.e eVar, kotlin.jvm.internal.k kVar) {
        this(gVar, eVar);
    }

    @Override // zg.i
    public gh.e a() {
        return this.f8974b;
    }

    @Override // zg.l
    public final String b(zg.k serializer, Object obj) {
        kotlin.jvm.internal.t.f(serializer, "serializer");
        j0 j0Var = new j0();
        try {
            i0.a(this, j0Var, serializer, obj);
            return j0Var.toString();
        } finally {
            j0Var.g();
        }
    }

    public final Object c(zg.a deserializer, i element) {
        kotlin.jvm.internal.t.f(deserializer, "deserializer");
        kotlin.jvm.internal.t.f(element, "element");
        return a1.a(this, element, deserializer);
    }

    public final Object d(zg.a deserializer, String string) {
        kotlin.jvm.internal.t.f(deserializer, "deserializer");
        kotlin.jvm.internal.t.f(string, "string");
        w0 w0VarA = x0.a(this, string);
        Object objE = new t0(this, d1.f9556c, w0VarA, deserializer.getDescriptor(), null).E(deserializer);
        w0VarA.v();
        return objE;
    }

    public final i e(zg.k serializer, Object obj) {
        kotlin.jvm.internal.t.f(serializer, "serializer");
        return c1.d(this, obj, serializer);
    }

    public final g f() {
        return this.f8973a;
    }

    public final fh.v g() {
        return this.f8975c;
    }

    public b(g gVar, gh.e eVar) {
        this.f8973a = gVar;
        this.f8974b = eVar;
        this.f8975c = new fh.v();
    }
}
