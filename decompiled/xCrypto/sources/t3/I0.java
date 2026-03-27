package t3;

import y3.AbstractC1960n;

/* JADX INFO: loaded from: classes3.dex */
public abstract class I0 extends I {
    @Override // t3.I
    public I f0(int i4) {
        AbstractC1960n.a(i4);
        return this;
    }

    public abstract I0 g0();

    public final String h0() {
        I0 i0G0;
        I0 i0C = C1803a0.c();
        if (this == i0C) {
            return "Dispatchers.Main";
        }
        try {
            i0G0 = i0C.g0();
        } catch (UnsupportedOperationException unused) {
            i0G0 = null;
        }
        if (this == i0G0) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }
}
