package N0;

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

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List f2709b = Arrays.asList("FNumber", "ExposureTime", "ISOSpeedRatings", "GPSAltitude", "GPSAltitudeRef", "FocalLength", "GPSDateStamp", "WhiteBalance", "GPSProcessingMethod", "GPSTimeStamp", "DateTime", "Flash", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "Make", "Model");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final W.a f2710a;

    public b(String str) {
        this.f2710a = new W.a(str);
    }

    public static void a(W.a aVar, W.a aVar2) throws Throwable {
        Iterator it = f2709b.iterator();
        while (it.hasNext()) {
            b(aVar, aVar2, (String) it.next());
        }
        try {
            aVar2.S();
        } catch (IOException unused) {
        }
    }

    public static void b(W.a aVar, W.a aVar2, String str) {
        if (aVar.d(str) != null) {
            aVar2.W(str, aVar.d(str));
        }
    }

    public ByteArrayOutputStream c(Context context, ByteArrayOutputStream byteArrayOutputStream) throws Throwable {
        FileInputStream fileInputStream;
        Exception e4;
        FileOutputStream fileOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        try {
            String string = UUID.randomUUID().toString();
            File file = new File(context.getCacheDir(), string + ".jpg");
            fileOutputStream = new FileOutputStream(file);
            try {
                Q3.a.e(byteArrayOutputStream.toByteArray(), fileOutputStream);
                fileOutputStream.close();
                W.a aVar = new W.a(file.getAbsolutePath());
                a(this.f2710a, aVar);
                aVar.S();
                fileOutputStream.close();
                byteArrayOutputStream2 = new ByteArrayOutputStream();
                fileInputStream = new FileInputStream(file);
            } catch (Exception e5) {
                fileInputStream = null;
                e4 = e5;
            }
        } catch (Exception e6) {
            fileInputStream = null;
            e4 = e6;
            fileOutputStream = null;
        }
        try {
            Q3.a.a(fileInputStream, byteArrayOutputStream2);
            fileInputStream.close();
            return byteArrayOutputStream2;
        } catch (Exception e7) {
            e4 = e7;
            Log.e("ExifDataCopier", "Error preserving Exif data on selected image: " + e4);
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e8) {
                    e8.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e9) {
                    e9.printStackTrace();
                }
            }
            return byteArrayOutputStream;
        }
    }

    public b(byte[] bArr) {
        this.f2710a = new W.a(new ByteArrayInputStream(bArr));
    }
}
