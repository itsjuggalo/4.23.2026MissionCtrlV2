package b6;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes2.dex */
public final class V0 extends CancellationException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient InterfaceC1101w0 f9026a;

    public V0(String str, InterfaceC1101w0 interfaceC1101w0) {
        super(str);
        this.f9026a = interfaceC1101w0;
    }

    public V0(String str) {
        this(str, null);
    }
}
