package V1;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class p extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3228a = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f3229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Iterator f3230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Iterator f3231d;
    public final /* synthetic */ q e;

    public p(q qVar) {
        this.e = qVar;
        this.f3230c = qVar.f3232a.iterator();
        this.f3231d = qVar.f3233b.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        Object next;
        int i = this.f3228a;
        if (i == 4) {
            throw new IllegalStateException();
        }
        int iC = S.i.c(i);
        if (iC == 0) {
            return true;
        }
        if (iC == 2) {
            return false;
        }
        this.f3228a = 4;
        Iterator it = this.f3230c;
        if (!it.hasNext()) {
            while (true) {
                Iterator it2 = this.f3231d;
                if (!it2.hasNext()) {
                    this.f3228a = 3;
                    next = null;
                    break;
                }
                next = it2.next();
                if (!this.e.f3232a.contains(next)) {
                    break;
                }
            }
        } else {
            next = it.next();
        }
        this.f3229b = next;
        if (this.f3228a == 3) {
            return false;
        }
        this.f3228a = 1;
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f3228a = 2;
        Object obj = this.f3229b;
        this.f3229b = null;
        return obj;
    }
}
