package B6;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.revenuecat.purchases.common.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            int i7 = inputStream.read(bArr);
            if (i7 == -1) {
                outputStream.flush();
                return;
            }
            outputStream.write(bArr, 0, i7);
        }
    }

    public static String b(Context context, Uri uri, String str, String[] strArr) throws Throwable {
        Cursor cursor = null;
        try {
            Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                        cursorQuery.close();
                        return string;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String d(android.content.Context r4, android.net.Uri r5) throws java.lang.Throwable {
        /*
            r0 = 0
            r1 = 0
            android.content.ContentResolver r2 = r4.getContentResolver()     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3b
            java.io.InputStream r5 = r2.openInputStream(r5)     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3b
            java.lang.String r2 = "image_picker"
            java.lang.String r3 = "jpg"
            java.io.File r4 = r4.getCacheDir()     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L35
            java.io.File r4 = java.io.File.createTempFile(r2, r3, r4)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L35
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L33
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L33
            if (r5 == 0) goto L25
            a(r5, r2)     // Catch: java.lang.Throwable -> L22 java.io.IOException -> L4a
            r3 = 1
            goto L26
        L22:
            r4 = move-exception
        L23:
            r0 = r5
            goto L3f
        L25:
            r3 = r1
        L26:
            if (r5 == 0) goto L2b
            r5.close()     // Catch: java.io.IOException -> L2b
        L2b:
            r2.close()     // Catch: java.io.IOException -> L54
            r1 = r3
            goto L54
        L30:
            r4 = move-exception
            r2 = r0
            goto L23
        L33:
            r2 = r0
            goto L4a
        L35:
            r4 = r0
            r2 = r4
            goto L4a
        L38:
            r4 = move-exception
            r2 = r0
            goto L3f
        L3b:
            r4 = r0
            r5 = r4
            r2 = r5
            goto L4a
        L3f:
            if (r0 == 0) goto L44
            r0.close()     // Catch: java.io.IOException -> L44
        L44:
            if (r2 == 0) goto L49
            r2.close()     // Catch: java.io.IOException -> L49
        L49:
            throw r4
        L4a:
            if (r5 == 0) goto L4f
            r5.close()     // Catch: java.io.IOException -> L4f
        L4f:
            if (r2 == 0) goto L54
            r2.close()     // Catch: java.io.IOException -> L54
        L54:
            if (r1 == 0) goto L5a
            java.lang.String r0 = r4.getPath()
        L5a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: B6.a.d(android.content.Context, android.net.Uri):java.lang.String");
    }

    public static boolean f(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean g(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean h(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public static boolean i(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public final String c(Context context, Uri uri) {
        Uri uri2 = null;
        if (DocumentsContract.isDocumentUri(context, uri)) {
            if (g(uri)) {
                String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
                if ("primary".equalsIgnoreCase(strArrSplit[0])) {
                    return Environment.getExternalStorageDirectory() + "/" + strArrSplit[1];
                }
            } else if (f(uri)) {
                String documentId = DocumentsContract.getDocumentId(uri);
                if (!TextUtils.isEmpty(documentId)) {
                    try {
                        return b(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue()), null, null);
                    } catch (NumberFormatException unused) {
                        return null;
                    }
                }
            } else if (i(uri)) {
                String[] strArrSplit2 = DocumentsContract.getDocumentId(uri).split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
                String str = strArrSplit2[0];
                if ("image".equals(str)) {
                    uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(str)) {
                    uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(str)) {
                    uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                return b(context, uri2, "_id=?", new String[]{strArrSplit2[1]});
            }
        } else {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                return h(uri) ? uri.getLastPathSegment() : b(context, uri, null, null);
            }
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        }
        return null;
    }

    public String e(Context context, Uri uri) {
        String strC = c(context, uri);
        return strC == null ? d(context, uri) : strC;
    }
}
