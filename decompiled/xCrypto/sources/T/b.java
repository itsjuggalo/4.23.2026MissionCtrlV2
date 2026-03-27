package T;

import S.C0518d;
import S.InterfaceC0519e;
import Z2.e;
import i3.k;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class b implements InterfaceC0519e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f5101a;

    public b(k produceNewData) {
        r.f(produceNewData, "produceNewData");
        this.f5101a = produceNewData;
    }

    @Override // S.InterfaceC0519e
    public Object a(C0518d c0518d, e eVar) {
        return this.f5101a.invoke(c0518d);
    }
}
