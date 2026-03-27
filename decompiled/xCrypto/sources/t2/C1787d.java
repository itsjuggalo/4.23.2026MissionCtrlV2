package t2;

import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import q2.w;
import q2.x;
import x2.C1925a;
import y2.C1946a;

/* JADX INFO: renamed from: t2.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1787d extends w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final x f14759d = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f14760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f14761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f14762c;

    /* JADX INFO: renamed from: t2.d$a */
    public class a implements x {
        @Override // q2.x
        public w create(q2.e eVar, C1925a c1925a) {
            Class clsC = c1925a.c();
            a aVar = null;
            if (!Enum.class.isAssignableFrom(clsC) || clsC == Enum.class) {
                return null;
            }
            if (!clsC.isEnum()) {
                clsC = clsC.getSuperclass();
            }
            return new C1787d(clsC, aVar);
        }
    }

    public /* synthetic */ C1787d(Class cls, a aVar) {
        this(cls);
    }

    @Override // q2.w
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Enum c(C1946a c1946a) throws IOException {
        if (c1946a.r0() == y2.b.NULL) {
            c1946a.n0();
            return null;
        }
        String strP0 = c1946a.p0();
        Enum r02 = (Enum) this.f14760a.get(strP0);
        return r02 == null ? (Enum) this.f14761b.get(strP0) : r02;
    }

    @Override // q2.w
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void e(y2.c cVar, Enum r32) throws IOException {
        cVar.s0(r32 == null ? null : (String) this.f14762c.get(r32));
    }

    public C1787d(Class cls) {
        this.f14760a = new HashMap();
        this.f14761b = new HashMap();
        this.f14762c = new HashMap();
        try {
            Field[] declaredFields = cls.getDeclaredFields();
            int i4 = 0;
            for (Field field : declaredFields) {
                if (field.isEnumConstant()) {
                    declaredFields[i4] = field;
                    i4++;
                }
            }
            Field[] fieldArr = (Field[]) Arrays.copyOf(declaredFields, i4);
            AccessibleObject.setAccessible(fieldArr, true);
            for (Field field2 : fieldArr) {
                Enum r4 = (Enum) field2.get(null);
                String strName = r4.name();
                String string = r4.toString();
                r2.c cVar = (r2.c) field2.getAnnotation(r2.c.class);
                if (cVar != null) {
                    strName = cVar.value();
                    for (String str : cVar.alternate()) {
                        this.f14760a.put(str, r4);
                    }
                }
                this.f14760a.put(strName, r4);
                this.f14761b.put(string, r4);
                this.f14762c.put(r4, strName);
            }
        } catch (IllegalAccessException e4) {
            throw new AssertionError(e4);
        }
    }
}
