package K2;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f0 extends AbstractC0359g {
    @Override // K2.AbstractC0359g
    public void cancel(String str, Throwable th) {
        delegate().cancel(str, th);
    }

    public abstract AbstractC0359g delegate();

    @Override // K2.AbstractC0359g
    public C0353a getAttributes() {
        return delegate().getAttributes();
    }

    @Override // K2.AbstractC0359g
    public void halfClose() {
        delegate().halfClose();
    }

    @Override // K2.AbstractC0359g
    public boolean isReady() {
        return delegate().isReady();
    }

    @Override // K2.AbstractC0359g
    public void request(int i4) {
        delegate().request(i4);
    }

    @Override // K2.AbstractC0359g
    public void setMessageCompression(boolean z4) {
        delegate().setMessageCompression(z4);
    }

    public String toString() {
        return Z1.g.b(this).d("delegate", delegate()).toString();
    }
}
