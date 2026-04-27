package com.google.firebase.firestore.model;

import com.google.firebase.firestore.model.mutation.FieldMask;
import com.google.firebase.firestore.util.Assert;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import p2.C1698D;
import p2.u;

/* JADX INFO: loaded from: classes.dex */
public final class ObjectValue implements Cloneable {
    private final Map<String, Object> overlayMap;
    private C1698D partialValue;

    public ObjectValue(C1698D c1698d) {
        this.overlayMap = new HashMap();
        Assert.hardAssert(c1698d.G() == C1698D.c.MAP_VALUE, "ObjectValues should be backed by a MapValue", new Object[0]);
        Assert.hardAssert(!ServerTimestamps.isServerTimestamp(c1698d), "ServerTimestamps should not be used as an ObjectValue", new Object[0]);
        this.partialValue = c1698d;
    }

    private u applyOverlay(FieldPath fieldPath, Map<String, Object> map) {
        C1698D c1698dExtractNestedValue = extractNestedValue(this.partialValue, fieldPath);
        u.b bVarT = Values.isMapValue(c1698dExtractNestedValue) ? (u.b) c1698dExtractNestedValue.C().toBuilder() : u.t();
        boolean z4 = false;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Map) {
                u uVarApplyOverlay = applyOverlay(fieldPath.append(key), (Map) value);
                if (uVarApplyOverlay != null) {
                    bVarT.h(key, (C1698D) C1698D.I().o(uVarApplyOverlay).build());
                    z4 = true;
                }
            } else {
                if (value instanceof C1698D) {
                    bVarT.h(key, (C1698D) value);
                } else if (bVarT.f(key)) {
                    Assert.hardAssert(value == null, "Expected entry to be a Map, a Value or null", new Object[0]);
                    bVarT.i(key);
                }
                z4 = true;
            }
        }
        if (z4) {
            return (u) bVarT.build();
        }
        return null;
    }

    private C1698D buildProto() {
        synchronized (this.overlayMap) {
            try {
                u uVarApplyOverlay = applyOverlay(FieldPath.EMPTY_PATH, this.overlayMap);
                if (uVarApplyOverlay != null) {
                    this.partialValue = (C1698D) C1698D.I().o(uVarApplyOverlay).build();
                    this.overlayMap.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.partialValue;
    }

    private FieldMask extractFieldMask(u uVar) {
        HashSet hashSet = new HashSet();
        for (Map.Entry entry : uVar.n().entrySet()) {
            FieldPath fieldPathFromSingleSegment = FieldPath.fromSingleSegment((String) entry.getKey());
            if (Values.isMapValue((C1698D) entry.getValue())) {
                Set<FieldPath> mask = extractFieldMask(((C1698D) entry.getValue()).C()).getMask();
                if (mask.isEmpty()) {
                    hashSet.add(fieldPathFromSingleSegment);
                } else {
                    Iterator<FieldPath> it = mask.iterator();
                    while (it.hasNext()) {
                        hashSet.add(fieldPathFromSingleSegment.append(it.next()));
                    }
                }
            } else {
                hashSet.add(fieldPathFromSingleSegment);
            }
        }
        return FieldMask.fromSet(hashSet);
    }

    private C1698D extractNestedValue(C1698D c1698d, FieldPath fieldPath) {
        if (fieldPath.isEmpty()) {
            return c1698d;
        }
        for (int i4 = 0; i4 < fieldPath.length() - 1; i4++) {
            c1698d = c1698d.C().o(fieldPath.getSegment(i4), null);
            if (!Values.isMapValue(c1698d)) {
                return null;
            }
        }
        return c1698d.C().o(fieldPath.getLastSegment(), null);
    }

    public static ObjectValue fromMap(Map<String, C1698D> map) {
        return new ObjectValue((C1698D) C1698D.I().n(u.t().g(map)).build());
    }

    private void setOverlay(FieldPath fieldPath, C1698D c1698d) {
        Map<String, Object> map;
        Map<String, Object> map2 = this.overlayMap;
        for (int i4 = 0; i4 < fieldPath.length() - 1; i4++) {
            String segment = fieldPath.getSegment(i4);
            Object obj = map2.get(segment);
            if (obj instanceof Map) {
                map = (Map) obj;
            } else {
                if (obj instanceof C1698D) {
                    C1698D c1698d2 = (C1698D) obj;
                    if (c1698d2.G() == C1698D.c.MAP_VALUE) {
                        HashMap map3 = new HashMap(c1698d2.C().n());
                        map2.put(segment, map3);
                        map2 = map3;
                    }
                }
                map = new HashMap<>();
                map2.put(segment, map);
            }
            map2 = map;
        }
        map2.put(fieldPath.getLastSegment(), c1698d);
    }

    public void delete(FieldPath fieldPath) {
        Assert.hardAssert(!fieldPath.isEmpty(), "Cannot delete field for empty path on ObjectValue", new Object[0]);
        setOverlay(fieldPath, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ObjectValue) {
            return Values.equals(buildProto(), ((ObjectValue) obj).buildProto());
        }
        return false;
    }

    public C1698D get(FieldPath fieldPath) {
        return extractNestedValue(buildProto(), fieldPath);
    }

    public FieldMask getFieldMask() {
        return extractFieldMask(buildProto().C());
    }

    public Map<String, C1698D> getFieldsMap() {
        return buildProto().C().n();
    }

    public int hashCode() {
        return buildProto().hashCode();
    }

    public void set(FieldPath fieldPath, C1698D c1698d) {
        Assert.hardAssert(!fieldPath.isEmpty(), "Cannot set field for empty path on ObjectValue", new Object[0]);
        setOverlay(fieldPath, c1698d);
    }

    public void setAll(Map<FieldPath, C1698D> map) {
        for (Map.Entry<FieldPath, C1698D> entry : map.entrySet()) {
            FieldPath key = entry.getKey();
            if (entry.getValue() == null) {
                delete(key);
            } else {
                set(key, entry.getValue());
            }
        }
    }

    public String toString() {
        return "ObjectValue{internalValue=" + Values.canonicalId(buildProto()) + '}';
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public ObjectValue m16clone() {
        return new ObjectValue(buildProto());
    }

    public ObjectValue() {
        this((C1698D) C1698D.I().o(u.l()).build());
    }
}
