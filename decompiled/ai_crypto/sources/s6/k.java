package s6;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.H;
import p6.e;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k {

    public static final class a implements p6.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final E5.j f23057a;

        public a(Function0 function0) {
            this.f23057a = E5.k.b(function0);
        }

        @Override // p6.e
        public String a() {
            return b().a();
        }

        public final p6.e b() {
            return (p6.e) this.f23057a.getValue();
        }

        @Override // p6.e
        public boolean c() {
            return e.a.c(this);
        }

        @Override // p6.e
        public int d(String name) {
            kotlin.jvm.internal.r.f(name, "name");
            return b().d(name);
        }

        @Override // p6.e
        public p6.i e() {
            return b().e();
        }

        @Override // p6.e
        public int f() {
            return b().f();
        }

        @Override // p6.e
        public String g(int i7) {
            return b().g(i7);
        }

        @Override // p6.e
        public List getAnnotations() {
            return e.a.a(this);
        }

        @Override // p6.e
        public List h(int i7) {
            return b().h(i7);
        }

        @Override // p6.e
        public p6.e i(int i7) {
            return b().i(i7);
        }

        @Override // p6.e
        public boolean isInline() {
            return e.a.b(this);
        }

        @Override // p6.e
        public boolean j(int i7) {
            return b().j(i7);
        }
    }

    public static final g d(q6.e eVar) {
        kotlin.jvm.internal.r.f(eVar, "<this>");
        g gVar = eVar instanceof g ? (g) eVar : null;
        if (gVar != null) {
            return gVar;
        }
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Decoder to be JsonDecoder, got " + H.b(eVar.getClass()));
    }

    public static final l e(q6.f fVar) {
        kotlin.jvm.internal.r.f(fVar, "<this>");
        l lVar = fVar instanceof l ? (l) fVar : null;
        if (lVar != null) {
            return lVar;
        }
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Encoder to be JsonEncoder, got " + H.b(fVar.getClass()));
    }

    public static final p6.e f(Function0 function0) {
        return new a(function0);
    }

    public static final void g(q6.e eVar) {
        d(eVar);
    }

    public static final void h(q6.f fVar) {
        e(fVar);
    }
}
