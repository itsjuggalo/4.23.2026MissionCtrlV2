package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.FieldFilter;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.Values;
import com.google.firebase.firestore.util.Assert;
import java.util.Iterator;
import p2.C1698D;

/* JADX INFO: loaded from: classes.dex */
public class ArrayContainsAnyFilter extends FieldFilter {
    public ArrayContainsAnyFilter(FieldPath fieldPath, C1698D c1698d) {
        super(fieldPath, FieldFilter.Operator.ARRAY_CONTAINS_ANY, c1698d);
        Assert.hardAssert(Values.isArray(c1698d), "ArrayContainsAnyFilter expects an ArrayValue", new Object[0]);
    }

    @Override // com.google.firebase.firestore.core.FieldFilter, com.google.firebase.firestore.core.Filter
    public boolean matches(Document document) {
        C1698D field = document.getField(getField());
        if (!Values.isArray(field)) {
            return false;
        }
        Iterator it = field.v().a().iterator();
        while (it.hasNext()) {
            if (Values.contains(getValue().v(), (C1698D) it.next())) {
                return true;
            }
        }
        return false;
    }
}
