package c4;

import b4.v;

/* JADX INFO: loaded from: classes.dex */
public class q implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13471b;

    public q(String str, int i8) {
        this.f13470a = str;
        this.f13471b = i8;
    }

    @Override // b4.v
    public byte[] a() {
        return this.f13471b == 0 ? b4.o.f12909n : this.f13470a.getBytes(l.f13443e);
    }

    @Override // b4.v
    public int j() {
        return this.f13471b;
    }
}
