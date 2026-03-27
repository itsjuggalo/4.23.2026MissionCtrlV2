package t3;

import java.io.IOException;
import java.io.StringWriter;
import w3.C1293m;
import w3.i0;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {
    public boolean a() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public final k b() {
        if (this instanceof k) {
            return (k) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public String c() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public final String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            B3.b bVar = new B3.b(stringWriter);
            bVar.f170l = 1;
            i0.f10783z.getClass();
            C1293m.e(bVar, this);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
