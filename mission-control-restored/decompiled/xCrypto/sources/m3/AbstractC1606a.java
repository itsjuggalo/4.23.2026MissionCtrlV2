package m3;

import java.util.Random;

/* JADX INFO: renamed from: m3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1606a extends AbstractC1608c {
    @Override // m3.AbstractC1608c
    public int b(int i4) {
        return AbstractC1609d.e(g().nextInt(), i4);
    }

    @Override // m3.AbstractC1608c
    public int c() {
        return g().nextInt();
    }

    @Override // m3.AbstractC1608c
    public int d(int i4) {
        return g().nextInt(i4);
    }

    @Override // m3.AbstractC1608c
    public long e() {
        return g().nextLong();
    }

    public abstract Random g();
}
