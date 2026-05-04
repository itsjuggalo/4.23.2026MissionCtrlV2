package ng;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class w2 extends CancellationException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient y1 f17194a;

    public w2(String str, y1 y1Var) {
        super(str);
        this.f17194a = y1Var;
    }

    public w2(String str) {
        this(str, null);
    }
}
