package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.FieldFilter;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.Values;
import com.google.firebase.firestore.util.Assert;
import p2.C1698D;

/* JADX INFO: loaded from: classes.dex */
public class NotInFilter extends FieldFilter {
    public NotInFilter(FieldPath fieldPath, C1698D c1698d) {
        super(fieldPath, FieldFilter.Operator.NOT_IN, c1698d);
        Assert.hardAssert(Values.isArray(c1698d), "NotInFilter expects an ArrayValue", new Object[0]);
    }

    @Override // com.google.firebase.firestore.core.FieldFilter, com.google.firebase.firestore.core.Filter
    public boolean matches(Document document) {
        C1698D field;
        return (Values.contains(getValue().v(), Values.NULL_VALUE) || (field = document.getField(getField())) == null || field.H() || Values.contains(getValue().v(), field)) ? false : true;
    }
}
