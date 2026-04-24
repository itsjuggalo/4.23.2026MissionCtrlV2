package o4;

import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import l4.C2172e;
import l4.w;
import l4.x;
import m4.InterfaceC2241c;
import s4.C2645a;
import t4.C2657a;

/* JADX INFO: renamed from: o4.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2312d extends w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final x f20068d = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f20069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f20070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f20071c;

    /* JADX INFO: renamed from: o4.d$a */
    public class a implements x {
        @Override // l4.x
        public w create(C2172e c2172e, C2645a c2645a) {
            Class clsC = c2645a.c();
            a aVar = null;
            if (!Enum.class.isAssignableFrom(clsC) || clsC == Enum.class) {
                return null;
            }
            if (!clsC.isEnum()) {
                clsC = clsC.getSuperclass();
            }
            return new C2312d(clsC, aVar);
        }
    }

    public /* synthetic */ C2312d(Class cls, a aVar) {
        this(cls);
    }

    @Override // l4.w
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Enum c(C2657a c2657a) throws IOException {
        if (c2657a.M0() == t4.b.NULL) {
            c2657a.I0();
            return null;
        }
        String strK0 = c2657a.K0();
        Enum r02 = (Enum) this.f20069a.get(strK0);
        return r02 == null ? (Enum) this.f20070b.get(strK0) : r02;
    }

    @Override // l4.w
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void e(t4.c cVar, Enum r32) throws IOException {
        cVar.N0(r32 == null ? null : (String) this.f20071c.get(r32));
    }

    public C2312d(Class cls) {
        this.f20069a = new HashMap();
        this.f20070b = new HashMap();
        this.f20071c = new HashMap();
        try {
            Field[] declaredFields = cls.getDeclaredFields();
            int i7 = 0;
            for (Field field : declaredFields) {
                if (field.isEnumConstant()) {
                    declaredFields[i7] = field;
                    i7++;
                }
            }
            Field[] fieldArr = (Field[]) Arrays.copyOf(declaredFields, i7);
            AccessibleObject.setAccessible(fieldArr, true);
            for (Field field2 : fieldArr) {
                Enum r42 = (Enum) field2.get(null);
                String strName = r42.name();
                String string = r42.toString();
                InterfaceC2241c interfaceC2241c = (InterfaceC2241c) field2.getAnnotation(InterfaceC2241c.class);
                if (interfaceC2241c != null) {
                    strName = interfaceC2241c.value();
                    for (String str : interfaceC2241c.alternate()) {
                        this.f20069a.put(str, r42);
                    }
                }
                this.f20069a.put(strName, r42);
                this.f20070b.put(string, r42);
                this.f20071c.put(r42, strName);
            }
        } catch (IllegalAccessException e7) {
            throw new AssertionError(e7);
        }
    }
}
