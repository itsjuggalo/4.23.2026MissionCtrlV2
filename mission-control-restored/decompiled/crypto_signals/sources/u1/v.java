package u1;

/* JADX INFO: loaded from: classes.dex */
public final class v extends w {
    public final CallableC1211m e;

    public /* synthetic */ v(CallableC1211m callableC1211m) {
        super(false, null, null);
        this.e = callableC1211m;
    }

    @Override // u1.w
    public final String a() {
        try {
            return (String) this.e.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
