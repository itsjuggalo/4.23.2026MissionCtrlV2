package x4;

/* JADX INFO: renamed from: x4.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2957a extends AbstractC2958b {
    @Override // x4.f
    public void error(String str, String str2, Object obj) {
        m().error(str, str2, obj);
    }

    public abstract f m();

    @Override // x4.f
    public void success(Object obj) {
        m().success(obj);
    }
}
