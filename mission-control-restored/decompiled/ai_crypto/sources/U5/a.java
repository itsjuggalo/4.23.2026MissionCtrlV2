package U5;

import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends c {
    @Override // U5.c
    public int b(int i7) {
        return d.e(g().nextInt(), i7);
    }

    @Override // U5.c
    public int c() {
        return g().nextInt();
    }

    @Override // U5.c
    public int d(int i7) {
        return g().nextInt(i7);
    }

    @Override // U5.c
    public long e() {
        return g().nextLong();
    }

    public abstract Random g();
}
