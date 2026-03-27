package g3;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: renamed from: g3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0611b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f6559b;

    public C0611b(Set set, c cVar) {
        this.f6558a = b(set);
        this.f6559b = cVar;
    }

    public static String b(Set set) {
        StringBuilder sb = new StringBuilder();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            C0610a c0610a = (C0610a) it.next();
            sb.append(c0610a.f6556a);
            sb.append('/');
            sb.append(c0610a.f6557b);
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    public final String a() {
        Set setUnmodifiableSet;
        Set setUnmodifiableSet2;
        c cVar = this.f6559b;
        synchronized (cVar.f6561a) {
            setUnmodifiableSet = Collections.unmodifiableSet(cVar.f6561a);
        }
        boolean zIsEmpty = setUnmodifiableSet.isEmpty();
        String str = this.f6558a;
        if (zIsEmpty) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(' ');
        synchronized (cVar.f6561a) {
            setUnmodifiableSet2 = Collections.unmodifiableSet(cVar.f6561a);
        }
        sb.append(b(setUnmodifiableSet2));
        return sb.toString();
    }
}
