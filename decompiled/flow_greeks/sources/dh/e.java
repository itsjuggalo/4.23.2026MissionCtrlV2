package dh;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bh.e f8136b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(zg.b element) {
        super(element);
        kotlin.jvm.internal.t.f(element, "element");
        this.f8136b = new d(element.getDescriptor());
    }

    @Override // dh.p, zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return this.f8136b;
    }

    @Override // dh.a
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public ArrayList a() {
        return new ArrayList();
    }

    @Override // dh.a
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public int b(ArrayList arrayList) {
        kotlin.jvm.internal.t.f(arrayList, "<this>");
        return arrayList.size();
    }

    @Override // dh.a
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public void c(ArrayList arrayList, int i10) {
        kotlin.jvm.internal.t.f(arrayList, "<this>");
        arrayList.ensureCapacity(i10);
    }

    @Override // dh.p
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public void n(ArrayList arrayList, int i10, Object obj) {
        kotlin.jvm.internal.t.f(arrayList, "<this>");
        arrayList.add(i10, obj);
    }

    @Override // dh.a
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public ArrayList k(List list) {
        kotlin.jvm.internal.t.f(list, "<this>");
        ArrayList arrayList = list instanceof ArrayList ? (ArrayList) list : null;
        return arrayList == null ? new ArrayList(list) : arrayList;
    }

    @Override // dh.a
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public List l(ArrayList arrayList) {
        kotlin.jvm.internal.t.f(arrayList, "<this>");
        return arrayList;
    }
}
