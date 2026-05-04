package eh;

import bh.e;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.n0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements bh.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final cd.k f9026a;

        public a(Function0 function0) {
            this.f9026a = cd.l.b(function0);
        }

        public final bh.e a() {
            return (bh.e) this.f9026a.getValue();
        }

        @Override // bh.e
        public List getAnnotations() {
            return e.a.a(this);
        }

        @Override // bh.e
        public bh.l h() {
            return a().h();
        }

        @Override // bh.e
        public String i() {
            return a().i();
        }

        @Override // bh.e
        public boolean isInline() {
            return e.a.b(this);
        }

        @Override // bh.e
        public boolean j() {
            return e.a.c(this);
        }

        @Override // bh.e
        public int k(String name) {
            kotlin.jvm.internal.t.f(name, "name");
            return a().k(name);
        }

        @Override // bh.e
        public int l() {
            return a().l();
        }

        @Override // bh.e
        public String m(int i10) {
            return a().m(i10);
        }

        @Override // bh.e
        public List n(int i10) {
            return a().n(i10);
        }

        @Override // bh.e
        public bh.e o(int i10) {
            return a().o(i10);
        }

        @Override // bh.e
        public boolean p(int i10) {
            return a().p(i10);
        }
    }

    public static final h d(ch.e eVar) {
        kotlin.jvm.internal.t.f(eVar, "<this>");
        h hVar = eVar instanceof h ? (h) eVar : null;
        if (hVar != null) {
            return hVar;
        }
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Decoder to be JsonDecoder, got " + n0.b(eVar.getClass()));
    }

    public static final s e(ch.f fVar) {
        kotlin.jvm.internal.t.f(fVar, "<this>");
        s sVar = fVar instanceof s ? (s) fVar : null;
        if (sVar != null) {
            return sVar;
        }
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Encoder to be JsonEncoder, got " + n0.b(fVar.getClass()));
    }

    public static final bh.e f(Function0 function0) {
        return new a(function0);
    }

    public static final void g(ch.e eVar) {
        d(eVar);
    }

    public static final void h(ch.f fVar) {
        e(fVar);
    }
}
