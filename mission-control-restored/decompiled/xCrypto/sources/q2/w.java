package q2;

import java.io.IOException;
import t2.C1790g;
import t2.C1791h;
import y2.C1946a;

/* JADX INFO: loaded from: classes.dex */
public abstract class w {

    public final class b extends w {
        public b() {
        }

        @Override // q2.w
        public Object c(C1946a c1946a) throws IOException {
            if (c1946a.r0() != y2.b.NULL) {
                return w.this.c(c1946a);
            }
            c1946a.n0();
            return null;
        }

        @Override // q2.w
        public void e(y2.c cVar, Object obj) throws IOException {
            if (obj == null) {
                cVar.e0();
            } else {
                w.this.e(cVar, obj);
            }
        }

        public String toString() {
            return "NullSafeTypeAdapter[" + w.this + "]";
        }
    }

    public final Object a(j jVar) {
        try {
            return c(new C1790g(jVar));
        } catch (IOException e4) {
            throw new k(e4);
        }
    }

    public final w b() {
        return !(this instanceof b) ? new b() : this;
    }

    public abstract Object c(C1946a c1946a);

    public final j d(Object obj) {
        try {
            C1791h c1791h = new C1791h();
            e(c1791h, obj);
            return c1791h.v0();
        } catch (IOException e4) {
            throw new k(e4);
        }
    }

    public abstract void e(y2.c cVar, Object obj);
}
