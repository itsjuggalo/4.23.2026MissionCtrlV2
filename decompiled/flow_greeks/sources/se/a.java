package se;

/* JADX INFO: loaded from: classes3.dex */
public class a implements pd.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f20213a;

    public a(b bVar) {
        this.f20213a = bVar;
    }

    @Override // pd.k
    public Object invoke(Object obj) {
        return Boolean.valueOf(b.h(this.f20213a, (ve.r) obj));
    }
}
