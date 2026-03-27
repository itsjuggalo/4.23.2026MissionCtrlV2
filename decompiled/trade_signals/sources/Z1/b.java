package Z1;

import Z1.a;
import android.os.IBinder;
import com.google.android.gms.common.internal.AbstractC1294n;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class b extends a.AbstractBinderC0162a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f9728a;

    public b(Object obj) {
        this.f9728a = obj;
    }

    public static Object F(a aVar) {
        if (aVar instanceof b) {
            return ((b) aVar).f9728a;
        }
        IBinder iBinderAsBinder = aVar.asBinder();
        Field[] declaredFields = iBinderAsBinder.getClass().getDeclaredFields();
        Field field = null;
        int i8 = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i8++;
                field = field2;
            }
        }
        if (i8 != 1) {
            throw new IllegalArgumentException("Unexpected number of IObjectWrapper declared fields: " + declaredFields.length);
        }
        AbstractC1294n.j(field);
        if (field.isAccessible()) {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        }
        field.setAccessible(true);
        try {
            return field.get(iBinderAsBinder);
        } catch (IllegalAccessException e8) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", e8);
        } catch (NullPointerException e9) {
            throw new IllegalArgumentException("Binder object is null.", e9);
        }
    }

    public static a G(Object obj) {
        return new b(obj);
    }
}
