package fe;

import fe.a;
import fe.b;
import java.util.Collection;
import java.util.List;
import xf.d2;
import xf.f2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public interface z extends b {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface a {
        a a();

        a b(List list);

        z build();

        a c(b1 b1Var);

        a d(u uVar);

        a e();

        a f(b1 b1Var);

        a g(xf.r0 r0Var);

        a h();

        a i(boolean z10);

        a j(ef.f fVar);

        a k(d2 d2Var);

        a l(List list);

        a m(b.a aVar);

        a n(ge.h hVar);

        a o();

        a p(m mVar);

        a q(a.InterfaceC0175a interfaceC0175a, Object obj);

        a r(b bVar);

        a s(e0 e0Var);

        a t();
    }

    boolean C0();

    boolean R();

    @Override // fe.b, fe.a, fe.m
    z a();

    @Override // fe.n, fe.m
    m b();

    z c(f2 f2Var);

    z d0();

    @Override // fe.b, fe.a
    Collection f();

    boolean isInfix();

    boolean isInline();

    boolean isOperator();

    boolean isSuspend();

    a u();

    boolean v0();
}
