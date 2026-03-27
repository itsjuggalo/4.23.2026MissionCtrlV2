package e4;

import Z2.C;
import a3.InterfaceC0841b;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.tasks.Tasks;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {
    public static boolean a(Object obj, Object obj2) {
        return AbstractC1206q.b(obj, obj2);
    }

    public static String b(Y2.b bVar) {
        if (bVar == null) {
            return null;
        }
        try {
            V2.b bVar2 = (V2.b) Tasks.await(bVar.a(false), 30000L, TimeUnit.MILLISECONDS);
            if (bVar2.a() != null) {
                Log.w("StorageUtil", "Error getting App Check token; using placeholder token instead. Error: " + bVar2.a());
            }
            return bVar2.b();
        } catch (InterruptedException e7) {
            e = e7;
            Log.e("StorageUtil", "Unexpected error getting App Check token: " + e);
            return null;
        } catch (ExecutionException e8) {
            e = e8;
            Log.e("StorageUtil", "Unexpected error getting App Check token: " + e);
            return null;
        } catch (TimeoutException e9) {
            e = e9;
            Log.e("StorageUtil", "Unexpected error getting App Check token: " + e);
            return null;
        }
    }

    public static String c(InterfaceC0841b interfaceC0841b) {
        String strG;
        if (interfaceC0841b != null) {
            try {
                strG = ((C) Tasks.await(interfaceC0841b.d(false), 30000L, TimeUnit.MILLISECONDS)).g();
            } catch (InterruptedException e7) {
                e = e7;
                Log.e("StorageUtil", "error getting token " + e);
            } catch (ExecutionException e8) {
                e = e8;
                Log.e("StorageUtil", "error getting token " + e);
            } catch (TimeoutException e9) {
                e = e9;
                Log.e("StorageUtil", "error getting token " + e);
            }
        } else {
            strG = null;
        }
        if (!TextUtils.isEmpty(strG)) {
            return strG;
        }
        Log.w("StorageUtil", "no auth token for request");
        return null;
    }

    public static Uri d(Q2.g gVar, String str) {
        String strSubstring;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Uri uri = f4.e.f14121k;
        if (str.toLowerCase().startsWith("gs://")) {
            return Uri.parse("gs://" + AbstractC1482d.b(AbstractC1482d.a(str.substring(5))));
        }
        Uri uri2 = Uri.parse(str);
        String scheme = uri2.getScheme();
        if (scheme == null || !(a(scheme.toLowerCase(), "http") || a(scheme.toLowerCase(), "https"))) {
            Log.w("StorageUtil", "FirebaseStorage is unable to support the scheme:" + scheme);
            throw new IllegalArgumentException("Uri scheme");
        }
        int iIndexOf = uri2.getAuthority().toLowerCase().indexOf(uri.getAuthority());
        String strC = AbstractC1482d.c(uri2.getEncodedPath());
        if (iIndexOf == 0 && strC.startsWith("/")) {
            int iIndexOf2 = strC.indexOf("/b/", 0);
            int i7 = iIndexOf2 + 3;
            int iIndexOf3 = strC.indexOf("/", i7);
            int iIndexOf4 = strC.indexOf("/o/", 0);
            if (iIndexOf2 == -1 || iIndexOf3 == -1) {
                Log.w("StorageUtil", "Firebase Storage URLs must point to an object in your Storage Bucket. Please obtain a URL using the Firebase Console or getDownloadUrl().");
                throw new IllegalArgumentException("Firebase Storage URLs must point to an object in your Storage Bucket. Please obtain a URL using the Firebase Console or getDownloadUrl().");
            }
            strSubstring = strC.substring(i7, iIndexOf3);
            strC = iIndexOf4 != -1 ? strC.substring(iIndexOf4 + 3) : "";
        } else {
            if (iIndexOf <= 1) {
                Log.w("StorageUtil", "Firebase Storage URLs must point to an object in your Storage Bucket. Please obtain a URL using the Firebase Console or getDownloadUrl().");
                throw new IllegalArgumentException("Firebase Storage URLs must point to an object in your Storage Bucket. Please obtain a URL using the Firebase Console or getDownloadUrl().");
            }
            strSubstring = uri2.getAuthority().substring(0, iIndexOf - 1);
        }
        AbstractC1207s.f(strSubstring, "No bucket specified");
        return new Uri.Builder().scheme("gs").authority(strSubstring).encodedPath(strC).build();
    }

    public static long e(String str) {
        if (str == null) {
            return 0L;
        }
        String strReplaceAll = str.replaceAll("Z$", "-0000");
        try {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault()).parse(strReplaceAll).getTime();
        } catch (ParseException e7) {
            Log.w("StorageUtil", "unable to parse datetime:" + strReplaceAll, e7);
            return 0L;
        }
    }
}
