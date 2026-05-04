package we;

import we.d;

/* JADX INFO: loaded from: classes3.dex */
public class a implements pd.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f23934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d.a f23935b;

    public a(d dVar, d.a aVar) {
        this.f23934a = dVar;
        this.f23935b = aVar;
    }

    @Override // pd.k
    public Object invoke(Object obj) {
        return Boolean.valueOf(d.i(this.f23934a, this.f23935b, obj));
    }
}
