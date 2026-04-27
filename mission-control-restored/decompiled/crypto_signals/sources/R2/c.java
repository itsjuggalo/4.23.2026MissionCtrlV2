package R2;

import Z1.r;
import java.util.Collections;
import java.util.List;
import s3.I0;

/* JADX INFO: loaded from: classes.dex */
public abstract class c implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f2773a;

    public c(List list) {
        this.f2773a = Collections.unmodifiableList(list);
    }

    @Override // R2.p
    public final I0 a(I0 i02, r rVar) {
        return d(i02);
    }

    @Override // R2.p
    public final I0 b(I0 i02) {
        return null;
    }

    @Override // R2.p
    public final I0 c(I0 i02, I0 i03) {
        return d(i02);
    }

    public abstract I0 d(I0 i02);

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f2773a.equals(((c) obj).f2773a);
    }

    public final int hashCode() {
        return this.f2773a.hashCode() + (getClass().hashCode() * 31);
    }
}
