package Z1;

import Z1.a;
import android.os.IBinder;
import com.google.android.gms.common.internal.AbstractC1207s;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class b extends a.AbstractBinderC0104a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f5704a;

    public b(Object obj) {
        this.f5704a = obj;
    }

    public static Object c(a aVar) {
        if (aVar instanceof b) {
            return ((b) aVar).f5704a;
        }
        IBinder iBinderAsBinder = aVar.asBinder();
        Field[] declaredFields = iBinderAsBinder.getClass().getDeclaredFields();
        Field field = null;
        int i7 = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i7++;
                field = field2;
            }
        }
        if (i7 != 1) {
            throw new IllegalArgumentException("Unexpected number of IObjectWrapper declared fields: " + declaredFields.length);
        }
        AbstractC1207s.k(field);
        if (field.isAccessible()) {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        }
        field.setAccessible(true);
        try {
            return field.get(iBinderAsBinder);
        } catch (IllegalAccessException e7) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", e7);
        } catch (NullPointerException e8) {
            throw new IllegalArgumentException("Binder object is null.", e8);
        }
    }

    public static a f(Object obj) {
        return new b(obj);
    }
}
