package i6;

import S5.h;
import java.util.Iterator;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2595q;

/* JADX INFO: renamed from: i6.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1969f implements S5.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q6.c f18866a;

    public C1969f(q6.c fqNameToMatch) {
        AbstractC2304t.f(fqNameToMatch, "fqNameToMatch");
        this.f18866a = fqNameToMatch;
    }

    @Override // S5.h
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C1967e b(q6.c fqName) {
        AbstractC2304t.f(fqName, "fqName");
        if (AbstractC2304t.b(fqName, this.f18866a)) {
            return C1967e.f18864a;
        }
        return null;
    }

    @Override // S5.h
    public boolean isEmpty() {
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return AbstractC2595q.i().iterator();
    }

    @Override // S5.h
    public boolean r(q6.c cVar) {
        return h.b.b(this, cVar);
    }
}
