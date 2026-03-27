package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.FieldFilter;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.Values;
import com.google.firebase.firestore.util.Assert;
import p2.C1698D;

/* JADX INFO: loaded from: classes.dex */
public class KeyFieldFilter extends FieldFilter {
    private final DocumentKey key;

    public KeyFieldFilter(FieldPath fieldPath, FieldFilter.Operator operator, C1698D c1698d) {
        super(fieldPath, operator, c1698d);
        Assert.hardAssert(Values.isReferenceValue(c1698d), "KeyFieldFilter expects a ReferenceValue", new Object[0]);
        this.key = DocumentKey.fromName(getValue().D());
    }

    @Override // com.google.firebase.firestore.core.FieldFilter, com.google.firebase.firestore.core.Filter
    public boolean matches(Document document) {
        return matchesComparison(document.getKey().compareTo(this.key));
    }
}
