package androidx.datastore.preferences.protobuf;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0810x implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Iterator f7229a;

    public C0810x(Iterator it) {
        this.f7229a = it;
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Map.Entry next() {
        Map.Entry entry = (Map.Entry) this.f7229a.next();
        entry.getValue();
        return entry;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f7229a.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.f7229a.remove();
    }
}
