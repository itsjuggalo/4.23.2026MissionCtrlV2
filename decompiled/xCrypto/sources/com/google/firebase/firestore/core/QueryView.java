package com.google.firebase.firestore.core;

/* JADX INFO: loaded from: classes.dex */
final class QueryView {
    private final Query query;
    private final int targetId;
    private final View view;

    public QueryView(Query query, int i4, View view) {
        this.query = query;
        this.targetId = i4;
        this.view = view;
    }

    public Query getQuery() {
        return this.query;
    }

    public int getTargetId() {
        return this.targetId;
    }

    public View getView() {
        return this.view;
    }
}
