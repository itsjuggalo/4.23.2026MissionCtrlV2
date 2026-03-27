package e1;

import android.content.Context;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import k0.C2063a;

/* JADX INFO: renamed from: e1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1470b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List f13560b = Arrays.asList("FNumber", "ExposureTime", "ISOSpeedRatings", "GPSAltitude", "GPSAltitudeRef", "FocalLength", "GPSDateStamp", "WhiteBalance", "GPSProcessingMethod", "GPSTimeStamp", "DateTime", "Flash", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "Make", "Model");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2063a f13561a;

    public C1470b(String str) {
        this.f13561a = new C2063a(str);
    }

    public static void a(C2063a c2063a, C2063a c2063a2) throws Throwable {
        Iterator it = f13560b.iterator();
        while (it.hasNext()) {
            b(c2063a, c2063a2, (String) it.next());
        }
        try {
            c2063a2.S();
        } catch (IOException unused) {
        }
    }

    public static void b(C2063a c2063a, C2063a c2063a2, String str) {
        if (c2063a.d(str) != null) {
            c2063a2.W(str, c2063a.d(str));
        }
    }

    public ByteArrayOutputStream c(Context context, ByteArrayOutputStream byteArrayOutputStream) throws Throwable {
        FileInputStream fileInputStream;
        Exception e7;
        FileOutputStream fileOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        try {
            String string = UUID.randomUUID().toString();
            File file = new File(context.getCacheDir(), string + ".jpg");
            fileOutputStream = new FileOutputStream(file);
            try {
                y6.a.e(byteArrayOutputStream.toByteArray(), fileOutputStream);
                fileOutputStream.close();
                C2063a c2063a = new C2063a(file.getAbsolutePath());
                a(this.f13561a, c2063a);
                c2063a.S();
                fileOutputStream.close();
                byteArrayOutputStream2 = new ByteArrayOutputStream();
                fileInputStream = new FileInputStream(file);
            } catch (Exception e8) {
                fileInputStream = null;
                e7 = e8;
            }
        } catch (Exception e9) {
            fileInputStream = null;
            e7 = e9;
            fileOutputStream = null;
        }
        try {
            y6.a.a(fileInputStream, byteArrayOutputStream2);
            fileInputStream.close();
            return byteArrayOutputStream2;
        } catch (Exception e10) {
            e7 = e10;
            Log.e("ExifDataCopier", "Error preserving Exif data on selected image: " + e7);
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e11) {
                    e11.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e12) {
                    e12.printStackTrace();
                }
            }
            return byteArrayOutputStream;
        }
    }

    public C1470b(byte[] bArr) {
        this.f13561a = new C2063a(new ByteArrayInputStream(bArr));
    }
}
