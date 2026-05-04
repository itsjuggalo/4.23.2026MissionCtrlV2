package com.google.firebase.firestore;

import d9.b1;
import d9.s1;
import g9.y1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import n9.x;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class k implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f6200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y1 f6201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FirebaseFirestore f6202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f6203d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b1 f6204e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final s1 f6205f;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator f6206a;

        public a(Iterator it) {
            this.f6206a = it;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public j next() {
            return k.this.c((j9.h) this.f6206a.next());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6206a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("QuerySnapshot does not support remove().");
        }
    }

    public k(i iVar, y1 y1Var, FirebaseFirestore firebaseFirestore) {
        this.f6200a = (i) x.b(iVar);
        this.f6201b = (y1) x.b(y1Var);
        this.f6202c = (FirebaseFirestore) x.b(firebaseFirestore);
        this.f6205f = new s1(y1Var.j(), y1Var.k());
    }

    public final j c(j9.h hVar) {
        return j.h(this.f6202c, hVar, this.f6201b.k(), this.f6201b.f().contains(hVar.getKey()));
    }

    public List d() {
        return e(b1.EXCLUDE);
    }

    public List e(b1 b1Var) {
        if (b1.INCLUDE.equals(b1Var) && this.f6201b.b()) {
            throw new IllegalArgumentException("To include metadata changes with your document changes, you must also pass MetadataChanges.INCLUDE to addSnapshotListener().");
        }
        if (this.f6203d == null || this.f6204e != b1Var) {
            this.f6203d = Collections.unmodifiableList(d9.g.a(this.f6202c, b1Var, this.f6201b));
            this.f6204e = b1Var;
        }
        return this.f6203d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f6202c.equals(kVar.f6202c) && this.f6200a.equals(kVar.f6200a) && this.f6201b.equals(kVar.f6201b) && this.f6205f.equals(kVar.f6205f);
    }

    public List f() {
        ArrayList arrayList = new ArrayList(this.f6201b.e().size());
        Iterator it = this.f6201b.e().iterator();
        while (it.hasNext()) {
            arrayList.add(c((j9.h) it.next()));
        }
        return arrayList;
    }

    public s1 g() {
        return this.f6205f;
    }

    public int hashCode() {
        return (((((this.f6202c.hashCode() * 31) + this.f6200a.hashCode()) * 31) + this.f6201b.hashCode()) * 31) + this.f6205f.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new a(this.f6201b.e().iterator());
    }
}
