package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.FieldFilter;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import java.util.ArrayList;
import java.util.List;
import p2.C1698D;

/* JADX INFO: loaded from: classes.dex */
public class KeyFieldNotInFilter extends FieldFilter {
    private final List<DocumentKey> keys;

    /* JADX WARN: Illegal instructions before constructor call */
    public KeyFieldNotInFilter(FieldPath fieldPath, C1698D c1698d) {
        FieldFilter.Operator operator = FieldFilter.Operator.NOT_IN;
        super(fieldPath, operator, c1698d);
        ArrayList arrayList = new ArrayList();
        this.keys = arrayList;
        arrayList.addAll(KeyFieldInFilter.extractDocumentKeysFromArrayValue(operator, c1698d));
    }

    @Override // com.google.firebase.firestore.core.FieldFilter, com.google.firebase.firestore.core.Filter
    public boolean matches(Document document) {
        return !this.keys.contains(document.getKey());
    }
}
