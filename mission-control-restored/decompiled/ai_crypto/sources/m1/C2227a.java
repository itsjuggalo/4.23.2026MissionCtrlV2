package m1;

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
import m1.AbstractC2229c;

/* JADX INFO: renamed from: m1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2227a implements AbstractC2229c.a {

    /* JADX INFO: renamed from: m1.a$a, reason: collision with other inner class name */
    public static class C0309a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ZipFile f18941a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ZipEntry f18942b;

        public C0309a(ZipFile zipFile, ZipEntry zipEntry) {
            this.f18941a = zipFile;
            this.f18942b = zipEntry;
        }
    }

    @Override // m1.AbstractC2229c.a
    public void a(Context context, String[] strArr, String str, File file, C2230d c2230d) throws Throwable {
        String[] strArrE;
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        long jC;
        C0309a c0309a = null;
        Closeable closeable = null;
        try {
            C0309a c0309aD = d(context, strArr, str, c2230d);
            try {
                if (c0309aD == null) {
                    try {
                        strArrE = e(context, str);
                    } catch (Exception e7) {
                        strArrE = new String[]{e7.toString()};
                    }
                    throw new C2228b(str, strArr, strArrE);
                }
                int i7 = 0;
                while (true) {
                    int i8 = i7 + 1;
                    if (i7 >= 5) {
                        c2230d.i("FATAL! Couldn't extract the library from the APK!");
                        try {
                            ZipFile zipFile = c0309aD.f18941a;
                            if (zipFile != null) {
                                zipFile.close();
                                return;
                            }
                            return;
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    c2230d.j("Found %s! Extracting...", str);
                    try {
                        if (file.exists() || file.createNewFile()) {
                            try {
                                inputStream = c0309aD.f18941a.getInputStream(c0309aD.f18942b);
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
                                    ZipFile zipFile2 = c0309aD.f18941a;
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
                    i7 = i8;
                }
            } catch (Throwable th4) {
                th = th4;
                c0309a = c0309aD;
                if (c0309a != null) {
                    try {
                        ZipFile zipFile3 = c0309a.f18941a;
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
        long j7 = 0;
        while (true) {
            int i7 = inputStream.read(bArr);
            if (i7 == -1) {
                outputStream.flush();
                return j7;
            }
            outputStream.write(bArr, 0, i7);
            j7 += (long) i7;
        }
    }

    public final C0309a d(Context context, String[] strArr, String str, C2230d c2230d) {
        String[] strArrF = f(context);
        int length = strArrF.length;
        int i7 = 0;
        while (true) {
            ZipFile zipFile = null;
            if (i7 >= length) {
                return null;
            }
            String str2 = strArrF[i7];
            int i8 = 0;
            while (true) {
                int i9 = i8 + 1;
                if (i8 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), 1);
                    break;
                } catch (IOException unused) {
                    i8 = i9;
                }
            }
            if (zipFile != null) {
                int i10 = 0;
                while (true) {
                    int i11 = i10 + 1;
                    if (i10 < 5) {
                        for (String str3 : strArr) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("lib");
                            char c7 = File.separatorChar;
                            sb.append(c7);
                            sb.append(str3);
                            sb.append(c7);
                            sb.append(str);
                            String string = sb.toString();
                            c2230d.j("Looking for %s in APK %s...", string, str2);
                            ZipEntry entry = zipFile.getEntry(string);
                            if (entry != null) {
                                return new C0309a(zipFile, entry);
                            }
                        }
                        i10 = i11;
                    } else {
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
            i7++;
        }
    }

    public final String[] e(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("lib");
        char c7 = File.separatorChar;
        sb.append(c7);
        sb.append("([^\\");
        sb.append(c7);
        sb.append("]*)");
        sb.append(c7);
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
