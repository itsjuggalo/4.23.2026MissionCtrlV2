package t3;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes3.dex */
public final class V0 extends CancellationException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient InterfaceC1846w0 f14968a;

    public V0(String str, InterfaceC1846w0 interfaceC1846w0) {
        super(str);
        this.f14968a = interfaceC1846w0;
    }

    public V0(String str) {
        this(str, null);
    }
}
