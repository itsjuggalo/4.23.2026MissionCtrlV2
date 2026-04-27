package N0;

import X.h;
import android.content.Context;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List f1089b = Arrays.asList("FNumber", "ExposureTime", "ISOSpeedRatings", "GPSAltitude", "GPSAltitudeRef", "FocalLength", "GPSDateStamp", "WhiteBalance", "GPSProcessingMethod", "GPSTimeStamp", "DateTime", "Flash", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "Make", "Model");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f1090a;

    public a(String str) {
        this.f1090a = new h(str);
    }

    public final ByteArrayOutputStream a(Context context, ByteArrayOutputStream byteArrayOutputStream) {
        FileInputStream fileInputStream;
        Exception e;
        FileOutputStream fileOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        try {
            String string = UUID.randomUUID().toString();
            File file = new File(context.getCacheDir(), string + ".jpg");
            fileOutputStream = new FileOutputStream(file);
            try {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                int i = w5.a.f11446a;
                if (byteArray != null) {
                    fileOutputStream.write(byteArray);
                }
                fileOutputStream.close();
                h hVar = new h(file.getAbsolutePath());
                h hVar2 = this.f1090a;
                for (String str : f1089b) {
                    if (hVar2.b(str) != null) {
                        hVar.D(str, hVar2.b(str));
                    }
                }
                try {
                    hVar.z();
                } catch (IOException unused) {
                }
                hVar.z();
                fileOutputStream.close();
                byteArrayOutputStream2 = new ByteArrayOutputStream();
                fileInputStream = new FileInputStream(file);
            } catch (Exception e2) {
                fileInputStream = null;
                e = e2;
            }
        } catch (Exception e6) {
            fileInputStream = null;
            e = e6;
            fileOutputStream = null;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int i6 = fileInputStream.read(bArr);
                if (-1 == i6) {
                    fileInputStream.close();
                    return byteArrayOutputStream2;
                }
                byteArrayOutputStream2.write(bArr, 0, i6);
            }
        } catch (Exception e7) {
            e = e7;
            Log.e("ExifDataCopier", "Error preserving Exif data on selected image: " + e);
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

    public a(byte[] bArr) {
        this.f1090a = new h(new ByteArrayInputStream(bArr));
    }
}
