package D3;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final G3.s f1431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final H3.d f1432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f1433c;

    public t0(G3.s sVar, H3.d dVar, List list) {
        this.f1431a = sVar;
        this.f1432b = dVar;
        this.f1433c = list;
    }

    public H3.f a(G3.k kVar, H3.m mVar) {
        H3.d dVar = this.f1432b;
        return dVar != null ? new H3.l(kVar, this.f1431a, dVar, mVar, this.f1433c) : new H3.o(kVar, this.f1431a, mVar, this.f1433c);
    }
}
