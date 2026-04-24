package com.google.protobuf;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: com.google.protobuf.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1484x implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Iterator f16609a;

    public C1484x(Iterator it) {
        this.f16609a = it;
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Map.Entry next() {
        Map.Entry entry = (Map.Entry) this.f16609a.next();
        entry.getValue();
        return entry;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f16609a.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.f16609a.remove();
    }
}
