package Z3;

import x3.InterfaceC2825f;

/* JADX INFO: renamed from: Z3.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC0790j implements InterfaceC2825f {
    EVENT_TYPE_UNKNOWN(0),
    SESSION_START(1);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5942a;

    EnumC0790j(int i7) {
        this.f5942a = i7;
    }

    @Override // x3.InterfaceC2825f
    public int d() {
        return this.f5942a;
    }
}
