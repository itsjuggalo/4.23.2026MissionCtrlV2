package w3;

import java.lang.reflect.Field;
import s3.AbstractC1024h;
import y3.AbstractC1430c;

/* JADX INFO: renamed from: w3.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1303x extends AbstractC1302w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v3.n f10822b;

    public C1303x(v3.n nVar, C1304y c1304y) {
        super(c1304y);
        this.f10822b = nVar;
    }

    @Override // w3.AbstractC1302w
    public final Object d() {
        return this.f10822b.b();
    }

    @Override // w3.AbstractC1302w
    public final void f(Object obj, B3.a aVar, C1301v c1301v) throws IllegalAccessException {
        Object objB = c1301v.f10818f.b(aVar);
        if (objB == null && c1301v.f10819g) {
            return;
        }
        Field field = c1301v.f10815b;
        if (c1301v.f10820h) {
            throw new t3.i(AbstractC1024h.b("Cannot set value of 'static final' ", AbstractC1430c.d(field, false)));
        }
        field.set(obj, objB);
    }

    @Override // w3.AbstractC1302w
    public final Object e(Object obj) {
        return obj;
    }
}
