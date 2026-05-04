package dh;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class m0 extends s0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bh.e f8186c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m0(zg.b kSerializer, zg.b vSerializer) {
        super(kSerializer, vSerializer, null);
        kotlin.jvm.internal.t.f(kSerializer, "kSerializer");
        kotlin.jvm.internal.t.f(vSerializer, "vSerializer");
        this.f8186c = new l0(kSerializer.getDescriptor(), vSerializer.getDescriptor());
    }

    @Override // dh.s0, zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return this.f8186c;
    }

    @Override // dh.a
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public LinkedHashMap a() {
        return new LinkedHashMap();
    }

    @Override // dh.a
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public int b(LinkedHashMap linkedHashMap) {
        kotlin.jvm.internal.t.f(linkedHashMap, "<this>");
        return linkedHashMap.size() * 2;
    }

    @Override // dh.a
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public void c(LinkedHashMap linkedHashMap, int i10) {
        kotlin.jvm.internal.t.f(linkedHashMap, "<this>");
    }

    @Override // dh.a
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public Iterator d(Map map) {
        kotlin.jvm.internal.t.f(map, "<this>");
        return map.entrySet().iterator();
    }

    @Override // dh.a
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public int e(Map map) {
        kotlin.jvm.internal.t.f(map, "<this>");
        return map.size();
    }

    @Override // dh.a
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public LinkedHashMap k(Map map) {
        kotlin.jvm.internal.t.f(map, "<this>");
        LinkedHashMap linkedHashMap = map instanceof LinkedHashMap ? (LinkedHashMap) map : null;
        return linkedHashMap == null ? new LinkedHashMap(map) : linkedHashMap;
    }

    @Override // dh.a
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public Map l(LinkedHashMap linkedHashMap) {
        kotlin.jvm.internal.t.f(linkedHashMap, "<this>");
        return linkedHashMap;
    }
}
