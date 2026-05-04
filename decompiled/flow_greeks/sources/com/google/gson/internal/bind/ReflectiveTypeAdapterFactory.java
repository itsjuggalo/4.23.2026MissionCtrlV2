package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.a0;
import com.google.gson.internal.c0;
import com.google.gson.internal.d0;
import com.google.gson.internal.f0;
import com.google.gson.internal.u;
import com.google.gson.j;
import com.google.gson.m;
import com.google.gson.p;
import com.google.gson.r;
import com.google.gson.v;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class ReflectiveTypeAdapterFactory implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f6718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.gson.c f6719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Excluder f6720c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final JsonAdapterAnnotationTypeAdapterFactory f6721d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f6722e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class Adapter<T, A> extends TypeAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f6724a;

        public Adapter(c cVar) {
            this.f6724a = cVar;
        }

        @Override // com.google.gson.TypeAdapter
        public Object c(gb.a aVar) throws IOException {
            if (aVar.n0() == gb.b.NULL) {
                aVar.j0();
                return null;
            }
            Object objF = f();
            Map map = this.f6724a.f6741a;
            try {
                aVar.e();
                while (aVar.Z()) {
                    b bVar = (b) map.get(aVar.h0());
                    if (bVar == null) {
                        aVar.x0();
                    } else {
                        h(objF, aVar, bVar);
                    }
                }
                aVar.G();
                return g(objF);
            } catch (IllegalAccessException e10) {
                throw eb.a.e(e10);
            } catch (IllegalStateException e11) {
                throw new p(e11);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void e(gb.c cVar, Object obj) throws IOException {
            if (obj == null) {
                cVar.a0();
                return;
            }
            cVar.u();
            try {
                Iterator it = this.f6724a.f6742b.iterator();
                while (it.hasNext()) {
                    ((b) it.next()).c(cVar, obj);
                }
                cVar.G();
            } catch (IllegalAccessException e10) {
                throw eb.a.e(e10);
            }
        }

        public abstract Object f();

        public abstract Object g(Object obj);

        public abstract void h(Object obj, gb.a aVar, b bVar);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class RecordAdapter<T> extends Adapter<T, Object[]> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final Map f6726e = k();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Constructor f6727b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object[] f6728c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map f6729d;

        public RecordAdapter(Class cls, c cVar, boolean z10) {
            super(cVar);
            this.f6729d = new HashMap();
            Constructor constructorI = eb.a.i(cls);
            this.f6727b = constructorI;
            if (z10) {
                ReflectiveTypeAdapterFactory.b(null, constructorI);
            } else {
                eb.a.o(constructorI);
            }
            String[] strArrK = eb.a.k(cls);
            for (int i10 = 0; i10 < strArrK.length; i10++) {
                this.f6729d.put(strArrK[i10], Integer.valueOf(i10));
            }
            Class<?>[] parameterTypes = this.f6727b.getParameterTypes();
            this.f6728c = new Object[parameterTypes.length];
            for (int i11 = 0; i11 < parameterTypes.length; i11++) {
                this.f6728c[i11] = f6726e.get(parameterTypes[i11]);
            }
        }

        public static Map k() {
            HashMap map = new HashMap();
            map.put(Byte.TYPE, (byte) 0);
            map.put(Short.TYPE, (short) 0);
            map.put(Integer.TYPE, 0);
            map.put(Long.TYPE, 0L);
            map.put(Float.TYPE, Float.valueOf(0.0f));
            map.put(Double.TYPE, Double.valueOf(0.0d));
            map.put(Character.TYPE, (char) 0);
            map.put(Boolean.TYPE, Boolean.FALSE);
            return map;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Object[] f() {
            return (Object[]) this.f6728c.clone();
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Object g(Object[] objArr) {
            try {
                return this.f6727b.newInstance(objArr);
            } catch (IllegalAccessException e10) {
                throw eb.a.e(e10);
            } catch (IllegalArgumentException e11) {
                e = e11;
                throw new RuntimeException("Failed to invoke constructor '" + eb.a.c(this.f6727b) + "' with args " + Arrays.toString(objArr), e);
            } catch (InstantiationException e12) {
                e = e12;
                throw new RuntimeException("Failed to invoke constructor '" + eb.a.c(this.f6727b) + "' with args " + Arrays.toString(objArr), e);
            } catch (InvocationTargetException e13) {
                throw new RuntimeException("Failed to invoke constructor '" + eb.a.c(this.f6727b) + "' with args " + Arrays.toString(objArr), e13.getCause());
            }
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void h(Object[] objArr, gb.a aVar, b bVar) {
            Integer num = (Integer) this.f6729d.get(bVar.f6739c);
            if (num != null) {
                bVar.a(aVar, num.intValue(), objArr);
                return;
            }
            throw new IllegalStateException("Could not find the index in the constructor '" + eb.a.c(this.f6727b) + "' for field with name '" + bVar.f6739c + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f6730d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Method f6731e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ TypeAdapter f6732f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ TypeAdapter f6733g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ boolean f6734h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ boolean f6735i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, Field field, boolean z10, Method method, TypeAdapter typeAdapter, TypeAdapter typeAdapter2, boolean z11, boolean z12) {
            super(str, field);
            this.f6730d = z10;
            this.f6731e = method;
            this.f6732f = typeAdapter;
            this.f6733g = typeAdapter2;
            this.f6734h = z11;
            this.f6735i = z12;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.b
        public void a(gb.a aVar, int i10, Object[] objArr) {
            Object objC = this.f6733g.c(aVar);
            if (objC != null || !this.f6734h) {
                objArr[i10] = objC;
                return;
            }
            throw new m("null is not allowed as value for record component '" + this.f6739c + "' of primitive type; at path " + aVar.K());
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.b
        public void b(gb.a aVar, Object obj) throws IllegalAccessException {
            Object objC = this.f6733g.c(aVar);
            if (objC == null && this.f6734h) {
                return;
            }
            if (this.f6730d) {
                ReflectiveTypeAdapterFactory.b(obj, this.f6738b);
            } else if (this.f6735i) {
                throw new j("Cannot set value of 'static final' " + eb.a.g(this.f6738b, false));
            }
            this.f6738b.set(obj, objC);
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.b
        public void c(gb.c cVar, Object obj) throws IllegalAccessException {
            Object objInvoke;
            if (this.f6730d) {
                Method method = this.f6731e;
                if (method == null) {
                    ReflectiveTypeAdapterFactory.b(obj, this.f6738b);
                } else {
                    ReflectiveTypeAdapterFactory.b(obj, method);
                }
            }
            Method method2 = this.f6731e;
            if (method2 != null) {
                try {
                    objInvoke = method2.invoke(obj, null);
                } catch (InvocationTargetException e10) {
                    throw new j("Accessor " + eb.a.g(this.f6731e, false) + " threw exception", e10.getCause());
                }
            } else {
                objInvoke = this.f6738b.get(obj);
            }
            if (objInvoke == obj) {
                return;
            }
            cVar.R(this.f6737a);
            this.f6732f.e(cVar, objInvoke);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f6737a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Field f6738b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f6739c;

        public b(String str, Field field) {
            this.f6737a = str;
            this.f6738b = field;
            this.f6739c = field.getName();
        }

        public abstract void a(gb.a aVar, int i10, Object[] objArr);

        public abstract void b(gb.a aVar, Object obj);

        public abstract void c(gb.c cVar, Object obj);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f6740c = new c(Collections.EMPTY_MAP, Collections.EMPTY_LIST);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map f6741a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f6742b;

        public c(Map map, List list) {
            this.f6741a = map;
            this.f6742b = list;
        }
    }

    public ReflectiveTypeAdapterFactory(u uVar, com.google.gson.c cVar, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory, List list) {
        this.f6718a = uVar;
        this.f6719b = cVar;
        this.f6720c = excluder;
        this.f6721d = jsonAdapterAnnotationTypeAdapterFactory;
        this.f6722e = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(Object obj, AccessibleObject accessibleObject) {
        if (Modifier.isStatic(((Member) accessibleObject).getModifiers())) {
            obj = null;
        }
        if (d0.a(accessibleObject, obj)) {
            return;
        }
        throw new j(eb.a.g(accessibleObject, true) + " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type.");
    }

    public static IllegalArgumentException d(Class cls, String str, Field field, Field field2) {
        throw new IllegalArgumentException("Class " + cls.getName() + " declares multiple JSON fields named '" + str + "'; conflict is caused by fields " + eb.a.f(field) + " and " + eb.a.f(field2) + "\nSee " + f0.a("duplicate-fields"));
    }

    public final b c(Gson gson, Field field, Method method, String str, fb.a aVar, boolean z10, boolean z11) {
        boolean z12;
        TypeAdapter typeAdapterRuntimeTypeWrapper;
        boolean zA = c0.a(aVar.c());
        int modifiers = field.getModifiers();
        boolean z13 = false;
        if (Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers)) {
            z12 = false;
            z13 = true;
        } else {
            z12 = false;
        }
        cb.b bVar = (cb.b) field.getAnnotation(cb.b.class);
        TypeAdapter typeAdapterC = bVar != null ? this.f6721d.c(this.f6718a, gson, aVar, bVar, false) : null;
        boolean z14 = typeAdapterC == null ? z12 : true;
        if (typeAdapterC == null) {
            typeAdapterC = gson.k(aVar);
        }
        TypeAdapter typeAdapter = typeAdapterC;
        if (z10) {
            typeAdapterRuntimeTypeWrapper = z14 ? typeAdapter : new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, aVar.d());
        } else {
            typeAdapterRuntimeTypeWrapper = typeAdapter;
        }
        return new a(str, field, z11, method, typeAdapterRuntimeTypeWrapper, typeAdapter, zA, z13);
    }

    @Override // com.google.gson.v
    public TypeAdapter create(Gson gson, fb.a aVar) {
        Class clsC = aVar.c();
        if (!Object.class.isAssignableFrom(clsC)) {
            return null;
        }
        if (eb.a.l(clsC)) {
            return new TypeAdapter() { // from class: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.1
                @Override // com.google.gson.TypeAdapter
                public Object c(gb.a aVar2) throws IOException {
                    aVar2.x0();
                    return null;
                }

                @Override // com.google.gson.TypeAdapter
                public void e(gb.c cVar, Object obj) throws IOException {
                    cVar.a0();
                }

                public String toString() {
                    return "AnonymousOrNonStaticLocalClassAdapter";
                }
            };
        }
        r rVarB = d0.b(this.f6722e, clsC);
        if (rVarB != r.BLOCK_ALL) {
            boolean z10 = rVarB == r.BLOCK_INACCESSIBLE;
            return eb.a.m(clsC) ? new RecordAdapter(clsC, e(gson, aVar, clsC, z10, true), z10) : new FieldReflectionAdapter(this.f6718a.t(aVar), e(gson, aVar, clsC, z10, false));
        }
        throw new j("ReflectionAccessFilter does not permit using reflection for " + clsC + ". Register a TypeAdapter for this type or adjust the access filter.");
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00c8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x012c A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.c e(com.google.gson.Gson r20, fb.a r21, java.lang.Class r22, boolean r23, boolean r24) {
        /*
            Method dump skipped, instruction units count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.e(com.google.gson.Gson, fb.a, java.lang.Class, boolean, boolean):com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$c");
    }

    public final List f(Field field) {
        cb.c cVar = (cb.c) field.getAnnotation(cb.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.f6719b.a(field));
        }
        String strValue = cVar.value();
        String[] strArrAlternate = cVar.alternate();
        if (strArrAlternate.length == 0) {
            return Collections.singletonList(strValue);
        }
        ArrayList arrayList = new ArrayList(strArrAlternate.length + 1);
        arrayList.add(strValue);
        Collections.addAll(arrayList, strArrAlternate);
        return arrayList;
    }

    public final boolean g(Field field, boolean z10) {
        return !this.f6720c.c(field, z10);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class FieldReflectionAdapter<T> extends Adapter<T, T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a0 f6725b;

        public FieldReflectionAdapter(a0 a0Var, c cVar) {
            super(cVar);
            this.f6725b = a0Var;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public Object f() {
            return this.f6725b.a();
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public void h(Object obj, gb.a aVar, b bVar) {
            bVar.b(aVar, obj);
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public Object g(Object obj) {
            return obj;
        }
    }
}
