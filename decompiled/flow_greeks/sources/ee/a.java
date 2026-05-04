package ee;

import fe.b;
import fe.e0;
import fe.g1;
import ie.o0;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends qf.f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C0166a f8677e = new C0166a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ef.f f8678f;

    /* JADX INFO: renamed from: ee.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0166a {
        public /* synthetic */ C0166a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final ef.f a() {
            return a.f8678f;
        }

        public C0166a() {
        }
    }

    static {
        ef.f fVarK = ef.f.k("clone");
        kotlin.jvm.internal.t.e(fVarK, "identifier(...)");
        f8678f = fVarK;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(wf.n storageManager, fe.e containingClass) {
        super(storageManager, containingClass);
        kotlin.jvm.internal.t.f(storageManager, "storageManager");
        kotlin.jvm.internal.t.f(containingClass, "containingClass");
    }

    @Override // qf.f
    public List j() {
        o0 o0VarL1 = o0.l1(m(), ge.h.L.b(), f8678f, b.a.DECLARATION, g1.f9483a);
        o0VarL1.R0(null, m().J0(), dd.r.k(), dd.r.k(), dd.r.k(), nf.e.m(m()).i(), e0.f9463d, fe.t.f9509c);
        return dd.q.e(o0VarL1);
    }
}
