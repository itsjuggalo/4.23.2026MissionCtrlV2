package s6;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: s6.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C2725l implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Iterator f23186a;

    public C2725l(Iterator it) {
        this.f23186a = it;
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Map.Entry next() {
        Map.Entry entry = (Map.Entry) this.f23186a.next();
        entry.getValue();
        return entry;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f23186a.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.f23186a.remove();
    }
}
