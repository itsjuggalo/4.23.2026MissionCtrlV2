package androidx.datastore.preferences.protobuf;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1121x implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Iterator f11449a;

    public C1121x(Iterator it) {
        this.f11449a = it;
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Map.Entry next() {
        Map.Entry entry = (Map.Entry) this.f11449a.next();
        entry.getValue();
        return entry;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f11449a.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.f11449a.remove();
    }
}
