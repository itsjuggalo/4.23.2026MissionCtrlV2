package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.FieldFilter;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.Values;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import java.util.List;
import p2.C1698D;

/* JADX INFO: loaded from: classes.dex */
public class KeyFieldInFilter extends FieldFilter {
    private final List<DocumentKey> keys;

    /* JADX WARN: Illegal instructions before constructor call */
    public KeyFieldInFilter(FieldPath fieldPath, C1698D c1698d) {
        FieldFilter.Operator operator = FieldFilter.Operator.IN;
        super(fieldPath, operator, c1698d);
        ArrayList arrayList = new ArrayList();
        this.keys = arrayList;
        arrayList.addAll(extractDocumentKeysFromArrayValue(operator, c1698d));
    }

    public static List<DocumentKey> extractDocumentKeysFromArrayValue(FieldFilter.Operator operator, C1698D c1698d) {
        Assert.hardAssert(operator == FieldFilter.Operator.IN || operator == FieldFilter.Operator.NOT_IN, "extractDocumentKeysFromArrayValue requires IN or NOT_IN operators", new Object[0]);
        Assert.hardAssert(Values.isArray(c1698d), "KeyFieldInFilter/KeyFieldNotInFilter expects an ArrayValue", new Object[0]);
        ArrayList arrayList = new ArrayList();
        for (C1698D c1698d2 : c1698d.v().a()) {
            Assert.hardAssert(Values.isReferenceValue(c1698d2), "Comparing on key with " + operator.toString() + ", but an array value was not a ReferenceValue", new Object[0]);
            arrayList.add(DocumentKey.fromName(c1698d2.D()));
        }
        return arrayList;
    }

    @Override // com.google.firebase.firestore.core.FieldFilter, com.google.firebase.firestore.core.Filter
    public boolean matches(Document document) {
        return this.keys.contains(document.getKey());
    }
}
