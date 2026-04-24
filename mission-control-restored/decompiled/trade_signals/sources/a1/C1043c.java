package a1;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import q1.AbstractC2618a;

/* JADX INFO: renamed from: a1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1043c implements U0.d {
    @Override // U0.d
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(ByteBuffer byteBuffer, File file, U0.h hVar) throws Throwable {
        try {
            AbstractC2618a.f(byteBuffer, file);
            return true;
        } catch (IOException e8) {
            if (Log.isLoggable("ByteBufferEncoder", 3)) {
                Log.d("ByteBufferEncoder", "Failed to write data", e8);
            }
            return false;
        }
    }
}
