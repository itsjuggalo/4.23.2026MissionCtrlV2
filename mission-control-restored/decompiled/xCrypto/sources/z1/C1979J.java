package z1;

import java.util.concurrent.Callable;

/* JADX INFO: renamed from: z1.J, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1979J extends C1981L {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Callable f16073f;

    public /* synthetic */ C1979J(Callable callable, AbstractC1980K abstractC1980K) {
        super();
        this.f16073f = callable;
    }

    @Override // z1.C1981L
    public final String a() {
        try {
            return (String) this.f16073f.call();
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }
}
