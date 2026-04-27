package Q1;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class J extends L {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Callable f6670f;

    public /* synthetic */ J(Callable callable, K k8) {
        super();
        this.f6670f = callable;
    }

    @Override // Q1.L
    public final String a() {
        try {
            return (String) this.f6670f.call();
        } catch (Exception e8) {
            throw new RuntimeException(e8);
        }
    }
}
