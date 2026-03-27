package d0;

import H5.d;
import Q5.k;
import c0.C1114c;
import c0.InterfaceC1115d;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: d0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1389b implements InterfaceC1115d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f13151a;

    public C1389b(k produceNewData) {
        r.f(produceNewData, "produceNewData");
        this.f13151a = produceNewData;
    }

    @Override // c0.InterfaceC1115d
    public Object a(C1114c c1114c, d dVar) {
        return this.f13151a.invoke(c1114c);
    }
}
