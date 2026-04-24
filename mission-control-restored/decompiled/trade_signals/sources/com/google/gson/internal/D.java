package com.google.gson.internal;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class D {

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f16014a;

        public class a extends b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Method f16015b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Method method) {
                super();
                this.f16015b = method;
            }

            @Override // com.google.gson.internal.D.b
            public boolean a(AccessibleObject accessibleObject, Object obj) {
                try {
                    return ((Boolean) this.f16015b.invoke(accessibleObject, obj)).booleanValue();
                } catch (Exception e8) {
                    throw new RuntimeException("Failed invoking canAccess", e8);
                }
            }
        }

        /* JADX INFO: renamed from: com.google.gson.internal.D$b$b, reason: collision with other inner class name */
        public class C0258b extends b {
            public C0258b() {
                super();
            }

            @Override // com.google.gson.internal.D.b
            public boolean a(AccessibleObject accessibleObject, Object obj) {
                return true;
            }
        }

        static {
            b aVar;
            if (v.c()) {
                try {
                    aVar = new a(AccessibleObject.class.getDeclaredMethod("canAccess", Object.class));
                } catch (NoSuchMethodException unused) {
                    aVar = null;
                }
            } else {
                aVar = null;
            }
            if (aVar == null) {
                aVar = new C0258b();
            }
            f16014a = aVar;
        }

        public b() {
        }

        public abstract boolean a(AccessibleObject accessibleObject, Object obj);
    }

    public static boolean a(AccessibleObject accessibleObject, Object obj) {
        return b.f16014a.a(accessibleObject, obj);
    }

    public static com.google.gson.r b(List list, Class cls) {
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            return com.google.gson.r.ALLOW;
        }
        android.support.v4.media.session.b.a(it.next());
        throw null;
    }
}
