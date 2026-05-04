package pa;

import pa.q;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class t extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f18467b;

    public t(int i10, String str) {
        super(str);
        this.f18467b = i10;
    }

    public int a() {
        return this.f18467b;
    }

    public t(int i10, String str, Throwable th) {
        super(str, th);
        this.f18467b = i10;
    }

    public t(String str, q.a aVar) {
        super(str, aVar);
        this.f18467b = -1;
    }

    public t(int i10, String str, q.a aVar) {
        super(str, aVar);
        this.f18467b = i10;
    }
}
