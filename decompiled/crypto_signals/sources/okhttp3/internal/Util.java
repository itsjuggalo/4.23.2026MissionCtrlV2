package okhttp3.internal;

import j$.util.DesugarTimeZone;
import java.io.Closeable;
import java.io.InterruptedIOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import okhttp3.Headers;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.internal.http2.Header;
import u5.C1250g;
import u5.E;
import u5.j;

/* JADX INFO: loaded from: classes.dex */
public final class Util {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f8827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f8828b = new String[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TimeZone f8829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f8830d;

    static {
        byte[] bArr = new byte[0];
        f8827a = bArr;
        ResponseBody.d(bArr);
        RequestBody.a(bArr);
        j.c("efbbbf");
        j.c("feff");
        j.c("fffe");
        j.c("0000ffff");
        j.c("ffff0000");
        Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        Charset.forName("UTF-16BE");
        Charset.forName("UTF-16LE");
        Charset.forName("UTF-32BE");
        Charset.forName("UTF-32LE");
        f8829c = DesugarTimeZone.getTimeZone("GMT");
        new Comparator<String>() { // from class: okhttp3.internal.Util.1
            @Override // java.util.Comparator
            public final int compare(String str, String str2) {
                return str.compareTo(str2);
            }
        };
        try {
            Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
        }
        f8830d = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    private Util() {
    }

    public static AssertionError a(String str, Exception exc) {
        AssertionError assertionError = new AssertionError(str);
        try {
            assertionError.initCause(exc);
        } catch (IllegalStateException unused) {
        }
        return assertionError;
    }

    public static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static boolean c(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static List d(List list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static List e(Object... objArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) objArr.clone()));
    }

    public static boolean f(E e, int i) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long jNanoTime = System.nanoTime();
        long jC = e.b().f10505a ? e.b().c() - jNanoTime : Long.MAX_VALUE;
        e.b().d(Math.min(jC, timeUnit.toNanos(i)) + jNanoTime);
        try {
            C1250g c1250g = new C1250g();
            while (e.a(8192L, c1250g) != -1) {
                c1250g.d();
            }
            if (jC == Long.MAX_VALUE) {
                e.b().a();
                return true;
            }
            e.b().d(jNanoTime + jC);
            return true;
        } catch (InterruptedIOException unused) {
            if (jC == Long.MAX_VALUE) {
                e.b().a();
                return false;
            }
            e.b().d(jNanoTime + jC);
            return false;
        } catch (Throwable th) {
            if (jC == Long.MAX_VALUE) {
                e.b().a();
            } else {
                e.b().d(jNanoTime + jC);
            }
            throw th;
        }
    }

    public static ThreadFactory g(final String str, final boolean z6) {
        return new ThreadFactory() { // from class: okhttp3.internal.Util.2
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z6);
                return thread;
            }
        };
    }

    public static Headers h(ArrayList arrayList) {
        Headers.Builder builder = new Headers.Builder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Header header = (Header) it.next();
            Internal.f8825a.a(builder, header.f8858a.s(), header.f8859b.s());
        }
        return new Headers(builder);
    }
}
