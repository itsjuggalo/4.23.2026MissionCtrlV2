package R5;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2487o;
import o5.C2489q;

/* JADX INFO: loaded from: classes2.dex */
public abstract class r0 {
    public r0() {
    }

    public abstract boolean a(q6.f fVar);

    public final r0 b(B5.k transform) {
        AbstractC2304t.f(transform, "transform");
        if (this instanceof A) {
            A a8 = (A) this;
            return new A(a8.c(), (M6.j) transform.invoke(a8.d()));
        }
        if (!(this instanceof I)) {
            throw new C2487o();
        }
        List<C2489q> listC = ((I) this).c();
        ArrayList arrayList = new ArrayList(p5.r.s(listC, 10));
        for (C2489q c2489q : listC) {
            arrayList.add(o5.w.a((q6.f) c2489q.a(), transform.invoke((M6.j) c2489q.b())));
        }
        return new I(arrayList);
    }

    public /* synthetic */ r0(AbstractC2296k abstractC2296k) {
        this();
    }
}
