package o7;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: o7.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2501e extends AbstractC2525q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m7.e f22161b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2501e(k7.b element) {
        super(element);
        AbstractC2304t.f(element, "element");
        this.f22161b = new C2499d(element.getDescriptor());
    }

    @Override // o7.AbstractC2523p, k7.b, k7.k, k7.a
    public m7.e getDescriptor() {
        return this.f22161b;
    }

    @Override // o7.AbstractC2493a
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public ArrayList a() {
        return new ArrayList();
    }

    @Override // o7.AbstractC2493a
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public int b(ArrayList arrayList) {
        AbstractC2304t.f(arrayList, "<this>");
        return arrayList.size();
    }

    @Override // o7.AbstractC2493a
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public void c(ArrayList arrayList, int i8) {
        AbstractC2304t.f(arrayList, "<this>");
        arrayList.ensureCapacity(i8);
    }

    @Override // o7.AbstractC2523p
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public void n(ArrayList arrayList, int i8, Object obj) {
        AbstractC2304t.f(arrayList, "<this>");
        arrayList.add(i8, obj);
    }

    @Override // o7.AbstractC2493a
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public ArrayList k(List list) {
        AbstractC2304t.f(list, "<this>");
        ArrayList arrayList = list instanceof ArrayList ? (ArrayList) list : null;
        return arrayList == null ? new ArrayList(list) : arrayList;
    }

    @Override // o7.AbstractC2493a
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public List l(ArrayList arrayList) {
        AbstractC2304t.f(arrayList, "<this>");
        return arrayList;
    }
}
