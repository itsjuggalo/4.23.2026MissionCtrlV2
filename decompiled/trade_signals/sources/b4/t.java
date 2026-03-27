package b4;

import b4.q;

/* JADX INFO: loaded from: classes.dex */
public class t extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12932b;

    public t(int i8, String str) {
        super(str);
        this.f12932b = i8;
    }

    public int a() {
        return this.f12932b;
    }

    public t(int i8, String str, q.a aVar) {
        super(str, aVar);
        this.f12932b = i8;
    }

    public t(int i8, String str, Throwable th) {
        super(str, th);
        this.f12932b = i8;
    }

    public t(String str, q.a aVar) {
        super(str, aVar);
        this.f12932b = -1;
    }
}
