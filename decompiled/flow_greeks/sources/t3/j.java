package t3;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import i3.v;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class j implements g3.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f20726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g3.j f20727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j3.b f20728c;

    public j(List list, g3.j jVar, j3.b bVar) {
        this.f20726a = list;
        this.f20727b = jVar;
        this.f20728c = bVar;
    }

    public static byte[] e(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int i10 = inputStream.read(bArr);
                if (i10 == -1) {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, i10);
            }
        } catch (IOException e10) {
            if (!Log.isLoggable("StreamGifDecoder", 5)) {
                return null;
            }
            Log.w("StreamGifDecoder", "Error reading data from stream", e10);
            return null;
        }
    }

    @Override // g3.j
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public v a(InputStream inputStream, int i10, int i11, g3.h hVar) {
        byte[] bArrE = e(inputStream);
        if (bArrE == null) {
            return null;
        }
        return this.f20727b.a(ByteBuffer.wrap(bArrE), i10, i11, hVar);
    }

    @Override // g3.j
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(InputStream inputStream, g3.h hVar) {
        return !((Boolean) hVar.c(i.f20725b)).booleanValue() && com.bumptech.glide.load.a.f(this.f20726a, inputStream, this.f20728c) == ImageHeaderParser.ImageType.GIF;
    }
}
