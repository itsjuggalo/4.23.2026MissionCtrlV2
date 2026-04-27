package g3;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: g3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1269a {
    public static final long a(InputStream inputStream, OutputStream out, int i4) throws IOException {
        r.f(inputStream, "<this>");
        r.f(out, "out");
        byte[] bArr = new byte[i4];
        int i5 = inputStream.read(bArr);
        long j4 = 0;
        while (i5 >= 0) {
            out.write(bArr, 0, i5);
            j4 += (long) i5;
            i5 = inputStream.read(bArr);
        }
        return j4;
    }

    public static /* synthetic */ long b(InputStream inputStream, OutputStream outputStream, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = UserMetadata.MAX_INTERNAL_KEY_SIZE;
        }
        return a(inputStream, outputStream, i4);
    }

    public static final byte[] c(InputStream inputStream) {
        r.f(inputStream, "<this>");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(UserMetadata.MAX_INTERNAL_KEY_SIZE, inputStream.available()));
        b(inputStream, byteArrayOutputStream, 0, 2, null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        r.e(byteArray, "toByteArray(...)");
        return byteArray;
    }
}
