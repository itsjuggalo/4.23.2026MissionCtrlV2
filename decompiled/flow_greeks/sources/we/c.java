package we;

import we.d;

/* JADX INFO: loaded from: classes3.dex */
public class c implements pd.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f23942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bg.p f23943b;

    public c(d dVar, bg.p pVar) {
        this.f23942a = dVar;
        this.f23943b = pVar;
    }

    @Override // pd.k
    public Object invoke(Object obj) {
        return d.I(this.f23942a, this.f23943b, (d.a) obj);
    }
}
