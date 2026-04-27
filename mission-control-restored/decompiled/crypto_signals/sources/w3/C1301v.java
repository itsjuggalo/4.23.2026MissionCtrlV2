package w3;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import s3.AbstractC1024h;
import y3.AbstractC1430c;

/* JADX INFO: renamed from: w3.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1301v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Field f10815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f10816c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Method f10817d;
    public final /* synthetic */ t3.s e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ t3.s f10818f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ boolean f10819g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ boolean f10820h;

    public C1301v(String str, Field field, Method method, t3.s sVar, t3.s sVar2, boolean z6, boolean z7) {
        this.f10817d = method;
        this.e = sVar;
        this.f10818f = sVar2;
        this.f10819g = z6;
        this.f10820h = z7;
        this.f10814a = str;
        this.f10815b = field;
        this.f10816c = field.getName();
    }

    public final void a(B3.b bVar, Object obj) throws IllegalAccessException {
        Object objInvoke;
        Field field = this.f10815b;
        Method method = this.f10817d;
        if (method != null) {
            try {
                objInvoke = method.invoke(obj, new Object[0]);
            } catch (InvocationTargetException e) {
                throw new t3.i(AbstractC1024h.c("Accessor ", AbstractC1430c.d(method, false), " threw exception"), e.getCause());
            }
        } else {
            objInvoke = field.get(obj);
        }
        if (objInvoke == obj) {
            return;
        }
        bVar.k(this.f10814a);
        this.e.c(bVar, objInvoke);
    }
}
