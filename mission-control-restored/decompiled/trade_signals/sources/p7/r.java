package p7;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.O;
import m7.e;
import o5.AbstractC2484l;
import o5.InterfaceC2483k;

/* JADX INFO: loaded from: classes2.dex */
public abstract class r {

    public static final class a implements m7.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InterfaceC2483k f22485a;

        public a(Function0 function0) {
            this.f22485a = AbstractC2484l.a(function0);
        }

        @Override // m7.e
        public String a() {
            return b().a();
        }

        public final m7.e b() {
            return (m7.e) this.f22485a.getValue();
        }

        @Override // m7.e
        public boolean c() {
            return e.a.c(this);
        }

        @Override // m7.e
        public int d(String name) {
            AbstractC2304t.f(name, "name");
            return b().d(name);
        }

        @Override // m7.e
        public int e() {
            return b().e();
        }

        @Override // m7.e
        public String f(int i8) {
            return b().f(i8);
        }

        @Override // m7.e
        public List g(int i8) {
            return b().g(i8);
        }

        @Override // m7.e
        public List getAnnotations() {
            return e.a.a(this);
        }

        @Override // m7.e
        public m7.e h(int i8) {
            return b().h(i8);
        }

        @Override // m7.e
        public m7.l i() {
            return b().i();
        }

        @Override // m7.e
        public boolean isInline() {
            return e.a.b(this);
        }

        @Override // m7.e
        public boolean j(int i8) {
            return b().j(i8);
        }
    }

    public static final h d(n7.e eVar) {
        AbstractC2304t.f(eVar, "<this>");
        h hVar = eVar instanceof h ? (h) eVar : null;
        if (hVar != null) {
            return hVar;
        }
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Decoder to be JsonDecoder, got " + O.b(eVar.getClass()));
    }

    public static final s e(n7.f fVar) {
        AbstractC2304t.f(fVar, "<this>");
        s sVar = fVar instanceof s ? (s) fVar : null;
        if (sVar != null) {
            return sVar;
        }
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Encoder to be JsonEncoder, got " + O.b(fVar.getClass()));
    }

    public static final m7.e f(Function0 function0) {
        return new a(function0);
    }

    public static final void g(n7.e eVar) {
        d(eVar);
    }

    public static final void h(n7.f fVar) {
        e(fVar);
    }
}
