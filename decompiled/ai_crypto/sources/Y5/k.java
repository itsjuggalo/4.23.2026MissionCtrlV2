package Y5;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k extends j {

    public static final class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterator f5663a;

        public a(Iterator it) {
            this.f5663a = it;
        }

        @Override // Y5.f
        public Iterator iterator() {
            return this.f5663a;
        }
    }

    public static final class b extends s implements Q5.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f5664a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Function0 function0) {
            super(1);
            this.f5664a = function0;
        }

        @Override // Q5.k
        public final Object invoke(Object it) {
            r.f(it, "it");
            return this.f5664a.invoke();
        }
    }

    public static f c(Iterator it) {
        r.f(it, "<this>");
        return d(new a(it));
    }

    public static f d(f fVar) {
        r.f(fVar, "<this>");
        return fVar instanceof Y5.a ? fVar : new Y5.a(fVar);
    }

    public static f e() {
        return d.f5652a;
    }

    public static f f(Function0 nextFunction) {
        r.f(nextFunction, "nextFunction");
        return d(new e(nextFunction, new b(nextFunction)));
    }
}
