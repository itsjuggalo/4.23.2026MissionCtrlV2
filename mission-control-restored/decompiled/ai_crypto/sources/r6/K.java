package r6;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class K extends Q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p6.e f22833c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K(n6.b kSerializer, n6.b vSerializer) {
        super(kSerializer, vSerializer, null);
        kotlin.jvm.internal.r.f(kSerializer, "kSerializer");
        kotlin.jvm.internal.r.f(vSerializer, "vSerializer");
        this.f22833c = new J(kSerializer.getDescriptor(), vSerializer.getDescriptor());
    }

    @Override // r6.Q, n6.b, n6.h, n6.a
    public p6.e getDescriptor() {
        return this.f22833c;
    }

    @Override // r6.AbstractC2610a
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public LinkedHashMap a() {
        return new LinkedHashMap();
    }

    @Override // r6.AbstractC2610a
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public int b(LinkedHashMap linkedHashMap) {
        kotlin.jvm.internal.r.f(linkedHashMap, "<this>");
        return linkedHashMap.size() * 2;
    }

    @Override // r6.AbstractC2610a
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public void c(LinkedHashMap linkedHashMap, int i7) {
        kotlin.jvm.internal.r.f(linkedHashMap, "<this>");
    }

    @Override // r6.AbstractC2610a
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public Iterator d(Map map) {
        kotlin.jvm.internal.r.f(map, "<this>");
        return map.entrySet().iterator();
    }

    @Override // r6.AbstractC2610a
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public int e(Map map) {
        kotlin.jvm.internal.r.f(map, "<this>");
        return map.size();
    }

    @Override // r6.AbstractC2610a
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public LinkedHashMap k(Map map) {
        kotlin.jvm.internal.r.f(map, "<this>");
        LinkedHashMap linkedHashMap = map instanceof LinkedHashMap ? (LinkedHashMap) map : null;
        return linkedHashMap == null ? new LinkedHashMap(map) : linkedHashMap;
    }

    @Override // r6.AbstractC2610a
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public Map l(LinkedHashMap linkedHashMap) {
        kotlin.jvm.internal.r.f(linkedHashMap, "<this>");
        return linkedHashMap;
    }
}
