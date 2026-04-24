package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.v;
import java.io.IOException;
import java.lang.Enum;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import l4.c;
import o4.C2462a;
import p4.C2568a;
import p4.C2570c;
import p4.EnumC2569b;

/* JADX INFO: loaded from: classes.dex */
class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final v f16057d = new v() { // from class: com.google.gson.internal.bind.EnumTypeAdapter.1
        @Override // com.google.gson.v
        public TypeAdapter create(Gson gson, C2462a c2462a) {
            Class clsC = c2462a.c();
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
    public final Map f16058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f16059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f16060c;

    public EnumTypeAdapter(Class cls) {
        this.f16058a = new HashMap();
        this.f16059b = new HashMap();
        this.f16060c = new HashMap();
        try {
            Field[] declaredFields = cls.getDeclaredFields();
            int i8 = 0;
            for (Field field : declaredFields) {
                if (field.isEnumConstant()) {
                    declaredFields[i8] = field;
                    i8++;
                }
            }
            Field[] fieldArr = (Field[]) Arrays.copyOf(declaredFields, i8);
            AccessibleObject.setAccessible(fieldArr, true);
            for (Field field2 : fieldArr) {
                Enum r42 = (Enum) field2.get(null);
                String strName = r42.name();
                String string = r42.toString();
                c cVar = (c) field2.getAnnotation(c.class);
                if (cVar != null) {
                    strName = cVar.value();
                    for (String str : cVar.alternate()) {
                        this.f16058a.put(str, r42);
                    }
                }
                this.f16058a.put(strName, r42);
                this.f16059b.put(string, r42);
                this.f16060c.put(r42, strName);
            }
        } catch (IllegalAccessException e8) {
            throw new AssertionError(e8);
        }
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Enum c(C2568a c2568a) throws IOException {
        if (c2568a.x0() == EnumC2569b.NULL) {
            c2568a.r0();
            return null;
        }
        String strV0 = c2568a.v0();
        Enum r02 = (Enum) this.f16058a.get(strV0);
        return r02 == null ? (Enum) this.f16059b.get(strV0) : r02;
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void e(C2570c c2570c, Enum r32) throws IOException {
        c2570c.y0(r32 == null ? null : (String) this.f16060c.get(r32));
    }
}
