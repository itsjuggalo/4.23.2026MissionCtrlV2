package androidx.lifecycle;

/* JADX INFO: renamed from: androidx.lifecycle.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0368z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C f4699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f4700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4701c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ A f4702d;

    public AbstractC0368z(A a6, C c6) {
        this.f4702d = a6;
        this.f4699a = c6;
    }

    public final void h(boolean z6) {
        if (z6 == this.f4700b) {
            return;
        }
        this.f4700b = z6;
        int i = z6 ? 1 : -1;
        A a6 = this.f4702d;
        int i6 = a6.f4622c;
        a6.f4622c = i + i6;
        if (!a6.f4623d) {
            a6.f4623d = true;
            while (true) {
                try {
                    int i7 = a6.f4622c;
                    if (i6 == i7) {
                        break;
                    }
                    boolean z7 = i6 == 0 && i7 > 0;
                    boolean z8 = i6 > 0 && i7 == 0;
                    if (z7) {
                        a6.f();
                    } else if (z8) {
                        a6.g();
                    }
                    i6 = i7;
                } catch (Throwable th) {
                    a6.f4623d = false;
                    throw th;
                }
            }
            a6.f4623d = false;
        }
        if (this.f4700b) {
            a6.c(this);
        }
    }

    public void i() {
    }

    public boolean j(InterfaceC0362t interfaceC0362t) {
        return false;
    }

    public abstract boolean k();
}
