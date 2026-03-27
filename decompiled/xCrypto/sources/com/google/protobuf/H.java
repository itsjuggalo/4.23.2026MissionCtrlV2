package com.google.protobuf;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class H extends I {

    public static class a implements Map.Entry {
        public abstract H a();
    }

    public static class b implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Iterator f10951a;

        public b(Iterator it) {
            this.f10951a = it;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            Map.Entry entry = (Map.Entry) this.f10951a.next();
            entry.getValue();
            return entry;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f10951a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f10951a.remove();
        }
    }
}
