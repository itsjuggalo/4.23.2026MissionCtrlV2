package K2;

import K2.AbstractC0359g;

/* JADX INFO: loaded from: classes3.dex */
public abstract class A extends f0 {
    @Override // K2.f0, K2.AbstractC0359g
    public /* bridge */ /* synthetic */ void cancel(String str, Throwable th) {
        super.cancel(str, th);
    }

    @Override // K2.f0
    public abstract AbstractC0359g delegate();

    @Override // K2.f0, K2.AbstractC0359g
    public /* bridge */ /* synthetic */ C0353a getAttributes() {
        return super.getAttributes();
    }

    @Override // K2.f0, K2.AbstractC0359g
    public /* bridge */ /* synthetic */ void halfClose() {
        super.halfClose();
    }

    @Override // K2.f0, K2.AbstractC0359g
    public /* bridge */ /* synthetic */ boolean isReady() {
        return super.isReady();
    }

    @Override // K2.f0, K2.AbstractC0359g
    public /* bridge */ /* synthetic */ void request(int i4) {
        super.request(i4);
    }

    @Override // K2.AbstractC0359g
    public void sendMessage(Object obj) {
        delegate().sendMessage(obj);
    }

    @Override // K2.f0, K2.AbstractC0359g
    public /* bridge */ /* synthetic */ void setMessageCompression(boolean z4) {
        super.setMessageCompression(z4);
    }

    @Override // K2.AbstractC0359g
    public void start(AbstractC0359g.a aVar, Z z4) {
        delegate().start(aVar, z4);
    }

    @Override // K2.f0
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
