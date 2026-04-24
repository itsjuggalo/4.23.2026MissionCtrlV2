package E2;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends b {
    @Override // E2.f
    public void error(String str, String str2, Object obj) {
        m().error(str, str2, obj);
    }

    public abstract f m();

    @Override // E2.f
    public void success(Object obj) {
        m().success(obj);
    }
}
