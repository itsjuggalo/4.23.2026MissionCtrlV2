package ng;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i2 extends k0 {
    @Override // ng.k0
    public k0 c0(int i10, String str) {
        sg.l.a(i10);
        return sg.l.b(this, str);
    }

    public abstract i2 e0();

    public final String f0() {
        i2 i2VarE0;
        i2 i2VarC = c1.c();
        if (this == i2VarC) {
            return "Dispatchers.Main";
        }
        try {
            i2VarE0 = i2VarC.e0();
        } catch (UnsupportedOperationException unused) {
            i2VarE0 = null;
        }
        if (this == i2VarE0) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }
}
