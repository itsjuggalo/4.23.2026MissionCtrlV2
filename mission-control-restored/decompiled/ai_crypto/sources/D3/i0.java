package D3;

import K3.AbstractC0612b;

/* JADX INFO: loaded from: classes.dex */
public class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1326b;

    public i0(int i7, int i8) {
        AbstractC0612b.d((i7 & 1) == i7, "Generator ID %d contains more than %d reserved bits", Integer.valueOf(i7), 1);
        this.f1326b = i7;
        d(i8);
    }

    public static i0 a() {
        return new i0(1, 1);
    }

    public static i0 b(int i7) {
        i0 i0Var = new i0(0, i7);
        i0Var.c();
        return i0Var;
    }

    public int c() {
        int i7 = this.f1325a;
        this.f1325a = i7 + 2;
        return i7;
    }

    public final void d(int i7) {
        AbstractC0612b.d((i7 & 1) == this.f1326b, "Cannot supply target ID from different generator ID", new Object[0]);
        this.f1325a = i7;
    }
}
