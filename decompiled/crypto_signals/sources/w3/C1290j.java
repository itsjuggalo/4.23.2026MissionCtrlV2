package w3;

import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import u3.InterfaceC1217b;

/* JADX INFO: renamed from: w3.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1290j extends t3.s {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C1289i f10784d = new C1289i();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f10785a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f10786b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f10787c = new HashMap();

    public C1290j(Class cls) {
        try {
            Field[] declaredFields = cls.getDeclaredFields();
            int i = 0;
            for (Field field : declaredFields) {
                if (field.isEnumConstant()) {
                    declaredFields[i] = field;
                    i++;
                }
            }
            Field[] fieldArr = (Field[]) Arrays.copyOf(declaredFields, i);
            AccessibleObject.setAccessible(fieldArr, true);
            for (Field field2 : fieldArr) {
                Enum r42 = (Enum) field2.get(null);
                String strName = r42.name();
                String string = r42.toString();
                InterfaceC1217b interfaceC1217b = (InterfaceC1217b) field2.getAnnotation(InterfaceC1217b.class);
                if (interfaceC1217b != null) {
                    strName = interfaceC1217b.value();
                    for (String str : interfaceC1217b.alternate()) {
                        this.f10785a.put(str, r42);
                    }
                }
                this.f10785a.put(strName, r42);
                this.f10786b.put(string, r42);
                this.f10787c.put(r42, strName);
            }
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }

    @Override // t3.s
    public final Object b(B3.a aVar) throws IOException {
        if (aVar.B() == 9) {
            aVar.x();
            return null;
        }
        String strZ = aVar.z();
        Enum r02 = (Enum) this.f10785a.get(strZ);
        return r02 == null ? (Enum) this.f10786b.get(strZ) : r02;
    }

    @Override // t3.s
    public final void c(B3.b bVar, Object obj) throws IOException {
        Enum r32 = (Enum) obj;
        bVar.v(r32 == null ? null : (String) this.f10787c.get(r32));
    }
}
