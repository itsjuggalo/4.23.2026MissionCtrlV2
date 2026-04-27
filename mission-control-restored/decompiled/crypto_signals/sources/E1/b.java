package E1;

import a3.d;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.internal.I;
import com.google.android.gms.internal.common.zzb;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class b extends zzb implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f388a;

    public b(Object obj) {
        super("com.google.android.gms.dynamic.IObjectWrapper");
        this.f388a = obj;
    }

    public static a a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
        return iInterfaceQueryLocalInterface instanceof a ? (a) iInterfaceQueryLocalInterface : new c(iBinder, "com.google.android.gms.dynamic.IObjectWrapper");
    }

    public static Object b(a aVar) {
        if (aVar instanceof b) {
            return ((b) aVar).f388a;
        }
        IBinder iBinderAsBinder = aVar.asBinder();
        Field[] declaredFields = iBinderAsBinder.getClass().getDeclaredFields();
        Field field = null;
        int i = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i++;
                field = field2;
            }
        }
        if (i != 1) {
            throw new IllegalArgumentException(d.f(declaredFields.length, "Unexpected number of IObjectWrapper declared fields: "));
        }
        I.g(field);
        if (field.isAccessible()) {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        }
        field.setAccessible(true);
        try {
            return field.get(iBinderAsBinder);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", e);
        } catch (NullPointerException e2) {
            throw new IllegalArgumentException("Binder object is null.", e2);
        }
    }
}
