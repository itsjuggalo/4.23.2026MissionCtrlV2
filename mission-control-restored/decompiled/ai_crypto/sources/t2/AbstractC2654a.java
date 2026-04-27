package t2;

import android.os.Build;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import n2.AbstractC2252a;

/* JADX INFO: renamed from: t2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2654a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f23117a = {AbstractC2252a.f19104h};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f23118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f23119c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map f23120d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map f23121e;

    /* JADX INFO: renamed from: t2.a$a, reason: collision with other inner class name */
    public class C0365a implements c {
        @Override // t2.AbstractC2654a.c
        public boolean a() {
            return true;
        }
    }

    /* JADX INFO: renamed from: t2.a$b */
    public class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f23122a;

        @Override // t2.AbstractC2654a.c
        public boolean a() {
            if (this.f23122a == null) {
                try {
                    Method declaredMethod = Build.class.getDeclaredMethod("getLong", String.class);
                    declaredMethod.setAccessible(true);
                    Long l7 = (Long) declaredMethod.invoke(null, "ro.build.version.oneui");
                    l7.longValue();
                    this.f23122a = l7;
                } catch (Exception unused) {
                    this.f23122a = -1L;
                }
            }
            return this.f23122a.longValue() >= 40100;
        }
    }

    /* JADX INFO: renamed from: t2.a$c */
    public interface c {
        boolean a();
    }

    static {
        C0365a c0365a = new C0365a();
        f23118b = c0365a;
        b bVar = new b();
        f23119c = bVar;
        HashMap map = new HashMap();
        map.put("fcnt", c0365a);
        map.put("google", c0365a);
        map.put("hmd global", c0365a);
        map.put("infinix", c0365a);
        map.put("infinix mobility limited", c0365a);
        map.put("itel", c0365a);
        map.put("kyocera", c0365a);
        map.put("lenovo", c0365a);
        map.put("lge", c0365a);
        map.put("motorola", c0365a);
        map.put("nothing", c0365a);
        map.put("oneplus", c0365a);
        map.put("oppo", c0365a);
        map.put("realme", c0365a);
        map.put("robolectric", c0365a);
        map.put("samsung", bVar);
        map.put("sharp", c0365a);
        map.put("sony", c0365a);
        map.put("tcl", c0365a);
        map.put("tecno", c0365a);
        map.put("tecno mobile limited", c0365a);
        map.put("vivo", c0365a);
        map.put("xiaomi", c0365a);
        f23120d = Collections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        map2.put("asus", c0365a);
        map2.put("jio", c0365a);
        f23121e = Collections.unmodifiableMap(map2);
    }

    public static boolean a() {
        if (Build.VERSION.SDK_INT < 31) {
            return false;
        }
        if (M.a.b()) {
            return true;
        }
        c cVar = (c) f23120d.get(Build.MANUFACTURER.toLowerCase());
        if (cVar == null) {
            cVar = (c) f23121e.get(Build.BRAND.toLowerCase());
        }
        return cVar != null && cVar.a();
    }
}
