package P1;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class J extends L {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Callable f4276f;

    public /* synthetic */ J(Callable callable, K k7) {
        super();
        this.f4276f = callable;
    }

    @Override // P1.L
    public final String a() {
        try {
            return (String) this.f4276f.call();
        } catch (Exception e7) {
            throw new RuntimeException(e7);
        }
    }
}
