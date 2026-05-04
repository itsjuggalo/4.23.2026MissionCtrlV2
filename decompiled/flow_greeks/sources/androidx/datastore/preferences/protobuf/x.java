package androidx.datastore.preferences.protobuf;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class x implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Iterator f1940a;

    public x(Iterator it) {
        this.f1940a = it;
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Map.Entry next() {
        Map.Entry entry = (Map.Entry) this.f1940a.next();
        entry.getValue();
        return entry;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f1940a.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.f1940a.remove();
    }
}
