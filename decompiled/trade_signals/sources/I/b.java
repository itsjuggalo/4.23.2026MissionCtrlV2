package I;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.flutter.plugins.firebase.database.Constants;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends ContentProvider {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String[] f4009e = {"_display_name", "_size"};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final File f4010f = new File("/");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final HashMap f4011g = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f4012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InterfaceC0051b f4014c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f4015d;

    public static class a {
        public static File[] a(Context context) {
            return context.getExternalMediaDirs();
        }
    }

    /* JADX INFO: renamed from: I.b$b, reason: collision with other inner class name */
    public interface InterfaceC0051b {
        File a(Uri uri);

        Uri b(File file);
    }

    public static class c implements InterfaceC0051b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f4016a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HashMap f4017b = new HashMap();

        public c(String str) {
            this.f4016a = str;
        }

        @Override // I.b.InterfaceC0051b
        public File a(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int iIndexOf = encodedPath.indexOf(47, 1);
            String strDecode = Uri.decode(encodedPath.substring(1, iIndexOf));
            String strDecode2 = Uri.decode(encodedPath.substring(iIndexOf + 1));
            File file = (File) this.f4017b.get(strDecode);
            if (file == null) {
                throw new IllegalArgumentException("Unable to find configured root for " + uri);
            }
            File file2 = new File(file, strDecode2);
            try {
                File canonicalFile = file2.getCanonicalFile();
                if (d(canonicalFile.getPath(), file.getPath())) {
                    return canonicalFile;
                }
                throw new SecurityException("Resolved path jumped beyond configured root");
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file2);
            }
        }

        @Override // I.b.InterfaceC0051b
        public Uri b(File file) {
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry entry = null;
                for (Map.Entry entry2 : this.f4017b.entrySet()) {
                    String path = ((File) entry2.getValue()).getPath();
                    if (d(canonicalPath, path) && (entry == null || path.length() > ((File) entry.getValue()).getPath().length())) {
                        entry = entry2;
                    }
                }
                if (entry == null) {
                    throw new IllegalArgumentException("Failed to find configured root that contains " + canonicalPath);
                }
                String path2 = ((File) entry.getValue()).getPath();
                boolean zEndsWith = path2.endsWith("/");
                int length = path2.length();
                if (!zEndsWith) {
                    length++;
                }
                return new Uri.Builder().scheme(FirebaseAnalytics.Param.CONTENT).authority(this.f4016a).encodedPath(Uri.encode((String) entry.getKey()) + '/' + Uri.encode(canonicalPath.substring(length), "/")).build();
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
            }
        }

        public void c(String str, File file) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Name must not be empty");
            }
            try {
                this.f4017b.put(str, file.getCanonicalFile());
            } catch (IOException e8) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file, e8);
            }
        }

        public final boolean d(String str, String str2) {
            String strK = b.k(str);
            String strK2 = b.k(str2);
            if (!strK.equals(strK2)) {
                if (!strK.startsWith(strK2 + '/')) {
                    return false;
                }
            }
            return true;
        }
    }

    public b() {
        this(0);
    }

    public static File b(File file, String... strArr) {
        for (String str : strArr) {
            if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }

    public static Object[] c(Object[] objArr, int i8) {
        Object[] objArr2 = new Object[i8];
        System.arraycopy(objArr, 0, objArr2, 0, i8);
        return objArr2;
    }

    public static String[] d(String[] strArr, int i8) {
        String[] strArr2 = new String[i8];
        System.arraycopy(strArr, 0, strArr2, 0, i8);
        return strArr2;
    }

    public static XmlResourceParser e(Context context, String str, ProviderInfo providerInfo, int i8) {
        if (providerInfo == null) {
            throw new IllegalArgumentException("Couldn't find meta-data for provider with authority " + str);
        }
        if (providerInfo.metaData == null && i8 != 0) {
            Bundle bundle = new Bundle(1);
            providerInfo.metaData = bundle;
            bundle.putInt("android.support.FILE_PROVIDER_PATHS", i8);
        }
        XmlResourceParser xmlResourceParserLoadXmlMetaData = providerInfo.loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
        if (xmlResourceParserLoadXmlMetaData != null) {
            return xmlResourceParserLoadXmlMetaData;
        }
        throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
    }

    public static InterfaceC0051b g(Context context, String str, int i8) {
        InterfaceC0051b interfaceC0051bJ;
        HashMap map = f4011g;
        synchronized (map) {
            try {
                interfaceC0051bJ = (InterfaceC0051b) map.get(str);
                if (interfaceC0051bJ == null) {
                    try {
                        try {
                            interfaceC0051bJ = j(context, str, i8);
                            map.put(str, interfaceC0051bJ);
                        } catch (IOException e8) {
                            throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e8);
                        }
                    } catch (XmlPullParserException e9) {
                        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e9);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return interfaceC0051bJ;
    }

    public static Uri h(Context context, String str, File file) {
        return g(context, str, 0).b(file);
    }

    public static int i(String str) {
        if ("r".equals(str)) {
            return 268435456;
        }
        if ("w".equals(str) || "wt".equals(str)) {
            return 738197504;
        }
        if ("wa".equals(str)) {
            return 704643072;
        }
        if ("rw".equals(str)) {
            return 939524096;
        }
        if ("rwt".equals(str)) {
            return 1006632960;
        }
        throw new IllegalArgumentException("Invalid mode: " + str);
    }

    public static InterfaceC0051b j(Context context, String str, int i8) throws XmlPullParserException, IOException {
        c cVar = new c(str);
        XmlResourceParser xmlResourceParserE = e(context, str, context.getPackageManager().resolveContentProvider(str, 128), i8);
        while (true) {
            int next = xmlResourceParserE.next();
            if (next == 1) {
                return cVar;
            }
            if (next == 2) {
                String name = xmlResourceParserE.getName();
                File externalStorageDirectory = null;
                String attributeValue = xmlResourceParserE.getAttributeValue(null, "name");
                String attributeValue2 = xmlResourceParserE.getAttributeValue(null, Constants.PATH);
                if ("root-path".equals(name)) {
                    externalStorageDirectory = f4010f;
                } else if ("files-path".equals(name)) {
                    externalStorageDirectory = context.getFilesDir();
                } else if ("cache-path".equals(name)) {
                    externalStorageDirectory = context.getCacheDir();
                } else if ("external-path".equals(name)) {
                    externalStorageDirectory = Environment.getExternalStorageDirectory();
                } else if ("external-files-path".equals(name)) {
                    File[] fileArrG = I.a.g(context, null);
                    if (fileArrG.length > 0) {
                        externalStorageDirectory = fileArrG[0];
                    }
                } else if ("external-cache-path".equals(name)) {
                    File[] fileArrF = I.a.f(context);
                    if (fileArrF.length > 0) {
                        externalStorageDirectory = fileArrF[0];
                    }
                } else if ("external-media-path".equals(name)) {
                    File[] fileArrA = a.a(context);
                    if (fileArrA.length > 0) {
                        externalStorageDirectory = fileArrA[0];
                    }
                }
                if (externalStorageDirectory != null) {
                    cVar.c(attributeValue, b(externalStorageDirectory, attributeValue2));
                }
            }
        }
    }

    public static String k(String str) {
        return (str.length() <= 0 || str.charAt(str.length() + (-1)) != '/') ? str : str.substring(0, str.length() - 1);
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        }
        if (!providerInfo.grantUriPermissions) {
            throw new SecurityException("Provider must grant uri permissions");
        }
        String str = providerInfo.authority.split(";")[0];
        synchronized (this.f4012a) {
            this.f4013b = str;
        }
        HashMap map = f4011g;
        synchronized (map) {
            map.remove(str);
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return f().a(uri).delete() ? 1 : 0;
    }

    public final InterfaceC0051b f() {
        InterfaceC0051b interfaceC0051b;
        synchronized (this.f4012a) {
            try {
                S.c.d(this.f4013b, "mAuthority is null. Did you override attachInfo and did not call super.attachInfo()?");
                if (this.f4014c == null) {
                    this.f4014c = g(getContext(), this.f4013b, this.f4015d);
                }
                interfaceC0051b = this.f4014c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return interfaceC0051b;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        File fileA = f().a(uri);
        int iLastIndexOf = fileA.getName().lastIndexOf(46);
        if (iLastIndexOf < 0) {
            return "application/octet-stream";
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileA.getName().substring(iLastIndexOf + 1));
        return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public String getTypeAnonymous(Uri uri) {
        return "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) {
        return ParcelFileDescriptor.open(f().a(uri), i(str));
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i8;
        File fileA = f().a(uri);
        String queryParameter = uri.getQueryParameter("displayName");
        if (strArr == null) {
            strArr = f4009e;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i9 = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i9] = "_display_name";
                i8 = i9 + 1;
                objArr[i9] = queryParameter == null ? fileA.getName() : queryParameter;
            } else if ("_size".equals(str3)) {
                strArr3[i9] = "_size";
                i8 = i9 + 1;
                objArr[i9] = Long.valueOf(fileA.length());
            }
            i9 = i8;
        }
        String[] strArrD = d(strArr3, i9);
        Object[] objArrC = c(objArr, i9);
        MatrixCursor matrixCursor = new MatrixCursor(strArrD, 1);
        matrixCursor.addRow(objArrC);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    public b(int i8) {
        this.f4012a = new Object();
        this.f4015d = i8;
    }
}
