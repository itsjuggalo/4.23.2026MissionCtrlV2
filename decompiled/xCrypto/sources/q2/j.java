package q2;

import java.io.IOException;
import java.io.StringWriter;
import s2.F;

/* JADX INFO: loaded from: classes.dex */
public abstract class j {
    public boolean c() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public g f() {
        if (m()) {
            return (g) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public m i() {
        if (o()) {
            return (m) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public o k() {
        if (p()) {
            return (o) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public String l() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean m() {
        return this instanceof g;
    }

    public boolean n() {
        return this instanceof l;
    }

    public boolean o() {
        return this instanceof m;
    }

    public boolean p() {
        return this instanceof o;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            y2.c cVar = new y2.c(stringWriter);
            cVar.m0(t.LENIENT);
            F.b(this, cVar);
            return stringWriter.toString();
        } catch (IOException e4) {
            throw new AssertionError(e4);
        }
    }
}
