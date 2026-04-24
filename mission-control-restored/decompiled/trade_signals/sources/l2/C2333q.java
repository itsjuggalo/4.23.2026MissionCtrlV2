package l2;

import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: renamed from: l2.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2333q implements InterfaceC2319c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Collection f20578a;

    public C2333q(Collection collection) {
        this.f20578a = collection;
    }

    @Override // l2.InterfaceC2319c
    public final /* bridge */ /* synthetic */ Object a(AbstractC2328l abstractC2328l) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f20578a);
        return AbstractC2331o.e(arrayList);
    }
}
