package F5;

import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends c {
    @Override // F5.c
    public int b(int i8) {
        return d.e(g().nextInt(), i8);
    }

    @Override // F5.c
    public int c() {
        return g().nextInt();
    }

    @Override // F5.c
    public int d(int i8) {
        return g().nextInt(i8);
    }

    @Override // F5.c
    public long e() {
        return g().nextLong();
    }

    public abstract Random g();
}
