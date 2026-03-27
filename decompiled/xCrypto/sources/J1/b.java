package J1;

import J1.a;
import android.os.IBinder;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class b extends a.AbstractBinderC0026a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f857a;

    public b(Object obj) {
        this.f857a = obj;
    }

    public static Object c(a aVar) {
        if (aVar instanceof b) {
            return ((b) aVar).f857a;
        }
        IBinder iBinderAsBinder = aVar.asBinder();
        Field[] declaredFields = iBinderAsBinder.getClass().getDeclaredFields();
        Field field = null;
        int i4 = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i4++;
                field = field2;
            }
        }
        if (i4 != 1) {
            throw new IllegalArgumentException("Unexpected number of IObjectWrapper declared fields: " + declaredFields.length);
        }
        AbstractC0940s.k(field);
        if (field.isAccessible()) {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        }
        field.setAccessible(true);
        try {
            return field.get(iBinderAsBinder);
        } catch (IllegalAccessException e4) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", e4);
        } catch (NullPointerException e5) {
            throw new IllegalArgumentException("Binder object is null.", e5);
        }
    }

    public static a f(Object obj) {
        return new b(obj);
    }
}
