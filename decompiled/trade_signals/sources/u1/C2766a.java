package u1;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import u1.AbstractC2768c;

/* JADX INFO: renamed from: u1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2766a implements AbstractC2768c.a {

    /* JADX INFO: renamed from: u1.a$a, reason: collision with other inner class name */
    public static class C0408a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ZipFile f23503a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ZipEntry f23504b;

        public C0408a(ZipFile zipFile, ZipEntry zipEntry) {
            this.f23503a = zipFile;
            this.f23504b = zipEntry;
        }
    }

    @Override // u1.AbstractC2768c.a
    public void a(Context context, String[] strArr, String str, File file, C2769d c2769d) throws Throwable {
        String[] strArrE;
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        long jC;
        C0408a c0408a = null;
        Closeable closeable = null;
        try {
            C0408a c0408aD = d(context, strArr, str, c2769d);
            try {
                if (c0408aD == null) {
                    try {
                        strArrE = e(context, str);
                    } catch (Exception e8) {
                        strArrE = new String[]{e8.toString()};
                    }
                    throw new C2767b(str, strArr, strArrE);
                }
                int i8 = 0;
                while (true) {
                    int i9 = i8 + 1;
                    if (i8 >= 5) {
                        c2769d.h("FATAL! Couldn't extract the library from the APK!");
                        try {
                            ZipFile zipFile = c0408aD.f23503a;
                            if (zipFile != null) {
                                zipFile.close();
                                return;
                            }
                            return;
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    c2769d.i("Found %s! Extracting...", str);
                    try {
                        if (file.exists() || file.createNewFile()) {
                            try {
                                inputStream = c0408aD.f23503a.getInputStream(c0408aD.f23504b);
                                try {
                                    fileOutputStream = new FileOutputStream(file);
                                } catch (FileNotFoundException unused2) {
                                    fileOutputStream = null;
                                } catch (IOException unused3) {
                                    fileOutputStream = null;
                                } catch (Throwable th) {
                                    th = th;
                                    fileOutputStream = null;
                                }
                            } catch (FileNotFoundException unused4) {
                                inputStream = null;
                                fileOutputStream = null;
                            } catch (IOException unused5) {
                                inputStream = null;
                                fileOutputStream = null;
                            } catch (Throwable th2) {
                                th = th2;
                                fileOutputStream = null;
                            }
                            try {
                                jC = c(inputStream, fileOutputStream);
                                fileOutputStream.getFD().sync();
                            } catch (FileNotFoundException unused6) {
                                b(inputStream);
                            } catch (IOException unused7) {
                                b(inputStream);
                            } catch (Throwable th3) {
                                th = th3;
                                closeable = inputStream;
                                b(closeable);
                                b(fileOutputStream);
                                throw th;
                            }
                            if (jC == file.length()) {
                                b(inputStream);
                                b(fileOutputStream);
                                file.setReadable(true, false);
                                file.setExecutable(true, false);
                                file.setWritable(true);
                                try {
                                    ZipFile zipFile2 = c0408aD.f23503a;
                                    if (zipFile2 != null) {
                                        zipFile2.close();
                                        return;
                                    }
                                    return;
                                } catch (IOException unused8) {
                                    return;
                                }
                            }
                            b(inputStream);
                            b(fileOutputStream);
                        }
                    } catch (IOException unused9) {
                    }
                    i8 = i9;
                }
            } catch (Throwable th4) {
                th = th4;
                c0408a = c0408aD;
                if (c0408a != null) {
                    try {
                        ZipFile zipFile3 = c0408a.f23503a;
                        if (zipFile3 != null) {
                            zipFile3.close();
                        }
                    } catch (IOException unused10) {
                    }
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public final void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public final long c(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j8 = 0;
        while (true) {
            int i8 = inputStream.read(bArr);
            if (i8 == -1) {
                outputStream.flush();
                return j8;
            }
            outputStream.write(bArr, 0, i8);
            j8 += (long) i8;
        }
    }

    public final C0408a d(Context context, String[] strArr, String str, C2769d c2769d) {
        String[] strArrF = f(context);
        int length = strArrF.length;
        int i8 = 0;
        while (true) {
            ZipFile zipFile = null;
            if (i8 >= length) {
                return null;
            }
            String str2 = strArrF[i8];
            int i9 = 0;
            while (true) {
                int i10 = i9 + 1;
                if (i9 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), 1);
                    break;
                } catch (IOException unused) {
                    i9 = i10;
                }
            }
            if (zipFile != null) {
                int i11 = 0;
                while (true) {
                    int i12 = i11 + 1;
                    if (i11 < 5) {
                        for (String str3 : strArr) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("lib");
                            char c8 = File.separatorChar;
                            sb.append(c8);
                            sb.append(str3);
                            sb.append(c8);
                            sb.append(str);
                            String string = sb.toString();
                            c2769d.i("Looking for %s in APK %s...", string, str2);
                            ZipEntry entry = zipFile.getEntry(string);
                            if (entry != null) {
                                return new C0408a(zipFile, entry);
                            }
                        }
                        i11 = i12;
                    } else {
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
            i8++;
        }
    }

    public final String[] e(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("lib");
        char c8 = File.separatorChar;
        sb.append(c8);
        sb.append("([^\\");
        sb.append(c8);
        sb.append("]*)");
        sb.append(c8);
        sb.append(str);
        Pattern patternCompile = Pattern.compile(sb.toString());
        HashSet hashSet = new HashSet();
        for (String str2 : f(context)) {
            try {
                Enumeration<? extends ZipEntry> enumerationEntries = new ZipFile(new File(str2), 1).entries();
                while (enumerationEntries.hasMoreElements()) {
                    Matcher matcher = patternCompile.matcher(enumerationEntries.nextElement().getName());
                    if (matcher.matches()) {
                        hashSet.add(matcher.group(1));
                    }
                }
            } catch (IOException unused) {
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    public final String[] f(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr == null || strArr.length == 0) {
            return new String[]{applicationInfo.sourceDir};
        }
        String[] strArr2 = new String[strArr.length + 1];
        strArr2[0] = applicationInfo.sourceDir;
        System.arraycopy(strArr, 0, strArr2, 1, strArr.length);
        return strArr2;
    }
}
