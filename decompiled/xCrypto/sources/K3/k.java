package K3;

import H3.e;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.G;

/* JADX INFO: loaded from: classes3.dex */
public abstract class k {

    public static final class a implements H3.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final W2.j f1370a;

        public a(Function0 function0) {
            this.f1370a = W2.k.b(function0);
        }

        @Override // H3.e
        public String a() {
            return b().a();
        }

        public final H3.e b() {
            return (H3.e) this.f1370a.getValue();
        }

        @Override // H3.e
        public boolean c() {
            return e.a.c(this);
        }

        @Override // H3.e
        public int d(String name) {
            kotlin.jvm.internal.r.f(name, "name");
            return b().d(name);
        }

        @Override // H3.e
        public H3.i e() {
            return b().e();
        }

        @Override // H3.e
        public int f() {
            return b().f();
        }

        @Override // H3.e
        public String g(int i4) {
            return b().g(i4);
        }

        @Override // H3.e
        public List getAnnotations() {
            return e.a.a(this);
        }

        @Override // H3.e
        public List h(int i4) {
            return b().h(i4);
        }

        @Override // H3.e
        public H3.e i(int i4) {
            return b().i(i4);
        }

        @Override // H3.e
        public boolean isInline() {
            return e.a.b(this);
        }

        @Override // H3.e
        public boolean j(int i4) {
            return b().j(i4);
        }
    }

    public static final g d(I3.e eVar) {
        kotlin.jvm.internal.r.f(eVar, "<this>");
        g gVar = eVar instanceof g ? (g) eVar : null;
        if (gVar != null) {
            return gVar;
        }
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Decoder to be JsonDecoder, got " + G.b(eVar.getClass()));
    }

    public static final l e(I3.f fVar) {
        kotlin.jvm.internal.r.f(fVar, "<this>");
        l lVar = fVar instanceof l ? (l) fVar : null;
        if (lVar != null) {
            return lVar;
        }
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Encoder to be JsonEncoder, got " + G.b(fVar.getClass()));
    }

    public static final H3.e f(Function0 function0) {
        return new a(function0);
    }

    public static final void g(I3.e eVar) {
        d(eVar);
    }

    public static final void h(I3.f fVar) {
        e(fVar);
    }
}
