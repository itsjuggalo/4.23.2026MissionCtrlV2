package td;

import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends c {
    @Override // td.c
    public int b(int i10) {
        return d.e(g().nextInt(), i10);
    }

    @Override // td.c
    public int c() {
        return g().nextInt();
    }

    @Override // td.c
    public int d(int i10) {
        return g().nextInt(i10);
    }

    @Override // td.c
    public long e() {
        return g().nextLong();
    }

    public abstract Random g();
}
