package b6;

/* JADX INFO: loaded from: classes2.dex */
public abstract class I0 extends I {
    public abstract I0 B0();

    public final String C0() {
        I0 i0B0;
        I0 i0C = C1058a0.c();
        if (this == i0C) {
            return "Dispatchers.Main";
        }
        try {
            i0B0 = i0C.B0();
        } catch (UnsupportedOperationException unused) {
            i0B0 = null;
        }
        if (this == i0B0) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }
}
