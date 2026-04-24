package o7;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class M extends T {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m7.e f22125c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M(k7.b kSerializer, k7.b vSerializer) {
        super(kSerializer, vSerializer, null);
        AbstractC2304t.f(kSerializer, "kSerializer");
        AbstractC2304t.f(vSerializer, "vSerializer");
        this.f22125c = new L(kSerializer.getDescriptor(), vSerializer.getDescriptor());
    }

    @Override // o7.T, k7.b, k7.k, k7.a
    public m7.e getDescriptor() {
        return this.f22125c;
    }

    @Override // o7.AbstractC2493a
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public LinkedHashMap a() {
        return new LinkedHashMap();
    }

    @Override // o7.AbstractC2493a
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public int b(LinkedHashMap linkedHashMap) {
        AbstractC2304t.f(linkedHashMap, "<this>");
        return linkedHashMap.size() * 2;
    }

    @Override // o7.AbstractC2493a
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public void c(LinkedHashMap linkedHashMap, int i8) {
        AbstractC2304t.f(linkedHashMap, "<this>");
    }

    @Override // o7.AbstractC2493a
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public Iterator d(Map map) {
        AbstractC2304t.f(map, "<this>");
        return map.entrySet().iterator();
    }

    @Override // o7.AbstractC2493a
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public int e(Map map) {
        AbstractC2304t.f(map, "<this>");
        return map.size();
    }

    @Override // o7.AbstractC2493a
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public LinkedHashMap k(Map map) {
        AbstractC2304t.f(map, "<this>");
        LinkedHashMap linkedHashMap = map instanceof LinkedHashMap ? (LinkedHashMap) map : null;
        return linkedHashMap == null ? new LinkedHashMap(map) : linkedHashMap;
    }

    @Override // o7.AbstractC2493a
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public Map l(LinkedHashMap linkedHashMap) {
        AbstractC2304t.f(linkedHashMap, "<this>");
        return linkedHashMap;
    }
}
