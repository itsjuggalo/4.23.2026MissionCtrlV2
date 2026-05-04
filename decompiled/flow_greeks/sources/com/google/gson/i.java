package com.google.gson;

import com.google.gson.internal.e0;
import java.io.IOException;
import java.io.StringWriter;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i {
    public boolean a() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public f c() {
        if (g()) {
            return (f) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public l d() {
        if (q()) {
            return (l) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public n e() {
        if (r()) {
            return (n) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public String f() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean g() {
        return this instanceof f;
    }

    public boolean p() {
        return this instanceof k;
    }

    public boolean q() {
        return this instanceof l;
    }

    public boolean r() {
        return this instanceof n;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            gb.c cVar = new gb.c(stringWriter);
            cVar.i0(s.LENIENT);
            e0.b(this, cVar);
            return stringWriter.toString();
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }
}
