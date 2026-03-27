package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.FieldFilter;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.Values;
import p2.C1698D;

/* JADX INFO: loaded from: classes.dex */
public class ArrayContainsFilter extends FieldFilter {
    public ArrayContainsFilter(FieldPath fieldPath, C1698D c1698d) {
        super(fieldPath, FieldFilter.Operator.ARRAY_CONTAINS, c1698d);
    }

    @Override // com.google.firebase.firestore.core.FieldFilter, com.google.firebase.firestore.core.Filter
    public boolean matches(Document document) {
        C1698D field = document.getField(getField());
        return Values.isArray(field) && Values.contains(field.v(), getValue());
    }
}
