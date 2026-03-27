package g6;

import E5.AbstractC0460e;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class x {

    public static final class a extends kotlin.jvm.internal.s implements Q5.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Q5.k f14330a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f14331b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ H5.g f14332c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Q5.k kVar, Object obj, H5.g gVar) {
            super(1);
            this.f14330a = kVar;
            this.f14331b = obj;
            this.f14332c = gVar;
        }

        public final void a(Throwable th) throws IllegalAccessException, InvocationTargetException {
            x.b(this.f14330a, this.f14331b, this.f14332c);
        }

        @Override // Q5.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) throws IllegalAccessException, InvocationTargetException {
            a((Throwable) obj);
            return E5.E.f1657a;
        }
    }

    public static final Q5.k a(Q5.k kVar, Object obj, H5.g gVar) {
        return new a(kVar, obj, gVar);
    }

    public static final void b(Q5.k kVar, Object obj, H5.g gVar) throws IllegalAccessException, InvocationTargetException {
        O oC = c(kVar, obj, null);
        if (oC != null) {
            b6.K.a(gVar, oC);
        }
    }

    public static final O c(Q5.k kVar, Object obj, O o7) throws IllegalAccessException, InvocationTargetException {
        try {
            kVar.invoke(obj);
        } catch (Throwable th) {
            if (o7 == null || o7.getCause() == th) {
                return new O("Exception in undelivered element handler for " + obj, th);
            }
            AbstractC0460e.a(o7, th);
        }
        return o7;
    }

    public static /* synthetic */ O d(Q5.k kVar, Object obj, O o7, int i7, Object obj2) {
        if ((i7 & 2) != 0) {
            o7 = null;
        }
        return c(kVar, obj, o7);
    }
}
