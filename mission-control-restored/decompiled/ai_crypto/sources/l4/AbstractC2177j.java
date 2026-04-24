package l4;

import java.io.IOException;
import java.io.StringWriter;
import n4.F;

/* JADX INFO: renamed from: l4.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2177j {
    public boolean a() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public C2174g b() {
        if (j()) {
            return (C2174g) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public m c() {
        if (l()) {
            return (m) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public o g() {
        if (m()) {
            return (o) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public String h() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean j() {
        return this instanceof C2174g;
    }

    public boolean k() {
        return this instanceof l;
    }

    public boolean l() {
        return this instanceof m;
    }

    public boolean m() {
        return this instanceof o;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            t4.c cVar = new t4.c(stringWriter);
            cVar.H0(t.LENIENT);
            F.b(this, cVar);
            return stringWriter.toString();
        } catch (IOException e7) {
            throw new AssertionError(e7);
        }
    }
}
