package eg;

import eg.f;
import xf.c1;
import xf.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class v implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pd.k f8955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f8956c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends v {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f8957d = new a();

        public a() {
            super("Boolean", u.f8953a, null);
        }

        public static final r0 c(ce.i iVar) {
            kotlin.jvm.internal.t.f(iVar, "<this>");
            c1 c1VarO = iVar.o();
            kotlin.jvm.internal.t.e(c1VarO, "getBooleanType(...)");
            return c1VarO;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends v {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f8958d = new b();

        public b() {
            super("Int", w.f8960a, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final r0 c(ce.i iVar) {
            kotlin.jvm.internal.t.f(iVar, "<this>");
            c1 c1VarE = iVar.E();
            kotlin.jvm.internal.t.e(c1VarE, "getIntType(...)");
            return c1VarE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends v {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f8959d = new c();

        public c() {
            super("Unit", x.f8961a, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final r0 c(ce.i iVar) {
            kotlin.jvm.internal.t.f(iVar, "<this>");
            c1 c1VarA0 = iVar.a0();
            kotlin.jvm.internal.t.e(c1VarA0, "getUnitType(...)");
            return c1VarA0;
        }
    }

    public /* synthetic */ v(String str, pd.k kVar, kotlin.jvm.internal.k kVar2) {
        this(str, kVar);
    }

    @Override // eg.f
    public boolean a(fe.z functionDescriptor) {
        kotlin.jvm.internal.t.f(functionDescriptor, "functionDescriptor");
        return kotlin.jvm.internal.t.b(functionDescriptor.getReturnType(), this.f8955b.invoke(nf.e.m(functionDescriptor)));
    }

    @Override // eg.f
    public String b(fe.z zVar) {
        return f.a.a(this, zVar);
    }

    @Override // eg.f
    public String getDescription() {
        return this.f8956c;
    }

    public v(String str, pd.k kVar) {
        this.f8954a = str;
        this.f8955b = kVar;
        this.f8956c = "must return " + str;
    }
}
