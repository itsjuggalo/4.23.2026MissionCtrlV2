package L;

import K.d;
import Q.g;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap f4946a = new ConcurrentHashMap();

    public class a implements b {
        public a() {
        }

        @Override // L.j.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int a(g.b bVar) {
            return bVar.e();
        }

        @Override // L.j.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean b(g.b bVar) {
            return bVar.f();
        }
    }

    public interface b {
        int a(Object obj);

        boolean b(Object obj);
    }

    public static Object e(Object[] objArr, int i8, b bVar) {
        return f(objArr, (i8 & 1) == 0 ? RCHTTPStatusCodes.BAD_REQUEST : 700, (i8 & 2) != 0, bVar);
    }

    public static Object f(Object[] objArr, int i8, boolean z7, b bVar) {
        Object obj = null;
        int i9 = Integer.MAX_VALUE;
        for (Object obj2 : objArr) {
            int iAbs = (Math.abs(bVar.a(obj2) - i8) * 2) + (bVar.b(obj2) == z7 ? 0 : 1);
            if (obj == null || i9 > iAbs) {
                obj = obj2;
                i9 = iAbs;
            }
        }
        return obj;
    }

    public abstract Typeface a(Context context, d.c cVar, Resources resources, int i8);

    public abstract Typeface b(Context context, CancellationSignal cancellationSignal, g.b[] bVarArr, int i8);

    public Typeface c(Context context, InputStream inputStream) {
        File fileE = k.e(context);
        if (fileE == null) {
            return null;
        }
        try {
            if (k.d(fileE, inputStream)) {
                return Typeface.createFromFile(fileE.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileE.delete();
        }
    }

    public Typeface d(Context context, Resources resources, int i8, String str, int i9) {
        File fileE = k.e(context);
        if (fileE == null) {
            return null;
        }
        try {
            if (k.c(fileE, resources, i8)) {
                return Typeface.createFromFile(fileE.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileE.delete();
        }
    }

    public g.b g(g.b[] bVarArr, int i8) {
        return (g.b) e(bVarArr, i8, new a());
    }
}
