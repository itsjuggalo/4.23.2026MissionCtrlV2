package androidx.datastore.preferences.protobuf;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0952x implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Iterator f7637a;

    public C0952x(Iterator it) {
        this.f7637a = it;
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Map.Entry next() {
        Map.Entry entry = (Map.Entry) this.f7637a.next();
        entry.getValue();
        return entry;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f7637a.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.f7637a.remove();
    }
}
