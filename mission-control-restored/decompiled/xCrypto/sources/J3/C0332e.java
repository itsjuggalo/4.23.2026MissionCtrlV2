package J3;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: J3.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0332e extends AbstractC0344q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final H3.e f923b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0332e(F3.b element) {
        super(element);
        kotlin.jvm.internal.r.f(element, "element");
        this.f923b = new C0330d(element.getDescriptor());
    }

    @Override // J3.AbstractC0343p, F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return this.f923b;
    }

    @Override // J3.AbstractC0324a
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public ArrayList a() {
        return new ArrayList();
    }

    @Override // J3.AbstractC0324a
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public int b(ArrayList arrayList) {
        kotlin.jvm.internal.r.f(arrayList, "<this>");
        return arrayList.size();
    }

    @Override // J3.AbstractC0324a
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public void c(ArrayList arrayList, int i4) {
        kotlin.jvm.internal.r.f(arrayList, "<this>");
        arrayList.ensureCapacity(i4);
    }

    @Override // J3.AbstractC0343p
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public void n(ArrayList arrayList, int i4, Object obj) {
        kotlin.jvm.internal.r.f(arrayList, "<this>");
        arrayList.add(i4, obj);
    }

    @Override // J3.AbstractC0324a
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public ArrayList k(List list) {
        kotlin.jvm.internal.r.f(list, "<this>");
        ArrayList arrayList = list instanceof ArrayList ? (ArrayList) list : null;
        return arrayList == null ? new ArrayList(list) : arrayList;
    }

    @Override // J3.AbstractC0324a
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public List l(ArrayList arrayList) {
        kotlin.jvm.internal.r.f(arrayList, "<this>");
        return arrayList;
    }
}
