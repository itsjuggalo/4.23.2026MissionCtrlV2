package Y2;

import android.util.Log;
import com.google.firebase.components.ComponentRegistrar;
import java.lang.reflect.InvocationTargetException;
import k2.C0764j;
import s3.AbstractC1024h;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements X2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3594b;

    public /* synthetic */ b(Object obj, int i) {
        this.f3593a = i;
        this.f3594b = obj;
    }

    @Override // X2.b
    public final Object get() {
        switch (this.f3593a) {
            case 0:
                return new Z2.c((Z1.h) this.f3594b);
            case 1:
                String str = (String) this.f3594b;
                try {
                    Class<?> cls = Class.forName(str);
                    if (ComponentRegistrar.class.isAssignableFrom(cls)) {
                        return (ComponentRegistrar) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    }
                    throw new C0764j("Class " + str + " is not an instance of com.google.firebase.components.ComponentRegistrar");
                } catch (ClassNotFoundException unused) {
                    Log.w("ComponentDiscovery", "Class " + str + " is not an found.");
                    return null;
                } catch (IllegalAccessException e) {
                    throw new C0764j(AbstractC1024h.c("Could not instantiate ", str, "."), e);
                } catch (InstantiationException e2) {
                    throw new C0764j(AbstractC1024h.c("Could not instantiate ", str, "."), e2);
                } catch (NoSuchMethodException e6) {
                    throw new C0764j(AbstractC1024h.b("Could not instantiate ", str), e6);
                } catch (InvocationTargetException e7) {
                    throw new C0764j(AbstractC1024h.b("Could not instantiate ", str), e7);
                }
            default:
                return (ComponentRegistrar) this.f3594b;
        }
    }
}
