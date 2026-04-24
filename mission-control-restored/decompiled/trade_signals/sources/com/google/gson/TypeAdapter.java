package com.google.gson;

import java.io.IOException;
import p4.C2568a;
import p4.C2570c;
import p4.EnumC2569b;

/* JADX INFO: loaded from: classes.dex */
public abstract class TypeAdapter {

    public final class NullSafeTypeAdapter extends TypeAdapter {
        public NullSafeTypeAdapter() {
        }

        @Override // com.google.gson.TypeAdapter
        public Object c(C2568a c2568a) throws IOException {
            if (c2568a.x0() != EnumC2569b.NULL) {
                return TypeAdapter.this.c(c2568a);
            }
            c2568a.r0();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void e(C2570c c2570c, Object obj) throws IOException {
            if (obj == null) {
                c2570c.R();
            } else {
                TypeAdapter.this.e(c2570c, obj);
            }
        }

        public String toString() {
            return "NullSafeTypeAdapter[" + TypeAdapter.this + "]";
        }
    }

    public final Object a(i iVar) {
        try {
            return c(new com.google.gson.internal.bind.a(iVar));
        } catch (IOException e8) {
            throw new j(e8);
        }
    }

    public final TypeAdapter b() {
        return !(this instanceof NullSafeTypeAdapter) ? new NullSafeTypeAdapter() : this;
    }

    public abstract Object c(C2568a c2568a);

    public final i d(Object obj) {
        try {
            com.google.gson.internal.bind.b bVar = new com.google.gson.internal.bind.b();
            e(bVar, obj);
            return bVar.B0();
        } catch (IOException e8) {
            throw new j(e8);
        }
    }

    public abstract void e(C2570c c2570c, Object obj);
}
