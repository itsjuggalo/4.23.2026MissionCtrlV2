package K2;

/* JADX INFO: renamed from: K2.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0359g {
    public abstract void cancel(String str, Throwable th);

    public C0353a getAttributes() {
        return C0353a.f1111c;
    }

    public abstract void halfClose();

    public boolean isReady() {
        return true;
    }

    public abstract void request(int i4);

    public abstract void sendMessage(Object obj);

    public abstract void start(a aVar, Z z4);

    /* JADX INFO: renamed from: K2.g$a */
    public static abstract class a {
        public abstract void onClose(l0 l0Var, Z z4);

        public abstract void onMessage(Object obj);

        public void onReady() {
        }

        public void onHeaders(Z z4) {
        }
    }

    public void setMessageCompression(boolean z4) {
    }
}
