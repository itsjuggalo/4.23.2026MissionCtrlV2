package y3;

import W2.AbstractC0737e;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class x {

    public static final class a extends kotlin.jvm.internal.s implements i3.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i3.k f16016a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f16017b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Z2.i f16018c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(i3.k kVar, Object obj, Z2.i iVar) {
            super(1);
            this.f16016a = kVar;
            this.f16017b = obj;
            this.f16018c = iVar;
        }

        public final void a(Throwable th) throws IllegalAccessException, InvocationTargetException {
            x.b(this.f16016a, this.f16017b, this.f16018c);
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) throws IllegalAccessException, InvocationTargetException {
            a((Throwable) obj);
            return W2.E.f5463a;
        }
    }

    public static final i3.k a(i3.k kVar, Object obj, Z2.i iVar) {
        return new a(kVar, obj, iVar);
    }

    public static final void b(i3.k kVar, Object obj, Z2.i iVar) throws IllegalAccessException, InvocationTargetException {
        O oC = c(kVar, obj, null);
        if (oC != null) {
            t3.K.a(iVar, oC);
        }
    }

    public static final O c(i3.k kVar, Object obj, O o4) throws IllegalAccessException, InvocationTargetException {
        try {
            kVar.invoke(obj);
            return o4;
        } catch (Throwable th) {
            if (o4 != null && o4.getCause() != th) {
                AbstractC0737e.a(o4, th);
                return o4;
            }
            return new O("Exception in undelivered element handler for " + obj, th);
        }
    }

    public static /* synthetic */ O d(i3.k kVar, Object obj, O o4, int i4, Object obj2) {
        if ((i4 & 2) != 0) {
            o4 = null;
        }
        return c(kVar, obj, o4);
    }
}
