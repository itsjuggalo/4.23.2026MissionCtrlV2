package Y6;

import d7.AbstractC1651l;

/* JADX INFO: loaded from: classes2.dex */
public abstract class E0 extends I {
    public final String A0() {
        E0 e0Z0;
        E0 e0C = C0994a0.c();
        if (this == e0C) {
            return "Dispatchers.Main";
        }
        try {
            e0Z0 = e0C.z0();
        } catch (UnsupportedOperationException unused) {
            e0Z0 = null;
        }
        if (this == e0Z0) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    @Override // Y6.I
    public I x0(int i8, String str) {
        AbstractC1651l.a(i8);
        return AbstractC1651l.b(this, str);
    }

    public abstract E0 z0();
}
