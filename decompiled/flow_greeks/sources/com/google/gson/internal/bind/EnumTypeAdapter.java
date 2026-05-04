package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.v;
import gb.c;
import java.io.IOException;
import java.lang.Enum;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final v f6693d = new v() { // from class: com.google.gson.internal.bind.EnumTypeAdapter.1
        @Override // com.google.gson.v
        public TypeAdapter create(Gson gson, fb.a aVar) {
            Class clsC = aVar.c();
            if (!Enum.class.isAssignableFrom(clsC) || clsC == Enum.class) {
                return null;
            }
            if (!clsC.isEnum()) {
                clsC = clsC.getSuperclass();
            }
            return new EnumTypeAdapter(clsC);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f6694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f6695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f6696c;

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Enum c(gb.a aVar) throws IOException {
        if (aVar.n0() == gb.b.NULL) {
            aVar.j0();
            return null;
        }
        String strL0 = aVar.l0();
        Enum r02 = (Enum) this.f6694a.get(strL0);
        return r02 == null ? (Enum) this.f6695b.get(strL0) : r02;
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void e(c cVar, Enum r32) throws IOException {
        cVar.o0(r32 == null ? null : (String) this.f6696c.get(r32));
    }

    public EnumTypeAdapter(Class cls) {
        this.f6694a = new HashMap();
        this.f6695b = new HashMap();
        this.f6696c = new HashMap();
        try {
            Field[] declaredFields = cls.getDeclaredFields();
            int i10 = 0;
            for (Field field : declaredFields) {
                if (field.isEnumConstant()) {
                    declaredFields[i10] = field;
                    i10++;
                }
            }
            Field[] fieldArr = (Field[]) Arrays.copyOf(declaredFields, i10);
            AccessibleObject.setAccessible(fieldArr, true);
            for (Field field2 : fieldArr) {
                Enum r42 = (Enum) field2.get(null);
                String strName = r42.name();
                String string = r42.toString();
                cb.c cVar = (cb.c) field2.getAnnotation(cb.c.class);
                if (cVar != null) {
                    strName = cVar.value();
                    for (String str : cVar.alternate()) {
                        this.f6694a.put(str, r42);
                    }
                }
                this.f6694a.put(strName, r42);
                this.f6695b.put(string, r42);
                this.f6696c.put(r42, strName);
            }
        } catch (IllegalAccessException e10) {
            throw new AssertionError(e10);
        }
    }
}
