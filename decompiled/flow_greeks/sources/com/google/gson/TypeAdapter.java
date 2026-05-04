package com.google.gson;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TypeAdapter {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class NullSafeTypeAdapter extends TypeAdapter {
        public NullSafeTypeAdapter() {
        }

        @Override // com.google.gson.TypeAdapter
        public Object c(gb.a aVar) throws IOException {
            if (aVar.n0() != gb.b.NULL) {
                return TypeAdapter.this.c(aVar);
            }
            aVar.j0();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void e(gb.c cVar, Object obj) throws IOException {
            if (obj == null) {
                cVar.a0();
            } else {
                TypeAdapter.this.e(cVar, obj);
            }
        }

        public String toString() {
            return "NullSafeTypeAdapter[" + TypeAdapter.this + "]";
        }
    }

    public final Object a(i iVar) {
        try {
            return c(new com.google.gson.internal.bind.a(iVar));
        } catch (IOException e10) {
            throw new j(e10);
        }
    }

    public final TypeAdapter b() {
        return !(this instanceof NullSafeTypeAdapter) ? new NullSafeTypeAdapter() : this;
    }

    public abstract Object c(gb.a aVar);

    public final i d(Object obj) {
        try {
            com.google.gson.internal.bind.b bVar = new com.google.gson.internal.bind.b();
            e(bVar, obj);
            return bVar.r0();
        } catch (IOException e10) {
            throw new j(e10);
        }
    }

    public abstract void e(gb.c cVar, Object obj);
}
