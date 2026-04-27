package h1;

import W0.v;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: renamed from: h1.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1855j implements U0.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f18383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final U0.j f18384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final X0.b f18385c;

    public C1855j(List list, U0.j jVar, X0.b bVar) {
        this.f18383a = list;
        this.f18384b = jVar;
        this.f18385c = bVar;
    }

    public static byte[] e(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int i8 = inputStream.read(bArr);
                if (i8 == -1) {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, i8);
            }
        } catch (IOException e8) {
            if (!Log.isLoggable("StreamGifDecoder", 5)) {
                return null;
            }
            Log.w("StreamGifDecoder", "Error reading data from stream", e8);
            return null;
        }
    }

    @Override // U0.j
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public v a(InputStream inputStream, int i8, int i9, U0.h hVar) {
        byte[] bArrE = e(inputStream);
        if (bArrE == null) {
            return null;
        }
        return this.f18384b.a(ByteBuffer.wrap(bArrE), i8, i9, hVar);
    }

    @Override // U0.j
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(InputStream inputStream, U0.h hVar) {
        return !((Boolean) hVar.c(AbstractC1854i.f18382b)).booleanValue() && com.bumptech.glide.load.a.f(this.f18383a, inputStream, this.f18385c) == ImageHeaderParser.ImageType.GIF;
    }
}
