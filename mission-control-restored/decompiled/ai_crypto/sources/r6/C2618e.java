package r6;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: r6.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2618e extends AbstractC2630q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p6.e f22880b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2618e(n6.b element) {
        super(element);
        kotlin.jvm.internal.r.f(element, "element");
        this.f22880b = new C2616d(element.getDescriptor());
    }

    @Override // r6.AbstractC2629p, n6.b, n6.h, n6.a
    public p6.e getDescriptor() {
        return this.f22880b;
    }

    @Override // r6.AbstractC2610a
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public ArrayList a() {
        return new ArrayList();
    }

    @Override // r6.AbstractC2610a
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public int b(ArrayList arrayList) {
        kotlin.jvm.internal.r.f(arrayList, "<this>");
        return arrayList.size();
    }

    @Override // r6.AbstractC2610a
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public void c(ArrayList arrayList, int i7) {
        kotlin.jvm.internal.r.f(arrayList, "<this>");
        arrayList.ensureCapacity(i7);
    }

    @Override // r6.AbstractC2629p
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public void n(ArrayList arrayList, int i7, Object obj) {
        kotlin.jvm.internal.r.f(arrayList, "<this>");
        arrayList.add(i7, obj);
    }

    @Override // r6.AbstractC2610a
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public ArrayList k(List list) {
        kotlin.jvm.internal.r.f(list, "<this>");
        ArrayList arrayList = list instanceof ArrayList ? (ArrayList) list : null;
        return arrayList == null ? new ArrayList(list) : arrayList;
    }

    @Override // r6.AbstractC2610a
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public List l(ArrayList arrayList) {
        kotlin.jvm.internal.r.f(arrayList, "<this>");
        return arrayList;
    }
}
