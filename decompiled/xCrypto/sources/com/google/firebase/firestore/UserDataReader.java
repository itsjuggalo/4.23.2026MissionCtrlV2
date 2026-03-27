package com.google.firebase.firestore;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.core.UserData;
import com.google.firebase.firestore.model.DatabaseId;
import com.google.firebase.firestore.model.ObjectValue;
import com.google.firebase.firestore.model.Values;
import com.google.firebase.firestore.model.mutation.ArrayTransformOperation;
import com.google.firebase.firestore.model.mutation.FieldMask;
import com.google.firebase.firestore.model.mutation.NumericIncrementTransformOperation;
import com.google.firebase.firestore.model.mutation.ServerTimestampOperation;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.CustomClassMapper;
import com.google.firebase.firestore.util.Preconditions;
import com.google.firebase.firestore.util.Util;
import com.google.protobuf.f0;
import com.google.protobuf.u0;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p2.C1698D;
import p2.C1705b;
import p2.u;

/* JADX INFO: loaded from: classes.dex */
public final class UserDataReader {
    private final DatabaseId databaseId;

    public UserDataReader(DatabaseId databaseId) {
        this.databaseId = databaseId;
    }

    private ObjectValue convertAndParseDocumentData(Object obj, UserData.ParseContext parseContext) {
        if (obj.getClass().isArray()) {
            throw new IllegalArgumentException("Invalid data. Data must be a Map<String, Object> or a suitable POJO object, but it was an array");
        }
        C1698D data = parseData(CustomClassMapper.convertToPlainJavaTypes(obj), parseContext);
        if (data.G() == C1698D.c.MAP_VALUE) {
            return new ObjectValue(data);
        }
        throw new IllegalArgumentException("Invalid data. Data must be a Map<String, Object> or a suitable POJO object, but it was of type: " + Util.typeName(obj));
    }

    private List<C1698D> parseArrayTransformElements(List<Object> list) {
        UserData.ParseAccumulator parseAccumulator = new UserData.ParseAccumulator(UserData.Source.Argument);
        ArrayList arrayList = new ArrayList(list.size());
        for (int i4 = 0; i4 < list.size(); i4++) {
            arrayList.add(convertAndParseFieldData(list.get(i4), parseAccumulator.rootContext().childContext(i4)));
        }
        return arrayList;
    }

    private C1698D parseData(Object obj, UserData.ParseContext parseContext) {
        if (obj instanceof Map) {
            return parseMap((Map) obj, parseContext);
        }
        if (obj instanceof FieldValue) {
            parseSentinelFieldValue((FieldValue) obj, parseContext);
            return null;
        }
        if (parseContext.getPath() != null) {
            parseContext.addToFieldMask(parseContext.getPath());
        }
        if (!(obj instanceof List)) {
            return parseScalarValue(obj, parseContext);
        }
        if (!parseContext.isArrayElement() || parseContext.getDataSource() == UserData.Source.ArrayArgument) {
            return parseList((List) obj, parseContext);
        }
        throw parseContext.createError("Nested arrays are not supported");
    }

    private <T> C1698D parseList(List<T> list, UserData.ParseContext parseContext) {
        C1705b.C0224b c0224bT = C1705b.t();
        Iterator<T> it = list.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            C1698D data = parseData(it.next(), parseContext.childContext(i4));
            if (data == null) {
                data = (C1698D) C1698D.I().p(f0.NULL_VALUE).build();
            }
            c0224bT.g(data);
            i4++;
        }
        return (C1698D) C1698D.I().g(c0224bT).build();
    }

    private <K, V> C1698D parseMap(Map<K, V> map, UserData.ParseContext parseContext) {
        if (map.isEmpty()) {
            if (parseContext.getPath() != null && !parseContext.getPath().isEmpty()) {
                parseContext.addToFieldMask(parseContext.getPath());
            }
            return (C1698D) C1698D.I().o(p2.u.l()).build();
        }
        u.b bVarT = p2.u.t();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (!(entry.getKey() instanceof String)) {
                throw parseContext.createError(String.format("Non-String Map key (%s) is not allowed", entry.getValue()));
            }
            String str = (String) entry.getKey();
            C1698D data = parseData(entry.getValue(), parseContext.childContext(str));
            if (data != null) {
                bVarT.h(str, data);
            }
        }
        return (C1698D) C1698D.I().n(bVarT).build();
    }

    private C1698D parseScalarValue(Object obj, UserData.ParseContext parseContext) {
        if (obj == null) {
            return (C1698D) C1698D.I().p(f0.NULL_VALUE).build();
        }
        if (obj instanceof Integer) {
            return (C1698D) C1698D.I().m(((Integer) obj).intValue()).build();
        }
        if (obj instanceof Long) {
            return (C1698D) C1698D.I().m(((Long) obj).longValue()).build();
        }
        if (obj instanceof Float) {
            return (C1698D) C1698D.I().k(((Float) obj).doubleValue()).build();
        }
        if (obj instanceof Double) {
            return (C1698D) C1698D.I().k(((Double) obj).doubleValue()).build();
        }
        if (obj instanceof Boolean) {
            return (C1698D) C1698D.I().i(((Boolean) obj).booleanValue()).build();
        }
        if (obj instanceof String) {
            return (C1698D) C1698D.I().r((String) obj).build();
        }
        if (obj instanceof Date) {
            return parseTimestamp(new Timestamp((Date) obj));
        }
        if (obj instanceof Timestamp) {
            return parseTimestamp((Timestamp) obj);
        }
        if (obj instanceof GeoPoint) {
            GeoPoint geoPoint = (GeoPoint) obj;
            return (C1698D) C1698D.I().l(A2.a.p().f(geoPoint.getLatitude()).g(geoPoint.getLongitude())).build();
        }
        if (obj instanceof Blob) {
            return (C1698D) C1698D.I().j(((Blob) obj).toByteString()).build();
        }
        if (obj instanceof DocumentReference) {
            DocumentReference documentReference = (DocumentReference) obj;
            if (documentReference.getFirestore() != null) {
                DatabaseId databaseId = documentReference.getFirestore().getDatabaseId();
                if (!databaseId.equals(this.databaseId)) {
                    throw parseContext.createError(String.format("Document reference is for database %s/%s but should be for database %s/%s", databaseId.getProjectId(), databaseId.getDatabaseId(), this.databaseId.getProjectId(), this.databaseId.getDatabaseId()));
                }
            }
            return (C1698D) C1698D.I().q(String.format("projects/%s/databases/%s/documents/%s", this.databaseId.getProjectId(), this.databaseId.getDatabaseId(), documentReference.getPath())).build();
        }
        if (obj instanceof VectorValue) {
            return parseVectorValue((VectorValue) obj, parseContext);
        }
        if (obj.getClass().isArray()) {
            throw parseContext.createError("Arrays are not supported; use a List instead");
        }
        throw parseContext.createError("Unsupported type: " + Util.typeName(obj));
    }

    private void parseSentinelFieldValue(FieldValue fieldValue, UserData.ParseContext parseContext) {
        if (!parseContext.isWrite()) {
            throw parseContext.createError(String.format("%s() can only be used with set() and update()", fieldValue.getMethodName()));
        }
        if (parseContext.getPath() == null) {
            throw parseContext.createError(String.format("%s() is not currently supported inside arrays", fieldValue.getMethodName()));
        }
        if (fieldValue instanceof FieldValue.DeleteFieldValue) {
            if (parseContext.getDataSource() == UserData.Source.MergeSet) {
                parseContext.addToFieldMask(parseContext.getPath());
                return;
            } else {
                if (parseContext.getDataSource() != UserData.Source.Update) {
                    throw parseContext.createError("FieldValue.delete() can only be used with update() and set() with SetOptions.merge()");
                }
                Assert.hardAssert(parseContext.getPath().length() > 0, "FieldValue.delete() at the top level should have already been handled.", new Object[0]);
                throw parseContext.createError("FieldValue.delete() can only appear at the top level of your update data");
            }
        }
        if (fieldValue instanceof FieldValue.ServerTimestampFieldValue) {
            parseContext.addToFieldTransforms(parseContext.getPath(), ServerTimestampOperation.getInstance());
            return;
        }
        if (fieldValue instanceof FieldValue.ArrayUnionFieldValue) {
            parseContext.addToFieldTransforms(parseContext.getPath(), new ArrayTransformOperation.Union(parseArrayTransformElements(((FieldValue.ArrayUnionFieldValue) fieldValue).getElements())));
        } else if (fieldValue instanceof FieldValue.ArrayRemoveFieldValue) {
            parseContext.addToFieldTransforms(parseContext.getPath(), new ArrayTransformOperation.Remove(parseArrayTransformElements(((FieldValue.ArrayRemoveFieldValue) fieldValue).getElements())));
        } else {
            if (!(fieldValue instanceof FieldValue.NumericIncrementFieldValue)) {
                throw Assert.fail("Unknown FieldValue type: %s", Util.typeName(fieldValue));
            }
            parseContext.addToFieldTransforms(parseContext.getPath(), new NumericIncrementTransformOperation(parseQueryValue(((FieldValue.NumericIncrementFieldValue) fieldValue).getOperand())));
        }
    }

    private C1698D parseTimestamp(Timestamp timestamp) {
        return (C1698D) C1698D.I().s(u0.p().g(timestamp.getSeconds()).f((timestamp.getNanoseconds() / 1000) * 1000)).build();
    }

    private C1698D parseVectorValue(VectorValue vectorValue, UserData.ParseContext parseContext) {
        u.b bVarT = p2.u.t();
        bVarT.h(Values.TYPE_KEY, Values.VECTOR_VALUE_TYPE);
        bVarT.h("value", parseData(vectorValue.toList(), parseContext));
        return (C1698D) C1698D.I().n(bVarT).build();
    }

    public C1698D convertAndParseFieldData(Object obj, UserData.ParseContext parseContext) {
        return parseData(CustomClassMapper.convertToPlainJavaTypes(obj), parseContext);
    }

    public UserData.ParsedSetData parseMergeData(Object obj, FieldMask fieldMask) {
        UserData.ParseAccumulator parseAccumulator = new UserData.ParseAccumulator(UserData.Source.MergeSet);
        ObjectValue objectValueConvertAndParseDocumentData = convertAndParseDocumentData(obj, parseAccumulator.rootContext());
        if (fieldMask == null) {
            return parseAccumulator.toMergeData(objectValueConvertAndParseDocumentData);
        }
        for (com.google.firebase.firestore.model.FieldPath fieldPath : fieldMask.getMask()) {
            if (!parseAccumulator.contains(fieldPath)) {
                throw new IllegalArgumentException("Field '" + fieldPath.toString() + "' is specified in your field mask but not in your input data.");
            }
        }
        return parseAccumulator.toMergeData(objectValueConvertAndParseDocumentData, fieldMask);
    }

    public C1698D parseQueryValue(Object obj) {
        return parseQueryValue(obj, false);
    }

    public UserData.ParsedSetData parseSetData(Object obj) {
        UserData.ParseAccumulator parseAccumulator = new UserData.ParseAccumulator(UserData.Source.Set);
        return parseAccumulator.toSetData(convertAndParseDocumentData(obj, parseAccumulator.rootContext()));
    }

    public UserData.ParsedUpdateData parseUpdateData(Map<String, Object> map) {
        Preconditions.checkNotNull(map, "Provided update data must not be null.");
        UserData.ParseAccumulator parseAccumulator = new UserData.ParseAccumulator(UserData.Source.Update);
        UserData.ParseContext parseContextRootContext = parseAccumulator.rootContext();
        ObjectValue objectValue = new ObjectValue();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            com.google.firebase.firestore.model.FieldPath internalPath = FieldPath.fromDotSeparatedPath(entry.getKey()).getInternalPath();
            Object value = entry.getValue();
            if (value instanceof FieldValue.DeleteFieldValue) {
                parseContextRootContext.addToFieldMask(internalPath);
            } else {
                C1698D c1698dConvertAndParseFieldData = convertAndParseFieldData(value, parseContextRootContext.childContext(internalPath));
                if (c1698dConvertAndParseFieldData != null) {
                    parseContextRootContext.addToFieldMask(internalPath);
                    objectValue.set(internalPath, c1698dConvertAndParseFieldData);
                }
            }
        }
        return parseAccumulator.toUpdateData(objectValue);
    }

    public C1698D parseQueryValue(Object obj, boolean z4) {
        UserData.ParseAccumulator parseAccumulator = new UserData.ParseAccumulator(z4 ? UserData.Source.ArrayArgument : UserData.Source.Argument);
        C1698D c1698dConvertAndParseFieldData = convertAndParseFieldData(obj, parseAccumulator.rootContext());
        Assert.hardAssert(c1698dConvertAndParseFieldData != null, "Parsed data should not be null.", new Object[0]);
        Assert.hardAssert(parseAccumulator.getFieldTransforms().isEmpty(), "Field transforms should have been disallowed.", new Object[0]);
        return c1698dConvertAndParseFieldData;
    }

    public UserData.ParsedUpdateData parseUpdateData(List<Object> list) {
        com.google.firebase.firestore.model.FieldPath internalPath;
        Assert.hardAssert(list.size() % 2 == 0, "Expected fieldAndValues to contain an even number of elements", new Object[0]);
        UserData.ParseAccumulator parseAccumulator = new UserData.ParseAccumulator(UserData.Source.Update);
        UserData.ParseContext parseContextRootContext = parseAccumulator.rootContext();
        ObjectValue objectValue = new ObjectValue();
        Iterator<Object> it = list.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            Object next2 = it.next();
            boolean z4 = next instanceof String;
            Assert.hardAssert(z4 || (next instanceof FieldPath), "Expected argument to be String or FieldPath.", new Object[0]);
            if (z4) {
                internalPath = FieldPath.fromDotSeparatedPath((String) next).getInternalPath();
            } else {
                internalPath = ((FieldPath) next).getInternalPath();
            }
            if (next2 instanceof FieldValue.DeleteFieldValue) {
                parseContextRootContext.addToFieldMask(internalPath);
            } else {
                C1698D c1698dConvertAndParseFieldData = convertAndParseFieldData(next2, parseContextRootContext.childContext(internalPath));
                if (c1698dConvertAndParseFieldData != null) {
                    parseContextRootContext.addToFieldMask(internalPath);
                    objectValue.set(internalPath, c1698dConvertAndParseFieldData);
                }
            }
        }
        return parseAccumulator.toUpdateData(objectValue);
    }
}
