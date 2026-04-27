package com.google.gson;

import com.google.gson.internal.E;
import java.io.IOException;
import java.io.StringWriter;
import p4.C2570c;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {
    public boolean C() {
        return this instanceof k;
    }

    public boolean F() {
        return this instanceof l;
    }

    public boolean H() {
        return this instanceof n;
    }

    public boolean a() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public f d() {
        if (n()) {
            return (f) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public l e() {
        if (F()) {
            return (l) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public n f() {
        if (H()) {
            return (n) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public String h() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean n() {
        return this instanceof f;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            C2570c c2570c = new C2570c(stringWriter);
            c2570c.m0(s.LENIENT);
            E.b(this, c2570c);
            return stringWriter.toString();
        } catch (IOException e8) {
            throw new AssertionError(e8);
        }
    }
}
