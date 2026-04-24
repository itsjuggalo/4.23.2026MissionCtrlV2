package i7;

import B5.k;
import Y6.C1019n;
import Y6.InterfaceC1015l;
import java.util.concurrent.CancellationException;
import l2.AbstractC2328l;
import l2.C2318b;
import l2.InterfaceC2322f;
import o5.AbstractC2491s;
import o5.C2470H;
import o5.C2490r;
import s5.InterfaceC2707e;
import t5.AbstractC2750b;
import t5.AbstractC2751c;
import u5.AbstractC2781h;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    public static final class a implements InterfaceC2322f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1015l f18942a;

        public a(InterfaceC1015l interfaceC1015l) {
            this.f18942a = interfaceC1015l;
        }

        @Override // l2.InterfaceC2322f
        public final void a(AbstractC2328l abstractC2328l) {
            Exception excJ = abstractC2328l.j();
            if (excJ != null) {
                InterfaceC1015l interfaceC1015l = this.f18942a;
                C2490r.a aVar = C2490r.f21981b;
                interfaceC1015l.resumeWith(C2490r.b(AbstractC2491s.a(excJ)));
            } else {
                if (abstractC2328l.m()) {
                    InterfaceC1015l.a.a(this.f18942a, null, 1, null);
                    return;
                }
                InterfaceC1015l interfaceC1015l2 = this.f18942a;
                C2490r.a aVar2 = C2490r.f21981b;
                interfaceC1015l2.resumeWith(C2490r.b(abstractC2328l.k()));
            }
        }
    }

    /* JADX INFO: renamed from: i7.b$b, reason: collision with other inner class name */
    public static final class C0318b implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C2318b f18943a;

        public C0318b(C2318b c2318b) {
            this.f18943a = c2318b;
        }

        public final void a(Throwable th) {
            this.f18943a.a();
        }

        @Override // B5.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return C2470H.f21956a;
        }
    }

    public static final Object a(AbstractC2328l abstractC2328l, InterfaceC2707e interfaceC2707e) {
        return b(abstractC2328l, null, interfaceC2707e);
    }

    public static final Object b(AbstractC2328l abstractC2328l, C2318b c2318b, InterfaceC2707e interfaceC2707e) throws Exception {
        if (!abstractC2328l.n()) {
            C1019n c1019n = new C1019n(AbstractC2750b.c(interfaceC2707e), 1);
            c1019n.E();
            abstractC2328l.b(i7.a.f18941a, new a(c1019n));
            if (c2318b != null) {
                c1019n.p(new C0318b(c2318b));
            }
            Object objY = c1019n.y();
            if (objY == AbstractC2751c.f()) {
                AbstractC2781h.c(interfaceC2707e);
            }
            return objY;
        }
        Exception excJ = abstractC2328l.j();
        if (excJ != null) {
            throw excJ;
        }
        if (!abstractC2328l.m()) {
            return abstractC2328l.k();
        }
        throw new CancellationException("Task " + abstractC2328l + " was cancelled normally.");
    }
}
