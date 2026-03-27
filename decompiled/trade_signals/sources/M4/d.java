package M4;

import F4.AbstractC0490d;
import F4.AbstractC0493g;
import F4.AbstractC0511z;
import F4.C0489c;
import F4.InterfaceC0494h;
import F4.X;
import F4.Y;
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    public static final class a implements InterfaceC0494h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final X f5371a;

        /* JADX INFO: renamed from: M4.d$a$a, reason: collision with other inner class name */
        public final class C0077a extends AbstractC0511z.a {
            public C0077a(AbstractC0493g abstractC0493g) {
                super(abstractC0493g);
            }

            @Override // F4.AbstractC0511z, F4.AbstractC0493g
            public void e(AbstractC0493g.a aVar, X x8) {
                x8.l(a.this.f5371a);
                super.e(aVar, x8);
            }
        }

        public a(X x8) {
            this.f5371a = (X) AbstractC2848n.o(x8, "extraHeaders");
        }

        @Override // F4.InterfaceC0494h
        public AbstractC0493g a(Y y7, C0489c c0489c, AbstractC0490d abstractC0490d) {
            return new C0077a(abstractC0490d.g(y7, c0489c));
        }
    }

    public static InterfaceC0494h a(X x8) {
        return new a(x8);
    }
}
