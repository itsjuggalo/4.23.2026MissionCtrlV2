package B0;

import c5.r;
import c5.s;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements C.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f97a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f98b;

    public /* synthetic */ i(Object obj, int i) {
        this.f97a = i;
        this.f98b = obj;
    }

    @Override // C.a
    public final void accept(Object obj) {
        switch (this.f97a) {
            case 0:
                ((r) ((s) this.f98b)).d((l) obj);
                break;
            default:
                ((P3.n) this.f98b).setWindowInfoListenerDisplayFeatures((l) obj);
                break;
        }
    }
}
