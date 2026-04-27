package l4;

import java.io.IOException;
import o4.C2315g;
import t4.C2657a;

/* JADX INFO: loaded from: classes.dex */
public abstract class w {

    public final class b extends w {
        public b() {
        }

        @Override // l4.w
        public Object c(C2657a c2657a) throws IOException {
            if (c2657a.M0() != t4.b.NULL) {
                return w.this.c(c2657a);
            }
            c2657a.I0();
            return null;
        }

        @Override // l4.w
        public void e(t4.c cVar, Object obj) throws IOException {
            if (obj == null) {
                cVar.z0();
            } else {
                w.this.e(cVar, obj);
            }
        }

        public String toString() {
            return "NullSafeTypeAdapter[" + w.this + "]";
        }
    }

    public final Object a(AbstractC2177j abstractC2177j) {
        try {
            return c(new C2315g(abstractC2177j));
        } catch (IOException e7) {
            throw new C2178k(e7);
        }
    }

    public final w b() {
        return !(this instanceof b) ? new b() : this;
    }

    public abstract Object c(C2657a c2657a);

    public final AbstractC2177j d(Object obj) {
        try {
            o4.h hVar = new o4.h();
            e(hVar, obj);
            return hVar.Q0();
        } catch (IOException e7) {
            throw new C2178k(e7);
        }
    }

    public abstract void e(t4.c cVar, Object obj);
}
